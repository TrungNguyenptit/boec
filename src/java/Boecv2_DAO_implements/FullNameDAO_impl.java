/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO_implements;

import Boecv2_DAO.FullNameDAO;
import entities.Address;
import entities.Fullname;
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
public class FullNameDAO_impl implements FullNameDAO{

    @Override
    public int insertFullName(Fullname fullname) {
        int id=0;
        try {
        String query="INSERT INTO `fullname`(`Firstname`, `Lastname`) VALUES(?,?)";
            PreparedStatement prs = GetConnectionToDatabase.getConnection().prepareStatement(query,
                                      Statement.RETURN_GENERATED_KEYS);
            prs.setString(1, fullname.getFirstname());
            prs.setString(2, fullname.getLastname());
            prs.executeUpdate();
            ResultSet rs = prs.getGeneratedKeys();
            if(rs.next()){
                id= rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FullNameDAO_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Fullname getaFullName(int id) {
        Fullname fun = null;
       String query = "SELECT * FROM fullname WHERE ID = ?";
        try {
            PreparedStatement prs = GetConnectionToDatabase.getConnection().prepareCall(query);
            prs.setInt(1,id);
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
                fun = new Fullname();
                fun.setId(rs.getInt("ID"));
                fun.setFirstname(rs.getString("Firstname"));
                fun.setLastname(rs.getString("Lastname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fun;
    }
    
}
