package com.example.transaction_service.dto;

public class TransactionDetailsDTO {

    private Long transactionId;
    private UserDTO seller;
    private UserDTO buyer;
    private GoodsDTO goods;
    private int quantity;
    private double totalPrice;

    // Constructor, getters, and setters

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public UserDTO getSeller() {
        return seller;
    }

    public void setSeller(UserDTO seller) {
        this.seller = seller;
    }

    public UserDTO getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDTO buyer) {
        this.buyer = buyer;
    }

    public GoodsDTO getGoods() {
        return goods;
    }

    public void setGoods(GoodsDTO goods) {
        this.goods = goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
