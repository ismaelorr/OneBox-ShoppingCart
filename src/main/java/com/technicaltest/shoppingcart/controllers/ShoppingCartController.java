package com.technicaltest.shoppingcart.controllers;

import com.technicaltest.shoppingcart.model.Product;
import com.technicaltest.shoppingcart.model.ShoppingCart;
import com.technicaltest.shoppingcart.services.ShoppingCartService;
import com.technicaltest.shoppingcart.services.impl.ShoppingCartServiceImpl;
import org.springframework.web.bind.annotation.*;


/**
 *
 */
@RestController
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService = new ShoppingCartServiceImpl();

    /**
     *
     * @param shoppingCart
     * @return
     */
    @PostMapping("/cart/generateCart")
    public String generateCart(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.saveCarts(shoppingCart);
    }

    /**
     *
     * @param cartId
     * @return
     */
    @GetMapping("/cart/getCart/{cartId}")
    public String getCartInformation(@PathVariable String cartId){
        return shoppingCartService.getCartsInfo(cartId);
    }

    /**
     *
     * @param cartId
     * @param product
     * @return
     */
    @PostMapping("/cart/addProducts/{cartId}")
    public String addProducts(@PathVariable String cartId, @RequestBody Product product){
        return shoppingCartService.addProductsImpl(cartId,product);
    }

    /**
     *
     * @param cartId
     * @return
     */
    @DeleteMapping("/cart/deleteCart/{cartId}")
    public String deleteCart(@PathVariable String cartId){
       return shoppingCartService.deleteProductsImpl(cartId);
    }

}
