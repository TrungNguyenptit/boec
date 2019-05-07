/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO_implements;

import Boecv2_DAO.AddressDAO;
import entities.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trung Nguyen
 */
public class AddressDAO_impl implements AddressDAO{
    static Connection con = GetConnectionToDatabase.getConnection();
    @Override
    public int insertAddress(Address address) {
        int id=0;
        try {
            String query="INSERT INTO address(`Street`, `District`, `City`) VALUES(?,?,?)";
            PreparedStatement prs = con.prepareStatement(query,
                                      Statement.RETURN_GENERATED_KEYS);
            prs.setString(1,address.getStreet());
            prs.setString(2,address.getDistrict());
            prs.setString(3,address.getCity());
            prs.executeUpdate();
            ResultSet rs = prs.getGeneratedKeys();
            if(rs.next()){
                id= rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    @Override
    public Address getaAddress(int id) {
        Address add=null;
       String query = "SELECT * FROM address WHERE ID = ?";
        try {
            PreparedStatement prs = con.prepareCall(query);
            prs.setInt(1,id);
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
               add = new Address();
               add.setId(rs.getInt("ID"));
               add.setStreet(rs.getString("Street"));
               add.setDistrict(rs.getString("District"));
               add.setCity(rs.getString("City"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return add;
    }
    
}
