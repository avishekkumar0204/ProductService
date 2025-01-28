package com.example.productservice.dtos;

import org.apache.hc.core5.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDto {
    private String message;
    private String solution;
}
