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
@Table(name = "onlinepayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlinepayment.findAll", query = "SELECT o FROM Onlinepayment o")
    , @NamedQuery(name = "Onlinepayment.findByPaymentID", query = "SELECT o FROM Onlinepayment o WHERE o.paymentID = :paymentID")})
public class Onlinepayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PaymentID")
    private Integer paymentID;
    @JoinColumn(name = "CardID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Card cardID;
    @JoinColumn(name = "PaymentID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Payment payment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onlinePaymentPaymentID")
    private List<Onlineorder> onlineorderList;

    public Onlinepayment() {
    }

    public Onlinepayment(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Card getCardID() {
        return cardID;
    }

    public void setCardID(Card cardID) {
        this.cardID = cardID;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @XmlTransient
    public List<Onlineorder> getOnlineorderList() {
        return onlineorderList;
    }

    public void setOnlineorderList(List<Onlineorder> onlineorderList) {
        this.onlineorderList = onlineorderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentID != null ? paymentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onlinepayment)) {
            return false;
        }
        Onlinepayment other = (Onlinepayment) object;
        if ((this.paymentID == null && other.paymentID != null) || (this.paymentID != null && !this.paymentID.equals(other.paymentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Onlinepayment[ paymentID=" + paymentID + " ]";
    }
    
}
