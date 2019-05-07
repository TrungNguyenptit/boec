/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boecv2_servlet;

import Boecv2_DAO.FullNameDAO;
import Boecv2_DAO_implements.AccountDAO_impl;
import Boecv2_DAO_implements.AddressDAO_impl;
import Boecv2_DAO_implements.CustomerAccountDAO_impl;
import Boecv2_DAO_implements.FullNameDAO_impl;
import Boecv2_DAO_implements.PersonDAO_impl;
import Boecv2_model.User;
import Boecv2_model.AccountSing;
import entities.Account;
import entities.Address;
import entities.Customeraccount;
import entities.Fullname;
import entities.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Trung Nguyen
 */
@WebServlet(name = "doRegister", urlPatterns = {"/doRegister"})
public class doRegister extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        HttpSession session = request.getSession();
        processRequest(request, response);
        boolean success = true;
        User user = null;
        AccountSing accountsing = null;
        Account account = null;
        Address address = null;
        Fullname fullname = null;
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");
        if (password.equals(confirmpassword) == false) {
            success = false;
            user = getUser(request);
        }
        if (success) {
            user = getUser(request);
            System.out.println(user.toString());
            accountsing = getAccountSing(user);
            System.out.println(accountsing.toString());
            account = getAccount(accountsing);
            System.out.println(account.toString());
            address = getAddress(user);
            fullname = getFullName(user);
            //session.setAttribute("acc", accountsing);
            AccountDAO_impl accdao = new AccountDAO_impl();
            AddressDAO_impl adddao = new AddressDAO_impl();
            FullNameDAO_impl fundao = new FullNameDAO_impl();
            CustomerAccountDAO_impl acdao = new CustomerAccountDAO_impl();
            PersonDAO_impl perdao = new PersonDAO_impl();
            int accountid = accdao.insertAccount(account);
            int addressid = adddao.insertAddress(address);
            int fullnameid = fundao.insertFullName(fullname);
            perdao.insertPerson(getPerson(request, adddao.getaAddress(addressid), fundao.getaFullName(fullnameid)));
            Customeraccount ca = new Customeraccount(new Integer(accountid));
            acdao.insertCutomerAccount(ca);
            RequestDispatcher dipatcher = request.getRequestDispatcher("index.html");
            dipatcher.forward(request, response);
        } else {
            session.setAttribute("Diff", "Two Password Fields don't fit");
            session.setAttribute("user", user);
            response.sendRedirect("login-register.jsp");

        }
    }

    public User getUser(HttpServletRequest request) {
        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstname = setCharacterEncoding(request.getParameter("firstname"));
        String lastname = setCharacterEncoding(request.getParameter("lastname"));
        String street =(String) request.getParameter("street");
        String district = setCharacterEncoding(request.getParameter("district"));
        String city = setCharacterEncoding(request.getParameter("city"));
        //1 2 3 4 5
        if (firstname.equals("") && !lastname.equals("") && !street.equals("") && !district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).lastname(lastname).street(street).district(district).city(city).build();
        } else if (!firstname.equals("") && lastname.equals("") && !street.equals("") && !district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).street(street).district(district).city(city).build();
        } else if (firstname.equals("") && !lastname.equals("") && street.equals("") && !district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).lastname(lastname).district(district).city(city).build();
        } else if (firstname.equals("") && !lastname.equals("") && !street.equals("") && district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).lastname(lastname).street(street).city(city).build();
        } else if (firstname.equals("") && !lastname.equals("") && !street.equals("") && !district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).lastname(lastname).street(street).district(district).build();
            //1,2 1,3 1,4 1,5
        } else if (firstname.equals("") && lastname.equals("") && !street.equals("") && !district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).street(street).district(district).city(city).build();
        } else if (firstname.equals("") && !lastname.equals("") && street.equals("") && !district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).lastname(lastname).district(district).city(city).build();
        } else if (firstname.equals("") && !lastname.equals("") && !street.equals("") && district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).lastname(lastname).street(street).city(city).build();
        } else if (firstname.equals("") && !lastname.equals("") && !street.equals("") && !district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).lastname(lastname).street(street).district(district).build();
            //2,3 2,4 2,5
        } else if (!firstname.equals("") && lastname.equals("") && street.equals("") && !district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).district(district).city(city).build();
        } else if (!firstname.equals("") && lastname.equals("") && !street.equals("") && district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).street(street).city(city).build();
        } else if (!firstname.equals("") && lastname.equals("") && !street.equals("") && !district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).street(street).district(district).build();
            //3,4 3,5
        } else if (!firstname.equals("") && !lastname.equals("") && street.equals("") && district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).lastname(lastname).city(city).build();
        } else if (!firstname.equals("") && !lastname.equals("") && street.equals("") && !district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).lastname(lastname).district(district).build();
            //4,5
        } else if (!firstname.equals("") && !lastname.equals("") && !street.equals("") && district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).lastname(lastname).firstname(firstname).street(street).build();
            //1,2,3 1,2,4 1,2,5 2,3,4 2,3,5 3,4,5
        } else if (firstname.equals("") && lastname.equals("") && street.equals("") && !district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).district(district).city(city).build();
        } else if (firstname.equals("") && lastname.equals("") && !street.equals("") && district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).street(street).city(city).build();
        } else if (firstname.equals("") && lastname.equals("") && !street.equals("") && !district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).street(street).district(district).build();
        } else if (!firstname.equals("") && lastname.equals("") && street.equals("") && district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).city(city).build();
        } else if (!firstname.equals("") && lastname.equals("") && street.equals("") && !district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).district(district).build();
        } else if (!firstname.equals("") && !lastname.equals("") && street.equals("") && district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).build();
            //1,2,3,4 2,3,4,5
        } else if (firstname.equals("") && lastname.equals("") && street.equals("") && district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).city(city).build();
        } else if (!firstname.equals("") && lastname.equals("") && street.equals("") && district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).build();
        } //full
        else if (!firstname.equals("") && !lastname.equals("") && !street.equals("") && !district.equals("") && !city.equals("")) {
            user = new User.UserBuilder(username, password).firstname(firstname).lastname(lastname).street(street).district(district).city(city).build();
        } else if (firstname.equals("") && lastname.equals("") && street.equals("") && district.equals("") && city.equals("")) {
            user = new User.UserBuilder(username, password).build();
        }
        return user;
    }

    public AccountSing getAccountSing(User user) {
        AccountSing accountsing = AccountSing.getInstance();
        accountsing.setUsername(user.getUsername());
        accountsing.setPassword(user.getPassword());
        return accountsing;
    }

    public Account getAccount(AccountSing accountsing) {
        Account account = new Account();
        account.setUsername(accountsing.getUsername());
        account.setPassword(accountsing.getPassword());
        return account;
    }

    public Address getAddress(User user) {
        Address add = new Address();
        add.setStreet(user.getStreet());
        add.setDistrict(user.getDistrict());
        add.setCity(user.getCity());
        return add;
    }

    public Fullname getFullName(User user) {
        Fullname fun = new Fullname();
        fun.setFirstname(user.getFirstname());
        fun.setLastname(user.getLastname());
        return fun;
    }

    public Person getPerson(HttpServletRequest request, Address addressid, Fullname fullnameid) {
        Person person = null;
        String date = request.getParameter("date");
        try {
            if (!date.equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date convertdate = new java.util.Date();
                convertdate = sdf.parse(date);
                person = new Person();
                person.setDateofbirth(convertdate);
                person.setAddressID(addressid);
                person.setFullNameID(fullnameid);
            } else {
                person = new Person();
                person.setDateofbirth(null);
                person.setAddressID(addressid);
                person.setFullNameID(fullnameid);
            }
        } catch (ParseException ex) {
            Logger.getLogger(doRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String setCharacterEncoding(String item) {
        byte[] bytes = item.getBytes(StandardCharsets.ISO_8859_1);
        item = new String(bytes, StandardCharsets.UTF_8);
        return item;
    }
}
