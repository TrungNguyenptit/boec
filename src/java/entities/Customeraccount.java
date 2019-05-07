/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "customeraccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customeraccount.findAll", query = "SELECT c FROM Customeraccount c")
    , @NamedQuery(name = "Customeraccount.findByAccountID", query = "SELECT c FROM Customeraccount c WHERE c.accountID = :accountID")})
public class Customeraccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AccountID")
    private Integer accountID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerAccountAccountID")
    private List<Cart> cartList;
    @JoinColumn(name = "AccountID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerAccountAccountID")
    private List<Contribute> contributeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerAccountAccountID")
    private List<Registry> registryList;

    public Customeraccount() {
    }

    public Customeraccount(Integer accountID) {
        this.accountID = accountID;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    @XmlTransient
    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @XmlTransient
    public List<Contribute> getContributeList() {
        return contributeList;
    }

    public void setContributeList(List<Contribute> contributeList) {
        this.contributeList = contributeList;
    }

    @XmlTransient
    public List<Registry> getRegistryList() {
        return registryList;
    }

    public void setRegistryList(List<Registry> registryList) {
        this.registryList = registryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customeraccount)) {
            return false;
        }
        Customeraccount other = (Customeraccount) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Customeraccount[ accountID=" + accountID + " ]";
    }
    
}
