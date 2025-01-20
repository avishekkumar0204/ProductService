package com.example.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel{
    public String name;
    public String description;
}
