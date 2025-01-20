package com.example.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SampleController {
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String name){
        return "Hello " + name;
    }
}
