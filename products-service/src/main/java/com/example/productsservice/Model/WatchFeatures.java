package com.example.productsservice.Model;

import org.springframework.web.multipart.MultipartFile;

public class WatchFeatures {

    private String watchModelFeatures;
    private String id;
    private MultipartFile featureImage;
    private String featureHead;
    private String featureDesc;

    public WatchFeatures(String watchModelFeatures, String id, MultipartFile featureImage, String featureHead, String featureDesc) {
        this.watchModelFeatures = watchModelFeatures;
        this.id = id;
        this.featureImage = featureImage;
        this.featureHead = featureHead;
        this.featureDesc = featureDesc;
    }

    public String getWatchModelFeatures() {
        return watchModelFeatures;
    }

    public void setWatchModelFeatures(String watchModelFeatures) {
        this.watchModelFeatures = watchModelFeatures;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MultipartFile getFeatureImage() {
        return featureImage;
    }

    public void setFeatureImage(MultipartFile featureImage) {
        this.featureImage = featureImage;
    }

    public String getFeatureHead() {
        return featureHead;
    }

    public void setFeatureHead(String featureHead) {
        this.featureHead = featureHead;
    }

    public String getFeatureDesc() {
        return featureDesc;
    }

    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    @Override
    public String toString() {
        return "WatchFeatures{" +
                "watchModelFeatures='" + watchModelFeatures + '\'' +
                ", id='" + id + '\'' +
                ", featureImage=" + featureImage + ", image size=" + featureImage.getSize() +
                ", featureHead='" + featureHead + '\'' +
                ", featureDesc='" + featureDesc + '\'' +
                '}';
    }
}
