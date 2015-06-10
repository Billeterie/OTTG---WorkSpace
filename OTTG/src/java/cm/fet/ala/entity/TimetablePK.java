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
public class TimetablePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_tt")
    private int idTt;
    @Basic(optional = false)
    @Column(name = "id_faculty")
    private String idFaculty;

    public TimetablePK() {
    }

    public TimetablePK(int idTt, String idFaculty) {
        this.idTt = idTt;
        this.idFaculty = idFaculty;
    }

    public int getIdTt() {
        return idTt;
    }

    public void setIdTt(int idTt) {
        this.idTt = idTt;
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
        hash += (int) idTt;
        hash += (idFaculty != null ? idFaculty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimetablePK)) {
            return false;
        }
        TimetablePK other = (TimetablePK) object;
        if (this.idTt != other.idTt) {
            return false;
        }
        if ((this.idFaculty == null && other.idFaculty != null) || (this.idFaculty != null && !this.idFaculty.equals(other.idFaculty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.fet.ala.TimetablePK[ idTt=" + idTt + ", idFaculty=" + idFaculty + " ]";
    }
    
}
