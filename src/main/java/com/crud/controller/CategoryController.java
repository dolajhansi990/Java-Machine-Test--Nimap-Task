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



import com.crud.entity.Category;

import com.crud.service.CategoryService;


@RestController

@RequestMapping("/api/categories")

public class CategoryController {

  @Autowired

  private CategoryService categoryService;

  // 1. Get all categories with pagination

  @GetMapping

  public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "0") int page) {

    PageRequest pageRequest = PageRequest.of(page, 5); // page size = 10, you can adjust it

    Page<Category> categories = categoryService.getAllCategories(pageRequest);

    return ResponseEntity.ok(categories);

  }

  // 2. Create a new category

  @PostMapping

  public ResponseEntity<Category> createCategory(@RequestBody Category category) {

    Category createdCategory = categoryService.createCategory(category);

    return ResponseEntity.ok(createdCategory);

  }

  // 3. Get category by ID

  @GetMapping("/{id}")

  public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {

    Optional<Category> category = categoryService.getCategoryById(id);

    return category.map(ResponseEntity::ok)

            .orElse(ResponseEntity.notFound().build());

  }

  // 4. Update category by ID

  @PutMapping("/{id}")

  public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {

    Optional<Category> updatedCategory = categoryService.updateCategory(id, categoryDetails);

    return updatedCategory.map(ResponseEntity::ok)

               .orElse(ResponseEntity.notFound().build());

  }

  // 5. Delete category by ID

  @DeleteMapping("/{id}")

  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {

    boolean deleted = categoryService.deleteCategory(id);

    return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

  }

}

