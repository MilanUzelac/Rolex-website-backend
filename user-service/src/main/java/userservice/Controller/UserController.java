package userservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.Model.User;
import userservice.Repository.UserRepository;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(Principal principal){
        return "Radi user controller, principal -> " + principal.getName();
    }

    //TODO ovde nesto zeza kod requestbody
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestBody User user){
        System.out.println("USER -> " + user.toString());
        userRepository.save(user);
        return new ResponseEntity<>("User is saved", HttpStatus.OK);
    }

    @RequestMapping(value = "/getCurrentUser/{user}",method = RequestMethod.GET)
    public User getCurrentUser(@PathVariable String user){
        return userRepository.findUserByUserName(user);
    }
}