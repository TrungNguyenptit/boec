/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findByMerchandiseID", query = "SELECT b FROM Book b WHERE b.merchandiseID = :merchandiseID")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MerchandiseID")
    private Integer merchandiseID;
    @JoinTable(name = "book_author", joinColumns = {
        @JoinColumn(name = "BookMerchandiseID", referencedColumnName = "MerchandiseID")}, inverseJoinColumns = {
        @JoinColumn(name = "authorPersonID", referencedColumnName = "PersonID")})
    @ManyToMany
    private List<Author> authorList;
    @JoinColumn(name = "PublisherID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Publisher publisherID;
    @JoinColumn(name = "MerchandiseID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Merchandise merchandise;
    @JoinColumn(name = "TypeBookID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Typebook typeBookID;

    public Book() {
    }

    public Book(Integer merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public Integer getMerchandiseID() {
        return merchandiseID;
    }

    public void setMerchandiseID(Integer merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    @XmlTransient
    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Publisher getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Publisher publisherID) {
        this.publisherID = publisherID;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public Typebook getTypeBookID() {
        return typeBookID;
    }

    public void setTypeBookID(Typebook typeBookID) {
        this.typeBookID = typeBookID;
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.merchandiseID == null && other.merchandiseID != null) || (this.merchandiseID != null && !this.merchandiseID.equals(other.merchandiseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Book[ merchandiseID=" + merchandiseID + " ]";
    }
    
}
