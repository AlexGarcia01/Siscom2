/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.ent;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "sueldos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sueldos.findAll", query = "SELECT s FROM Sueldos s"),
    @NamedQuery(name = "Sueldos.findByIdSUELDOS", query = "SELECT s FROM Sueldos s WHERE s.idSUELDOS = :idSUELDOS"),
    @NamedQuery(name = "Sueldos.findByFechaInicio", query = "SELECT s FROM Sueldos s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Sueldos.findByFechaFin", query = "SELECT s FROM Sueldos s WHERE s.fechaFin = :fechaFin")})
public class Sueldos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSUELDOS")
    private Integer idSUELDOS;
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
    @JoinColumn(name = "TAB_SUELDOS_idTAB_SUELDOS", referencedColumnName = "idTAB_SUELDOS")
    @ManyToOne(optional = false)
    private TabSueldos tABSUELDOSidTABSUELDOS;

    public Sueldos() {
    }

    public Sueldos(Integer idSUELDOS) {
        this.idSUELDOS = idSUELDOS;
    }

    public Sueldos(Integer idSUELDOS, Date fechaInicio, Date fechaFin) {
        this.idSUELDOS = idSUELDOS;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdSUELDOS() {
        return idSUELDOS;
    }

    public void setIdSUELDOS(Integer idSUELDOS) {
        this.idSUELDOS = idSUELDOS;
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

    public TabSueldos getTABSUELDOSidTABSUELDOS() {
        return tABSUELDOSidTABSUELDOS;
    }

    public void setTABSUELDOSidTABSUELDOS(TabSueldos tABSUELDOSidTABSUELDOS) {
        this.tABSUELDOSidTABSUELDOS = tABSUELDOSidTABSUELDOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSUELDOS != null ? idSUELDOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sueldos)) {
            return false;
        }
        Sueldos other = (Sueldos) object;
        if ((this.idSUELDOS == null && other.idSUELDOS != null) || (this.idSUELDOS != null && !this.idSUELDOS.equals(other.idSUELDOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.Sueldos[ idSUELDOS=" + idSUELDOS + " ]";
    }
    
}
