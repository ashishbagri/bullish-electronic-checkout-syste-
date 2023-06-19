package com.example.assignments.checkoutsystem.controller;

import com.example.assignments.checkoutsystem.model.Bucket;
import com.example.assignments.checkoutsystem.model.Item;
import com.example.assignments.checkoutsystem.repo.BucketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * * Bucket REST API
 * 	* Reterive all Buckets
 * 		* GET /buckets
 * 	* Create an Empty Bucket
 * 		* POST /buckets
 * 	* Reterive one Bucket
 * 		* GET /buckets/{id}
 * 	* Reterive Bucket for a user/
 * 		* GET /buckets/user/id
 * 	* Add Product to a Bucket
 * 		* POST /buckets/{id}/items
 * 	* Delete a Product from the Bucket
 * 		* POST /buckets/{id}/items/{id}
 */
@RestController
@RequestMapping("/buckets")
public class BucketController {

    @Autowired
    private BucketRepo bucketRepo;

    @GetMapping
    public ResponseEntity<Iterable<Bucket>> getAllBuckets(){
        return new ResponseEntity<>(bucketRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bucket> getBucketById(@PathVariable Long id) {
        Bucket found = bucketRepo.findById(id).orElse(null);
        if (found == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<Bucket> addProduct(@PathVariable Long id, @RequestBody Item item) {

        Bucket bucket = bucketRepo.findById(id).orElse(null);
        if(bucket  == null)
            throw new RuntimeException("Bucket not found");
        List<Item> items = bucket.getItems();
        if(items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
        return new ResponseEntity<>(bucket, HttpStatus.OK);

    }

    @PostMapping("/{bucket_id}/items/{id}")
    public ResponseEntity<Bucket> removeItem(@PathVariable Long bucket_id, @PathVariable Long id, @RequestBody Item item) {
        Bucket bucket = bucketRepo.findById(id).orElse(null);
        if(bucket  == null)
            throw new RuntimeException("Bucket not found");
        List<Item> items = bucket.getItems();
        if(items == null) {
            items = new ArrayList<>();
        }
        if(items.contains(item)){
            items.remove(item);
        }
        return new ResponseEntity<>(bucket, HttpStatus.OK);
    }
}
