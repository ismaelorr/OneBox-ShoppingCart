package com.technicaltest.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author Ismael Orellana Bello
 * @Date 09/02/2024
 * @version 0.0.1
 *
 * Represents a product in a shopping cart
 */
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    /**
     * The unique identifier of the product.
     */
    @Getter
    @Setter
    private String productId;
    /**
     * The description of the product.
     */
    @Getter
    @Setter
    private String productDesc;
    /**
     * The quantity of the product.
     */
    @Getter
    @Setter
    private int amount;


}
