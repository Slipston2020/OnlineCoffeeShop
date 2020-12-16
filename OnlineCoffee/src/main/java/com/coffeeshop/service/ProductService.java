package com.coffeeshop.service;

import com.coffeeshop.entity.Customer;
import com.coffeeshop.entity.Produkct;

import java.io.IOException;
import java.sql.SQLException;

public interface ProductService {

    public String addproduct (Produkct produkct) throws IOException, SQLException;
}
