package com.crud.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity

public class Product {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String name;

	private double price;

	@ManyToOne

	@JoinColumn(name = "category_id", nullable = false)
	@JsonBackReference
	private Category category;
	
	@Transient
	public String getCategoryName() {
		return category!=null?category.getName():null;
	}

	// Getters and setters

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

	public double getPrice() {

		return price;

	}

	public void setPrice(double price) {

		this.price = price;

	}

	public Category getCategory() {

		return category;

	}

	public void setCategory(Category category) {

		this.category = category;

	}

}