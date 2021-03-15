package com.myretail.model;

import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;

public class ProductBean {
    @Id
    private String id;

    @NotNull
    private String name;

    private PriceBean currentPrice;

    public ProductBean(String id, String name, PriceBean currentPrice) {
        super();
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriceBean getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(PriceBean currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Product [_id=" + id + ", name=" + name + ", price=" + currentPrice.getPrice() + ", priceCode=" + currentPrice.getCurrencyCode() + "]";
    }
}
