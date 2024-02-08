package com.technicaltest.shoppingcart.services.impl;


import com.technicaltest.shoppingcart.model.Product;
import com.technicaltest.shoppingcart.model.ShoppingCart;
import com.technicaltest.shoppingcart.model.constants.StringConstants;
import com.technicaltest.shoppingcart.services.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private StringConstants constants = new StringConstants();
    private HashMap<String,ShoppingCart> shoppingCarts = new HashMap<>();

    /**
     *
     * @param shoppingCart
     * @return
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
     *
     * @param shoppingCartId
     * @return
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
                    result+="ProductId "+ shoppingCart.getProducts().get(productId).getProductId() + " Description: "+
                            shoppingCart.getProducts().get(productId).getProductDesc() + " amount: "+
                            shoppingCart.getProducts().get(productId).getAmount();
                }
            }
            else{
                result+="Don´t have any products";
            }
            return result;
        }catch (NullPointerException exception){
            return constants.NULL_POINTER_EXCEPTION_MESSAGE;
        }
    }
    /**
     *
     * @param cartId
     * @param product
     * @return
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
     *
     * @param shoppingCartId
     * @return
     */
    @Override
    public String deleteProductsImpl(String shoppingCartId) {
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
}
