package com.coffeeshop.service;

import com.coffeeshop.dao.CustomerDao;
import com.coffeeshop.dao.ProdukctDao;
import com.coffeeshop.dao.impl.ProdukctDaoImpl;
import com.coffeeshop.entity.Produkct;


import java.io.IOException;
import java.sql.SQLException;

public class ProducktServiceImpl implements ProductService {
    ProdukctDao produkctDao = new ProdukctDaoImpl();

    public ProducktServiceImpl() throws IOException {
    }

    public void ProducktServiceImpl() throws IOException {
    }


    @Override
    public String addproduct(Produkct produkct) throws IOException, SQLException {
            produkctDao.save(produkct);
            return "Fine!";
        }

    @Override
        public String delproduct(Produkct produkct) throws IOException, SQLException {
        produkctDao.delll(produkct);
        return "Fine!";

    }
    @Override
    public String findProd(int id) throws IOException, SQLException {
       Produkct foundProduct =  produkctDao.findProdByID(id);
        if (id == 0) {
            return "No iD entered";
        }

        if (foundProduct != null) {

                         return "Fine! product ID: " + id + " type ID: "
                        + foundProduct.getType() + " name : "
                        + foundProduct.getName() + " brand: "
                        + foundProduct.getBrand() + " price: "
                        + foundProduct.getPrice();
            }



        return null;
    }


}
