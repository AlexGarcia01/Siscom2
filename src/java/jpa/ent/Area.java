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
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByIdAREA", query = "SELECT a FROM Area a WHERE a.idAREA = :idAREA"),
    @NamedQuery(name = "Area.findByNombreArea", query = "SELECT a FROM Area a WHERE a.nombreArea = :nombreArea")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAREA")
    private Integer idAREA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NombreArea")
    private String nombreArea;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aREAidAREA")
    private Collection<Proyecto> proyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aREAidAREA")
    private Collection<Puestos> puestosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aREAidAREA")
    private Collection<Usuarios> usuariosCollection;

    public Area() {
    }

    public Area(Integer idAREA) {
        this.idAREA = idAREA;
    }

    public Area(Integer idAREA, String nombreArea) {
        this.idAREA = idAREA;
        this.nombreArea = nombreArea;
    }

    public Integer getIdAREA() {
        return idAREA;
    }

    public void setIdAREA(Integer idAREA) {
        this.idAREA = idAREA;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    @XmlTransient
    public Collection<Proyecto> getProyectoCollection() {
        return proyectoCollection;
    }

    public void setProyectoCollection(Collection<Proyecto> proyectoCollection) {
        this.proyectoCollection = proyectoCollection;
    }

    @XmlTransient
    public Collection<Puestos> getPuestosCollection() {
        return puestosCollection;
    }

    public void setPuestosCollection(Collection<Puestos> puestosCollection) {
        this.puestosCollection = puestosCollection;
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
        hash += (idAREA != null ? idAREA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.idAREA == null && other.idAREA != null) || (this.idAREA != null && !this.idAREA.equals(other.idAREA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.Area[ idAREA=" + idAREA + " ]";
    }
    
}
