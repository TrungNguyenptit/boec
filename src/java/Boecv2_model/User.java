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
public class User {
    private final String username;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String street;
    private final String district;
    private final String city;
    private User(UserBuilder userbuilder){
        this.username= userbuilder.username;
        this.password = userbuilder.password;
        this.firstname = userbuilder.firstname;
        this.lastname = userbuilder.lastname;
        this.street = userbuilder.street;
        this.district = userbuilder.district;
        this.city = userbuilder.city;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStreet() {
        return street;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", street=" + street + ", district=" + district + ", city=" + city + '}';
    }


    
    public static class UserBuilder{
    private final String username;
    private final String password;
    private  String firstname;
    private  String lastname;
    private  String street;
    private  String district;
    private  String city;

    public UserBuilder(String username, String password) {
        this.username = username;
        this.password = password;
    }
      public UserBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }
        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public UserBuilder street(String street) {
            this.street = street;
            return this;
        }
        public UserBuilder district(String district) {
            this.district = district;
            return this;
        }
        public UserBuilder city(String city) {
            this.city = city;
            return this;
        }
        public User build(){
            User user = new User(this);
            return user;
        }
    }
}