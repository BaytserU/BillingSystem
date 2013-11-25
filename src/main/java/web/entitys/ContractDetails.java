/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.entitys;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ike
 */
@Entity
@Table(name = "contract_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContractDetails.findAll", query = "SELECT c FROM ContractDetails c"),
    @NamedQuery(name = "ContractDetails.findByContractId", query = "SELECT c FROM ContractDetails c WHERE c.contractId = :contractId"),
    @NamedQuery(name = "ContractDetails.findByContractDate", query = "SELECT c FROM ContractDetails c WHERE c.contractDate = :contractDate"),
    @NamedQuery(name = "ContractDetails.findByCourseStatus", query = "SELECT c FROM ContractDetails c WHERE c.courseStatus = :courseStatus"),
    @NamedQuery(name = "ContractDetails.findByCourseDiscount", query = "SELECT c FROM ContractDetails c WHERE c.courseDiscount = :courseDiscount"),
    @NamedQuery(name = "ContractDetails.findByCoursebalanceUAH", query = "SELECT c FROM ContractDetails c WHERE c.coursebalanceUAH = :coursebalanceUAH")})
public class ContractDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "contract_id")
    private Integer contractId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contract_date")
    @Temporal(TemporalType.DATE)
    private Date contractDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "course_status")
    private String courseStatus;
    @Column(name = "course_discount_%")
    private Integer courseDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_balance_UAH")
    private int coursebalanceUAH;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contractId")
    private Collection<Transaction> transactionCollection;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    @ManyToOne(optional = false)
    private Students studentId;

    public ContractDetails() {
    }

    public ContractDetails(Integer contractId) {
        this.contractId = contractId;
    }

    public ContractDetails(Integer contractId, Date contractDate, String courseStatus, int coursebalanceUAH) {
        this.contractId = contractId;
        this.contractDate = contractDate;
        this.courseStatus = courseStatus;
        this.coursebalanceUAH = coursebalanceUAH;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public Integer getCourseDiscount() {
        return courseDiscount;
    }

    public void setCourseDiscount(Integer courseDiscount) {
        this.courseDiscount = courseDiscount;
    }

    public int getCoursebalanceUAH() {
        return coursebalanceUAH;
    }

    public void setCoursebalanceUAH(int coursebalanceUAH) {
        this.coursebalanceUAH = coursebalanceUAH;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    public Students getStudentId() {
        return studentId;
    }

    public void setStudentId(Students studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractId != null ? contractId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContractDetails)) {
            return false;
        }
        ContractDetails other = (ContractDetails) object;
        if ((this.contractId == null && other.contractId != null) || (this.contractId != null && !this.contractId.equals(other.contractId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.entitys.ContractDetails[ contractId=" + contractId + " ]";
    }
    
}
