package Boecv2_model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Trung Nguyen
 */
public class CheckUser {
     public boolean checkLogin(String username, String password){
        if(username.equals("s") && password.equals("1")){
            return true;
        }else{
            return false;
        }
    }
}
