package com.myretail.model;

public class PriceBean {

    private int price;

    private String currencyCode;

    public PriceBean(int price, String currencyCode) {
        this.price = price;
        this.currencyCode = currencyCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
