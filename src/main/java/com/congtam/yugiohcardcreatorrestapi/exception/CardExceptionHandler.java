package com.congtam.yugiohcardcreatorrestapi.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

@RestControllerAdvice
public class CardExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CardErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder("");
        ex.getBindingResult().getAllErrors().forEach((error) ->
                errorMessage.append(error.getDefaultMessage()).append("\n"));

        return new CardErrorResponse(errorMessage.toString(), new Date());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CardErrorResponse handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException ex) {
        return new CardErrorResponse(ex.getMessage(), new Date());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CardErrorResponse handleConstraintViolationException(
            ConstraintViolationException ex) {
        StringBuilder errorMessage = new StringBuilder("");
        ex.getConstraintViolations().forEach((violation) ->
                errorMessage.append(violation.getMessage()).append("\n"));
        errorMessage.append("\b");

        return new CardErrorResponse(errorMessage.toString(), new Date());
    }
}
