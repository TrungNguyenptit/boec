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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "electronic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Electronic.findAll", query = "SELECT e FROM Electronic e")
    , @NamedQuery(name = "Electronic.findByWeight", query = "SELECT e FROM Electronic e WHERE e.weight = :weight")
    , @NamedQuery(name = "Electronic.findByColor", query = "SELECT e FROM Electronic e WHERE e.color = :color")
    , @NamedQuery(name = "Electronic.findByMerchandiseID", query = "SELECT e FROM Electronic e WHERE e.merchandiseID = :merchandiseID")})
public class Electronic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Weight")
    private float weight;
    @Size(max = 255)
    @Column(name = "Color")
    private String color;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MerchandiseID")
    private Integer merchandiseID;
    @JoinColumn(name = "BrandID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Brand brandID;
    @JoinColumn(name = "MerchandiseID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Merchandise merchandise;

    public Electronic() {
    }

    public Electronic(Integer merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public Electronic(Integer merchandiseID, float weight) {
        this.merchandiseID = merchandiseID;
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMerchandiseID() {
        return merchandiseID;
    }

    public void setMerchandiseID(Integer merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public Brand getBrandID() {
        return brandID;
    }

    public void setBrandID(Brand brandID) {
        this.brandID = brandID;
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
        if (!(object instanceof Electronic)) {
            return false;
        }
        Electronic other = (Electronic) object;
        if ((this.merchandiseID == null && other.merchandiseID != null) || (this.merchandiseID != null && !this.merchandiseID.equals(other.merchandiseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Electronic[ merchandiseID=" + merchandiseID + " ]";
    }
    
}
