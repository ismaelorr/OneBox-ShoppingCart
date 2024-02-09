package com.technicaltest.shoppingcart.model;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

/**
 * @Author Ismael Orellana Bello
 * @Date 09/02/2024
 * @version 0.0.1
 *
 * Represents a shopping cart
 */
public class ShoppingCart {


    /**
     * Constructs a new shopping cart with an empty list of products and the current time as creation time.
     */
    public ShoppingCart() {
        this.products = new HashMap<>();
        this.creationTime = System.currentTimeMillis();
    }

    /**
     * The unique identifier of the shopping cart.
     */
    @Getter
    @Setter
    private String shoppinCartId;
    /**
     * The products contained in the shopping cart.
     */
    @Getter
    @Setter
    private HashMap<String,Product> products;
    /**
     * The time when the shopping cart was created (in milliseconds since epoch).
     */
    @Getter
    @Setter
    private long creationTime;


}
