package com.example.productsservice.Model;

public class WatchDial {
    private String dialImg;
    private String modelDial;
    private String modelDialDetails;

    public WatchDial(String dialImg, String modelDial, String modelDialDetails) {
        this.dialImg = dialImg;
        this.modelDial = modelDial;
        this.modelDialDetails = modelDialDetails;
    }

    public String getDialImg() {
        return dialImg;
    }

    public void setDialImg(String dialImg) {
        this.dialImg = dialImg;
    }

    public String getModelDial() {
        return modelDial;
    }

    public void setModelDial(String modelDial) {
        this.modelDial = modelDial;
    }

    public String getModelDialDetails() {
        return modelDialDetails;
    }

    public void setModelDialDetails(String modelDialDetails) {
        this.modelDialDetails = modelDialDetails;
    }
}
