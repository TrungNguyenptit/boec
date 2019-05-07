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
@Table(name = "counterpayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Counterpayment.findAll", query = "SELECT c FROM Counterpayment c")
    , @NamedQuery(name = "Counterpayment.findByPaymentID", query = "SELECT c FROM Counterpayment c WHERE c.paymentID = :paymentID")})
public class Counterpayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PaymentID")
    private Integer paymentID;
    @JoinColumn(name = "PaymentID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Payment payment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "counterPaymentPaymentID")
    private List<Counterorder> counterorderList;

    public Counterpayment() {
    }

    public Counterpayment(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @XmlTransient
    public List<Counterorder> getCounterorderList() {
        return counterorderList;
    }

    public void setCounterorderList(List<Counterorder> counterorderList) {
        this.counterorderList = counterorderList;
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
        if (!(object instanceof Counterpayment)) {
            return false;
        }
        Counterpayment other = (Counterpayment) object;
        if ((this.paymentID == null && other.paymentID != null) || (this.paymentID != null && !this.paymentID.equals(other.paymentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Counterpayment[ paymentID=" + paymentID + " ]";
    }
    
}
