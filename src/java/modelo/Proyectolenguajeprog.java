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
@Table(name = "proyectolenguajeprog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectolenguajeprog.findAll", query = "SELECT p FROM Proyectolenguajeprog p"),
    @NamedQuery(name = "Proyectolenguajeprog.findByCodigo", query = "SELECT p FROM Proyectolenguajeprog p WHERE p.proyectolenguajeprogPK.codigo = :codigo"),
    @NamedQuery(name = "Proyectolenguajeprog.findByLenguajeprog", query = "SELECT p FROM Proyectolenguajeprog p WHERE p.proyectolenguajeprogPK.lenguajeprog = :lenguajeprog")})
public class Proyectolenguajeprog implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectolenguajeprogPK proyectolenguajeprogPK;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public Proyectolenguajeprog() {
    }

    public Proyectolenguajeprog(ProyectolenguajeprogPK proyectolenguajeprogPK) {
        this.proyectolenguajeprogPK = proyectolenguajeprogPK;
    }

    public Proyectolenguajeprog(int codigo, String lenguajeprog) {
        this.proyectolenguajeprogPK = new ProyectolenguajeprogPK(codigo, lenguajeprog);
    }

    public ProyectolenguajeprogPK getProyectolenguajeprogPK() {
        return proyectolenguajeprogPK;
    }

    public void setProyectolenguajeprogPK(ProyectolenguajeprogPK proyectolenguajeprogPK) {
        this.proyectolenguajeprogPK = proyectolenguajeprogPK;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectolenguajeprogPK != null ? proyectolenguajeprogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectolenguajeprog)) {
            return false;
        }
        Proyectolenguajeprog other = (Proyectolenguajeprog) object;
        if ((this.proyectolenguajeprogPK == null && other.proyectolenguajeprogPK != null) || (this.proyectolenguajeprogPK != null && !this.proyectolenguajeprogPK.equals(other.proyectolenguajeprogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyectolenguajeprog[ proyectolenguajeprogPK=" + proyectolenguajeprogPK + " ]";
    }
    
}
