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
@Table(name = "proyectosistemaoperativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectosistemaoperativo.findAll", query = "SELECT p FROM Proyectosistemaoperativo p"),
    @NamedQuery(name = "Proyectosistemaoperativo.findByCodigo", query = "SELECT p FROM Proyectosistemaoperativo p WHERE p.proyectosistemaoperativoPK.codigo = :codigo"),
    @NamedQuery(name = "Proyectosistemaoperativo.findBySistemaoperativo", query = "SELECT p FROM Proyectosistemaoperativo p WHERE p.proyectosistemaoperativoPK.sistemaoperativo = :sistemaoperativo")})
public class Proyectosistemaoperativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectosistemaoperativoPK proyectosistemaoperativoPK;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public Proyectosistemaoperativo() {
    }

    public Proyectosistemaoperativo(ProyectosistemaoperativoPK proyectosistemaoperativoPK) {
        this.proyectosistemaoperativoPK = proyectosistemaoperativoPK;
    }

    public Proyectosistemaoperativo(int codigo, String sistemaoperativo) {
        this.proyectosistemaoperativoPK = new ProyectosistemaoperativoPK(codigo, sistemaoperativo);
    }

    public ProyectosistemaoperativoPK getProyectosistemaoperativoPK() {
        return proyectosistemaoperativoPK;
    }

    public void setProyectosistemaoperativoPK(ProyectosistemaoperativoPK proyectosistemaoperativoPK) {
        this.proyectosistemaoperativoPK = proyectosistemaoperativoPK;
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
        hash += (proyectosistemaoperativoPK != null ? proyectosistemaoperativoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectosistemaoperativo)) {
            return false;
        }
        Proyectosistemaoperativo other = (Proyectosistemaoperativo) object;
        if ((this.proyectosistemaoperativoPK == null && other.proyectosistemaoperativoPK != null) || (this.proyectosistemaoperativoPK != null && !this.proyectosistemaoperativoPK.equals(other.proyectosistemaoperativoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyectosistemaoperativo[ proyectosistemaoperativoPK=" + proyectosistemaoperativoPK + " ]";
    }
    
}
