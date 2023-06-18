package com.example.assignments.checkoutsystem.repo;

import com.example.assignments.checkoutsystem.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
