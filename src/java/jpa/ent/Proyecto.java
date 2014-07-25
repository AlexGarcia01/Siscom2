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
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByIdPROYECTO", query = "SELECT p FROM Proyecto p WHERE p.idPROYECTO = :idPROYECTO"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByCompa\u00f1ia", query = "SELECT p FROM Proyecto p WHERE p.compa\u00f1ia = :compa\u00f1ia"),
    @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Proyecto.findByFechaFin", query = "SELECT p FROM Proyecto p WHERE p.fechaFin = :fechaFin")})
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPROYECTO")
    private Integer idPROYECTO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Compa\u00f1ia")
    private String compañia;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOidPROYECTO")
    private Collection<RecursosProyecto> recursosProyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOidPROYECTO")
    private Collection<HorasRoyecto> horasRoyectoCollection;
    @JoinColumn(name = "AREA_idAREA", referencedColumnName = "idAREA")
    @ManyToOne(optional = false)
    private Area aREAidAREA;
    @JoinColumn(name = "TIPO_PROYECTO_idTIPO_PROYECTO", referencedColumnName = "idTIPO_PROYECTO")
    @ManyToOne(optional = false)
    private TipoProyecto tIPOPROYECTOidTIPOPROYECTO;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOidPROYECTO")
    private Collection<FacturacionProyecto> facturacionProyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOidPROYECTO")
    private Collection<GastoProyectos> gastoProyectosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOidPROYECTO")
    private Collection<EntregablesProyecto> entregablesProyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pROYECTOidPROYECTO")
    private Collection<RecursoAsignadoProyecto> recursoAsignadoProyectoCollection;

    public Proyecto() {
    }

    public Proyecto(Integer idPROYECTO) {
        this.idPROYECTO = idPROYECTO;
    }

    public Proyecto(Integer idPROYECTO, String nombre, String compañia, Date fechaInicio, Date fechaFin) {
        this.idPROYECTO = idPROYECTO;
        this.nombre = nombre;
        this.compañia = compañia;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdPROYECTO() {
        return idPROYECTO;
    }

    public void setIdPROYECTO(Integer idPROYECTO) {
        this.idPROYECTO = idPROYECTO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
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
    public Collection<HorasRoyecto> getHorasRoyectoCollection() {
        return horasRoyectoCollection;
    }

    public void setHorasRoyectoCollection(Collection<HorasRoyecto> horasRoyectoCollection) {
        this.horasRoyectoCollection = horasRoyectoCollection;
    }

    public Area getAREAidAREA() {
        return aREAidAREA;
    }

    public void setAREAidAREA(Area aREAidAREA) {
        this.aREAidAREA = aREAidAREA;
    }

    public TipoProyecto getTIPOPROYECTOidTIPOPROYECTO() {
        return tIPOPROYECTOidTIPOPROYECTO;
    }

    public void setTIPOPROYECTOidTIPOPROYECTO(TipoProyecto tIPOPROYECTOidTIPOPROYECTO) {
        this.tIPOPROYECTOidTIPOPROYECTO = tIPOPROYECTOidTIPOPROYECTO;
    }

    @XmlTransient
    public Collection<FacturacionProyecto> getFacturacionProyectoCollection() {
        return facturacionProyectoCollection;
    }

    public void setFacturacionProyectoCollection(Collection<FacturacionProyecto> facturacionProyectoCollection) {
        this.facturacionProyectoCollection = facturacionProyectoCollection;
    }

    @XmlTransient
    public Collection<GastoProyectos> getGastoProyectosCollection() {
        return gastoProyectosCollection;
    }

    public void setGastoProyectosCollection(Collection<GastoProyectos> gastoProyectosCollection) {
        this.gastoProyectosCollection = gastoProyectosCollection;
    }

    @XmlTransient
    public Collection<EntregablesProyecto> getEntregablesProyectoCollection() {
        return entregablesProyectoCollection;
    }

    public void setEntregablesProyectoCollection(Collection<EntregablesProyecto> entregablesProyectoCollection) {
        this.entregablesProyectoCollection = entregablesProyectoCollection;
    }

    @XmlTransient
    public Collection<RecursoAsignadoProyecto> getRecursoAsignadoProyectoCollection() {
        return recursoAsignadoProyectoCollection;
    }

    public void setRecursoAsignadoProyectoCollection(Collection<RecursoAsignadoProyecto> recursoAsignadoProyectoCollection) {
        this.recursoAsignadoProyectoCollection = recursoAsignadoProyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPROYECTO != null ? idPROYECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.idPROYECTO == null && other.idPROYECTO != null) || (this.idPROYECTO != null && !this.idPROYECTO.equals(other.idPROYECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.Proyecto[ idPROYECTO=" + idPROYECTO + " ]";
    }
    
}
