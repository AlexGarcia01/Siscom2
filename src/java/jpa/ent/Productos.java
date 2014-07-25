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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdPRODUCTOS", query = "SELECT p FROM Productos p WHERE p.idPRODUCTOS = :idPRODUCTOS"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPRODUCTOS")
    private Integer idPRODUCTOS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pRODUCTOSidPRODUCTOS")
    private Collection<EntregablesProyecto> entregablesProyectoCollection;

    public Productos() {
    }

    public Productos(Integer idPRODUCTOS) {
        this.idPRODUCTOS = idPRODUCTOS;
    }

    public Productos(Integer idPRODUCTOS, String descripcion) {
        this.idPRODUCTOS = idPRODUCTOS;
        this.descripcion = descripcion;
    }

    public Integer getIdPRODUCTOS() {
        return idPRODUCTOS;
    }

    public void setIdPRODUCTOS(Integer idPRODUCTOS) {
        this.idPRODUCTOS = idPRODUCTOS;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<EntregablesProyecto> getEntregablesProyectoCollection() {
        return entregablesProyectoCollection;
    }

    public void setEntregablesProyectoCollection(Collection<EntregablesProyecto> entregablesProyectoCollection) {
        this.entregablesProyectoCollection = entregablesProyectoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPRODUCTOS != null ? idPRODUCTOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idPRODUCTOS == null && other.idPRODUCTOS != null) || (this.idPRODUCTOS != null && !this.idPRODUCTOS.equals(other.idPRODUCTOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.Productos[ idPRODUCTOS=" + idPRODUCTOS + " ]";
    }
    
}
