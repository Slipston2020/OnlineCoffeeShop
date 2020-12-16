package com.coffeeshop.entity;

import lombok.Data;

@Data

public class Transaction {
    private int id;
    private int customerId;
    private int productId;
    private int quantity;
    private boolean delivery;
    private int sum;


    public Transaction (int customerId,int productId,int quantity, boolean delivery, int sum) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.delivery = delivery;
        this.sum = sum;


    }


}