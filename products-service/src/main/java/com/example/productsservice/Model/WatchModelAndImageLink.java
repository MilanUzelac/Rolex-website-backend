package com.example.productsservice.Model;

public class WatchModelAndImageLink {
    private String watchModel;
    private String imageUrl;
    private String gender;
    private int price;

    public WatchModelAndImageLink(String watchModel, String imageUrl, String gender, int price) {
        this.watchModel = watchModel;
        this.imageUrl = imageUrl;
        this.gender = gender;
        this.price = price;
    }

    public String getWatchModel() {
        return watchModel;
    }

    public void setWatchModel(String watchModel) {
        this.watchModel = watchModel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
