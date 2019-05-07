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
@Table(name = "onlineorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlineorder.findAll", query = "SELECT o FROM Onlineorder o")
    , @NamedQuery(name = "Onlineorder.findByOrderID", query = "SELECT o FROM Onlineorder o WHERE o.orderID = :orderID")})
public class Onlineorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderID")
    private Integer orderID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onlineOrderOrderID")
    private List<Bill> billList;
    @JoinColumn(name = "CartID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cart cartID;
    @JoinColumn(name = "DiscountCodeID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Discountcode discountCodeID;
    @JoinColumn(name = "OnlinePaymentPaymentID", referencedColumnName = "PaymentID")
    @ManyToOne(optional = false)
    private Onlinepayment onlinePaymentPaymentID;
    @JoinColumn(name = "DeliverryID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Deliverry deliverryID;
    @JoinColumn(name = "OrderID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Order1 order1;

    public Onlineorder() {
    }

    public Onlineorder(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public Cart getCartID() {
        return cartID;
    }

    public void setCartID(Cart cartID) {
        this.cartID = cartID;
    }

    public Discountcode getDiscountCodeID() {
        return discountCodeID;
    }

    public void setDiscountCodeID(Discountcode discountCodeID) {
        this.discountCodeID = discountCodeID;
    }

    public Onlinepayment getOnlinePaymentPaymentID() {
        return onlinePaymentPaymentID;
    }

    public void setOnlinePaymentPaymentID(Onlinepayment onlinePaymentPaymentID) {
        this.onlinePaymentPaymentID = onlinePaymentPaymentID;
    }

    public Deliverry getDeliverryID() {
        return deliverryID;
    }

    public void setDeliverryID(Deliverry deliverryID) {
        this.deliverryID = deliverryID;
    }

    public Order1 getOrder1() {
        return order1;
    }

    public void setOrder1(Order1 order1) {
        this.order1 = order1;
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
        if (!(object instanceof Onlineorder)) {
            return false;
        }
        Onlineorder other = (Onlineorder) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Onlineorder[ orderID=" + orderID + " ]";
    }
    
}
