package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;

import com.crud.entity.Category;

import com.crud.repository.CategoryRepository;
import java.util.Optional;

@Service

public class CategoryServiceImpl implements CategoryService {

	@Autowired

	private CategoryRepository categoryRepository;

	@Override

	public Page<Category> getAllCategories(PageRequest pageRequest) {

		return categoryRepository.findAll(pageRequest);

	}

	@Override

	public Category createCategory(Category category) {

		return categoryRepository.save(category);

	}

	@Override

	public Optional<Category> getCategoryById(Long id) {

		return categoryRepository.findById(id);

	}

	@Override

	public Optional<Category> updateCategory(Long id, Category categoryDetails) {

		Optional<Category> existingCategory = categoryRepository.findById(id);

		if (existingCategory.isPresent()) {

			Category category = existingCategory.get();

			category.setName(categoryDetails.getName());

			return Optional.of(categoryRepository.save(category));

		}

		return Optional.empty();

	}

	@Override

	public boolean deleteCategory(Long id) {

		Optional<Category> category = categoryRepository.findById(id);

		if (category.isPresent()) {

			categoryRepository.delete(category.get());

			return true;

		}

		return false;

	}

}