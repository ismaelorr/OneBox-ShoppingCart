package com.technicaltest.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 *
 */
@AllArgsConstructor
public class ShoppingCart {
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
    private List<Product> products;


}
