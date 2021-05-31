package com.example.productsservice.Model;

public class StaticTextShortAbout {
    private String firstDesc;
    private String secondDesc;

    public StaticTextShortAbout(String firstDesc, String secondDesc) {
        this.firstDesc = firstDesc;
        this.secondDesc = secondDesc;
    }

    public String getFirstDesc() {
        return firstDesc;
    }

    public void setFirstDesc(String firstDesc) {
        this.firstDesc = firstDesc;
    }

    public String getSecondDesc() {
        return secondDesc;
    }

    public void setSecondDesc(String secondDesc) {
        this.secondDesc = secondDesc;
    }
}
