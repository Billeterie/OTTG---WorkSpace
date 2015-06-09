/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.fet.ala.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "classroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classroom.findAll", query = "SELECT c FROM Classroom c"),
    @NamedQuery(name = "Classroom.findByIdClassroom", query = "SELECT c FROM Classroom c WHERE c.idClassroom = :idClassroom"),
    @NamedQuery(name = "Classroom.findByLocation", query = "SELECT c FROM Classroom c WHERE c.location = :location"),
    @NamedQuery(name = "Classroom.findByCapacity", query = "SELECT c FROM Classroom c WHERE c.capacity = :capacity")})
public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_classroom")
    private Integer idClassroom;
    @Column(name = "location")
    private String location;
    @Column(name = "capacity")
    private Integer capacity;
    @JoinColumn(name = "id_classroom", referencedColumnName = "id_tt", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Timetable timetable;

    public Classroom() {
    }

    public Classroom(Integer idClassroom) {
        this.idClassroom = idClassroom;
    }

    public Integer getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(Integer idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClassroom != null ? idClassroom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classroom)) {
            return false;
        }
        Classroom other = (Classroom) object;
        if ((this.idClassroom == null && other.idClassroom != null) || (this.idClassroom != null && !this.idClassroom.equals(other.idClassroom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.fet.ala.Classroom[ idClassroom=" + idClassroom + " ]";
    }
    
}
