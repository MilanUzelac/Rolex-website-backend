package ordermicroservice.ordermicroservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/public/")
public class OrderPublicController {
    @RequestMapping(value = "testOrder",method = RequestMethod.GET)
    public String testOrder(){
        return "Order works...";
    }
}
