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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "tab_sueldos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabSueldos.findAll", query = "SELECT t FROM TabSueldos t"),
    @NamedQuery(name = "TabSueldos.findByIdTABSUELDOS", query = "SELECT t FROM TabSueldos t WHERE t.idTABSUELDOS = :idTABSUELDOS"),
    @NamedQuery(name = "TabSueldos.findBySueldoBAse", query = "SELECT t FROM TabSueldos t WHERE t.sueldoBAse = :sueldoBAse"),
    @NamedQuery(name = "TabSueldos.findBySueldoVariable", query = "SELECT t FROM TabSueldos t WHERE t.sueldoVariable = :sueldoVariable")})
public class TabSueldos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTAB_SUELDOS")
    private Integer idTABSUELDOS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SueldoBAse")
    private double sueldoBAse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SueldoVariable")
    private double sueldoVariable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tABSUELDOSidTABSUELDOS")
    private Collection<Sueldos> sueldosCollection;
    @JoinColumn(name = "PUESTOS_idPUESTOS", referencedColumnName = "idPUESTOS")
    @ManyToOne(optional = false)
    private Puestos pUESTOSidPUESTOS;

    public TabSueldos() {
    }

    public TabSueldos(Integer idTABSUELDOS) {
        this.idTABSUELDOS = idTABSUELDOS;
    }

    public TabSueldos(Integer idTABSUELDOS, double sueldoBAse, double sueldoVariable) {
        this.idTABSUELDOS = idTABSUELDOS;
        this.sueldoBAse = sueldoBAse;
        this.sueldoVariable = sueldoVariable;
    }

    public Integer getIdTABSUELDOS() {
        return idTABSUELDOS;
    }

    public void setIdTABSUELDOS(Integer idTABSUELDOS) {
        this.idTABSUELDOS = idTABSUELDOS;
    }

    public double getSueldoBAse() {
        return sueldoBAse;
    }

    public void setSueldoBAse(double sueldoBAse) {
        this.sueldoBAse = sueldoBAse;
    }

    public double getSueldoVariable() {
        return sueldoVariable;
    }

    public void setSueldoVariable(double sueldoVariable) {
        this.sueldoVariable = sueldoVariable;
    }

    @XmlTransient
    public Collection<Sueldos> getSueldosCollection() {
        return sueldosCollection;
    }

    public void setSueldosCollection(Collection<Sueldos> sueldosCollection) {
        this.sueldosCollection = sueldosCollection;
    }

    public Puestos getPUESTOSidPUESTOS() {
        return pUESTOSidPUESTOS;
    }

    public void setPUESTOSidPUESTOS(Puestos pUESTOSidPUESTOS) {
        this.pUESTOSidPUESTOS = pUESTOSidPUESTOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTABSUELDOS != null ? idTABSUELDOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabSueldos)) {
            return false;
        }
        TabSueldos other = (TabSueldos) object;
        if ((this.idTABSUELDOS == null && other.idTABSUELDOS != null) || (this.idTABSUELDOS != null && !this.idTABSUELDOS.equals(other.idTABSUELDOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ent.TabSueldos[ idTABSUELDOS=" + idTABSUELDOS + " ]";
    }
    
}
