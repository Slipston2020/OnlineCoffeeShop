package com.coffeeshop.dao.impl;

import com.coffeeshop.ConnectionManager;
import com.coffeeshop.dao.CustomerDao;
import com.coffeeshop.entity.Customer;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();


    public CustomerDaoImpl() throws IOException {
    }



    @Override
        public Customer findByPhone(String phone) throws SQLException {
            Customer customer = null;
            if (con != null) {
                PreparedStatement pr = con.prepareStatement("SELECT * FROM \"customers\" where PHONE=?");
                pr.setString(1 , phone);
                ResultSet resultSet = pr.executeQuery();//return sql result
                if(resultSet.next()) {
                    String name = resultSet.getString("NAME");
                    String email = resultSet.getString("EMAIL");
                    String password = resultSet.getString("PASSWORD");

                    customer = new Customer(name,phone,email,password);

                    return customer;
                }

                            }

        return customer;

        }

        @Override
        public Boolean save(Customer customer) throws IOException {
                            ConnectionManager cm = new ConnectionManager();
                Connection con = cm.getConnection();
                if (con != null) {
                    try {
                        PreparedStatement pr = con.prepareStatement("insert into \"customers\" (name,phone,email,password) values (?,?,?,?)");
                        pr.setString(1,customer.getName());
                        pr.setString(2,customer.getPhone());
                        pr.setString(3,customer.getEmail());
                        pr.setString(4, DigestUtils.md5DigestAsHex((customer.getPassword()).getBytes()));
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
            @Override

    public int getIdByPhone (String phone) throws SQLException {
                if (con != null) {

                    PreparedStatement preparedStatement
                            = con.prepareStatement("SELECT ID FROM \"customers\" WHERE PHONE=?");

                    preparedStatement.setString(1, phone);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {

                        int id = resultSet.getInt("id");

                        return id;

                    }

                }
                return -1;
            }
    }





