package com.coffeeshop.dao;

import com.coffeeshop.entity.Customer;

import java.io.IOException;
import java.sql.SQLException;

public interface CustomerDao {

        Customer findByPhone(String phone) throws SQLException;

        Boolean save(Customer customer) throws IOException;
        public int getIdByPhone(String name) throws SQLException;

}
