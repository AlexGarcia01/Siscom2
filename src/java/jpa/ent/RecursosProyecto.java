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
@Table(name = "recursos_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecursosProyecto.findAll", query = "SELECT r FROM RecursosProyecto r"),
    @NamedQuery(name = "RecursosProyecto.findByIdRECURSOSPROYECTO", query = "SELECT r FROM RecursosProyecto r WHERE r.idRECURSOSPROYECTO = :idRECURSOSPROYECTO"),
    @NamedQuery(name = "RecursosProyecto.findByTipoRecurso", query = "SELECT r FROM RecursosProyecto r WHERE r.tipoRecurso = :tipoRecurso"),
    @NamedQuery(name = "RecursosProyecto.findByNumeroRecursos", query = "SELECT r FROM RecursosProyecto r WHERE r.numeroRecursos = :numeroRecursos")})
public class RecursosProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRECURSOS_PROYECTO")
    private Integer idRECURSOSPROYECTO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TipoRecurso")
    private String tipoRecurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumeroRecursos")
    private int numeroRecursos;
    @JoinColumn(name = "PUESTOS_idPUESTOS", referencedColumnName = "idPUESTOS")
    @ManyToOne(optional = false)
    private Puestos pUESTOSidPUESTOS;
    @JoinColumn(name = "PROYECTO_idPROYECTO", referencedColumnName = "idPROYECTO")
    @ManyToOne(optional = false)
    private Proyecto pROYECTOidPROYECTO;

    public RecursosProyecto() {
    }

    public RecursosProyecto(Integer idRECURSOSPROYECTO) {
        this.idRECURSOSPROYECTO = idRECURSOSPROYECTO;
    }

    public RecursosProyecto(Integer idRECURSOSPROYECTO, String tipoRecurso, int numeroRecursos) {
        this.idRECURSOSPROYECTO = idRECURSOSPROYECTO;
        this.tipoRecurso = tipoRecurso;
        this.numeroRecursos = numeroRecursos;
    }

    public Integer getIdRECURSOSPROYECTO() {
        return idRECURSOSPROYECTO;
    }

    public void setIdRECURSOSPROYECTO(Integer idRECURSOSPROYECTO) {
        this.idRECURSOSPROYECTO = idRECURSOSPROYECTO;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public int getNumeroRecursos() {
        return numeroRecursos;
    }

    public void setNumeroRecursos(int numeroRecursos) {
        this.numeroRecursos = numeroRecursos;
    }

    public Puestos getPUESTOSidPUESTOS() {
        return pUESTOSidPUESTOS;
    }

    public void setPUESTOSidPUESTOS(Puestos pUESTOSidPUESTOS) {
        this.pUESTOSidPUESTOS = pUESTOSidPUESTOS;
    }

    public Proyecto getPROYECTOidPROYECTO() {
        return pROYECTOidPROYECTO;
    }

    public void setPROYECTOidPROYECTO(Proyecto pROYECTOidPROYECTO) {
        this.pROYECTOidPROYECTO = pROYECTOidPROYECTO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRECURSOSPROYECTO != null ? idRECURSOSPROYECTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecursosProyecto)) {
            return false;
        }
        RecursosProyecto other = (RecursosProyecto) object;
        if ((this.idRECURSOSPROYECTO == null && other.idRECURSOSPROYECTO != null) || (this.idRECURSOSPROYECTO != null && !this.idRECURSOSPROYECTO.equals(other.idRECURSOSPROYECTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.RecursosProyecto[ idRECURSOSPROYECTO=" + idRECURSOSPROYECTO + " ]";
    }
    
}
