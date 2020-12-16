package com.coffeeshop.dao;

import com.coffeeshop.entity.Transaction;

import java.io.IOException;
import java.sql.SQLException;

public interface TransactionDao {

    Transaction findByCheck(String check) throws SQLException;

    Boolean save(Transaction transaction) throws IOException;


}
