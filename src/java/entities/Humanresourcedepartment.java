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
@Table(name = "humanresourcedepartment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Humanresourcedepartment.findAll", query = "SELECT h FROM Humanresourcedepartment h")
    , @NamedQuery(name = "Humanresourcedepartment.findByDepartmentID", query = "SELECT h FROM Humanresourcedepartment h WHERE h.departmentID = :departmentID")})
public class Humanresourcedepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DepartmentID")
    private Integer departmentID;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Department department;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "humanResourceDepartmentDepartmentID")
    private List<Humanresourcemanager> humanresourcemanagerList;

    public Humanresourcedepartment() {
    }

    public Humanresourcedepartment(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @XmlTransient
    public List<Humanresourcemanager> getHumanresourcemanagerList() {
        return humanresourcemanagerList;
    }

    public void setHumanresourcemanagerList(List<Humanresourcemanager> humanresourcemanagerList) {
        this.humanresourcemanagerList = humanresourcemanagerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Humanresourcedepartment)) {
            return false;
        }
        Humanresourcedepartment other = (Humanresourcedepartment) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Humanresourcedepartment[ departmentID=" + departmentID + " ]";
    }
    
}
