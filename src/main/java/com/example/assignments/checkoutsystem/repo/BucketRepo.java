package com.example.assignments.checkoutsystem.repo;

import com.example.assignments.checkoutsystem.model.Bucket;
import org.springframework.data.repository.CrudRepository;

public interface BucketRepo extends CrudRepository<Bucket,Long> {
}
