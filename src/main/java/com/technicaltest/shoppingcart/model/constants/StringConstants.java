package com.technicaltest.shoppingcart.model.constants;
/**
 * @Author Ismael Orellana Bello
 * @Date 09/02/2024
 * @version 0.0.1
 *
 * Class containing constant string messages for error handling and response messages.
 */
public class StringConstants {

    // Exception messages
    public static final String NULL_POINTER_EXCEPTION_MESSAGE = "The error was caused by a Null Pointer, this is a controlled exception";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE = "The error was caused by a Illegal Argument, this is a controlled exception";
    public static final String HTTP_NOT_REDEABLE_EXCEPTION_MESSAGE = "The error was caused by a Message not redeable, this is a controlled exception";
    // Request response messages
    public static final String REQUEST_CREATE_CART_OK = "The cart was created succesfully";
    public static final String REQUEST_ADD_PRODUCTS_OK = "The product has been added to the cart correctly";
    public static final String REQUEST_DELETE_KO = "An error occurred while trying to delete the cart";
    public static final String REQUEST_ADD_PRODUCTS_BAD_AMOUNT = "You can´t put less than 0 units of the product";

}
