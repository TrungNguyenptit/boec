/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_model;

/**
 *
 * @author Trung Nguyen
 */
public class AccountSing {
    private int id;
    private String username;
    private String password;
    private static AccountSing instance = new AccountSing();

    public AccountSing() {
    }
    
    public static AccountSing getInstance(){
        return instance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "AccountSing{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }
    
}
