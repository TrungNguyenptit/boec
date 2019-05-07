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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "promotionseason")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotionseason.findAll", query = "SELECT p FROM Promotionseason p")
    , @NamedQuery(name = "Promotionseason.findById", query = "SELECT p FROM Promotionseason p WHERE p.id = :id")
    , @NamedQuery(name = "Promotionseason.findByName", query = "SELECT p FROM Promotionseason p WHERE p.name = :name")
    , @NamedQuery(name = "Promotionseason.findByStartDate", query = "SELECT p FROM Promotionseason p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "Promotionseason.findByOverDate", query = "SELECT p FROM Promotionseason p WHERE p.overDate = :overDate")})
public class Promotionseason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "OverDate")
    @Temporal(TemporalType.DATE)
    private Date overDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotionSeasonID")
    private List<Discountcode> discountcodeList;

    public Promotionseason() {
    }

    public Promotionseason(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getOverDate() {
        return overDate;
    }

    public void setOverDate(Date overDate) {
        this.overDate = overDate;
    }

    @XmlTransient
    public List<Discountcode> getDiscountcodeList() {
        return discountcodeList;
    }

    public void setDiscountcodeList(List<Discountcode> discountcodeList) {
        this.discountcodeList = discountcodeList;
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
        if (!(object instanceof Promotionseason)) {
            return false;
        }
        Promotionseason other = (Promotionseason) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Promotionseason[ id=" + id + " ]";
    }
    
}
