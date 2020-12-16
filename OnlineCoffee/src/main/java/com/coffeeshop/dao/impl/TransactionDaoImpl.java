package com.coffeeshop.dao.impl;

import com.coffeeshop.ConnectionManager;
import com.coffeeshop.dao.TransactionDao;
import com.coffeeshop.entity.Transaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDaoImpl implements TransactionDao {

    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    private Object Customer;

    public TransactionDaoImpl() throws IOException {
    }


    @Override
    public Transaction findByCheck(String check) throws SQLException {
        Transaction transaction = null;
        if (con != null) {
            PreparedStatement pr = con.prepareStatement("SELECT * FROM \"Transaction\" where check=?");
            pr.setString(1 , check);
            ResultSet resultSet = pr.executeQuery();//return sql result
            if(resultSet.next()) {
                int customerId = resultSet.getInt("customerId");
                int productId = resultSet.getInt("productId");
                int quantity = resultSet.getInt("quantity");
                boolean delivery = resultSet.getBoolean("delivery");
                int sum = resultSet.getInt("sum");


                transaction = new Transaction(customerId,productId,quantity,delivery,sum);

                return transaction;
            }
            pr.close();
            con.close();
        }

        return transaction;

    }

    @Override
    public Boolean save(Transaction transaction) throws IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        if (con != null) {
            try {
                PreparedStatement pr = con.prepareStatement("insert into \"Transaction\" (customerId, productId, quantity, delivery, sum ) values (?,?,?,?,?)");
                pr.setInt(1,transaction.getCustomerId());
                pr.setInt(2,transaction.getProductId());
                pr.setInt(3,transaction.getQuantity());
                pr.setBoolean(4,transaction.isDelivery());
                pr.setInt(5,transaction.getSum());
                pr.executeUpdate();
                pr.close();
                con.close();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
