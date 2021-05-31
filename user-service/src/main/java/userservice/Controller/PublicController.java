package userservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import userservice.Model.User;
import userservice.Repository.UserRepository;

import java.awt.*;

@RestController
@RequestMapping("/public/")
public class PublicController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "testpublic",method= RequestMethod.GET)
    public String getPublic(){
        return "Public works";
    }



}
