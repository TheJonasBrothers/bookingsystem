package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/bookingsystem";
    private static String username = "root";
    private static String password = "";
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try{
                try{
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url, username, password);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
}
