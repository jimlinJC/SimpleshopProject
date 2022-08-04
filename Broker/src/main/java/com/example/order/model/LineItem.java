package com.example.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class LineItem implements Serializable {

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private Integer lid;

    private String sku;

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    private Integer quantity;

    @JsonIgnore
    private SaleOrder saleOrder;
}

