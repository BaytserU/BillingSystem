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
@Table(name = "courses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Courses.findAll", query = "SELECT c FROM Courses c"),
    @NamedQuery(name = "Courses.findByCourseId", query = "SELECT c FROM Courses c WHERE c.courseId = :courseId"),
    @NamedQuery(name = "Courses.findByCourseName", query = "SELECT c FROM Courses c WHERE c.courseName = :courseName"),
    @NamedQuery(name = "Courses.findByCourseDurationLessons", query = "SELECT c FROM Courses c WHERE c.courseDurationLessons = :courseDurationLessons")})
public class Courses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_id")
    private Integer courseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "course_name")
    private String courseName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "course_duration_lessons")
    private int courseDurationLessons;
    @Lob
    @Size(max = 65535)
    @Column(name = "course_description")
    private String courseDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<Groups> groupsCollection;

    public Courses() {
    }

    public Courses(Integer courseId) {
        this.courseId = courseId;
    }

    public Courses(Integer courseId, String courseName, int courseDurationLessons) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDurationLessons = courseDurationLessons;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseDurationLessons() {
        return courseDurationLessons;
    }

    public void setCourseDurationLessons(int courseDurationLessons) {
        this.courseDurationLessons = courseDurationLessons;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @XmlTransient
    public Collection<Groups> getGroupsCollection() {
        return groupsCollection;
    }

    public void setGroupsCollection(Collection<Groups> groupsCollection) {
        this.groupsCollection = groupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Courses)) {
            return false;
        }
        Courses other = (Courses) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.entitys.Courses[ courseId=" + courseId + " ]";
    }
    
}
