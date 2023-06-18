package com.example.assignments.checkoutsystem.repo;

import com.example.assignments.checkoutsystem.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
