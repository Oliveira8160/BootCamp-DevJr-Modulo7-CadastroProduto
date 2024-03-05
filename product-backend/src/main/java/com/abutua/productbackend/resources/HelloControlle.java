package com.abutua.productbackend.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController

public class HelloControlle {

    @GetMapping("hello")
    public String getHello(){
        
        return "Hello Bootcamp";
    }

}
