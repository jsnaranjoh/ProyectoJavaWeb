/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsnar
 */
@Entity
@Table(name = "jefe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jefe.findAll", query = "SELECT j FROM Jefe j"),
    @NamedQuery(name = "Jefe.findByCedula", query = "SELECT j FROM Jefe j WHERE j.cedula = :cedula"),
    @NamedQuery(name = "Jefe.findByPresupuesto", query = "SELECT j FROM Jefe j WHERE j.presupuesto = :presupuesto")})
public class Jefe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presupuesto")
    private int presupuesto;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ingsoftware ingsoftware;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "verificador")
    private List<Solicitud> solicitudList;

    public Jefe() {
    }

    public Jefe(Integer cedula) {
        this.cedula = cedula;
    }

    public Jefe(Integer cedula, int presupuesto) {
        this.cedula = cedula;
        this.presupuesto = presupuesto;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Ingsoftware getIngsoftware() {
        return ingsoftware;
    }

    public void setIngsoftware(Ingsoftware ingsoftware) {
        this.ingsoftware = ingsoftware;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jefe)) {
            return false;
        }
        Jefe other = (Jefe) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Jefe[ cedula=" + cedula + " ]";
    }
    
}
