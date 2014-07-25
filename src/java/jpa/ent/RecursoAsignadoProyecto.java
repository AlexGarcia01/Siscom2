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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "recurso_asignado_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecursoAsignadoProyecto.findAll", query = "SELECT r FROM RecursoAsignadoProyecto r"),
    @NamedQuery(name = "RecursoAsignadoProyecto.findByIdRECURSOASIGNADOPROYECTO", query = "SELECT r FROM RecursoAsignadoProyecto r WHERE r.idRECURSOASIGNADOPROYECTO = :idRECURSOASIGNADOPROYECTO"),
    @NamedQuery(name = "RecursoAsignadoProyecto.findByFechaInicio", query = "SELECT r FROM RecursoAsignadoProyecto r WHERE r.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "RecursoAsignadoProyecto.findByFechaFin", query = "SELECT r FROM RecursoAsignadoProyecto r WHERE r.fechaFin = :fechaFin"),
    @NamedQuery(name = "RecursoAsignadoProyecto.findBySuperior", query = "SELECT r FROM RecursoAsignadoProyecto r WHERE r.superior = :superior"),
    @NamedQuery(name = "RecursoAsignadoProyecto.findByPorcentageTiempo", query = "SELECT r FROM RecursoAsignadoProyecto r WHERE r.porcentageTiempo = :porcentageTiempo"),
    @NamedQuery(name = "RecursoAsignadoProyecto.findByComisionPorDia", query = "SELECT r FROM RecursoAsignadoProyecto r WHERE r.comisionPorDia = :comisionPorDia")})
public class RecursoAsignadoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRECURSO_ASIGNADO_PROYECTO")
    private Integer idRECURSOASIGNADOPROYECTO;
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
    @Size(max = 45)
    @Column(name = "Superior")
    private String superior;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PorcentageTiempo")
    private String porcentageTiempo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ComisionPorDia")
    private double comisionPorDia;
    @JoinColumn(name = "PROYECTO_idPROYECTO", referencedColumnName = "idPROYECTO")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOidPROYECTO;
    @JoinColumn(name = "USUARIOS_idUSUARIOS", referencedColumnName = "idUSUARIOS")
    @ManyToOne(optional = false)
    private Usuarios uSUARIOSidUSUARIOS;

    public RecursoAsignadoProyecto() {
    }

    public RecursoAsignadoProyecto(Integer idRECURSOASIGNADOPROYECTO) {
        this.idRECURSOASIGNADOPROYECTO = idRECURSOASIGNADOPROYECTO;
    }

    public RecursoAsignadoProyecto(Integer idRECURSOASIGNADOPROYECTO, Date fechaInicio, Date fechaFin, String porcentageTiempo, double comisionPorDia) {
        this.idRECURSOASIGNADOPROYECTO = idRECURSOASIGNADOPROYECTO;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.porcentageTiempo = porcentageTiempo;
        this.comisionPorDia = comisionPorDia;
    }

    public Integer getIdRECURSOASIGNADOPROYECTO() {
        return idRECURSOASIGNADOPROYECTO;
    }

    public void setIdRECURSOASIGNADOPROYECTO(Integer idRECURSOASIGNADOPROYECTO) {
        this.idRECURSOASIGNADOPROYECTO = idRECURSOASIGNADOPROYECTO;
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

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    public String getPorcentageTiempo() {
        return porcentageTiempo;
    }

    public void setPorcentageTiempo(String porcentageTiempo) {
        this.porcentageTiempo = porcentageTiempo;
    }

    public double getComisionPorDia() {
        return comisionPorDia;
    }

    public void setComisionPorDia(double comisionPorDia) {
        this.comisionPorDia = comisionPorDia;
    }

    public Proyecto getPROYECTOidPROYECTO() {
        return pROYECTOidPROYECTO;
    }

    public void setPROYECTOidPROYECTO(Proyecto pROYECTOidPROYECTO) {
        this.pROYECTOidPROYECTO = pROYECTOidPROYECTO;
    }

    public Usuarios getUSUARIOSidUSUARIOS() {
        return uSUARIOSidUSUARIOS;
    }

    public void setUSUARIOSidUSUARIOS(Usuarios uSUARIOSidUSUARIOS) {
        this.uSUARIOSidUSUARIOS = uSUARIOSidUSUARIOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRECURSOASIGNADOPROYECTO != null ? idRECURSOASIGNADOPROYECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursoAsignadoProyecto)) {
            return false;
        }
        RecursoAsignadoProyecto other = (RecursoAsignadoProyecto) object;
        if ((this.idRECURSOASIGNADOPROYECTO == null && other.idRECURSOASIGNADOPROYECTO != null) || (this.idRECURSOASIGNADOPROYECTO != null && !this.idRECURSOASIGNADOPROYECTO.equals(other.idRECURSOASIGNADOPROYECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.RecursoAsignadoProyecto[ idRECURSOASIGNADOPROYECTO=" + idRECURSOASIGNADOPROYECTO + " ]";
    }
    
}
