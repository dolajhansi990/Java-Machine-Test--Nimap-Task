package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.crud.entity.Product;

import com.crud.repository.ProductRepository;

import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {

	@Autowired

	private ProductRepository productRepository;

	@Override

	public Page<Product> getAllProducts(Pageable pageable) {

		return productRepository.findAll(pageable);

	}

	@Override

	public Product createProduct(Product product) {

		return productRepository.save(product);

	}

	@Override

	public Optional<Product> getProductById(Long id) {

		return productRepository.findById(id);

	}

	@Override

	public Optional<Product> updateProduct(Long id, Product productDetails) {

		Optional<Product> existingProduct = productRepository.findById(id);

		if (existingProduct.isPresent()) {

			Product product = existingProduct.get();

			product.setName(productDetails.getName());

			product.setPrice(productDetails.getPrice());
			
			product.setCategory(productDetails.getCategory());

			return Optional.of(productRepository.save(product));

		}

		return Optional.empty();

	}

	@Override

	public boolean deleteProduct(Long id) {

		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {

			productRepository.delete(product.get());

			return true;

		}

		return false;

	}

}
