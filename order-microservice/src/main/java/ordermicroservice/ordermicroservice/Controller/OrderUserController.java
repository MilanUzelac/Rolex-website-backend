package ordermicroservice.ordermicroservice.Controller;

import ordermicroservice.ordermicroservice.Model.Order;
import ordermicroservice.ordermicroservice.Model.SaveOrder;
import ordermicroservice.ordermicroservice.Model.WatchModel;
import ordermicroservice.ordermicroservice.Repository.OrderRepository;
import ordermicroservice.ordermicroservice.RestClients.UserRestClient;
import ordermicroservice.ordermicroservice.RestClients.WatchRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user/")
public class OrderUserController {

    @Autowired
    UserRestClient userRestClient;

    @Autowired
    WatchRestClient watchRestClient;

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(value = "makeNewOrder",method = RequestMethod.POST,consumes = {"multipart/form-data"})
    public String makeNewOrder(Principal principal, @RequestParam List<String> orderedWatchesList, @RequestParam String deliveryCity, @RequestParam Date deliveryDate){
        SaveOrder saveOrder = new SaveOrder(principal.getName(),watchRestClient.getWatchModelAndPrice(orderedWatchesList),deliveryCity,deliveryDate);
        orderRepository.save(saveOrder);
        System.out.println("Order has been saved...");
        System.out.println("Principal -> " + principal);
        System.out.println("Order toString() -> " + saveOrder.toString());
        return "Order has been successfully ordered.";
    }

    @RequestMapping(value = "getOrders",method = RequestMethod.GET,consumes = MediaType.ALL_VALUE)
    public List<Order> getOrder(Principal principal, HttpServletRequest request){

        List<SaveOrder> filteredOrder = orderRepository.findAll().stream().filter(e -> e.getUserNameOrder().equals(principal.getName())).collect(Collectors.toList());
        List<Order> fullUserOrders = new ArrayList<>();
        for (int i=0;i<filteredOrder.size();i++){
            System.out.println("Filtered ORDER  -> " + filteredOrder.get(i).getUserNameOrder());
            fullUserOrders.add(new Order(principal.getName(), userRestClient.getUser(principal.getName(),request.getHeader("Authorization")),watchRestClient.getWatchModelAndPrice(filteredOrder.get(i).getOrderedWatches()
                    .stream().map(WatchModel::getModel).collect(Collectors.toList())) ,filteredOrder.get(i).getChosenCity(),filteredOrder.get(i).getFinalPrice(),filteredOrder.get(i).getEstimatedDate()));
        }
        return fullUserOrders;

    }

}
