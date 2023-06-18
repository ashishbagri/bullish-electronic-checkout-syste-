package com.example.assignments.checkoutsystem.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Bucket {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bucket_id")
    private List<Item> items;

    private double total_price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", items=" + items +
                ", total_price=" + total_price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return Double.compare(bucket.total_price, total_price) == 0 && Objects.equals(id, bucket.id) && Objects.equals(items, bucket.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items, total_price);
    }
}
