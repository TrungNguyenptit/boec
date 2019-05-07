/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "accessories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessories.findAll", query = "SELECT a FROM Accessories a")
    , @NamedQuery(name = "Accessories.findByMerchandiseID", query = "SELECT a FROM Accessories a WHERE a.merchandiseID = :merchandiseID")})
public class Accessories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MerchandiseID")
    private Integer merchandiseID;
    @JoinColumn(name = "MerchandiseID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Merchandise merchandise;

    public Accessories() {
    }

    public Accessories(Integer merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public Integer getMerchandiseID() {
        return merchandiseID;
    }

    public void setMerchandiseID(Integer merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merchandiseID != null ? merchandiseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessories)) {
            return false;
        }
        Accessories other = (Accessories) object;
        if ((this.merchandiseID == null && other.merchandiseID != null) || (this.merchandiseID != null && !this.merchandiseID.equals(other.merchandiseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Accessories[ merchandiseID=" + merchandiseID + " ]";
    }
    
}
