package com.halim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halim.model.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

}