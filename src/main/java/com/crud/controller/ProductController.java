package com.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Product;

import com.crud.service.ProductService;

@RestController

@RequestMapping("/api/products")

public class ProductController {

	@Autowired

	private ProductService productService;

	// 1. GET all products with pagination

	@GetMapping

	public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page) {

		Page<Product> products = productService.getAllProducts(PageRequest.of(page, 5)); // page size: 10

		return ResponseEntity.ok(products);

	}

	// 2. POST - create a new product

	@PostMapping

	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		Product createdProduct = productService.createProduct(product);

		return ResponseEntity.ok(createdProduct);

	}

	// 3. GET product by ID

	@GetMapping("/{id}")

	public ResponseEntity<Product> getProductById(@PathVariable Long id) {

		Optional<Product> product = productService.getProductById(id);

		return product.map(ResponseEntity::ok)

				.orElse(ResponseEntity.notFound().build());

	}

	// 4. PUT - update product by ID

	@PutMapping("/{id}")

	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {

		Optional<Product> updatedProduct = productService.updateProduct(id, productDetails);

		return updatedProduct.map(ResponseEntity::ok)

				.orElse(ResponseEntity.notFound().build());

	}

	// 5. DELETE - delete product by ID

	@DeleteMapping("/{id}")

	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

		boolean deleted = productService.deleteProduct(id);

		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

	}

}