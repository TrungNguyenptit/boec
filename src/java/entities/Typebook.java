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
@Table(name = "typebook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typebook.findAll", query = "SELECT t FROM Typebook t")
    , @NamedQuery(name = "Typebook.findById", query = "SELECT t FROM Typebook t WHERE t.id = :id")
    , @NamedQuery(name = "Typebook.findByName", query = "SELECT t FROM Typebook t WHERE t.name = :name")
    , @NamedQuery(name = "Typebook.findByDesciption", query = "SELECT t FROM Typebook t WHERE t.desciption = :desciption")
    , @NamedQuery(name = "Typebook.findByLimitage", query = "SELECT t FROM Typebook t WHERE t.limitage = :limitage")})
public class Typebook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "Desciption")
    private String desciption;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Limitage")
    private int limitage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeBookID")
    private List<Book> bookList;

    public Typebook() {
    }

    public Typebook(Integer id) {
        this.id = id;
    }

    public Typebook(Integer id, int limitage) {
        this.id = id;
        this.limitage = limitage;
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

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public int getLimitage() {
        return limitage;
    }

    public void setLimitage(int limitage) {
        this.limitage = limitage;
    }

    @XmlTransient
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
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
        if (!(object instanceof Typebook)) {
            return false;
        }
        Typebook other = (Typebook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typebook[ id=" + id + " ]";
    }
    
}
