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


    }
