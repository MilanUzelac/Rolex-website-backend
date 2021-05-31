package com.example.productsservice.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user/")
public class WatchesUserController {

    @RequestMapping(value = "getCurrUser", method = RequestMethod.GET)
    public String getCurruser(Principal principal){
        return "Current user -> " + principal.getName();
    }

}