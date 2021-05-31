package auth_server.Controller;

import auth_server.Model.*;
import auth_server.Repository.UserRepository;
import auth_server.RestClients.UserServiceRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceRestClient userServiceRestClient;

    @RequestMapping(value = "/validatejwt",method = RequestMethod.GET)
    public HttpStatus validateJWT(Principal principal){
        System.out.println("Auth principal -> " + principal.getName());
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/validateadmin",method = RequestMethod.GET)
    public ResponseEntity<String> validateAdmin(Principal principal){
        if(userRepository.getByUserName(principal.getName()).getRole().toString().equals("ADMIN")){
            return new ResponseEntity<>("ADMIN",HttpStatus.OK);
        }
        return new ResponseEntity<>("UNAUTHORIZED",HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/validateuser",method = RequestMethod.GET)
    public ResponseEntity<String> validateUser(Principal principal){
        if(userRepository.getByUserName(principal.getName()).getRole().toString().equals("USER")){
            return new ResponseEntity<>("USER",HttpStatus.OK);
        }
        return new ResponseEntity<>("UNAUTHORIZED",HttpStatus.UNAUTHORIZED);
    }


    @RequestMapping(value = "/validateroute",method = RequestMethod.GET)
    public ResponseEntity<String> validateAndRoute(Principal principal){
        if(userRepository.getByUserName(principal.getName()).getRole().toString().equals("USER")){
            return new ResponseEntity<>("USER",HttpStatus.OK);
        }else if(userRepository.getByUserName(principal.getName()).getRole().toString().equals("ADMIN")){
            return new ResponseEntity<>("ADMIN",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("UNAUTHORIZED",HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/userregistration",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registration(@RequestBody RegistrationUser registrationUser){
        if(userRepository.existsById(registrationUser.getUserName())){
            System.out.println("User already exists");
            return new ResponseEntity<>("User already exists",HttpStatus.CREATED);
        }else{
            System.out.println("Registrated user -> " + registrationUser.toString());
            userRepository.save(new User(registrationUser.getUserName(),new BCryptPasswordEncoder().encode(registrationUser.getPassword()), ROLE.USER));
            userServiceRestClient.saveNewUser(new UserDetails(registrationUser.getUserName(),registrationUser.getFirstName(),registrationUser.getLastName(),registrationUser.getYearOfBirth(),registrationUser.getAddress(),registrationUser.getPhoneNumber(),registrationUser.getEmail()));
            return new ResponseEntity<>("User " + registrationUser.getUserName() + " has been successfully registered.",HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getTestFromAuth", method = RequestMethod.POST)
    public String getTestTest(){
        System.out.println("It works...");
        return userServiceRestClient.getTest();
    }

    @RequestMapping(value = "/getAdminData/{userName}", method = RequestMethod.GET)
    public User getAdminData(@RequestParam String userName){
        return userRepository.getByUserName(userName);
    }

}
