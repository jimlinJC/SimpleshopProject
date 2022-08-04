package com.example.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {


    private String sku;


    private String name;

    private Integer quantity;

    @JsonIgnore
    private List<ProductTag> items = new ArrayList<ProductTag>();

}
