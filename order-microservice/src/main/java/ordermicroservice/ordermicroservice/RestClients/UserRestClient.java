package ordermicroservice.ordermicroservice.RestClients;

import ordermicroservice.ordermicroservice.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rolex-user-microservice",url= "http://rolexwebsite.com:8083")
public interface UserRestClient {
    @RequestMapping(value="/user/getCurrentUser/{user}", method = RequestMethod.GET)
    User getUser(@PathVariable String user,@RequestHeader("Authorization") String token);
}
