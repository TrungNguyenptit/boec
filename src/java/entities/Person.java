/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findById", query = "SELECT p FROM Person p WHERE p.id = :id")
    , @NamedQuery(name = "Person.findByDateofbirth", query = "SELECT p FROM Person p WHERE p.dateofbirth = :dateofbirth")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Countersalesman countersalesman;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Employee employee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Onlinesalesman onlinesalesman;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Author author;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Countercustomer countercustomer;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Courier courier;
    @JoinColumn(name = "AddressID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Address addressID;
    @JoinColumn(name = "FullNameID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Fullname fullNameID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Humanresourcemanager humanresourcemanager;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Warehousingemployee warehousingemployee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Onlinecustomer onlinecustomer;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Customer customer;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Countersalesman getCountersalesman() {
        return countersalesman;
    }

    public void setCountersalesman(Countersalesman countersalesman) {
        this.countersalesman = countersalesman;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Onlinesalesman getOnlinesalesman() {
        return onlinesalesman;
    }

    public void setOnlinesalesman(Onlinesalesman onlinesalesman) {
        this.onlinesalesman = onlinesalesman;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Countercustomer getCountercustomer() {
        return countercustomer;
    }

    public void setCountercustomer(Countercustomer countercustomer) {
        this.countercustomer = countercustomer;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Address getAddressID() {
        return addressID;
    }

    public void setAddressID(Address addressID) {
        this.addressID = addressID;
    }

    public Fullname getFullNameID() {
        return fullNameID;
    }

    public void setFullNameID(Fullname fullNameID) {
        this.fullNameID = fullNameID;
    }

    public Humanresourcemanager getHumanresourcemanager() {
        return humanresourcemanager;
    }

    public void setHumanresourcemanager(Humanresourcemanager humanresourcemanager) {
        this.humanresourcemanager = humanresourcemanager;
    }

    public Warehousingemployee getWarehousingemployee() {
        return warehousingemployee;
    }

    public void setWarehousingemployee(Warehousingemployee warehousingemployee) {
        this.warehousingemployee = warehousingemployee;
    }

    public Onlinecustomer getOnlinecustomer() {
        return onlinecustomer;
    }

    public void setOnlinecustomer(Onlinecustomer onlinecustomer) {
        this.onlinecustomer = onlinecustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Person[ id=" + id + " ]";
    }
    
}
