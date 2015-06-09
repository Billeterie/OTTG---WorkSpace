/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.fet.ala.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class LecturerPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_lecturer")
    private int idLecturer;
    @Basic(optional = false)
    @Column(name = "id_dept")
    private int idDept;
    @Basic(optional = false)
    @Column(name = "id_faculty")
    private String idFaculty;

    public LecturerPK() {
    }

    public LecturerPK(int idLecturer, int idDept, String idFaculty) {
        this.idLecturer = idLecturer;
        this.idDept = idDept;
        this.idFaculty = idFaculty;
    }

    public int getIdLecturer() {
        return idLecturer;
    }

    public void setIdLecturer(int idLecturer) {
        this.idLecturer = idLecturer;
    }

    public int getIdDept() {
        return idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }

    public String getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(String idFaculty) {
        this.idFaculty = idFaculty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLecturer;
        hash += (int) idDept;
        hash += (idFaculty != null ? idFaculty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LecturerPK)) {
            return false;
        }
        LecturerPK other = (LecturerPK) object;
        if (this.idLecturer != other.idLecturer) {
            return false;
        }
        if (this.idDept != other.idDept) {
            return false;
        }
        if ((this.idFaculty == null && other.idFaculty != null) || (this.idFaculty != null && !this.idFaculty.equals(other.idFaculty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.fet.ala.LecturerPK[ idLecturer=" + idLecturer + ", idDept=" + idDept + ", idFaculty=" + idFaculty + " ]";
    }
    
}
