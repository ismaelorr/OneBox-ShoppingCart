package com.technicaltest.shoppingcart.services;

import com.technicaltest.shoppingcart.model.Product;
import com.technicaltest.shoppingcart.model.ShoppingCart;


/**
 *
 */
public interface ShoppingCartService {

    public String saveCarts(ShoppingCart shoppingCart);

    public String getCartsInfo(String shoppingCartId);

    public String addProductsImpl(String cartId,Product product);

    public String deleteProductsImpl(String shoppingCartId);

}
