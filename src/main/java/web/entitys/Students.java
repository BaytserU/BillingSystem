/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ike
 */
@Entity
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByStudentId", query = "SELECT s FROM Students s WHERE s.studentId = :studentId"),
    @NamedQuery(name = "Students.findByStudentName", query = "SELECT s FROM Students s WHERE s.studentName = :studentName"),
    @NamedQuery(name = "Students.findByStudentSurname", query = "SELECT s FROM Students s WHERE s.studentSurname = :studentSurname"),
    @NamedQuery(name = "Students.findByStudentEMail", query = "SELECT s FROM Students s WHERE s.studentEMail = :studentEMail"),
    @NamedQuery(name = "Students.findByStudentPhoneNumber", query = "SELECT s FROM Students s WHERE s.studentPhoneNumber = :studentPhoneNumber"),
    @NamedQuery(name = "Students.findByStudentSkype", query = "SELECT s FROM Students s WHERE s.studentSkype = :studentSkype")})
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "student_id")
    private Integer studentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "student_name")
    private String studentName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "student_surname")
    private String studentSurname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "student_e_mail")
    private String studentEMail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "student_phone_number")
    private int studentPhoneNumber;
    @Size(max = 255)
    @Column(name = "student_skype")
    private String studentSkype;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne
    private Groups groupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Collection<ContractDetails> contractDetailsCollection;

    public Students() {
    }

    public Students(Integer studentId) {
        this.studentId = studentId;
    }

    public Students(Integer studentId, String studentName, String studentSurname, String studentEMail, int studentPhoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentEMail = studentEMail;
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public String getStudentEMail() {
        return studentEMail;
    }

    public void setStudentEMail(String studentEMail) {
        this.studentEMail = studentEMail;
    }

    public int getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(int studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentSkype() {
        return studentSkype;
    }

    public void setStudentSkype(String studentSkype) {
        this.studentSkype = studentSkype;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    @XmlTransient
    public Collection<ContractDetails> getContractDetailsCollection() {
        return contractDetailsCollection;
    }

    public void setContractDetailsCollection(Collection<ContractDetails> contractDetailsCollection) {
        this.contractDetailsCollection = contractDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.entitys.Students[ studentId=" + studentId + " ]";
    }
    
}
