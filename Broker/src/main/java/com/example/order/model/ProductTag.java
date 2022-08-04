package com.example.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ProductTag implements Serializable {
    private Integer iid;


    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @JsonIgnore
    private Product product;

    private String tag;
}
