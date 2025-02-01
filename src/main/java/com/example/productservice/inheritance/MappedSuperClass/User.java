package com.example.productservice.inheritance.MappedSuperClass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String password;
}
