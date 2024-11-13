package com.example.TransactionLock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TransactionLock.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
