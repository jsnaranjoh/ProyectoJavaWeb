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
 * @author NOREÑA
 */
@Entity
@Table(name = "senior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Senior.findAll", query = "SELECT s FROM Senior s"),
    @NamedQuery(name = "Senior.findByCedula", query = "SELECT s FROM Senior s WHERE s.cedula = :cedula"),
    @NamedQuery(name = "Senior.findByProyectosquelidera", query = "SELECT s FROM Senior s WHERE s.proyectosquelidera = :proyectosquelidera")})
public class Senior implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosquelidera")
    private int proyectosquelidera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lider")
    private List<Proyecto> proyectoList;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ingsoftware ingsoftware;

    public Senior() {
    }

    public Senior(Integer cedula) {
        this.cedula = cedula;
    }

    public Senior(Integer cedula, int proyectosquelidera) {
        this.cedula = cedula;
        this.proyectosquelidera = proyectosquelidera;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public int getProyectosquelidera() {
        return proyectosquelidera;
    }

    public void setProyectosquelidera(int proyectosquelidera) {
        this.proyectosquelidera = proyectosquelidera;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    public Ingsoftware getIngsoftware() {
        return ingsoftware;
    }

    public void setIngsoftware(Ingsoftware ingsoftware) {
        this.ingsoftware = ingsoftware;
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
        if (!(object instanceof Senior)) {
            return false;
        }
        Senior other = (Senior) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Senior[ cedula=" + cedula + " ]";
    }
    
}
