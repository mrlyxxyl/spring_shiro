package com.tgb.shirodemo.shiroutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtils {

    private static Connection connection;

    static {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://192.168.2.111:3306/test";
            String username = "root";
            String password = "root";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

