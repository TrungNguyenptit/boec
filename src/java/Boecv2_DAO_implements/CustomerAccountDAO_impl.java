/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO_implements;

import Boecv2_DAO.CustomerAccountDAO;
import entities.Customeraccount;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trung Nguyen
 */
public class CustomerAccountDAO_impl implements CustomerAccountDAO {

    @Override
    public void insertCutomerAccount(Customeraccount ca) {
        try {
        String query="INSERT INTO `customeraccount`(`AccountID`) VALUES(?) ";
            PreparedStatement prs = GetConnectionToDatabase.getConnection().prepareCall(query);
            prs.setInt(1, ca.getAccountID());
            prs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerAccountDAO_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
