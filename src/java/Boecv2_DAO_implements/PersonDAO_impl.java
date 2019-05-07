/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO_implements;

import Boecv2_DAO.PersonDAO;
import entities.Address;
import entities.Fullname;
import entities.Person;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trung Nguyen
 */
public class PersonDAO_impl implements PersonDAO{

    @Override
    public void insertPerson(Person person) {
       try {
        String query="INSERT INTO `person`(`FullNameID`, `AddressID`, `Dateofbirth`) VALUES (?,?,?)";
            PreparedStatement prs = GetConnectionToDatabase.getConnection().prepareCall(query);
            prs.setInt(1, person.getAddressID().getId());
            prs.setInt(2, person.getFullNameID().getId());
            prs.setDate(3, new java.sql.Date(person.getDateofbirth().getTime()));
            prs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
