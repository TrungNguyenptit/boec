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
@Table(name = "clothes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clothes.findAll", query = "SELECT c FROM Clothes c")
    , @NamedQuery(name = "Clothes.findBySex", query = "SELECT c FROM Clothes c WHERE c.sex = :sex")
    , @NamedQuery(name = "Clothes.findByType", query = "SELECT c FROM Clothes c WHERE c.type = :type")
    , @NamedQuery(name = "Clothes.findByColor", query = "SELECT c FROM Clothes c WHERE c.color = :color")
    , @NamedQuery(name = "Clothes.findByMerchandiseID", query = "SELECT c FROM Clothes c WHERE c.merchandiseID = :merchandiseID")})
public class Clothes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "Sex")
    private String sex;
    @Size(max = 255)
    @Column(name = "Type")
    private String type;
    @Size(max = 255)
    @Column(name = "Color")
    private String color;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MerchandiseID")
    private Integer merchandiseID;
    @JoinColumn(name = "MerchandiseID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Merchandise merchandise;
    @JoinColumn(name = "BrandID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Brand brandID;

    public Clothes() {
    }

    public Clothes(Integer merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public Brand getBrandID() {
        return brandID;
    }

    public void setBrandID(Brand brandID) {
        this.brandID = brandID;
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
        if (!(object instanceof Clothes)) {
            return false;
        }
        Clothes other = (Clothes) object;
        if ((this.merchandiseID == null && other.merchandiseID != null) || (this.merchandiseID != null && !this.merchandiseID.equals(other.merchandiseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clothes[ merchandiseID=" + merchandiseID + " ]";
    }
    
}
