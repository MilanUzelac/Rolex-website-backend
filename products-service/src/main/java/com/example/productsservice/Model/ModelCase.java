package com.example.productsservice.Model;

public class ModelCase {
    private String imageCase;
    private String modelCase;
    private String oysterArchitecture;
    private String diameter;
    private String material;
    private String bezel;
    private String windingCrown;
    private String crystal;
    private String waterResistance;

    public ModelCase(String imageCase, String modelCase, String oysterArchitecture, String diameter, String material, String bezel, String windingCrown, String crystal, String waterResistance) {
        this.imageCase = imageCase;
        this.modelCase = modelCase;
        this.oysterArchitecture = oysterArchitecture;
        this.diameter = diameter;
        this.material = material;
        this.bezel = bezel;
        this.windingCrown = windingCrown;
        this.crystal = crystal;
        this.waterResistance = waterResistance;
    }

    public String getImageCase() {
        return imageCase;
    }

    public void setImageCase(String imageCase) {
        this.imageCase = imageCase;
    }

    public String getModelCase() {
        return modelCase;
    }

    public void setModelCase(String modelCase) {
        this.modelCase = modelCase;
    }

    public String getOysterArchitecture() {
        return oysterArchitecture;
    }

    public void setOysterArchitecture(String oysterArchitecture) {
        this.oysterArchitecture = oysterArchitecture;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBezel() {
        return bezel;
    }

    public void setBezel(String bezel) {
        this.bezel = bezel;
    }

    public String getWindingCrown() {
        return windingCrown;
    }

    public void setWindingCrown(String windingCrown) {
        this.windingCrown = windingCrown;
    }

    public String getCrystal() {
        return crystal;
    }

    public void setCrystal(String crystal) {
        this.crystal = crystal;
    }

    public String getWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(String waterResistance) {
        this.waterResistance = waterResistance;
    }
}
