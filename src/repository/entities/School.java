
package repository.entities;

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
import javax.persistence.Table;


/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 */
@Entity
@Table(name = "SCHOOL")
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s"),
    @NamedQuery(name = "School.findById", query = "SELECT s FROM School s WHERE s.id = :id"),
    @NamedQuery(name = "School.findByName", query = "SELECT s FROM School s WHERE s.name = :name"),
    //P.A.
    @NamedQuery(name = "School.findByUniversityName", query = "SELECT s FROM School s WHERE s.universityName.name = :universityName order by s.name")})

    //δικό μου querie να βρίσκει τις σχολές με βαση το όνομα πανεπιστημιου
//    @NamedQuery(name = "School.findByUniversity", query = "SELECT s FROM School s WHERE s.universityName = :universityName"),
//    @NamedQuery(name = "School.findByNameAndUniversity",
//            query = "SELECT s FROM School s WHERE s.name = :schoolName AND s.universityName.name = :universityName")
//})
public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "UNIVERSITY_NAME", referencedColumnName = "NAME")
    @ManyToOne(optional = false)
    private University universityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolId")
    private Collection<Department> departmentCollection;

    public School() {
    }

    public School(Integer id) {
        this.id = id;
    }

    public School(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversityName() {
        return universityName;
    }

    public void setUniversityName(University universityName) {
        this.universityName = universityName;
    }

    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
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
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "School{" + "id=" + id + ", name=" + name + ", universityName=" + universityName + ", departmentCollection=" + departmentCollection + '}';
    }



}
