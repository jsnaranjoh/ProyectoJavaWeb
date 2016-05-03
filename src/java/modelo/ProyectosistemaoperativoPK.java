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
 * @author jsnar
 */
@Embeddable
public class ProyectosistemaoperativoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "sistemaoperativo")
    private String sistemaoperativo;

    public ProyectosistemaoperativoPK() {
    }

    public ProyectosistemaoperativoPK(int codigo, String sistemaoperativo) {
        this.codigo = codigo;
        this.sistemaoperativo = sistemaoperativo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSistemaoperativo() {
        return sistemaoperativo;
    }

    public void setSistemaoperativo(String sistemaoperativo) {
        this.sistemaoperativo = sistemaoperativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigo;
        hash += (sistemaoperativo != null ? sistemaoperativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectosistemaoperativoPK)) {
            return false;
        }
        ProyectosistemaoperativoPK other = (ProyectosistemaoperativoPK) object;
        if (this.codigo != other.codigo) {
            return false;
        }
        if ((this.sistemaoperativo == null && other.sistemaoperativo != null) || (this.sistemaoperativo != null && !this.sistemaoperativo.equals(other.sistemaoperativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProyectosistemaoperativoPK[ codigo=" + codigo + ", sistemaoperativo=" + sistemaoperativo + " ]";
    }
    
}
