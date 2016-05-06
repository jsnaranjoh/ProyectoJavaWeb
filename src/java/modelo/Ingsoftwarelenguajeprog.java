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
@Table(name = "ingsoftwarelenguajeprog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingsoftwarelenguajeprog.findAll", query = "SELECT i FROM Ingsoftwarelenguajeprog i"),
    @NamedQuery(name = "Ingsoftwarelenguajeprog.findByCedula", query = "SELECT i FROM Ingsoftwarelenguajeprog i WHERE i.ingsoftwarelenguajeprogPK.cedula = :cedula"),
    @NamedQuery(name = "Ingsoftwarelenguajeprog.findByLenguajeprog", query = "SELECT i FROM Ingsoftwarelenguajeprog i WHERE i.ingsoftwarelenguajeprogPK.lenguajeprog = :lenguajeprog")})
public class Ingsoftwarelenguajeprog implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngsoftwarelenguajeprogPK ingsoftwarelenguajeprogPK;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingsoftware ingsoftware;

    public Ingsoftwarelenguajeprog() {
    }

    public Ingsoftwarelenguajeprog(IngsoftwarelenguajeprogPK ingsoftwarelenguajeprogPK) {
        this.ingsoftwarelenguajeprogPK = ingsoftwarelenguajeprogPK;
    }

    public Ingsoftwarelenguajeprog(int cedula, String lenguajeprog) {
        this.ingsoftwarelenguajeprogPK = new IngsoftwarelenguajeprogPK(cedula, lenguajeprog);
    }

    public IngsoftwarelenguajeprogPK getIngsoftwarelenguajeprogPK() {
        return ingsoftwarelenguajeprogPK;
    }

    public void setIngsoftwarelenguajeprogPK(IngsoftwarelenguajeprogPK ingsoftwarelenguajeprogPK) {
        this.ingsoftwarelenguajeprogPK = ingsoftwarelenguajeprogPK;
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
        hash += (ingsoftwarelenguajeprogPK != null ? ingsoftwarelenguajeprogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingsoftwarelenguajeprog)) {
            return false;
        }
        Ingsoftwarelenguajeprog other = (Ingsoftwarelenguajeprog) object;
        if ((this.ingsoftwarelenguajeprogPK == null && other.ingsoftwarelenguajeprogPK != null) || (this.ingsoftwarelenguajeprogPK != null && !this.ingsoftwarelenguajeprogPK.equals(other.ingsoftwarelenguajeprogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ingsoftwarelenguajeprog[ ingsoftwarelenguajeprogPK=" + ingsoftwarelenguajeprogPK + " ]";
    }
    
}
