/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_DAO;

import entities.Address;

/**
 *
 * @author Trung Nguyen
 */
public interface AddressDAO {
    public int insertAddress(Address address);
    public Address getaAddress(int id);
}
