package com.company;

import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceDB {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
