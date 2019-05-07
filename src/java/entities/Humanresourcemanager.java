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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "humanresourcemanager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Humanresourcemanager.findAll", query = "SELECT h FROM Humanresourcemanager h")
    , @NamedQuery(name = "Humanresourcemanager.findByPersonID", query = "SELECT h FROM Humanresourcemanager h WHERE h.personID = :personID")})
public class Humanresourcemanager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    private Integer personID;
    @JoinColumn(name = "HumanResourceDepartmentDepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne(optional = false)
    private Humanresourcedepartment humanResourceDepartmentDepartmentID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Humanresourcemanager() {
    }

    public Humanresourcemanager(Integer personID) {
        this.personID = personID;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Humanresourcedepartment getHumanResourceDepartmentDepartmentID() {
        return humanResourceDepartmentDepartmentID;
    }

    public void setHumanResourceDepartmentDepartmentID(Humanresourcedepartment humanResourceDepartmentDepartmentID) {
        this.humanResourceDepartmentDepartmentID = humanResourceDepartmentDepartmentID;
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
        if (!(object instanceof Humanresourcemanager)) {
            return false;
        }
        Humanresourcemanager other = (Humanresourcemanager) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Humanresourcemanager[ personID=" + personID + " ]";
    }
    
}
