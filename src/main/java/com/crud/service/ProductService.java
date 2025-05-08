package com.crud.service;

import com.crud.entity.*;

import org.hibernate.query.*;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Page;

public interface ProductService {

	Product createProduct(Product product);

	Optional<Product> getProductById(Long id);

	Optional<Product> updateProduct(Long id, Product productDetails);

	boolean deleteProduct(Long id);

	Page<Product> getAllProducts(Pageable pageable);

}
