package ordermicroservice.ordermicroservice.Controller;

import ordermicroservice.ordermicroservice.Model.Order;
import ordermicroservice.ordermicroservice.Model.WatchModel;
import ordermicroservice.ordermicroservice.Repository.OrderRepository;
import ordermicroservice.ordermicroservice.RestClients.UserRestClient;
import ordermicroservice.ordermicroservice.RestClients.WatchRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin/")
public class OrderAdminController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRestClient userRestClient;
    @Autowired
    WatchRestClient watchRestClient;


    //TODO vraca null kod imageWatchCard;
    @RequestMapping(value = "getallorders",method = RequestMethod.GET)
    public List<Order> getAllOrders(HttpServletRequest request){
        return orderRepository.findAll().stream().map(e -> new Order(e.getUserNameOrder(),userRestClient.getUser(e.getUserNameOrder(),request.getHeader("Authorization")),
                watchRestClient.getWatchModelAndPrice(e.getOrderedWatches().stream().map(WatchModel::getModel).collect(Collectors.toList())),e.getChosenCity(),e.getFinalPrice(),e.getEstimatedDate())).collect(Collectors.toList());
    }

}
