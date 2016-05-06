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
public class ColaboraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "junior")
    private int junior;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyecto")
    private int proyecto;

    public ColaboraPK() {
    }

    public ColaboraPK(int junior, int proyecto) {
        this.junior = junior;
        this.proyecto = proyecto;
    }

    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) junior;
        hash += (int) proyecto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColaboraPK)) {
            return false;
        }
        ColaboraPK other = (ColaboraPK) object;
        if (this.junior != other.junior) {
            return false;
        }
        if (this.proyecto != other.proyecto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ColaboraPK[ junior=" + junior + ", proyecto=" + proyecto + " ]";
    }
    
}
