package com.coffeeshop;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    FileInputStream fis;
    Properties property = new Properties();


    public Connection getConnection() throws IOException {

        fis = new FileInputStream("src/main/resources/application.properties");
        property.load(fis);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(property.getProperty("spring.datasource.url"),property.getProperty("spring.datasource.username"),property.getProperty("spring.datasource.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
