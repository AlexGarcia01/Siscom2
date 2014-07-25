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
@Table(name = "entregables_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntregablesProyecto.findAll", query = "SELECT e FROM EntregablesProyecto e"),
    @NamedQuery(name = "EntregablesProyecto.findByIdENTREGABLESPROYECTO", query = "SELECT e FROM EntregablesProyecto e WHERE e.idENTREGABLESPROYECTO = :idENTREGABLESPROYECTO"),
    @NamedQuery(name = "EntregablesProyecto.findByDescripcion", query = "SELECT e FROM EntregablesProyecto e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EntregablesProyecto.findByFechaEnt", query = "SELECT e FROM EntregablesProyecto e WHERE e.fechaEnt = :fechaEnt"),
    @NamedQuery(name = "EntregablesProyecto.findByMonto", query = "SELECT e FROM EntregablesProyecto e WHERE e.monto = :monto"),
    @NamedQuery(name = "EntregablesProyecto.findByIva", query = "SELECT e FROM EntregablesProyecto e WHERE e.iva = :iva"),
    @NamedQuery(name = "EntregablesProyecto.findByMontoTotal", query = "SELECT e FROM EntregablesProyecto e WHERE e.montoTotal = :montoTotal")})
public class EntregablesProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idENTREGABLES_PROYECTO")
    private Integer idENTREGABLESPROYECTO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaEnt")
    @Temporal(TemporalType.DATE)
    private Date fechaEnt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Monto")
    private double monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Iva")
    private double iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MontoTotal")
    private double montoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eNTREGABLESPROYECTOidENTREGABLESPROYECTO")
    private Collection<FacturacionProyecto> facturacionProyectoCollection;
    @JoinColumn(name = "PROYECTO_idPROYECTO", referencedColumnName = "idPROYECTO")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOidPROYECTO;
    @JoinColumn(name = "PRODUCTOS_idPRODUCTOS", referencedColumnName = "idPRODUCTOS")
    @ManyToOne(optional = false)
    private Productos pRODUCTOSidPRODUCTOS;

    public EntregablesProyecto() {
    }

    public EntregablesProyecto(Integer idENTREGABLESPROYECTO) {
        this.idENTREGABLESPROYECTO = idENTREGABLESPROYECTO;
    }

    public EntregablesProyecto(Integer idENTREGABLESPROYECTO, String descripcion, Date fechaEnt, double monto, double iva, double montoTotal) {
        this.idENTREGABLESPROYECTO = idENTREGABLESPROYECTO;
        this.descripcion = descripcion;
        this.fechaEnt = fechaEnt;
        this.monto = monto;
        this.iva = iva;
        this.montoTotal = montoTotal;
    }

    public Integer getIdENTREGABLESPROYECTO() {
        return idENTREGABLESPROYECTO;
    }

    public void setIdENTREGABLESPROYECTO(Integer idENTREGABLESPROYECTO) {
        this.idENTREGABLESPROYECTO = idENTREGABLESPROYECTO;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEnt() {
        return fechaEnt;
    }

    public void setFechaEnt(Date fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @XmlTransient
    public Collection<FacturacionProyecto> getFacturacionProyectoCollection() {
        return facturacionProyectoCollection;
    }

    public void setFacturacionProyectoCollection(Collection<FacturacionProyecto> facturacionProyectoCollection) {
        this.facturacionProyectoCollection = facturacionProyectoCollection;
    }

    public Proyecto getPROYECTOidPROYECTO() {
        return pROYECTOidPROYECTO;
    }

    public void setPROYECTOidPROYECTO(Proyecto pROYECTOidPROYECTO) {
        this.pROYECTOidPROYECTO = pROYECTOidPROYECTO;
    }

    public Productos getPRODUCTOSidPRODUCTOS() {
        return pRODUCTOSidPRODUCTOS;
    }

    public void setPRODUCTOSidPRODUCTOS(Productos pRODUCTOSidPRODUCTOS) {
        this.pRODUCTOSidPRODUCTOS = pRODUCTOSidPRODUCTOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idENTREGABLESPROYECTO != null ? idENTREGABLESPROYECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntregablesProyecto)) {
            return false;
        }
        EntregablesProyecto other = (EntregablesProyecto) object;
        if ((this.idENTREGABLESPROYECTO == null && other.idENTREGABLESPROYECTO != null) || (this.idENTREGABLESPROYECTO != null && !this.idENTREGABLESPROYECTO.equals(other.idENTREGABLESPROYECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.EntregablesProyecto[ idENTREGABLESPROYECTO=" + idENTREGABLESPROYECTO + " ]";
    }
    
}
