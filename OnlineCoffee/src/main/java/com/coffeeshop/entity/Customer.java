package com.coffeeshop.entity;

import lombok.Data;

@Data

    public class Customer {
        private int id;
        private String name;
        private String phone;
        private String password;
        private String email;

        public Customer(String name, String phone, String email, String password) {
            this.name = name;
            this.phone = phone;
            this.password = password;
            this.email = email;
        }

    public void setDiscount(int discount) {
    }
}
