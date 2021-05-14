package com.halim.web.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private int price;
	private String brand;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name="product_category",joinColumns = {
			@JoinColumn(name="product_id", referencedColumnName = "id")}
	,inverseJoinColumns = {@JoinColumn(name="category_id",referencedColumnName = "id")})
	private Set<Category> categories = new HashSet<Category>();
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Set<Carousel> carousel;
	public Set<Carousel> getCarousel() {
		return carousel;
	}
	public void setCarousel(Set<Carousel> carousel) {
		this.carousel = carousel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}
