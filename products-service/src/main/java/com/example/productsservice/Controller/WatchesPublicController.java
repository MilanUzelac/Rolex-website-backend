package com.example.productsservice.Controller;

import com.example.productsservice.Model.Watch;
import com.example.productsservice.Model.WatchModel;
import com.example.productsservice.Model.WatchModelAndImageLink;
import com.example.productsservice.Repository.RolexWatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/public/")
public class WatchesPublicController {

    @Autowired
    RolexWatchRepository rolexWatchRepository;

    @RequestMapping(value = "/testFromAdmin", method = RequestMethod.GET)
    private String retrieveTest() {
        return "Response from product";
    }


    @RequestMapping(value = "/getmanswatch", method = RequestMethod.GET)
    private List<Watch> retrieveWatches() {
        return rolexWatchRepository.findWatchByGender("Male");
    }

    @RequestMapping(value = "/getwomanswatch", method = RequestMethod.GET)
    private List<Watch> retrieveWomansWatches() {
        return rolexWatchRepository.findWatchByGender("Female");
    }

    @RequestMapping(value="/getallwatches",method = RequestMethod.GET)
    public List<WatchModelAndImageLink> getAllWatches(){
        return rolexWatchRepository.findAll().stream().map(e -> new WatchModelAndImageLink(e.getModel(),e.getImageWatchCard(),e.getGender(),e.getPrice())).collect(Collectors.toList());
    }

    @RequestMapping(value = "/getWatchByModel", method = RequestMethod.GET)
    private Watch retrieveWatch(@RequestParam("watchModelParam") String watchModelParam) {
        return rolexWatchRepository.findWatchByModel(watchModelParam);
    }

    @RequestMapping(value = "/getwatchdetails")
    public List<Watch> retrieveWatchDetails(@RequestBody List<String> watchModel){
        List<Watch> watchListForCurrentUser = new ArrayList<>();
        for(int i=0;i<watchModel.size();i++){
            watchListForCurrentUser.add(rolexWatchRepository.findWatchByModel(watchModel.get(i)));
        }
        return watchListForCurrentUser;
    }


    @RequestMapping(value = "/getWatchModelAndPrice",method = RequestMethod.GET)
    public List<WatchModel> retrieveWatchModelAndPrice(@RequestParam List<String> watchModel){
        List<WatchModel> watchModelAndPriceList = new ArrayList<>();
        for(int i=0;i<watchModel.size();i++){
            watchModelAndPriceList.add(new WatchModel(rolexWatchRepository.findWatchByModel(watchModel.get(i)).getModel(),rolexWatchRepository.findWatchByModel(watchModel.get(i)).getPrice(),rolexWatchRepository.findWatchByModel(watchModel.get(i)).getImageWatchCard()));
        }
        return watchModelAndPriceList;
    }

    @RequestMapping(value = "/getWholeWatchDetails",method = RequestMethod.GET)
    public List<Watch> retrieveWholeWatchDetails(@RequestParam List<String> watchModel){
        List<Watch> watchWholeDetailsList = new ArrayList<>();
        for(int i=0;i<watchModel.size();i++){
            watchWholeDetailsList.add(rolexWatchRepository.findWatchByModel(watchModel.get(i)));
        }
        return watchWholeDetailsList;
    }

    @RequestMapping(value = "/getWatchForSlider",method = RequestMethod.GET)
    public List<Watch> getWatchForSlider(){
        return rolexWatchRepository.findAll().stream().limit(6).distinct().sorted(Comparator.comparing(Watch::getPrice).reversed()).collect(Collectors.toList());
    }




}