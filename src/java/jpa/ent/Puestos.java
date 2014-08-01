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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "puestos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puestos.findAll", query = "SELECT p FROM Puestos p"),
    @NamedQuery(name = "Puestos.findByIdPUESTOS", query = "SELECT p FROM Puestos p WHERE p.idPUESTOS = :idPUESTOS"),
    @NamedQuery(name = "Puestos.findByNombre", query = "SELECT p FROM Puestos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Puestos.findByNivel", query = "SELECT p FROM Puestos p WHERE p.nivel = :nivel"),
    @NamedQuery(name = "Puestos.findByFechaInicio", query = "SELECT p FROM Puestos p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Puestos.findByFechaFin", query = "SELECT p FROM Puestos p WHERE p.fechaFin = :fechaFin")})
public class Puestos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPUESTOS")
    private Integer idPUESTOS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nivel")
    private int nivel;
    @Column(name = "FechaInicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pUESTOSidPUESTOS")
    private Collection<RecursosProyecto> recursosProyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pUESTOSidPUESTOS")
    private Collection<TabSueldos> tabSueldosCollection;
    @JoinColumn(name = "AREA_idAREA", referencedColumnName = "idAREA")
    @ManyToOne(optional = false)
    private Area aREAidAREA;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pUESTOSidPUESTOS")
    private Collection<Usuarios> usuariosCollection;

    public Puestos() {
    }

    public Puestos(Integer idPUESTOS) {
        this.idPUESTOS = idPUESTOS;
    }

    public Puestos(Integer idPUESTOS, String nombre, int nivel) {
        this.idPUESTOS = idPUESTOS;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Integer getIdPUESTOS() {
        return idPUESTOS;
    }

    public void setIdPUESTOS(Integer idPUESTOS) {
        this.idPUESTOS = idPUESTOS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

    @XmlTransient
    public Collection<RecursosProyecto> getRecursosProyectoCollection() {
        return recursosProyectoCollection;
    }

    public void setRecursosProyectoCollection(Collection<RecursosProyecto> recursosProyectoCollection) {
        this.recursosProyectoCollection = recursosProyectoCollection;
    }

    @XmlTransient
    public Collection<TabSueldos> getTabSueldosCollection() {
        return tabSueldosCollection;
    }

    public void setTabSueldosCollection(Collection<TabSueldos> tabSueldosCollection) {
        this.tabSueldosCollection = tabSueldosCollection;
    }

    public Area getAREAidAREA() {
        return aREAidAREA;
    }

    public void setAREAidAREA(Area aREAidAREA) {
        this.aREAidAREA = aREAidAREA;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPUESTOS != null ? idPUESTOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puestos)) {
            return false;
        }
        Puestos other = (Puestos) object;
        if ((this.idPUESTOS == null && other.idPUESTOS != null) || (this.idPUESTOS != null && !this.idPUESTOS.equals(other.idPUESTOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
      //  return "jpa.ent.Puestos[ idPUESTOS=" + idPUESTOS + " ]";
        return nombre;
    }
    
}
