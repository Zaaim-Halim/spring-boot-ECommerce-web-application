package com.halim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halim.model.WishListItem;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem,Long> {

}
