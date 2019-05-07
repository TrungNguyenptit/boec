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
@Table(name = "deliverydepartment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliverydepartment.findAll", query = "SELECT d FROM Deliverydepartment d")
    , @NamedQuery(name = "Deliverydepartment.findByDepartmentID", query = "SELECT d FROM Deliverydepartment d WHERE d.departmentID = :departmentID")})
public class Deliverydepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DepartmentID")
    private Integer departmentID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryDepartmentDepartmentID")
    private List<Courier> courierList;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Department department;

    public Deliverydepartment() {
    }

    public Deliverydepartment(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    @XmlTransient
    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
        if (!(object instanceof Deliverydepartment)) {
            return false;
        }
        Deliverydepartment other = (Deliverydepartment) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Deliverydepartment[ departmentID=" + departmentID + " ]";
    }
    
}
