package com.example.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    public String title;
    public String description;
    public double price;
    public Category category;
}
