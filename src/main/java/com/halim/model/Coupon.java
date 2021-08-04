package com.halim.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int discount;
	@Transient
	private boolean isDicount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public boolean isDicount() {
		if(this.discount != 0)
			return true;
		return false;
	}
	
	
}
