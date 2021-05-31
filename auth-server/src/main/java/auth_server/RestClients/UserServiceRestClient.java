package auth_server.RestClients;

import auth_server.Model.UserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "rolex-user-microservice",url= "http://localhost:8083")
public interface UserServiceRestClient {
    @RequestMapping(value="/users/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> saveNewUser(@RequestBody UserDetails userDetails);

    @RequestMapping(value="/users/test", method = RequestMethod.GET)
    String getTest();
}
