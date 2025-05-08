# Java-Machine-Test--Nimap-Task
# Category-Product CRUD API with Spring Boot

## Overview

This project is a machine test implementation using *Spring Boot, **JPA (Hibernate), and **MySQL* for building a RESTful API that performs CRUD operations on Category and Product entities. The application supports server-side pagination and demonstrates a one-to-many relationship between categories and products.

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL (Relational DB)
- REST API
- Maven

---

## Requirements Implemented

- [1] Spring Boot application
- [2] REST Controllers
- [3] Relational DB configuration (MySQL, not in-memory)
- [4] Annotation-based configuration (no XML)
- [5] JPA with Hibernate
- [6] One-to-Many mapping: Category → Products
- [7] Server-side pagination
- [8] Category details embedded in product response

---

## API Endpoints

### Category CRUD
-------------------------------------------------------------------------
| Method | Endpoint                    | Description                    |
|--------|-----------------------------|--------------------------------|
| GET    | /api/categories?page={page} | Get all categories (paginated) |
| POST   | /api/categories             | Create a new category          |
| GET    | /api/categories/{id}        | Get category by ID             |
| PUT    | /api/categories/{id}        | Update category by ID          |
| DELETE | /api/categories/{id}        | Delete category by ID          |
-------------------------------------------------------------------------


### Product CRUD
----------------------------------------------------------------------------------
| Method | Endpoint                  | Description                               |
|--------|---------------------------|-------------------------------------------|
| GET    | /api/products?page={page} | Get all products (paginated)              |
| POST   | /api/products             | Create a new product                      |
| GET    | /api/products/{id}        | Get product by ID (with category details) |
| PUT    | /api/products/{id}        | Update product by ID                      |
| DELETE | /api/products/{id}        | Delete product by ID                      |
----------------------------------------------------------------------------------

---

## Database Schema

- *Category*
  - id (auto-increment)
  - name

- *Product*
  - id (auto-increment)
  - name
  - price
  - category_id (foreign key)



