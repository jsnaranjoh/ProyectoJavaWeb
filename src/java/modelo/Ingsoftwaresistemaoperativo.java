/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NOREÑA
 */
@Entity
@Table(name = "ingsoftwaresistemaoperativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingsoftwaresistemaoperativo.findAll", query = "SELECT i FROM Ingsoftwaresistemaoperativo i"),
    @NamedQuery(name = "Ingsoftwaresistemaoperativo.findByCedula", query = "SELECT i FROM Ingsoftwaresistemaoperativo i WHERE i.ingsoftwaresistemaoperativoPK.cedula = :cedula"),
    @NamedQuery(name = "Ingsoftwaresistemaoperativo.findBySistemaoperativo", query = "SELECT i FROM Ingsoftwaresistemaoperativo i WHERE i.ingsoftwaresistemaoperativoPK.sistemaoperativo = :sistemaoperativo")})
public class Ingsoftwaresistemaoperativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngsoftwaresistemaoperativoPK ingsoftwaresistemaoperativoPK;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingsoftware ingsoftware;

    public Ingsoftwaresistemaoperativo() {
    }

    public Ingsoftwaresistemaoperativo(IngsoftwaresistemaoperativoPK ingsoftwaresistemaoperativoPK) {
        this.ingsoftwaresistemaoperativoPK = ingsoftwaresistemaoperativoPK;
    }

    public Ingsoftwaresistemaoperativo(int cedula, String sistemaoperativo) {
        this.ingsoftwaresistemaoperativoPK = new IngsoftwaresistemaoperativoPK(cedula, sistemaoperativo);
    }

    public IngsoftwaresistemaoperativoPK getIngsoftwaresistemaoperativoPK() {
        return ingsoftwaresistemaoperativoPK;
    }

    public void setIngsoftwaresistemaoperativoPK(IngsoftwaresistemaoperativoPK ingsoftwaresistemaoperativoPK) {
        this.ingsoftwaresistemaoperativoPK = ingsoftwaresistemaoperativoPK;
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
        hash += (ingsoftwaresistemaoperativoPK != null ? ingsoftwaresistemaoperativoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingsoftwaresistemaoperativo)) {
            return false;
        }
        Ingsoftwaresistemaoperativo other = (Ingsoftwaresistemaoperativo) object;
        if ((this.ingsoftwaresistemaoperativoPK == null && other.ingsoftwaresistemaoperativoPK != null) || (this.ingsoftwaresistemaoperativoPK != null && !this.ingsoftwaresistemaoperativoPK.equals(other.ingsoftwaresistemaoperativoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ingsoftwaresistemaoperativo[ ingsoftwaresistemaoperativoPK=" + ingsoftwaresistemaoperativoPK + " ]";
    }
    
}
