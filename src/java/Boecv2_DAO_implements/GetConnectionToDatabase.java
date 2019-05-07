/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO_implements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Trung Nguyen
 */
public class GetConnectionToDatabase {
    private static Connection connection = null; 
    public static Connection getConnection(){
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/boec";
                String username = "root";
                String password = "";
                try {
                    connection = DriverManager.getConnection(url, username, password);
                    System.out.println("Connected!");
// assuming your SQL Server's	username is "username"               
// and password is "password"
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        }
        return connection;
    }
}
