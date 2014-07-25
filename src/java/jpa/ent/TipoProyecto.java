/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.ent;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "tipo_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProyecto.findAll", query = "SELECT t FROM TipoProyecto t"),
    @NamedQuery(name = "TipoProyecto.findByIdTIPOPROYECTO", query = "SELECT t FROM TipoProyecto t WHERE t.idTIPOPROYECTO = :idTIPOPROYECTO"),
    @NamedQuery(name = "TipoProyecto.findByDescripcionProyecto", query = "SELECT t FROM TipoProyecto t WHERE t.descripcionProyecto = :descripcionProyecto")})
public class TipoProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTIPO_PROYECTO")
    private Integer idTIPOPROYECTO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DescripcionProyecto")
    private String descripcionProyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tIPOPROYECTOidTIPOPROYECTO")
    private Collection<Proyecto> proyectoCollection;

    public TipoProyecto() {
    }

    public TipoProyecto(Integer idTIPOPROYECTO) {
        this.idTIPOPROYECTO = idTIPOPROYECTO;
    }

    public TipoProyecto(Integer idTIPOPROYECTO, String descripcionProyecto) {
        this.idTIPOPROYECTO = idTIPOPROYECTO;
        this.descripcionProyecto = descripcionProyecto;
    }

    public Integer getIdTIPOPROYECTO() {
        return idTIPOPROYECTO;
    }

    public void setIdTIPOPROYECTO(Integer idTIPOPROYECTO) {
        this.idTIPOPROYECTO = idTIPOPROYECTO;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIPOPROYECTO != null ? idTIPOPROYECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProyecto)) {
            return false;
        }
        TipoProyecto other = (TipoProyecto) object;
        if ((this.idTIPOPROYECTO == null && other.idTIPOPROYECTO != null) || (this.idTIPOPROYECTO != null && !this.idTIPOPROYECTO.equals(other.idTIPOPROYECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.TipoProyecto[ idTIPOPROYECTO=" + idTIPOPROYECTO + " ]";
    }
    
}
