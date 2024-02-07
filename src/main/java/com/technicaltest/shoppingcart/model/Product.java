package com.technicaltest.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */
@AllArgsConstructor
public class Product {

    /**
     *
     */
    @Getter
    @Setter
    private int productId;
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
