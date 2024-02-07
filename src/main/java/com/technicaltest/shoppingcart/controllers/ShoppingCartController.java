package com.technicaltest.shoppingcart.controllers;

import com.technicaltest.shoppingcart.model.ShoppingCart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class ShoppingCartController {

    /**
     *
     */
    @PostMapping("/cart/generateCart")
    public void generateCart(@RequestBody ShoppingCart shoppingCart){

    }
    /**
     *
     */
    public void getCartInformation(){

    }
    /**
     *
     */
    public void addProducts(){

    }
    /**
     *
     */
    public void deleteCart(){

    }

}
