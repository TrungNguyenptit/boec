/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "registry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registry.findAll", query = "SELECT r FROM Registry r")
    , @NamedQuery(name = "Registry.findById", query = "SELECT r FROM Registry r WHERE r.id = :id")
    , @NamedQuery(name = "Registry.findByRegistrationDate", query = "SELECT r FROM Registry r WHERE r.registrationDate = :registrationDate")})
public class Registry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RegistrationDate")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @JoinColumn(name = "CustomerAccountAccountID", referencedColumnName = "AccountID")
    @ManyToOne(optional = false)
    private Customeraccount customerAccountAccountID;
    @JoinColumn(name = "OnlineCustomerPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Onlinecustomer onlineCustomerPersonID;

    public Registry() {
    }

    public Registry(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Customeraccount getCustomerAccountAccountID() {
        return customerAccountAccountID;
    }

    public void setCustomerAccountAccountID(Customeraccount customerAccountAccountID) {
        this.customerAccountAccountID = customerAccountAccountID;
    }

    public Onlinecustomer getOnlineCustomerPersonID() {
        return onlineCustomerPersonID;
    }

    public void setOnlineCustomerPersonID(Onlinecustomer onlineCustomerPersonID) {
        this.onlineCustomerPersonID = onlineCustomerPersonID;
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
        if (!(object instanceof Registry)) {
            return false;
        }
        Registry other = (Registry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Registry[ id=" + id + " ]";
    }
    
}
