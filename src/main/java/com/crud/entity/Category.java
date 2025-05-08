package com.crud.entity;
import java.util.*;
import jakarta.persistence.*;
import com.crud.entity.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity

public class Category {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Product> products;

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

	public List<Product> getProducts() {

		return products;

	}

	public void setProducts(List<Product> products) {

		this.products = products;

	}

}