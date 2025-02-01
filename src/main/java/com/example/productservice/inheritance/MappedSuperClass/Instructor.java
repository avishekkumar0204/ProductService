package com.example.productservice.inheritance.MappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "msc_instructor")
public class Instructor extends User {
    private String subject;
    private String department;
    private String employeeId;
}
