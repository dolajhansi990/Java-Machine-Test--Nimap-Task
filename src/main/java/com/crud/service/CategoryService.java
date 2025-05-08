package com.crud.service;

import com.crud.entity.*;
import org.hibernate.query.*;
import java.util.*;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Page;

public interface CategoryService {

	Page<Category> getAllCategories(PageRequest pageRequest);

	Category createCategory(Category category);

	Optional<Category> getCategoryById(Long id);

	Optional<Category> updateCategory(Long id, Category categoryDetails);

	boolean deleteCategory(Long id);

}