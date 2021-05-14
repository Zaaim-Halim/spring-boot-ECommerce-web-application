package com.halim.web.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.halim.web.model.Carousel;

public interface CarouselRepository extends JpaRepository<Carousel, Long> {

}
