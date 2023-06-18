package com.example.assignments.checkoutsystem.repo;

import com.example.assignments.checkoutsystem.model.Receipt;
import org.springframework.data.repository.CrudRepository;

public interface ReceiptRepo extends CrudRepository<Receipt,  Long> {
}
