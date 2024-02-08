package com.technicaltest.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@AllArgsConstructor
public class Product {

    public Product(){

    }

    /**
     *
     */
    @Getter
    @Setter
    private String productId;
    /**
     *
     */
    @Getter
    @Setter
    private String productDesc;
    /**
     *
     */
    @Getter
    @Setter
    private int amount;


}
