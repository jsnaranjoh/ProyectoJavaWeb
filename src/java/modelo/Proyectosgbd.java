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
 * @author crisd
 */
@Entity
@Table(name = "proyectosgbd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectosgbd.findAll", query = "SELECT p FROM Proyectosgbd p"),
    @NamedQuery(name = "Proyectosgbd.findByCodigo", query = "SELECT p FROM Proyectosgbd p WHERE p.proyectosgbdPK.codigo = :codigo"),
    @NamedQuery(name = "Proyectosgbd.findBySgbd", query = "SELECT p FROM Proyectosgbd p WHERE p.proyectosgbdPK.sgbd = :sgbd")})
public class Proyectosgbd implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectosgbdPK proyectosgbdPK;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public Proyectosgbd() {
    }

    public Proyectosgbd(ProyectosgbdPK proyectosgbdPK) {
        this.proyectosgbdPK = proyectosgbdPK;
    }

    public Proyectosgbd(int codigo, String sgbd) {
        this.proyectosgbdPK = new ProyectosgbdPK(codigo, sgbd);
    }

    public ProyectosgbdPK getProyectosgbdPK() {
        return proyectosgbdPK;
    }

    public void setProyectosgbdPK(ProyectosgbdPK proyectosgbdPK) {
        this.proyectosgbdPK = proyectosgbdPK;
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
        hash += (proyectosgbdPK != null ? proyectosgbdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectosgbd)) {
            return false;
        }
        Proyectosgbd other = (Proyectosgbd) object;
        if ((this.proyectosgbdPK == null && other.proyectosgbdPK != null) || (this.proyectosgbdPK != null && !this.proyectosgbdPK.equals(other.proyectosgbdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyectosgbd[ proyectosgbdPK=" + proyectosgbdPK + " ]";
    }
    
}
