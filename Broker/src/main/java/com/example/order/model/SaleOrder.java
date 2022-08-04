package com.example.order.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleOrder implements Serializable {

    private Integer iid;

    private List<LineItem> lineItems = new ArrayList<>();

    private String email;

    private String creditCard;

    private LocalDateTime checkoutDate;

    private String state="created";

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public LocalDateTime getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDateTime checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getState() {
        return state;
    }

    @JsonProperty
    public void setState(String state) {
        this.state = state;
    }
}
