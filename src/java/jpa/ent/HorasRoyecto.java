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
@Table(name = "horas_royecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorasRoyecto.findAll", query = "SELECT h FROM HorasRoyecto h"),
    @NamedQuery(name = "HorasRoyecto.findByIdHORASROYECTO", query = "SELECT h FROM HorasRoyecto h WHERE h.idHORASROYECTO = :idHORASROYECTO"),
    @NamedQuery(name = "HorasRoyecto.findByHoras", query = "SELECT h FROM HorasRoyecto h WHERE h.horas = :horas"),
    @NamedQuery(name = "HorasRoyecto.findByStatus", query = "SELECT h FROM HorasRoyecto h WHERE h.status = :status")})
public class HorasRoyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHORAS_ROYECTO")
    private Integer idHORASROYECTO;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Horas")
    private int horas;
    @Size(max = 10)
    @Column(name = "Status")
    private String status;
    @JoinColumn(name = "PROYECTO_idPROYECTO", referencedColumnName = "idPROYECTO")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOidPROYECTO;
    @JoinColumn(name = "USUARIOS_idUSUARIOS", referencedColumnName = "idUSUARIOS")
    @ManyToOne(optional = false)
    private Usuarios uSUARIOSidUSUARIOS;
    @JoinColumn(name = "PERIODOS_idPERIODOS", referencedColumnName = "idPERIODOS")
    @ManyToOne(optional = false)
    private Periodos pERIODOSidPERIODOS;

    public HorasRoyecto() {
    }

    public HorasRoyecto(Integer idHORASROYECTO) {
        this.idHORASROYECTO = idHORASROYECTO;
    }

    public HorasRoyecto(Integer idHORASROYECTO, int horas) {
        this.idHORASROYECTO = idHORASROYECTO;
        this.horas = horas;
    }

    public Integer getIdHORASROYECTO() {
        return idHORASROYECTO;
    }

    public void setIdHORASROYECTO(Integer idHORASROYECTO) {
        this.idHORASROYECTO = idHORASROYECTO;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Periodos getPERIODOSidPERIODOS() {
        return pERIODOSidPERIODOS;
    }

    public void setPERIODOSidPERIODOS(Periodos pERIODOSidPERIODOS) {
        this.pERIODOSidPERIODOS = pERIODOSidPERIODOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHORASROYECTO != null ? idHORASROYECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorasRoyecto)) {
            return false;
        }
        HorasRoyecto other = (HorasRoyecto) object;
        if ((this.idHORASROYECTO == null && other.idHORASROYECTO != null) || (this.idHORASROYECTO != null && !this.idHORASROYECTO.equals(other.idHORASROYECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.HorasRoyecto[ idHORASROYECTO=" + idHORASROYECTO + " ]";
    }
    
}
