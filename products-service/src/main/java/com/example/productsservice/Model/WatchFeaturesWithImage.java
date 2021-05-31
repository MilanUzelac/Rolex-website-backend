package com.example.productsservice.Model;

import org.springframework.web.multipart.MultipartFile;

public class WatchFeaturesWithImage {
    private String imageUrl;
    private String headFeature;
    private String textFeature;

    public WatchFeaturesWithImage(String imageUrl, String headFeature, String textFeature) {
        this.imageUrl = imageUrl;
        this.headFeature = headFeature;
        this.textFeature = textFeature;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHeadFeature() {
        return headFeature;
    }

    public void setHeadFeature(String headFeature) {
        this.headFeature = headFeature;
    }

    public String getTextFeature() {
        return textFeature;
    }

    public void setTextFeature(String textFeature) {
        this.textFeature = textFeature;
    }
}

