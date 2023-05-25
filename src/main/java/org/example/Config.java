package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static final String user = "postgres";
    private static final String password = "2510";
    private static final String dataBase = "MyBase";
    private static final String url = "jdbc:postgresql://localhost:5432/" + dataBase;
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
