package com.example.assignments.checkoutsystem.repo;

import com.example.assignments.checkoutsystem.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
