package com.halim.web.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halim.web.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Category findByName(String name);

}
