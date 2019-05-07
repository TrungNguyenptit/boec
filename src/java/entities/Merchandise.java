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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "merchandise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Merchandise.findAll", query = "SELECT m FROM Merchandise m")
    , @NamedQuery(name = "Merchandise.findById", query = "SELECT m FROM Merchandise m WHERE m.id = :id")
    , @NamedQuery(name = "Merchandise.findByPrice", query = "SELECT m FROM Merchandise m WHERE m.price = :price")
    , @NamedQuery(name = "Merchandise.findByName", query = "SELECT m FROM Merchandise m WHERE m.name = :name")
    , @NamedQuery(name = "Merchandise.findByDescription", query = "SELECT m FROM Merchandise m WHERE m.description = :description")})
public class Merchandise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private float price;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    @ManyToMany(mappedBy = "merchandiseList")
    private List<Cart> cartList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "merchandise")
    private Laptop laptop;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "merchandise")
    private Houseware houseware;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "merchandise")
    private Book book;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchandiseID")
    private List<Contribute> contributeList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "merchandise")
    private Electronic electronic;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "merchandise")
    private Cellphone cellphone;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "merchandise")
    private Accessories accessories;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "merchandise")
    private Clothes clothes;
    @JoinColumn(name = "CounterOrderOrderID", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Counterorder counterOrderOrderID;
    @JoinColumn(name = "WarehouseID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Warehouse warehouseID;
    @JoinColumn(name = "GiftID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Gift giftID;

    public Merchandise() {
    }

    public Merchandise(Integer id) {
        this.id = id;
    }

    public Merchandise(Integer id, float price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Houseware getHouseware() {
        return houseware;
    }

    public void setHouseware(Houseware houseware) {
        this.houseware = houseware;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @XmlTransient
    public List<Contribute> getContributeList() {
        return contributeList;
    }

    public void setContributeList(List<Contribute> contributeList) {
        this.contributeList = contributeList;
    }

    public Electronic getElectronic() {
        return electronic;
    }

    public void setElectronic(Electronic electronic) {
        this.electronic = electronic;
    }

    public Cellphone getCellphone() {
        return cellphone;
    }

    public void setCellphone(Cellphone cellphone) {
        this.cellphone = cellphone;
    }

    public Accessories getAccessories() {
        return accessories;
    }

    public void setAccessories(Accessories accessories) {
        this.accessories = accessories;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Counterorder getCounterOrderOrderID() {
        return counterOrderOrderID;
    }

    public void setCounterOrderOrderID(Counterorder counterOrderOrderID) {
        this.counterOrderOrderID = counterOrderOrderID;
    }

    public Warehouse getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(Warehouse warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Gift getGiftID() {
        return giftID;
    }

    public void setGiftID(Gift giftID) {
        this.giftID = giftID;
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
        if (!(object instanceof Merchandise)) {
            return false;
        }
        Merchandise other = (Merchandise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Merchandise[ id=" + id + " ]";
    }
    
}
