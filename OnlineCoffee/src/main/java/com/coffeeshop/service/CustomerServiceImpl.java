package com.coffeeshop.service;

import com.coffeeshop.dao.CustomerDao;
import com.coffeeshop.dao.impl.CustomerDaoImpl;
import com.coffeeshop.entity.Customer;
import org.springframework.util.DigestUtils;



import java.io.IOException;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    public CustomerServiceImpl() throws IOException {
    }


    @Override
    public String login(String phone, String password) throws SQLException {
        Customer findCustomer = customerDao.findByPhone(phone);
        if (password == null) {
            return "no password entered!";
        }
        if (findCustomer != null){
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (password.equals(findCustomer.getPassword())) {
                return "OK! Customer ID is: " + customerDao.getIdByPhone(phone);
            }
        }

        return "Authorization failed!";
    }

    @Override
    public String registration(Customer customer) throws IOException, SQLException {
        Customer findCustomer = customerDao.findByPhone(customer.getName());
        if(findCustomer == null) {
            customerDao.save(customer);
            return "Fine!";
        }

        return "This login is not available!";

    }
}