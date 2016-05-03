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
import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue("junior")
@Table(name = "junior")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Junior.findAll", query = "SELECT j FROM Junior j"),
    @NamedQuery(name = "Junior.findByCedula", query = "SELECT j FROM Junior j WHERE j.cedula = :cedula"),
    @NamedQuery(name = "Junior.findByHorastrabajoxdia", query = "SELECT j FROM Junior j WHERE j.horastrabajoxdia = :horastrabajoxdia")})
public class Junior extends Ingsoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horastrabajoxdia")
    private int horastrabajoxdia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "junior1")
    private List<Colabora> colaboraList;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ingsoftware ingsoftware;

    public Junior() {
    }

    public Junior(Integer cedula) {
        this.cedula = cedula;
    }

    public Junior(Integer cedula, int horastrabajoxdia) {
        this.cedula = cedula;
        this.horastrabajoxdia = horastrabajoxdia;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public int getHorastrabajoxdia() {
        return horastrabajoxdia;
    }

    public void setHorastrabajoxdia(int horastrabajoxdia) {
        this.horastrabajoxdia = horastrabajoxdia;
    }

    @XmlTransient
    public List<Colabora> getColaboraList() {
        return colaboraList;
    }

    public void setColaboraList(List<Colabora> colaboraList) {
        this.colaboraList = colaboraList;
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
        if (!(object instanceof Junior)) {
            return false;
        }
        Junior other = (Junior) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Junior[ cedula=" + cedula + " ]";
    }
    
}
