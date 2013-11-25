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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "statuses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statuses.findAll", query = "SELECT s FROM Statuses s"),
    @NamedQuery(name = "Statuses.findByStatusId", query = "SELECT s FROM Statuses s WHERE s.statusId = :statusId"),
    @NamedQuery(name = "Statuses.findByStatusName", query = "SELECT s FROM Statuses s WHERE s.statusName = :statusName")})
public class Statuses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status_name")
    private String statusName;
    @Lob
    @Size(max = 65535)
    @Column(name = "status_description")
    private String statusDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    private Collection<Users> usersCollection;

    public Statuses() {
    }

    public Statuses(Integer statusId) {
        this.statusId = statusId;
    }

    public Statuses(Integer statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statuses)) {
            return false;
        }
        Statuses other = (Statuses) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.entitys.Statuses[ statusId=" + statusId + " ]";
    }
    
}
