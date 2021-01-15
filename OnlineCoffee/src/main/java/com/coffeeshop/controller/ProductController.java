package com.coffeeshop.controller;

import com.coffeeshop.entity.Customer;
import com.coffeeshop.entity.Produkct;
import com.coffeeshop.service.CustomerService;
import  com.coffeeshop.service.CustomerServiceImpl;
import com.coffeeshop.service.ProducktServiceImpl;
import com.coffeeshop.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class ProductController {

    ProductService productService = new ProducktServiceImpl();

    public ProductController() throws IOException {
    }


    @RequestMapping("/addproduct")
    ModelAndView addProd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product.html");

        return modelAndView;
    }


    @PostMapping("/addproduct")
    String addproduct(@RequestParam String type,
                        @RequestParam String name,
                        @RequestParam String brand,
                        @RequestParam int price) throws IOException, SQLException {

        Produkct produkct = new Produkct(type, name, brand, price);

        produkct.setType(type);
        produkct.setName(name);
        produkct.setBrand(brand);
        produkct.setPrice(price);

        return productService.addproduct(produkct);

    }

    @RequestMapping("/delproduct")
    ModelAndView delProd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("delproduct.html");

        return modelAndView;
    }


    @PostMapping ("/delproduct")
    String delproduct(@RequestParam String type,
                      @RequestParam String name,
                      @RequestParam String brand,
                      @RequestParam int price) throws IOException, SQLException {

        Produkct produkct = new Produkct(type, name, brand, price);

        produkct.setType(type);
        produkct.setName(name);
        produkct.setBrand(brand);
        produkct.setPrice(price);

        return productService.delproduct(produkct);

    }
    @RequestMapping("/findproduct")
    ModelAndView findProduct(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("findproduct.html");

        return modelAndView;
    }


    @PostMapping ("/findproduct")
    String findProductt (@RequestParam int id) throws SQLException, IOException {

        return productService.findProd(id);

    }
}