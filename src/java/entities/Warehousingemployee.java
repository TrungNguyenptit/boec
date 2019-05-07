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
@Table(name = "warehousingemployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warehousingemployee.findAll", query = "SELECT w FROM Warehousingemployee w")
    , @NamedQuery(name = "Warehousingemployee.findByPersonID", query = "SELECT w FROM Warehousingemployee w WHERE w.personID = :personID")})
public class Warehousingemployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PersonID")
    private Integer personID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;
    @JoinColumn(name = "WarehouseManagementDepartmentDepartmentID", referencedColumnName = "DepartmentID")
    @ManyToOne(optional = false)
    private Warehousemanagementdepartment warehouseManagementDepartmentDepartmentID;

    public Warehousingemployee() {
    }

    public Warehousingemployee(Integer personID) {
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

    public Warehousemanagementdepartment getWarehouseManagementDepartmentDepartmentID() {
        return warehouseManagementDepartmentDepartmentID;
    }

    public void setWarehouseManagementDepartmentDepartmentID(Warehousemanagementdepartment warehouseManagementDepartmentDepartmentID) {
        this.warehouseManagementDepartmentDepartmentID = warehouseManagementDepartmentDepartmentID;
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
        if (!(object instanceof Warehousingemployee)) {
            return false;
        }
        Warehousingemployee other = (Warehousingemployee) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Warehousingemployee[ personID=" + personID + " ]";
    }
    
}
