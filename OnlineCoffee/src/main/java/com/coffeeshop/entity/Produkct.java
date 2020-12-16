package com.coffeeshop.entity;

import lombok.Data;

@Data

public class Produkct {
    private int id;
    private String type;
    private String name;
    private String brand;
    private int price;

    public Produkct(String type, String name, String brand, int price) {
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
}