/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.fet.ala.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByIdDept", query = "SELECT d FROM Department d WHERE d.departmentPK.idDept = :idDept"),
    @NamedQuery(name = "Department.findByIdFaculty", query = "SELECT d FROM Department d WHERE d.departmentPK.idFaculty = :idFaculty"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DepartmentPK departmentPK;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<Lecturer> lecturerCollection;
    @JoinColumn(name = "id_faculty", referencedColumnName = "id_faculty", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Faculty faculty;

    public Department() {
    }

    public Department(DepartmentPK departmentPK) {
        this.departmentPK = departmentPK;
    }

    public Department(int idDept, String idFaculty) {
        this.departmentPK = new DepartmentPK(idDept, idFaculty);
    }

    public DepartmentPK getDepartmentPK() {
        return departmentPK;
    }

    public void setDepartmentPK(DepartmentPK departmentPK) {
        this.departmentPK = departmentPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Lecturer> getLecturerCollection() {
        return lecturerCollection;
    }

    public void setLecturerCollection(Collection<Lecturer> lecturerCollection) {
        this.lecturerCollection = lecturerCollection;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentPK != null ? departmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentPK == null && other.departmentPK != null) || (this.departmentPK != null && !this.departmentPK.equals(other.departmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.fet.ala.Department[ departmentPK=" + departmentPK + " ]";
    }
    
}
