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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "onlinesalesman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Onlinesalesman.findAll", query = "SELECT o FROM Onlinesalesman o")
    , @NamedQuery(name = "Onlinesalesman.findByPersonID", query = "SELECT o FROM Onlinesalesman o WHERE o.personID = :personID")})
public class Onlinesalesman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    private Integer personID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @JoinColumn(name = "SaleDepartmentDepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne(optional = false)
    private Saledepartment saleDepartmentDepartmentID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onlineSalesmanPersonID")
    private List<Bill> billList;

    public Onlinesalesman() {
    }

    public Onlinesalesman(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Saledepartment getSaleDepartmentDepartmentID() {
        return saleDepartmentDepartmentID;
    }

    public void setSaleDepartmentDepartmentID(Saledepartment saleDepartmentDepartmentID) {
        this.saleDepartmentDepartmentID = saleDepartmentDepartmentID;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Onlinesalesman)) {
            return false;
        }
        Onlinesalesman other = (Onlinesalesman) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Onlinesalesman[ personID=" + personID + " ]";
    }
    
}
