package com.example.transaction_service.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class GoodsDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private double price;
    private LocalDate expireDate;
    private int quantity;

    public GoodsDTO() {
    }

    public GoodsDTO(Long id, String name, String description, double price, LocalDate expireDate, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expireDate = expireDate;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString method
    @Override
    public String toString() {
        return "GoodsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", expireDate=" + expireDate +
                ", quantity=" + quantity +
                '}';
    }
}
