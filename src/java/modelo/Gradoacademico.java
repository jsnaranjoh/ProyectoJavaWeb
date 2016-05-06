/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NOREÑA
 */
@Entity
@Table(name = "gradoacademico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gradoacademico.findAll", query = "SELECT g FROM Gradoacademico g"),
    @NamedQuery(name = "Gradoacademico.findByNumero", query = "SELECT g FROM Gradoacademico g WHERE g.numero = :numero"),
    @NamedQuery(name = "Gradoacademico.findByNivel", query = "SELECT g FROM Gradoacademico g WHERE g.nivel = :nivel"),
    @NamedQuery(name = "Gradoacademico.findByLugar", query = "SELECT g FROM Gradoacademico g WHERE g.lugar = :lugar"),
    @NamedQuery(name = "Gradoacademico.findByAniotitulacion", query = "SELECT g FROM Gradoacademico g WHERE g.aniotitulacion = :aniotitulacion"),
    @NamedQuery(name = "Gradoacademico.findByTituloobtenido", query = "SELECT g FROM Gradoacademico g WHERE g.tituloobtenido = :tituloobtenido")})
public class Gradoacademico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lugar")
    private String lugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aniotitulacion")
    private int aniotitulacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tituloobtenido")
    private String tituloobtenido;
    @JoinColumn(name = "ingeniero", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Ingsoftware ingeniero;

    public Gradoacademico() {
    }

    public Gradoacademico(Integer numero) {
        this.numero = numero;
    }

    public Gradoacademico(Integer numero, String nivel, String lugar, int aniotitulacion, String tituloobtenido) {
        this.numero = numero;
        this.nivel = nivel;
        this.lugar = lugar;
        this.aniotitulacion = aniotitulacion;
        this.tituloobtenido = tituloobtenido;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getAniotitulacion() {
        return aniotitulacion;
    }

    public void setAniotitulacion(int aniotitulacion) {
        this.aniotitulacion = aniotitulacion;
    }

    public String getTituloobtenido() {
        return tituloobtenido;
    }

    public void setTituloobtenido(String tituloobtenido) {
        this.tituloobtenido = tituloobtenido;
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
        if (!(object instanceof Gradoacademico)) {
            return false;
        }
        Gradoacademico other = (Gradoacademico) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Gradoacademico[ numero=" + numero + " ]";
    }
    
}
