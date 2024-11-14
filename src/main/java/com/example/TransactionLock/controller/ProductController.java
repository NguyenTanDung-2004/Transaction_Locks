package com.example.TransactionLock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TransactionLock.entity.Product;
import com.example.TransactionLock.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity createProduct(@RequestBody Product product) {
        return productService.creatProduct(product);
    }

    @PostMapping("/order")
    public ResponseEntity order(@RequestParam(name = "productId") String productId) {
        System.out.println(productId);
        return productService.order(productId);
        // return null;
    }

    @GetMapping("")
    public ResponseEntity get() {
        return ResponseEntity.ok().body(ProductService.numberOfDecrease);
    }
}
