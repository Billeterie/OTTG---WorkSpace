/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.fet.ala.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "timetable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timetable.findAll", query = "SELECT t FROM Timetable t"),
    @NamedQuery(name = "Timetable.findByIdTt", query = "SELECT t FROM Timetable t WHERE t.timetablePK.idTt = :idTt"),
    @NamedQuery(name = "Timetable.findByIdFaculty", query = "SELECT t FROM Timetable t WHERE t.timetablePK.idFaculty = :idFaculty"),
    @NamedQuery(name = "Timetable.findBySemester", query = "SELECT t FROM Timetable t WHERE t.semester = :semester"),
    @NamedQuery(name = "Timetable.findByDate", query = "SELECT t FROM Timetable t WHERE t.date = :date")})
public class Timetable implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimetablePK timetablePK;
    @Column(name = "semester")
    private Short semester;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "timetable")
    private Classroom classroom;
    @JoinColumn(name = "id_faculty", referencedColumnName = "id_faculty", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Faculty faculty;

    public Timetable() {
    }

    public Timetable(TimetablePK timetablePK) {
        this.timetablePK = timetablePK;
    }

    public Timetable(int idTt, String idFaculty) {
        this.timetablePK = new TimetablePK(idTt, idFaculty);
    }

    public TimetablePK getTimetablePK() {
        return timetablePK;
    }

    public void setTimetablePK(TimetablePK timetablePK) {
        this.timetablePK = timetablePK;
    }

    public Short getSemester() {
        return semester;
    }

    public void setSemester(Short semester) {
        this.semester = semester;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
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
        hash += (timetablePK != null ? timetablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timetable)) {
            return false;
        }
        Timetable other = (Timetable) object;
        if ((this.timetablePK == null && other.timetablePK != null) || (this.timetablePK != null && !this.timetablePK.equals(other.timetablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.fet.ala.Timetable[ timetablePK=" + timetablePK + " ]";
    }
    
}
