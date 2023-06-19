package com.example.assignments.checkoutsystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "product_id")
    private Long productId;

    private int quantity;
    private double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity && Double.compare(item.total, total) == 0 && Objects.equals(id, item.id) && Objects.equals(productId, item.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, quantity, total);
    }

    public static Item of(Long productId, int quantity, double  total ){
        Item item = new Item();
        item.setProductId(productId);
        item.setQuantity(quantity);
        item.setTotal(total);
        return item;
    }
}
