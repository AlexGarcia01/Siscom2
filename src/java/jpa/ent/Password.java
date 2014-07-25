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
@Table(name = "password")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Password.findAll", query = "SELECT p FROM Password p"),
    @NamedQuery(name = "Password.findByIdPASSWORD", query = "SELECT p FROM Password p WHERE p.idPASSWORD = :idPASSWORD"),
    @NamedQuery(name = "Password.findByPassword", query = "SELECT p FROM Password p WHERE p.password = :password"),
    @NamedQuery(name = "Password.findByFecheInicio", query = "SELECT p FROM Password p WHERE p.fecheInicio = :fecheInicio"),
    @NamedQuery(name = "Password.findByFechaFin", query = "SELECT p FROM Password p WHERE p.fechaFin = :fechaFin"),
    @NamedQuery(name = "Password.findByFechaCaducidad", query = "SELECT p FROM Password p WHERE p.fechaCaducidad = :fechaCaducidad"),
    @NamedQuery(name = "Password.findByTipoUsuario", query = "SELECT p FROM Password p WHERE p.tipoUsuario = :tipoUsuario")})
public class Password implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPASSWORD")
    private Integer idPASSWORD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FecheInicio")
    @Temporal(TemporalType.DATE)
    private Date fecheInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaFin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaCaducidad")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TipoUsuario")
    private String tipoUsuario;
    @JoinColumn(name = "USUARIOS_idUSUARIOS", referencedColumnName = "idUSUARIOS")
    @ManyToOne(optional = false)
    private Usuarios uSUARIOSidUSUARIOS;

    public Password() {
    }

    public Password(Integer idPASSWORD) {
        this.idPASSWORD = idPASSWORD;
    }

    public Password(Integer idPASSWORD, String password, Date fecheInicio, Date fechaFin, Date fechaCaducidad, String tipoUsuario) {
        this.idPASSWORD = idPASSWORD;
        this.password = password;
        this.fecheInicio = fecheInicio;
        this.fechaFin = fechaFin;
        this.fechaCaducidad = fechaCaducidad;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdPASSWORD() {
        return idPASSWORD;
    }

    public void setIdPASSWORD(Integer idPASSWORD) {
        this.idPASSWORD = idPASSWORD;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecheInicio() {
        return fecheInicio;
    }

    public void setFecheInicio(Date fecheInicio) {
        this.fecheInicio = fecheInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
        hash += (idPASSWORD != null ? idPASSWORD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Password)) {
            return false;
        }
        Password other = (Password) object;
        if ((this.idPASSWORD == null && other.idPASSWORD != null) || (this.idPASSWORD != null && !this.idPASSWORD.equals(other.idPASSWORD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.Password[ idPASSWORD=" + idPASSWORD + " ]";
    }
    
}
