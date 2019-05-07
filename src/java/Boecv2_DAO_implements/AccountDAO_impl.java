/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO_implements;

import Boecv2_DAO.AccountDAO;
import Boecv2_model.AccountSing;
import entities.Account;
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
public class AccountDAO_impl implements AccountDAO{
    static Connection con = GetConnectionToDatabase.getConnection();
    @Override
    public int insertAccount(Account account) {
        int id = 0;
        try {
        String query="INSERT INTO account(Username,Password) VALUES(?,?)";
            PreparedStatement prs = con.prepareStatement(query,
                                      Statement.RETURN_GENERATED_KEYS);
            prs.setString(1, account.getUsername());
            prs.setString(2, account.getPassword());
            prs.executeUpdate();
            ResultSet rs = prs.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
                System.out.println(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public AccountSing getAccount(int id) {
        AccountSing account = AccountSing.getInstance();
        try {
        String query="SELECT * FROM account WHERE ID=?";
            PreparedStatement prs = con.prepareCall(query);
            prs.setInt(1, id);
            ResultSet rs = prs.executeQuery();
            while(rs.next()){
                account.setId(rs.getInt("ID"));
                account.setUsername(rs.getString("Username"));
                account.setPassword(rs.getString("Password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    
}
