package com.example.productsservice.Controller;

import com.example.productsservice.Model.*;
import com.example.productsservice.Repository.RolexWatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class RolexWatchContoller {

    private RolexWatchRepository rolexWatchRepository;

    public static List<WatchFeatures> watchFeaturesList = new ArrayList<>();
    public static List<WatchFeaturesWithImage> watchFeatureImageSaveListUrl = new ArrayList<>();

    @Autowired
    public RolexWatchContoller(RolexWatchRepository rolexWatchRepository) {
        this.rolexWatchRepository = rolexWatchRepository;
    }


}
