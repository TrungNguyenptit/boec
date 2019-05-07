/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO;

import entities.Fullname;

/**
 *
 * @author Trung Nguyen
 */
public interface FullNameDAO {
    public int insertFullName(Fullname fullname);
    public Fullname getaFullName(int id);
}
