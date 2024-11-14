package com.example.TransactionLock.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.TransactionLock.entity.Product;
import com.example.TransactionLock.repository.ProductRepository;

@Service
public class ProductService {
    public static int numberOfDecrease = 0;
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity creatProduct(Product product) {
        product = this.productRepository.save(product);
        // return
        return ResponseEntity.ok().body(product);
    }

    public ResponseEntity order(String productId) {
        // get product
        Product product = this.productRepository.findById(productId).get();
        // check
        if (product.getNumber() > 0) {
            // simulate the period for updating product.
            try {

                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            // decrease
            product.setNumber(product.getNumber() - 1);
            numberOfDecrease++;
            // save
            productRepository.save(product);
        }
        // return
        Map<String, String> map = new HashMap<>();
        map.put("message", "success");
        return ResponseEntity.ok().body(map);
    }
}
