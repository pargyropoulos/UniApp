

package repository.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "UNIVERSITY")
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u"),
    @NamedQuery(name = "University.findByName", query = "SELECT u FROM University u WHERE u.name = :name"),
    @NamedQuery(name = "University.findByCounter", query = "SELECT u FROM University u WHERE u.counter = :counter"),
    @NamedQuery(name = "University.findByDescription", query = "SELECT u FROM University u WHERE u.description = :description"),
    @NamedQuery(name = "University.findAllOrderByCounterDesc", query = "SELECT u FROM University u ORDER BY u.counter DESC, u.name ASC"),
    @NamedQuery(name = "University.findByInfo", query = "SELECT u FROM University u WHERE u.info = :info")})
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "COUNTER")
    private Integer counter;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "INFO")
    private String info;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityName")
    private Collection<School> schoolCollection;

    public University() {
    }

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Collection<School> getSchoolCollection() {
        return schoolCollection;
    }

    public void setSchoolCollection(Collection<School> schoolCollection) {
        this.schoolCollection = schoolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.University[ name=" + name + " ]";
    }

}
