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
@Table(name = "saledepartment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Saledepartment.findAll", query = "SELECT s FROM Saledepartment s")
    , @NamedQuery(name = "Saledepartment.findByDepartmentID", query = "SELECT s FROM Saledepartment s WHERE s.departmentID = :departmentID")})
public class Saledepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DepartmentID")
    private Integer departmentID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleDepartmentDepartmentID")
    private List<Countersalesman> countersalesmanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saleDepartmentDepartmentID")
    private List<Onlinesalesman> onlinesalesmanList;
    @JoinColumn(name = "DepartmentID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Department department;

    public Saledepartment() {
    }

    public Saledepartment(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    @XmlTransient
    public List<Countersalesman> getCountersalesmanList() {
        return countersalesmanList;
    }

    public void setCountersalesmanList(List<Countersalesman> countersalesmanList) {
        this.countersalesmanList = countersalesmanList;
    }

    @XmlTransient
    public List<Onlinesalesman> getOnlinesalesmanList() {
        return onlinesalesmanList;
    }

    public void setOnlinesalesmanList(List<Onlinesalesman> onlinesalesmanList) {
        this.onlinesalesmanList = onlinesalesmanList;
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
        if (!(object instanceof Saledepartment)) {
            return false;
        }
        Saledepartment other = (Saledepartment) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Saledepartment[ departmentID=" + departmentID + " ]";
    }
    
}
