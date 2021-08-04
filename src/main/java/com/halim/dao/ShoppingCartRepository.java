package com.halim.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.halim.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
	ShoppingCart findBySessionToken(String sessionToken);

}
