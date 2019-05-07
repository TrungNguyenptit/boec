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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "counterorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Counterorder.findAll", query = "SELECT c FROM Counterorder c")
    , @NamedQuery(name = "Counterorder.findByOrderID", query = "SELECT c FROM Counterorder c WHERE c.orderID = :orderID")})
public class Counterorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderID")
    private Integer orderID;
    @JoinTable(name = "counterorder_countersalesman", joinColumns = {
        @JoinColumn(name = "CounterOrderOrderID", referencedColumnName = "OrderID")}, inverseJoinColumns = {
        @JoinColumn(name = "CounterSalesmanPersonID", referencedColumnName = "PersonID")})
    @ManyToMany
    private List<Countersalesman> countersalesmanList;
    @JoinColumn(name = "CounterCustomerPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Countercustomer counterCustomerPersonID;
    @JoinColumn(name = "CounterPaymentPaymentID", referencedColumnName = "PaymentID")
    @ManyToOne(optional = false)
    private Counterpayment counterPaymentPaymentID;
    @JoinColumn(name = "OrderID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Order1 order1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "counterOrderOrderID")
    private List<Merchandise> merchandiseList;

    public Counterorder() {
    }

    public Counterorder(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @XmlTransient
    public List<Countersalesman> getCountersalesmanList() {
        return countersalesmanList;
    }

    public void setCountersalesmanList(List<Countersalesman> countersalesmanList) {
        this.countersalesmanList = countersalesmanList;
    }

    public Countercustomer getCounterCustomerPersonID() {
        return counterCustomerPersonID;
    }

    public void setCounterCustomerPersonID(Countercustomer counterCustomerPersonID) {
        this.counterCustomerPersonID = counterCustomerPersonID;
    }

    public Counterpayment getCounterPaymentPaymentID() {
        return counterPaymentPaymentID;
    }

    public void setCounterPaymentPaymentID(Counterpayment counterPaymentPaymentID) {
        this.counterPaymentPaymentID = counterPaymentPaymentID;
    }

    public Order1 getOrder1() {
        return order1;
    }

    public void setOrder1(Order1 order1) {
        this.order1 = order1;
    }

    @XmlTransient
    public List<Merchandise> getMerchandiseList() {
        return merchandiseList;
    }

    public void setMerchandiseList(List<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Counterorder)) {
            return false;
        }
        Counterorder other = (Counterorder) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Counterorder[ orderID=" + orderID + " ]";
    }
    
}
