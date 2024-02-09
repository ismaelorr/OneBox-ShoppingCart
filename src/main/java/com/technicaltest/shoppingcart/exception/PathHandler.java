package com.technicaltest.shoppingcart.exception;

import com.technicaltest.shoppingcart.model.constants.StringConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Ismael Orellana Bello
 * @Date 09/02/2024
 * @version 0.0.1
 *
 * Global exception handler for handling exceptions thrown by controllers.
 */
@RestControllerAdvice
public class PathHandler {

    private StringConstants stringConstants = new StringConstants();

    /**
     * Handles NullPointerException and returns an appropriate error message.
     * @param exception The NullPointerException that occurred.
     * @return An error message for the NullPointerException.
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String nullPointerHandler(NullPointerException exception){
        return stringConstants.NULL_POINTER_EXCEPTION_MESSAGE;
    }
    /**
     * Handles IllegalArgumentException and returns an appropriate error message.
     * @param exception The IllegalArgumentException that occurred.
     * @return An error message for the IllegalArgumentException.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String illegalArgumentHandler(IllegalArgumentException exception){
        return stringConstants.ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE;
    }
    /**
     * Handles HttpMessageNotReadableException and returns an appropriate error message.
     * @param exception The HttpMessageNotReadableException that occurred.
     * @return An error message for the HttpMessageNotReadableException.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String messageNotRedableHandler(HttpMessageNotReadableException exception){
        return stringConstants.HTTP_NOT_REDEABLE_EXCEPTION_MESSAGE;
    }



}

