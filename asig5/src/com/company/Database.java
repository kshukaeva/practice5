package com.company;

import java.sql.*;

public class Database implements InterfaceDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/simpledb", "postgres", "1234");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}