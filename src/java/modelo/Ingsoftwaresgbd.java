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
 * @author jsnar
 */
@Entity
@Table(name = "ingsoftwaresgbd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingsoftwaresgbd.findAll", query = "SELECT i FROM Ingsoftwaresgbd i"),
    @NamedQuery(name = "Ingsoftwaresgbd.findByCedula", query = "SELECT i FROM Ingsoftwaresgbd i WHERE i.ingsoftwaresgbdPK.cedula = :cedula"),
    @NamedQuery(name = "Ingsoftwaresgbd.findBySgbd", query = "SELECT i FROM Ingsoftwaresgbd i WHERE i.ingsoftwaresgbdPK.sgbd = :sgbd")})
public class Ingsoftwaresgbd implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngsoftwaresgbdPK ingsoftwaresgbdPK;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingsoftware ingsoftware;

    public Ingsoftwaresgbd() {
    }

    public Ingsoftwaresgbd(IngsoftwaresgbdPK ingsoftwaresgbdPK) {
        this.ingsoftwaresgbdPK = ingsoftwaresgbdPK;
    }

    public Ingsoftwaresgbd(int cedula, String sgbd) {
        this.ingsoftwaresgbdPK = new IngsoftwaresgbdPK(cedula, sgbd);
    }

    public IngsoftwaresgbdPK getIngsoftwaresgbdPK() {
        return ingsoftwaresgbdPK;
    }

    public void setIngsoftwaresgbdPK(IngsoftwaresgbdPK ingsoftwaresgbdPK) {
        this.ingsoftwaresgbdPK = ingsoftwaresgbdPK;
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
        hash += (ingsoftwaresgbdPK != null ? ingsoftwaresgbdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingsoftwaresgbd)) {
            return false;
        }
        Ingsoftwaresgbd other = (Ingsoftwaresgbd) object;
        if ((this.ingsoftwaresgbdPK == null && other.ingsoftwaresgbdPK != null) || (this.ingsoftwaresgbdPK != null && !this.ingsoftwaresgbdPK.equals(other.ingsoftwaresgbdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ingsoftwaresgbd[ ingsoftwaresgbdPK=" + ingsoftwaresgbdPK + " ]";
    }
    
}
