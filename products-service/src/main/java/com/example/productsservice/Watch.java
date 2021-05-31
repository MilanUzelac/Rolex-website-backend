package com.example.productsservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "watches")
public class Watch {
    @Id
    private long watchId;
    private String brand;
    private String model;
    private String gender;
    private String material;
    private String mechanism;
    private String[] imageUrls;
    private String warranty;
    private String waterResistance;
    private int price;
    private int caseDiameter;

    public Watch(long watchId, String brand, String model, String gender, String material, String mechanism, String[] imageUrls, String warranty, String waterResistance, int price, int caseDiameter) {
        this.watchId = watchId;
        this.brand = brand;
        this.model = model;
        this.gender = gender;
        this.material = material;
        this.mechanism = mechanism;
        this.imageUrls = imageUrls;
        this.warranty = warranty;
        this.waterResistance = waterResistance;
        this.price = price;
        this.caseDiameter = caseDiameter;
    }

    public long getWatchId() {
        return watchId;
    }

    public void setWatchId(long watchId) {
        this.watchId = watchId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(String waterResistance) {
        this.waterResistance = waterResistance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCaseDiameter() {
        return caseDiameter;
    }

    public void setCaseDiameter(int caseDiameter) {
        this.caseDiameter = caseDiameter;
    }
}
