package com.halim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halim.model.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long>{
	WishList findBySessionToken(String sessionToken);
}
