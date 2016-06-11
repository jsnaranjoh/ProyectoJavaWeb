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
import javax.validation.constraints.Size;

/**
 *
 * @author crisd
 */
@Embeddable
public class IngsoftwarelenguajeprogPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private int cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lenguajeprog")
    private String lenguajeprog;

    public IngsoftwarelenguajeprogPK() {
    }

    public IngsoftwarelenguajeprogPK(int cedula, String lenguajeprog) {
        this.cedula = cedula;
        this.lenguajeprog = lenguajeprog;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getLenguajeprog() {
        return lenguajeprog;
    }

    public void setLenguajeprog(String lenguajeprog) {
        this.lenguajeprog = lenguajeprog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cedula;
        hash += (lenguajeprog != null ? lenguajeprog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngsoftwarelenguajeprogPK)) {
            return false;
        }
        IngsoftwarelenguajeprogPK other = (IngsoftwarelenguajeprogPK) object;
        if (this.cedula != other.cedula) {
            return false;
        }
        if ((this.lenguajeprog == null && other.lenguajeprog != null) || (this.lenguajeprog != null && !this.lenguajeprog.equals(other.lenguajeprog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.IngsoftwarelenguajeprogPK[ cedula=" + cedula + ", lenguajeprog=" + lenguajeprog + " ]";
    }
    
}
