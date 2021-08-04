package com.halim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halim.model.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}
