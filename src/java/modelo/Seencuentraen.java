/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crisd
 */
@Entity
@Table(name = "seencuentraen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seencuentraen.findAll", query = "SELECT s FROM Seencuentraen s"),
    @NamedQuery(name = "Seencuentraen.findByProyecto", query = "SELECT s FROM Seencuentraen s WHERE s.seencuentraenPK.proyecto = :proyecto"),
    @NamedQuery(name = "Seencuentraen.findByFase", query = "SELECT s FROM Seencuentraen s WHERE s.seencuentraenPK.fase = :fase"),
    @NamedQuery(name = "Seencuentraen.findByFechainicio", query = "SELECT s FROM Seencuentraen s WHERE s.fechainicio = :fechainicio"),
    @NamedQuery(name = "Seencuentraen.findByFechafin", query = "SELECT s FROM Seencuentraen s WHERE s.fechafin = :fechafin")})
public class Seencuentraen implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeencuentraenPK seencuentraenPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafin")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @JoinColumn(name = "fase", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fase fase1;
    @JoinColumn(name = "proyecto", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto1;

    public Seencuentraen() {
    }

    public Seencuentraen(SeencuentraenPK seencuentraenPK) {
        this.seencuentraenPK = seencuentraenPK;
    }

    public Seencuentraen(SeencuentraenPK seencuentraenPK, Date fechainicio, Date fechafin) {
        this.seencuentraenPK = seencuentraenPK;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Seencuentraen(int proyecto, int fase) {
        this.seencuentraenPK = new SeencuentraenPK(proyecto, fase);
    }

    public SeencuentraenPK getSeencuentraenPK() {
        return seencuentraenPK;
    }

    public void setSeencuentraenPK(SeencuentraenPK seencuentraenPK) {
        this.seencuentraenPK = seencuentraenPK;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Fase getFase1() {
        return fase1;
    }

    public void setFase1(Fase fase1) {
        this.fase1 = fase1;
    }

    public Proyecto getProyecto1() {
        return proyecto1;
    }

    public void setProyecto1(Proyecto proyecto1) {
        this.proyecto1 = proyecto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seencuentraenPK != null ? seencuentraenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seencuentraen)) {
            return false;
        }
        Seencuentraen other = (Seencuentraen) object;
        if ((this.seencuentraenPK == null && other.seencuentraenPK != null) || (this.seencuentraenPK != null && !this.seencuentraenPK.equals(other.seencuentraenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Seencuentraen[ seencuentraenPK=" + seencuentraenPK + " ]";
    }
    
}
