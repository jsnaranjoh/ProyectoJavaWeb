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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crisd
 */
@Entity
@Table(name = "seminario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seminario.findAll", query = "SELECT s FROM Seminario s"),
    @NamedQuery(name = "Seminario.findByNumero", query = "SELECT s FROM Seminario s WHERE s.numero = :numero"),
    @NamedQuery(name = "Seminario.findByNombre", query = "SELECT s FROM Seminario s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Seminario.findByLugar", query = "SELECT s FROM Seminario s WHERE s.lugar = :lugar"),
    @NamedQuery(name = "Seminario.findByFechainicio", query = "SELECT s FROM Seminario s WHERE s.fechainicio = :fechainicio"),
    @NamedQuery(name = "Seminario.findByFechafin", query = "SELECT s FROM Seminario s WHERE s.fechafin = :fechafin")})
public class Seminario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lugar")
    private String lugar;
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
    @JoinColumn(name = "ingeniero", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Ingsoftware ingeniero;

    public Seminario() {
    }

    public Seminario(Integer numero) {
        this.numero = numero;
    }

    public Seminario(Integer numero, String nombre, String lugar, Date fechainicio, Date fechafin) {
        this.numero = numero;
        this.nombre = nombre;
        this.lugar = lugar;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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

    public Ingsoftware getIngeniero() {
        return ingeniero;
    }

    public void setIngeniero(Ingsoftware ingeniero) {
        this.ingeniero = ingeniero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seminario)) {
            return false;
        }
        Seminario other = (Seminario) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Seminario[ numero=" + numero + " ]";
    }
    
}
