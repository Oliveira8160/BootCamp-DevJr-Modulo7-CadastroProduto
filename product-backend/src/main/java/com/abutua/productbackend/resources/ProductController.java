package com.abutua.productbackend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.productbackend.models.Product;

import jakarta.annotation.PostConstruct;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        Product p1 = new Product();

        p1.setId(1);
        p1.setName("Product01");
        p1.setPrice(100.50);

        Product p2 = new Product();

        p2.setId(2);
        p2.setName("Product2");
        p2.setPrice(200.50);

        Product p3 = new Product();

        p3.setId(3);
        p3.setName("Product03");
        p3.setPrice(300.50);

        products.add(p1);
        products.add(p2);
        products.add(p3);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {

        // if (id <= products.size()) {

        // return ResponseEntity.ok(products.get(id - 1));

        // }
        // else{

        // throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Not Found");
        // }

        Product prod = products.stream().filter(p -> p.getId() == id).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found"));

                return ResponseEntity.ok(prod);
    }

    @GetMapping("products")
    public List<Product> getProducts() {

        return products;

    }
}
