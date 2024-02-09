package com.technicaltest.shoppingcart.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicaltest.shoppingcart.model.Product;
import com.technicaltest.shoppingcart.model.ShoppingCart;
import com.technicaltest.shoppingcart.services.ShoppingCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.HashMap;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ShoppingCartControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ShoppingCartService shoppingCartService;

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    ShoppingCart shoppingCart;

    public ShoppingCartControllerTest(){
        shoppingCart = new ShoppingCart();
        shoppingCart.setShoppinCartId("1");
        shoppingCart.setProducts(new HashMap<String, Product>());
        shoppingCart.setCreationTime(System.currentTimeMillis());
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(shoppingCartController).build();
    }

    @Test
    public void testGenerateCart() throws Exception {
        String requestBody = new ObjectMapper().writeValueAsString(shoppingCart);
        when(shoppingCartService.saveCarts(any(ShoppingCart.class))).thenReturn("Cart created successfully");
        mockMvc.perform(post("/cart/generateCart")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("Cart created successfully"));
    }

    @Test
    public void testGetCartInformation() throws Exception {
        when(shoppingCartService.getCartsInfo(shoppingCart.getShoppinCartId())).thenReturn("Cart information");
        mockMvc.perform(get("/cart/getCart/{cartId}", shoppingCart.getShoppinCartId()))
                .andExpect(status().isOk())
                .andExpect(content().string("Cart information"));
    }

    @Test
    public void testAddProducts() throws Exception {
        Product product = new Product("product1", "Something", 2);
        String requestBody = new ObjectMapper().writeValueAsString(product);
        when(shoppingCartService.addProductsImpl(shoppingCart.getShoppinCartId(), product)).thenReturn("Product added successfully");
        mockMvc.perform(post("/cart/addProducts/{cartId}", shoppingCart.getShoppinCartId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCart() throws Exception {
        when(shoppingCartService.deleteCartsImpl(shoppingCart.getShoppinCartId())).thenReturn("Cart deleted successfully");
        mockMvc.perform(delete("/cart/deleteCart/{cartId}", shoppingCart.getShoppinCartId()))
                .andExpect(status().isOk())
                .andExpect(content().string("Cart deleted successfully"));
    }
}
