package com.example.assignments.checkoutsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Receipt {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Bucket bucket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", bucket=" + bucket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(id, receipt.id) && Objects.equals(bucket, receipt.bucket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bucket);
    }
}
