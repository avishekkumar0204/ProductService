package com.example.productservice.inheritance.MappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "msc_student")
public class Student extends User {
    private String grade;
    private String section;
    private String rollNumber;
}
