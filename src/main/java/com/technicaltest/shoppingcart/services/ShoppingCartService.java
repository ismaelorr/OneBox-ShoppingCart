package com.technicaltest.shoppingcart.services;

import com.technicaltest.shoppingcart.model.Product;
import com.technicaltest.shoppingcart.model.ShoppingCart;
import org.springframework.stereotype.Service;


/**
 * @Author Ismael Orellana Bello
 * @Date 09/02/2024
 * @version 0.0.1
 *
 * Service interface for managing shopping carts.
 */
@Service
public interface ShoppingCartService {


    public String saveCarts(ShoppingCart shoppingCart);

    public String getCartsInfo(String shoppingCartId);

    public String addProductsImpl(String cartId,Product product);

    public String deleteCartsImpl(String shoppingCartId);


}
