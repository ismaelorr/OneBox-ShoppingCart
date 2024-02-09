package com.technicaltest.shoppingcart.controllers;

import com.technicaltest.shoppingcart.model.Product;
import com.technicaltest.shoppingcart.model.ShoppingCart;
import com.technicaltest.shoppingcart.services.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * @Author Ismael Orellana Bello
 * @Date 09/02/2024
 * @version 0.0.1
 *
 * Service implementation for managing shopping carts.
 */
@AllArgsConstructor
@RestController
public class ShoppingCartController {

    private ShoppingCartService shoppingCartService;

    /**
     * Endpoint for generating a new shopping cart.
     * @param shoppingCart The shopping cart object to be created.
     * @return A message indicating the result of the operation.
     */
    @PostMapping("/cart/generateCart")
    public String generateCart(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartService.saveCarts(shoppingCart);
    }

    /**
     * Endpoint for retrieving information about a specific shopping cart.
     * @param cartId The ID of the shopping cart.
     * @return Information about the specified shopping cart.
     */
    @GetMapping("/cart/getCart/{cartId}")
    public String getCartInformation(@PathVariable String cartId){
        return shoppingCartService.getCartsInfo(cartId);
    }

    /**
     * Endpoint for adding products to a shopping cart.
     * @param cartId The ID of the shopping cart to which products will be added.
     * @param product The product to be added to the shopping cart.
     * @return A message indicating the result of the operation.
     */
    @PostMapping("/cart/addProducts/{cartId}")
    public String addProducts(@PathVariable String cartId, @RequestBody Product product){
        return shoppingCartService.addProductsImpl(cartId,product);
    }

    /**
     * Endpoint for deleting a shopping cart.
     * @param cartId The ID of the shopping cart to be deleted.
     * @return A message indicating the result of the operation.
     */
    @DeleteMapping("/cart/deleteCart/{cartId}")
    public String deleteCart(@PathVariable String cartId){
       return shoppingCartService.deleteCartsImpl(cartId);
    }

}
