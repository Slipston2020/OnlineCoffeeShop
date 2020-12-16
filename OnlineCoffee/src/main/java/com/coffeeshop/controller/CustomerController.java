package com.coffeeshop.controller;

import com.coffeeshop.entity.Customer;
import com.coffeeshop.service.CustomerService;
import  com.coffeeshop.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@RestController
public class CustomerController {

    CustomerService customerService = new CustomerServiceImpl();

    public CustomerController() throws IOException {
    }

    @RequestMapping("/login")
    ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginform.html");

        return modelAndView;
    }

    @RequestMapping("/registration")
    ModelAndView regForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("regform.html");

        return modelAndView;
    }

    @PostMapping("/login")
    String login(@RequestParam String phone,
                 @RequestParam String password) throws SQLException {

        return customerService.login(phone, password);
    }

    @PostMapping("/registration")
    String registration(@RequestParam String name,
                        @RequestParam String phone,
                        @RequestParam String password,
                        @RequestParam String email) throws IOException, SQLException {

        Customer customer = new Customer(name, phone, email, password);

        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
        customer.setPassword(password);

        return customerService.registration(customer);

    }

}