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
@Table(name = "countersalesman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countersalesman.findAll", query = "SELECT c FROM Countersalesman c")
    , @NamedQuery(name = "Countersalesman.findByPersonID", query = "SELECT c FROM Countersalesman c WHERE c.personID = :personID")})
public class Countersalesman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    private Integer personID;
    @ManyToMany(mappedBy = "countersalesmanList")
    private List<Counterorder> counterorderList;
    @JoinColumn(name = "SaleDepartmentDepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne(optional = false)
    private Saledepartment saleDepartmentDepartmentID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Countersalesman() {
    }

    public Countersalesman(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    @XmlTransient
    public List<Counterorder> getCounterorderList() {
        return counterorderList;
    }

    public void setCounterorderList(List<Counterorder> counterorderList) {
        this.counterorderList = counterorderList;
    }

    public Saledepartment getSaleDepartmentDepartmentID() {
        return saleDepartmentDepartmentID;
    }

    public void setSaleDepartmentDepartmentID(Saledepartment saleDepartmentDepartmentID) {
        this.saleDepartmentDepartmentID = saleDepartmentDepartmentID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(object instanceof Countersalesman)) {
            return false;
        }
        Countersalesman other = (Countersalesman) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Countersalesman[ personID=" + personID + " ]";
    }
    
}
