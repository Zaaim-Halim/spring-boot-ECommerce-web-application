package com.halim.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.halim.model.Carousel;

public interface CarouselRepository extends JpaRepository<Carousel, Long> {

}
