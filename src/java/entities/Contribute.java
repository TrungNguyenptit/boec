/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Trung Nguyen
 */
@Entity
@Table(name = "contribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contribute.findAll", query = "SELECT c FROM Contribute c")
    , @NamedQuery(name = "Contribute.findById", query = "SELECT c FROM Contribute c WHERE c.id = :id")
    , @NamedQuery(name = "Contribute.findByContributiondate", query = "SELECT c FROM Contribute c WHERE c.contributiondate = :contributiondate")})
public class Contribute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Contributiondate")
    @Temporal(TemporalType.DATE)
    private Date contributiondate;
    @JoinColumn(name = "CustomerAccountAccountID", referencedColumnName = "AccountID")
    @ManyToOne(optional = false)
    private Customeraccount customerAccountAccountID;
    @JoinColumn(name = "MerchandiseID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Merchandise merchandiseID;
    @JoinColumn(name = "FeedbackID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Feedback feedbackID;

    public Contribute() {
    }

    public Contribute(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getContributiondate() {
        return contributiondate;
    }

    public void setContributiondate(Date contributiondate) {
        this.contributiondate = contributiondate;
    }

    public Customeraccount getCustomerAccountAccountID() {
        return customerAccountAccountID;
    }

    public void setCustomerAccountAccountID(Customeraccount customerAccountAccountID) {
        this.customerAccountAccountID = customerAccountAccountID;
    }

    public Merchandise getMerchandiseID() {
        return merchandiseID;
    }

    public void setMerchandiseID(Merchandise merchandiseID) {
        this.merchandiseID = merchandiseID;
    }

    public Feedback getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Feedback feedbackID) {
        this.feedbackID = feedbackID;
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
        if (!(object instanceof Contribute)) {
            return false;
        }
        Contribute other = (Contribute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contribute[ id=" + id + " ]";
    }
    
}
