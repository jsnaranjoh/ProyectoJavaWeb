/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author NOREÑA
 */
@Embeddable
public class SeencuentraenPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "proyecto")
    private int proyecto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fase")
    private int fase;

    public SeencuentraenPK() {
    }

    public SeencuentraenPK(int proyecto, int fase) {
        this.proyecto = proyecto;
        this.fase = fase;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyecto;
        hash += (int) fase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeencuentraenPK)) {
            return false;
        }
        SeencuentraenPK other = (SeencuentraenPK) object;
        if (this.proyecto != other.proyecto) {
            return false;
        }
        if (this.fase != other.fase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SeencuentraenPK[ proyecto=" + proyecto + ", fase=" + fase + " ]";
    }
    
}
