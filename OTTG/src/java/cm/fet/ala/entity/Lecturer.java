/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.fet.ala.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "lecturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecturer.findAll", query = "SELECT l FROM Lecturer l"),
    @NamedQuery(name = "Lecturer.findByIdLecturer", query = "SELECT l FROM Lecturer l WHERE l.lecturerPK.idLecturer = :idLecturer"),
    @NamedQuery(name = "Lecturer.findByIdDept", query = "SELECT l FROM Lecturer l WHERE l.lecturerPK.idDept = :idDept"),
    @NamedQuery(name = "Lecturer.findByIdFaculty", query = "SELECT l FROM Lecturer l WHERE l.lecturerPK.idFaculty = :idFaculty"),
    @NamedQuery(name = "Lecturer.findByName", query = "SELECT l FROM Lecturer l WHERE l.name = :name"),
    @NamedQuery(name = "Lecturer.findByType", query = "SELECT l FROM Lecturer l WHERE l.type = :type")})
public class Lecturer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LecturerPK lecturerPK;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @JoinColumns({
        @JoinColumn(name = "id_dept", referencedColumnName = "id_dept", insertable = false, updatable = false),
        @JoinColumn(name = "id_faculty", referencedColumnName = "id_faculty", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Department department;

    public Lecturer() {
    }

    public Lecturer(LecturerPK lecturerPK) {
        this.lecturerPK = lecturerPK;
    }

    public Lecturer(int idLecturer, int idDept, String idFaculty) {
        this.lecturerPK = new LecturerPK(idLecturer, idDept, idFaculty);
    }

    public LecturerPK getLecturerPK() {
        return lecturerPK;
    }

    public void setLecturerPK(LecturerPK lecturerPK) {
        this.lecturerPK = lecturerPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (lecturerPK != null ? lecturerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.lecturerPK == null && other.lecturerPK != null) || (this.lecturerPK != null && !this.lecturerPK.equals(other.lecturerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.fet.ala.Lecturer[ lecturerPK=" + lecturerPK + " ]";
    }
    
}
