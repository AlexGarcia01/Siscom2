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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUSUARIOS", query = "SELECT u FROM Usuarios u WHERE u.idUSUARIOS = :idUSUARIOS"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByApellidoPaterno", query = "SELECT u FROM Usuarios u WHERE u.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Usuarios.findByApellidoMaterno", query = "SELECT u FROM Usuarios u WHERE u.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Usuarios.findByTipoContrato", query = "SELECT u FROM Usuarios u WHERE u.tipoContrato = :tipoContrato"),
    @NamedQuery(name = "Usuarios.findByCalle", query = "SELECT u FROM Usuarios u WHERE u.calle = :calle"),
    @NamedQuery(name = "Usuarios.findByNumero", query = "SELECT u FROM Usuarios u WHERE u.numero = :numero"),
    @NamedQuery(name = "Usuarios.findByCp", query = "SELECT u FROM Usuarios u WHERE u.cp = :cp"),
    @NamedQuery(name = "Usuarios.findByColonia", query = "SELECT u FROM Usuarios u WHERE u.colonia = :colonia"),
    @NamedQuery(name = "Usuarios.findByDelegacion", query = "SELECT u FROM Usuarios u WHERE u.delegacion = :delegacion"),
    @NamedQuery(name = "Usuarios.findByCorreoElectronico", query = "SELECT u FROM Usuarios u WHERE u.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUSUARIOS")
    private Integer idUSUARIOS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ApellidoPaterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ApellidoMaterno")
    private String apellidoMaterno;
    @Size(max = 45)
    @Column(name = "TipoContrato")
    private String tipoContrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CP")
    private int cp;
    @Size(max = 45)
    @Column(name = "Colonia")
    private String colonia;
    @Size(max = 45)
    @Column(name = "Delegacion")
    private String delegacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CorreoElectronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono")
    private long telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUARIOSidUSUARIOS")
    private Collection<HorasRoyecto> horasRoyectoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUARIOSidUSUARIOS")
    private Collection<Password> passwordCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uSUARIOSidUSUARIOS")
    private Collection<RecursoAsignadoProyecto> recursoAsignadoProyectoCollection;
    @JoinColumn(name = "PUESTOS_idPUESTOS", referencedColumnName = "idPUESTOS")
    @ManyToOne(optional = false)
    private Puestos pUESTOSidPUESTOS;
    @JoinColumn(name = "AREA_idAREA", referencedColumnName = "idAREA")
    @ManyToOne(optional = false)
    private Area aREAidAREA;

    public Usuarios() {
    }

    public Usuarios(Integer idUSUARIOS) {
        this.idUSUARIOS = idUSUARIOS;
    }

    public Usuarios(Integer idUSUARIOS, String nombre, String apellidoPaterno, String apellidoMaterno, String calle, String numero, int cp, String correoElectronico, long telefono) {
        this.idUSUARIOS = idUSUARIOS;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public Integer getIdUSUARIOS() {
        return idUSUARIOS;
    }

    public void setIdUSUARIOS(Integer idUSUARIOS) {
        this.idUSUARIOS = idUSUARIOS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegacion() {
        return delegacion;
    }

    public void setDelegacion(String delegacion) {
        this.delegacion = delegacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<HorasRoyecto> getHorasRoyectoCollection() {
        return horasRoyectoCollection;
    }

    public void setHorasRoyectoCollection(Collection<HorasRoyecto> horasRoyectoCollection) {
        this.horasRoyectoCollection = horasRoyectoCollection;
    }

    @XmlTransient
    public Collection<Password> getPasswordCollection() {
        return passwordCollection;
    }

    public void setPasswordCollection(Collection<Password> passwordCollection) {
        this.passwordCollection = passwordCollection;
    }

    @XmlTransient
    public Collection<RecursoAsignadoProyecto> getRecursoAsignadoProyectoCollection() {
        return recursoAsignadoProyectoCollection;
    }

    public void setRecursoAsignadoProyectoCollection(Collection<RecursoAsignadoProyecto> recursoAsignadoProyectoCollection) {
        this.recursoAsignadoProyectoCollection = recursoAsignadoProyectoCollection;
    }

    public Puestos getPUESTOSidPUESTOS() {
        return pUESTOSidPUESTOS;
    }

    public void setPUESTOSidPUESTOS(Puestos pUESTOSidPUESTOS) {
        this.pUESTOSidPUESTOS = pUESTOSidPUESTOS;
    }

    public Area getAREAidAREA() {
        return aREAidAREA;
    }

    public void setAREAidAREA(Area aREAidAREA) {
        this.aREAidAREA = aREAidAREA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUSUARIOS != null ? idUSUARIOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.idUSUARIOS == null && other.idUSUARIOS != null) || (this.idUSUARIOS != null && !this.idUSUARIOS.equals(other.idUSUARIOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.Usuarios[ idUSUARIOS=" + idUSUARIOS + " ]";
    }
    
}
