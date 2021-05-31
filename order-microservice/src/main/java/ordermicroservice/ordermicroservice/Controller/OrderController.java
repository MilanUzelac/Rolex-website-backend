package ordermicroservice.ordermicroservice.Controller;

import ordermicroservice.ordermicroservice.Model.Order;
import ordermicroservice.ordermicroservice.Model.SaveOrder;
import ordermicroservice.ordermicroservice.Model.WatchModel;
import ordermicroservice.ordermicroservice.Repository.OrderRepository;
import ordermicroservice.ordermicroservice.RestClients.UserRestClient;
import ordermicroservice.ordermicroservice.RestClients.WatchRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/order/")
public class OrderController {


}