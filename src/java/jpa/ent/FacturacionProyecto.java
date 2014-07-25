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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "facturacion_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturacionProyecto.findAll", query = "SELECT f FROM FacturacionProyecto f"),
    @NamedQuery(name = "FacturacionProyecto.findByIdFACTURACIONPROYECTO", query = "SELECT f FROM FacturacionProyecto f WHERE f.idFACTURACIONPROYECTO = :idFACTURACIONPROYECTO"),
    @NamedQuery(name = "FacturacionProyecto.findByFolioFactura", query = "SELECT f FROM FacturacionProyecto f WHERE f.folioFactura = :folioFactura"),
    @NamedQuery(name = "FacturacionProyecto.findByMes", query = "SELECT f FROM FacturacionProyecto f WHERE f.mes = :mes"),
    @NamedQuery(name = "FacturacionProyecto.findByHoras", query = "SELECT f FROM FacturacionProyecto f WHERE f.horas = :horas"),
    @NamedQuery(name = "FacturacionProyecto.findByHorasFecha", query = "SELECT f FROM FacturacionProyecto f WHERE f.horasFecha = :horasFecha"),
    @NamedQuery(name = "FacturacionProyecto.findByMonto", query = "SELECT f FROM FacturacionProyecto f WHERE f.monto = :monto"),
    @NamedQuery(name = "FacturacionProyecto.findByIva", query = "SELECT f FROM FacturacionProyecto f WHERE f.iva = :iva"),
    @NamedQuery(name = "FacturacionProyecto.findByTotal", query = "SELECT f FROM FacturacionProyecto f WHERE f.total = :total")})
public class FacturacionProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFACTURACION_PROYECTO")
    private Integer idFACTURACIONPROYECTO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Folio_Factura")
    private String folioFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Mes")
    private String mes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Horas")
    private String horas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Horas_Fecha")
    private String horasFecha;
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
    @Column(name = "Total")
    private double total;
    @JoinColumn(name = "PROYECTO_idPROYECTO", referencedColumnName = "idPROYECTO")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOidPROYECTO;
    @JoinColumn(name = "ENTREGABLES_PROYECTO_idENTREGABLES_PROYECTO", referencedColumnName = "idENTREGABLES_PROYECTO")
    @ManyToOne(optional = false)
    private EntregablesProyecto eNTREGABLESPROYECTOidENTREGABLESPROYECTO;

    public FacturacionProyecto() {
    }

    public FacturacionProyecto(Integer idFACTURACIONPROYECTO) {
        this.idFACTURACIONPROYECTO = idFACTURACIONPROYECTO;
    }

    public FacturacionProyecto(Integer idFACTURACIONPROYECTO, String folioFactura, String mes, String horas, String horasFecha, double monto, double iva, double total) {
        this.idFACTURACIONPROYECTO = idFACTURACIONPROYECTO;
        this.folioFactura = folioFactura;
        this.mes = mes;
        this.horas = horas;
        this.horasFecha = horasFecha;
        this.monto = monto;
        this.iva = iva;
        this.total = total;
    }

    public Integer getIdFACTURACIONPROYECTO() {
        return idFACTURACIONPROYECTO;
    }

    public void setIdFACTURACIONPROYECTO(Integer idFACTURACIONPROYECTO) {
        this.idFACTURACIONPROYECTO = idFACTURACIONPROYECTO;
    }

    public String getFolioFactura() {
        return folioFactura;
    }

    public void setFolioFactura(String folioFactura) {
        this.folioFactura = folioFactura;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getHorasFecha() {
        return horasFecha;
    }

    public void setHorasFecha(String horasFecha) {
        this.horasFecha = horasFecha;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Proyecto getPROYECTOidPROYECTO() {
        return pROYECTOidPROYECTO;
    }

    public void setPROYECTOidPROYECTO(Proyecto pROYECTOidPROYECTO) {
        this.pROYECTOidPROYECTO = pROYECTOidPROYECTO;
    }

    public EntregablesProyecto getENTREGABLESPROYECTOidENTREGABLESPROYECTO() {
        return eNTREGABLESPROYECTOidENTREGABLESPROYECTO;
    }

    public void setENTREGABLESPROYECTOidENTREGABLESPROYECTO(EntregablesProyecto eNTREGABLESPROYECTOidENTREGABLESPROYECTO) {
        this.eNTREGABLESPROYECTOidENTREGABLESPROYECTO = eNTREGABLESPROYECTOidENTREGABLESPROYECTO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFACTURACIONPROYECTO != null ? idFACTURACIONPROYECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturacionProyecto)) {
            return false;
        }
        FacturacionProyecto other = (FacturacionProyecto) object;
        if ((this.idFACTURACIONPROYECTO == null && other.idFACTURACIONPROYECTO != null) || (this.idFACTURACIONPROYECTO != null && !this.idFACTURACIONPROYECTO.equals(other.idFACTURACIONPROYECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.FacturacionProyecto[ idFACTURACIONPROYECTO=" + idFACTURACIONPROYECTO + " ]";
    }
    
}
