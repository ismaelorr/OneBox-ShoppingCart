package com.technicaltest.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

/**
 *
 */
public class ShoppingCart {

    public ShoppingCart() {
        this.products = new HashMap<>();
    }

    /**
     *
     */
    @Getter
    @Setter
    private String shoppinCartId;
    /**
     *
     */
    @Getter
    @Setter
    private HashMap<String,Product> products;


}
