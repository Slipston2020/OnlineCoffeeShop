package com.coffeeshop.dao.impl;

import com.coffeeshop.ConnectionManager;
;import com.coffeeshop.dao.ProdukctDao;
import com.coffeeshop.entity.Produkct;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdukctDaoImpl implements ProdukctDao {

    ConnectionManager cm = new ConnectionManager();
    Connection con = cm.getConnection();
    private Object Customer;

    public ProdukctDaoImpl() throws IOException {
    }


    @Override
    public Produkct findByBrand(String brand) throws SQLException {
        Produkct produkct = null;
        if (con != null) {
            PreparedStatement pr = con.prepareStatement("SELECT * FROM \"product\" where brand=?");
            pr.setString(1, brand);
            ResultSet resultSet = pr.executeQuery();//return sql result
            if (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");

                int price = resultSet.getInt("price");

                produkct = new Produkct(type, name, brand, price);

                return produkct;
            }
            pr.close();
            con.close();
        }

        return produkct;

    }

    @Override
    public Boolean save(Produkct produkct) throws IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        if (con != null) {
            try {
                PreparedStatement pr = con.prepareStatement("insert into \"product\" (type,name,brand,price) values (?,?,?,?)");
                pr.setString(1, produkct.getType());
                pr.setString(2, produkct.getName());
                pr.setString(3, produkct.getBrand());
                pr.setInt(4, produkct.getPrice());
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
    public Boolean delll(Produkct produkct) throws IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        if (con != null) {
            try {
                PreparedStatement pr = con.prepareStatement("delete from \"product\" where type = ? and brand = ?");
                pr.setString(1, produkct.getType());
                pr.setString(2, produkct.getBrand());
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
    public Produkct findProdByID(int prodId) throws  IOException {
        ConnectionManager cm = new ConnectionManager();
        Connection con = cm.getConnection();
        if (con != null)
            try {
                PreparedStatement pr = con.prepareStatement("SELECT * FROM \"product\" WHERE ID=?");
                pr.setInt(1, prodId);
                ResultSet resultSet = pr.executeQuery();

                if (resultSet.next()) {

                    String type = resultSet.getString("type");
                    String name = resultSet.getString("name");
                    String brand = resultSet.getString("brand");
                    int price = resultSet.getInt("price");

                    return new Produkct(type,name,brand,price);
                }


            } catch (Exception e) {
                e.printStackTrace();

            }
        return null;
    }


}
