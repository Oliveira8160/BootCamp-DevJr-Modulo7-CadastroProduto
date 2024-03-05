package com.abutua.productbackend.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @GetMapping("product")
    public String getProduct(){
        return "Hello, I am Product";
    }
}
