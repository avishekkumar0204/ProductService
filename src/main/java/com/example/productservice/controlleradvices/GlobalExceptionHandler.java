package com.example.productservice.controlleradvices;

import com.example.productservice.exceptions.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.productservice.dtos.ExceptionDto;
import com.example.productservice.exceptions.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDto> nullPointerExceptionHandler(NullPointerException ex){
        ExceptionDto exceptionDto =  new ExceptionDto(ex.getMessage(), "Try again!!"); 
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(
            exceptionDto,
            HttpStatus.NOT_FOUND
        );
        return responseEntity;
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> productNotFoundExceptionHandler(ProductNotFoundException ex){
        ExceptionDto exceptionDto =  new ExceptionDto(ex.getMessage(), "Please try other product!!");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(
            exceptionDto,
            HttpStatus.NOT_FOUND
        );
        return responseEntity;
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionDto> categoryNotFoundExceptionHandler(CategoryNotFoundException ex){
        ExceptionDto exceptionDto =  new ExceptionDto(ex.getMessage(), "Please try other category!!");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(
            exceptionDto,
            HttpStatus.NOT_FOUND
        );
        return responseEntity;
    }
}
