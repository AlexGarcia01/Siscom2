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
@Table(name = "tipo_gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoGastos.findAll", query = "SELECT t FROM TipoGastos t"),
    @NamedQuery(name = "TipoGastos.findByIdTIPOGASTOS", query = "SELECT t FROM TipoGastos t WHERE t.idTIPOGASTOS = :idTIPOGASTOS"),
    @NamedQuery(name = "TipoGastos.findByDescripcion", query = "SELECT t FROM TipoGastos t WHERE t.descripcion = :descripcion")})
public class TipoGastos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTIPO_GASTOS")
    private Integer idTIPOGASTOS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tIPOGASTOSidTIPOGASTOS")
    private Collection<GastoProyectos> gastoProyectosCollection;

    public TipoGastos() {
    }

    public TipoGastos(Integer idTIPOGASTOS) {
        this.idTIPOGASTOS = idTIPOGASTOS;
    }

    public TipoGastos(Integer idTIPOGASTOS, String descripcion) {
        this.idTIPOGASTOS = idTIPOGASTOS;
        this.descripcion = descripcion;
    }

    public Integer getIdTIPOGASTOS() {
        return idTIPOGASTOS;
    }

    public void setIdTIPOGASTOS(Integer idTIPOGASTOS) {
        this.idTIPOGASTOS = idTIPOGASTOS;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<GastoProyectos> getGastoProyectosCollection() {
        return gastoProyectosCollection;
    }

    public void setGastoProyectosCollection(Collection<GastoProyectos> gastoProyectosCollection) {
        this.gastoProyectosCollection = gastoProyectosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIPOGASTOS != null ? idTIPOGASTOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoGastos)) {
            return false;
        }
        TipoGastos other = (TipoGastos) object;
        if ((this.idTIPOGASTOS == null && other.idTIPOGASTOS != null) || (this.idTIPOGASTOS != null && !this.idTIPOGASTOS.equals(other.idTIPOGASTOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.TipoGastos[ idTIPOGASTOS=" + idTIPOGASTOS + " ]";
    }
    
}
