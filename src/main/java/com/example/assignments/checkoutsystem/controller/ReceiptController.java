package com.example.assignments.checkoutsystem.controller;

import com.example.assignments.checkoutsystem.model.Bucket;
import com.example.assignments.checkoutsystem.model.Receipt;
import com.example.assignments.checkoutsystem.repo.BucketRepo;
import com.example.assignments.checkoutsystem.repo.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * * Receipt REST API
 * 	* Get all receipts
 * 		* GET /receipts
 * 	* Create a receipt
 * 		* POST /receipts/buckets/{id}
 */
@RestController
public class ReceiptController {

    @Autowired
    private ReceiptRepo receiptRepo;

    @Autowired
    private BucketRepo bucketRepo;

    @GetMapping("/receipts/buckets/{id}")
    public ResponseEntity<Receipt> generateBill(@PathVariable Long id){
        Bucket bucket = bucketRepo.findById(id).orElse(null);
        if(bucket== null){
            throw new RuntimeException("No Bucket Found");
        }
        Receipt receipt = new Receipt();
        receipt.setBucket(bucket);
        receiptRepo.save(receipt);
        return new ResponseEntity<>(receipt, HttpStatus.CREATED);
    }
}
