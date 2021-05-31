package com.example.productsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WatchController {

    private WatchRepository watchRepository;

    @Autowired
    public WatchController(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    static String[] images = {"image1","image2"};
    @GetMapping("/createWatches")
    public String createWatches(){
        watchRepository.save(new Watch(1,"Casio","v1","Male","Stainless Steel","analog",images,"2 years","yes",25000,52));
        return "Watch has been created";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getWatches")
    public List<Watch> returnWatches(){
        return watchRepository.findAll();
    }

    @RequestMapping(value="/deleteById/{id}", method = RequestMethod.DELETE)
    public String deleteWatchById(@PathVariable("id") Long id){
        watchRepository.delete(watchRepository.findById(id).get());
        return "Watch with id " + id + " has been removed";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getImagesFrontPage")
    public List<Watch> resImages(){
        List<Watch> watchesFrontPage = watchRepository.findAll();
       // List<String> imgList = Arrays.asList("http://localhost:8082/resources/images/day-date.jpg","http://localhost:8082/resources/images/sky-dweller.jpg","http://localhost:8082/resources/images/datejust.jpg");
        return watchesFrontPage;
    }

}
