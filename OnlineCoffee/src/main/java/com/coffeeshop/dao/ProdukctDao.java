package com.coffeeshop.dao;

import com.coffeeshop.entity.Customer;
import com.coffeeshop.entity.Produkct;

import java.io.IOException;
import java.sql.SQLException;

public interface ProdukctDao {

    Produkct findByBrand(String brand) throws SQLException;

    Boolean save (Produkct produkct) throws IOException;


}