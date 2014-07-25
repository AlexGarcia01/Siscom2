/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.ent;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "periodos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodos.findAll", query = "SELECT p FROM Periodos p"),
    @NamedQuery(name = "Periodos.findByIdPERIODOS", query = "SELECT p FROM Periodos p WHERE p.idPERIODOS = :idPERIODOS"),
    @NamedQuery(name = "Periodos.findByFechaInicio", query = "SELECT p FROM Periodos p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Periodos.findByFechaFin", query = "SELECT p FROM Periodos p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Periodos.findBySemana", query = "SELECT p FROM Periodos p WHERE p.semana = :semana")})
public class Periodos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPERIODOS")
    private Integer idPERIODOS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Semana")
    private int semana;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pERIODOSidPERIODOS")
    private Collection<HorasRoyecto> horasRoyectoCollection;

    public Periodos() {
    }

    public Periodos(Integer idPERIODOS) {
        this.idPERIODOS = idPERIODOS;
    }

    public Periodos(Integer idPERIODOS, Date fechaInicio, Date fechaFin, int semana) {
        this.idPERIODOS = idPERIODOS;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.semana = semana;
    }

    public Integer getIdPERIODOS() {
        return idPERIODOS;
    }

    public void setIdPERIODOS(Integer idPERIODOS) {
        this.idPERIODOS = idPERIODOS;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    @XmlTransient
    public Collection<HorasRoyecto> getHorasRoyectoCollection() {
        return horasRoyectoCollection;
    }

    public void setHorasRoyectoCollection(Collection<HorasRoyecto> horasRoyectoCollection) {
        this.horasRoyectoCollection = horasRoyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPERIODOS != null ? idPERIODOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodos)) {
            return false;
        }
        Periodos other = (Periodos) object;
        if ((this.idPERIODOS == null && other.idPERIODOS != null) || (this.idPERIODOS != null && !this.idPERIODOS.equals(other.idPERIODOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.Periodos[ idPERIODOS=" + idPERIODOS + " ]";
    }
    
}
