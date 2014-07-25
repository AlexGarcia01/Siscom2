/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.ent;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gasto_proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GastoProyectos.findAll", query = "SELECT g FROM GastoProyectos g"),
    @NamedQuery(name = "GastoProyectos.findByIdGASTOPROYECTOS", query = "SELECT g FROM GastoProyectos g WHERE g.idGASTOPROYECTOS = :idGASTOPROYECTOS"),
    @NamedQuery(name = "GastoProyectos.findByMonto", query = "SELECT g FROM GastoProyectos g WHERE g.monto = :monto"),
    @NamedQuery(name = "GastoProyectos.findByIva", query = "SELECT g FROM GastoProyectos g WHERE g.iva = :iva"),
    @NamedQuery(name = "GastoProyectos.findByTotalMonto", query = "SELECT g FROM GastoProyectos g WHERE g.totalMonto = :totalMonto")})
public class GastoProyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGASTO_PROYECTOS")
    private Integer idGASTOPROYECTOS;
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
    @Column(name = "TotalMonto")
    private double totalMonto;
    @JoinColumn(name = "PROYECTO_idPROYECTO", referencedColumnName = "idPROYECTO")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOidPROYECTO;
    @JoinColumn(name = "TIPO_GASTOS_idTIPO_GASTOS", referencedColumnName = "idTIPO_GASTOS")
    @ManyToOne(optional = false)
    private TipoGastos tIPOGASTOSidTIPOGASTOS;

    public GastoProyectos() {
    }

    public GastoProyectos(Integer idGASTOPROYECTOS) {
        this.idGASTOPROYECTOS = idGASTOPROYECTOS;
    }

    public GastoProyectos(Integer idGASTOPROYECTOS, double monto, double iva, double totalMonto) {
        this.idGASTOPROYECTOS = idGASTOPROYECTOS;
        this.monto = monto;
        this.iva = iva;
        this.totalMonto = totalMonto;
    }

    public Integer getIdGASTOPROYECTOS() {
        return idGASTOPROYECTOS;
    }

    public void setIdGASTOPROYECTOS(Integer idGASTOPROYECTOS) {
        this.idGASTOPROYECTOS = idGASTOPROYECTOS;
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

    public double getTotalMonto() {
        return totalMonto;
    }

    public void setTotalMonto(double totalMonto) {
        this.totalMonto = totalMonto;
    }

    public Proyecto getPROYECTOidPROYECTO() {
        return pROYECTOidPROYECTO;
    }

    public void setPROYECTOidPROYECTO(Proyecto pROYECTOidPROYECTO) {
        this.pROYECTOidPROYECTO = pROYECTOidPROYECTO;
    }

    public TipoGastos getTIPOGASTOSidTIPOGASTOS() {
        return tIPOGASTOSidTIPOGASTOS;
    }

    public void setTIPOGASTOSidTIPOGASTOS(TipoGastos tIPOGASTOSidTIPOGASTOS) {
        this.tIPOGASTOSidTIPOGASTOS = tIPOGASTOSidTIPOGASTOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGASTOPROYECTOS != null ? idGASTOPROYECTOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastoProyectos)) {
            return false;
        }
        GastoProyectos other = (GastoProyectos) object;
        if ((this.idGASTOPROYECTOS == null && other.idGASTOPROYECTOS != null) || (this.idGASTOPROYECTOS != null && !this.idGASTOPROYECTOS.equals(other.idGASTOPROYECTOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.GastoProyectos[ idGASTOPROYECTOS=" + idGASTOPROYECTOS + " ]";
    }
    
}
