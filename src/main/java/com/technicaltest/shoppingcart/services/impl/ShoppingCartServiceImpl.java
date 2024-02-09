package com.technicaltest.shoppingcart.services.impl;


import com.technicaltest.shoppingcart.model.Product;
import com.technicaltest.shoppingcart.model.ShoppingCart;
import com.technicaltest.shoppingcart.model.constants.StringConstants;
import com.technicaltest.shoppingcart.services.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ismael Orellana Bello
 * @Date 09/02/2024
 * @version 0.0.1
 *
 * Service implementation for managing shopping carts.
 */
@EnableScheduling
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private StringConstants constants = new StringConstants();
    private HashMap<String,ShoppingCart> shoppingCarts = new HashMap<>();

    /**
     * Saves the provided shopping cart.
     * @param shoppingCart The shopping cart to be saved.
     * @return A message indicating the result of the operation.
     */
    @Override
    public String saveCarts(ShoppingCart shoppingCart) {
        String result = constants.REQUEST_CREATE_CART_OK;
        if(shoppingCart == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(constants.NULL_POINTER_EXCEPTION_MESSAGE);
            result = constants.NULL_POINTER_EXCEPTION_MESSAGE;
        }
        else if(shoppingCarts.containsKey(shoppingCart.getShoppinCartId())) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(constants.ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE);
            result = constants.ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE + "the cart with ID: "+shoppingCart.getShoppinCartId()+" already exists";
        }
        else{
            shoppingCarts.put(shoppingCart.getShoppinCartId(),shoppingCart);
            ResponseEntity.status(HttpStatus.OK).body(constants.REQUEST_CREATE_CART_OK);
        }
        return result;
    }

    /**
     * Retrieves information about the shopping cart with the specified ID.
     * @param shoppingCartId The ID of the shopping cart to retrieve information for.
     * @return Information about the specified shopping cart.
     */
    @Override
    public String getCartsInfo(String shoppingCartId) {
        try{
            ShoppingCart shoppingCart = shoppingCarts.get(shoppingCartId);
            String result = "The cart with ID: "+shoppingCartId;
            if(shoppingCart.getProducts() != null && !shoppingCart.getProducts().isEmpty()){
                result += " have the next products:\n";
                for (Map.Entry<String, Product> product : shoppingCart.getProducts().entrySet()) {
                    String productId = product.getKey();
                    result+=" ProductId "+ shoppingCart.getProducts().get(productId).getProductId() + " Description: "+
                            shoppingCart.getProducts().get(productId).getProductDesc() + " amount: "+
                            shoppingCart.getProducts().get(productId).getAmount();
                }
            }
            else{
                result+=" Don´t have any products";
            }
            return result;
        }catch (NullPointerException exception){
            return constants.NULL_POINTER_EXCEPTION_MESSAGE;
        }
    }
    /**
     * Adds the specified product to the shopping cart with the given ID.
     * @param cartId The ID of the shopping cart to add the product to.
     * @param product The product to add to the shopping cart.
     * @return A message indicating the result of the operation.
     */
    @Override
    public String addProductsImpl(String cartId,Product product) {
        ShoppingCart shoppingCart = shoppingCarts.get(cartId);
        Map<String, Product> products = shoppingCart.getProducts();
        if (products == null) {
            products = new HashMap<>();
            shoppingCart.setProducts((HashMap<String, Product>) products);
        }
        String result = constants.REQUEST_ADD_PRODUCTS_OK;
        if(product.getAmount() > 0) {
            if (products.containsKey(product.getProductId())) {
                products.get(product.getProductId()).setAmount(products.get(product.getProductId()).getAmount() + product.getAmount());
            } else {
                products.put(product.getProductId(), product);
            }
        }
        else{
            result += constants.REQUEST_ADD_PRODUCTS_BAD_AMOUNT;
        }
        return result;
    }
    /**
     * Deletes the shopping cart with the specified ID.
     * @param shoppingCartId The ID of the shopping cart to delete.
     * @return A message indicating the result of the operation.
     */
    @Override
    public String deleteCartsImpl(String shoppingCartId) {
        String result = "The cart with ID: "+shoppingCartId+" has been successfully deleted";
        try{
            if(shoppingCarts.containsKey(shoppingCartId)){
                shoppingCarts.remove(shoppingCartId);
            }
            else{
                result = constants.REQUEST_DELETE_KO;
            }
        }catch (Exception e){
            result = constants.REQUEST_DELETE_KO;
        }
        finally{
            return result;
        }
    }

    /**
     * Scheduled method to clean up expired shopping carts.
     */
    @Scheduled(cron = "${cron.expression}")
    public void cleanupExpiredShoppingCarts() {
        long currentTime = System.currentTimeMillis();
        ArrayList<ShoppingCart> auxCarts = new ArrayList<>();
        for (Map.Entry<String, ShoppingCart> entry : shoppingCarts.entrySet()) {
            ShoppingCart cart = entry.getValue();
            if (currentTime - cart.getCreationTime() >= 600000) {
                auxCarts.add(cart);
            }
            else{
            }
        }
        if(auxCarts.size()>0){
            for(ShoppingCart cart : auxCarts){
                deleteCartsImpl(cart.getShoppinCartId());
                System.out.println("The cart with Id: "+cart.getShoppinCartId()+ " expired");
            }
        }
    }
}
