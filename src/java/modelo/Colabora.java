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
 * @author jsnar
 */
@Entity
@Table(name = "colabora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colabora.findAll", query = "SELECT c FROM Colabora c"),
    @NamedQuery(name = "Colabora.findByJunior", query = "SELECT c FROM Colabora c WHERE c.colaboraPK.junior = :junior"),
    @NamedQuery(name = "Colabora.findByProyecto", query = "SELECT c FROM Colabora c WHERE c.colaboraPK.proyecto = :proyecto"),
    @NamedQuery(name = "Colabora.findByHorasdedicadas", query = "SELECT c FROM Colabora c WHERE c.horasdedicadas = :horasdedicadas"),
    @NamedQuery(name = "Colabora.findByFechainicio", query = "SELECT c FROM Colabora c WHERE c.fechainicio = :fechainicio"),
    @NamedQuery(name = "Colabora.findByFechafin", query = "SELECT c FROM Colabora c WHERE c.fechafin = :fechafin")})
public class Colabora implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ColaboraPK colaboraPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horasdedicadas")
    private int horasdedicadas;
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
    @JoinColumn(name = "junior", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Junior junior1;
    @JoinColumn(name = "proyecto", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto1;

    public Colabora() {
    }

    public Colabora(ColaboraPK colaboraPK) {
        this.colaboraPK = colaboraPK;
    }

    public Colabora(ColaboraPK colaboraPK, int horasdedicadas, Date fechainicio, Date fechafin) {
        this.colaboraPK = colaboraPK;
        this.horasdedicadas = horasdedicadas;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Colabora(int junior, int proyecto) {
        this.colaboraPK = new ColaboraPK(junior, proyecto);
    }

    public ColaboraPK getColaboraPK() {
        return colaboraPK;
    }

    public void setColaboraPK(ColaboraPK colaboraPK) {
        this.colaboraPK = colaboraPK;
    }

    public int getHorasdedicadas() {
        return horasdedicadas;
    }

    public void setHorasdedicadas(int horasdedicadas) {
        this.horasdedicadas = horasdedicadas;
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

    public Junior getJunior1() {
        return junior1;
    }

    public void setJunior1(Junior junior1) {
        this.junior1 = junior1;
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
        hash += (colaboraPK != null ? colaboraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colabora)) {
            return false;
        }
        Colabora other = (Colabora) object;
        if ((this.colaboraPK == null && other.colaboraPK != null) || (this.colaboraPK != null && !this.colaboraPK.equals(other.colaboraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Colabora[ colaboraPK=" + colaboraPK + " ]";
    }
    
}
