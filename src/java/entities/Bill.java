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
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b")
    , @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id")
    , @NamedQuery(name = "Bill.findByPrintdate", query = "SELECT b FROM Bill b WHERE b.printdate = :printdate")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Printdate")
    @Temporal(TemporalType.DATE)
    private Date printdate;
    @JoinColumn(name = "OnlineOrderOrderID", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Onlineorder onlineOrderOrderID;
    @JoinColumn(name = "OnlineSalesmanPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Onlinesalesman onlineSalesmanPersonID;
    @JoinColumn(name = "DeliverID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Deliver deliverID;

    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPrintdate() {
        return printdate;
    }

    public void setPrintdate(Date printdate) {
        this.printdate = printdate;
    }

    public Onlineorder getOnlineOrderOrderID() {
        return onlineOrderOrderID;
    }

    public void setOnlineOrderOrderID(Onlineorder onlineOrderOrderID) {
        this.onlineOrderOrderID = onlineOrderOrderID;
    }

    public Onlinesalesman getOnlineSalesmanPersonID() {
        return onlineSalesmanPersonID;
    }

    public void setOnlineSalesmanPersonID(Onlinesalesman onlineSalesmanPersonID) {
        this.onlineSalesmanPersonID = onlineSalesmanPersonID;
    }

    public Deliver getDeliverID() {
        return deliverID;
    }

    public void setDeliverID(Deliver deliverID) {
        this.deliverID = deliverID;
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
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bill[ id=" + id + " ]";
    }
    
}
