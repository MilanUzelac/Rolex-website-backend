package userservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import userservice.Model.User;
import userservice.Repository.UserRepository;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "testpublic",method= RequestMethod.GET)
    public String getPublic(Principal principal){
        return "Admin works, principal -> " + principal.getName();
    }

    @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
