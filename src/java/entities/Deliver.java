/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "deliver")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliver.findAll", query = "SELECT d FROM Deliver d")
    , @NamedQuery(name = "Deliver.findById", query = "SELECT d FROM Deliver d WHERE d.id = :id")
    , @NamedQuery(name = "Deliver.findByDeliveryDate", query = "SELECT d FROM Deliver d WHERE d.deliveryDate = :deliveryDate")})
public class Deliver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DeliveryDate")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliverID")
    private List<Bill> billList;
    @JoinColumn(name = "CourierPersonID", referencedColumnName = "PersonID")
    @ManyToOne(optional = false)
    private Courier courierPersonID;

    public Deliver() {
    }

    public Deliver(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public Courier getCourierPersonID() {
        return courierPersonID;
    }

    public void setCourierPersonID(Courier courierPersonID) {
        this.courierPersonID = courierPersonID;
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
        if (!(object instanceof Deliver)) {
            return false;
        }
        Deliver other = (Deliver) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Deliver[ id=" + id + " ]";
    }
    
}
