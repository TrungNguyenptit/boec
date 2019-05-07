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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "discountcode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discountcode.findAll", query = "SELECT d FROM Discountcode d")
    , @NamedQuery(name = "Discountcode.findById", query = "SELECT d FROM Discountcode d WHERE d.id = :id")
    , @NamedQuery(name = "Discountcode.findByCode", query = "SELECT d FROM Discountcode d WHERE d.code = :code")
    , @NamedQuery(name = "Discountcode.findByAmountmoney", query = "SELECT d FROM Discountcode d WHERE d.amountmoney = :amountmoney")})
public class Discountcode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amountmoney")
    private float amountmoney;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discountCodeID")
    private List<Onlineorder> onlineorderList;
    @JoinColumn(name = "PromotionSeasonID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Promotionseason promotionSeasonID;

    public Discountcode() {
    }

    public Discountcode(Integer id) {
        this.id = id;
    }

    public Discountcode(Integer id, float amountmoney) {
        this.id = id;
        this.amountmoney = amountmoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getAmountmoney() {
        return amountmoney;
    }

    public void setAmountmoney(float amountmoney) {
        this.amountmoney = amountmoney;
    }

    @XmlTransient
    public List<Onlineorder> getOnlineorderList() {
        return onlineorderList;
    }

    public void setOnlineorderList(List<Onlineorder> onlineorderList) {
        this.onlineorderList = onlineorderList;
    }

    public Promotionseason getPromotionSeasonID() {
        return promotionSeasonID;
    }

    public void setPromotionSeasonID(Promotionseason promotionSeasonID) {
        this.promotionSeasonID = promotionSeasonID;
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
        if (!(object instanceof Discountcode)) {
            return false;
        }
        Discountcode other = (Discountcode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Discountcode[ id=" + id + " ]";
    }
    
}
