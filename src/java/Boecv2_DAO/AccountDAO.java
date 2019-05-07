/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO;

import Boecv2_model.AccountSing;
import entities.Account;
import javax.ejb.EJB;

/**
 *
 * @author Trung Nguyen
 */
public interface AccountDAO {
    public int insertAccount(Account account);
    public AccountSing getAccount(int id);
}
