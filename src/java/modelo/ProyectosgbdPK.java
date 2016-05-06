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
 * @author NOREÑA
 */
@Embeddable
public class ProyectosgbdPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sgbd")
    private String sgbd;

    public ProyectosgbdPK() {
    }

    public ProyectosgbdPK(int codigo, String sgbd) {
        this.codigo = codigo;
        this.sgbd = sgbd;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigo;
        hash += (sgbd != null ? sgbd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectosgbdPK)) {
            return false;
        }
        ProyectosgbdPK other = (ProyectosgbdPK) object;
        if (this.codigo != other.codigo) {
            return false;
        }
        if ((this.sgbd == null && other.sgbd != null) || (this.sgbd != null && !this.sgbd.equals(other.sgbd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProyectosgbdPK[ codigo=" + codigo + ", sgbd=" + sgbd + " ]";
    }
    
}
