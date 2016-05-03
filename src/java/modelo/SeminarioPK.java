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
 * @author jsnar
 */
@Embeddable
public class SeminarioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingeniero")
    private int ingeniero;

    public SeminarioPK() {
    }

    public SeminarioPK(int numero, int ingeniero) {
        this.numero = numero;
        this.ingeniero = ingeniero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIngeniero() {
        return ingeniero;
    }

    public void setIngeniero(int ingeniero) {
        this.ingeniero = ingeniero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numero;
        hash += (int) ingeniero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeminarioPK)) {
            return false;
        }
        SeminarioPK other = (SeminarioPK) object;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.ingeniero != other.ingeniero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.SeminarioPK[ numero=" + numero + ", ingeniero=" + ingeniero + " ]";
    }
    
}
