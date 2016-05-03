/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author jsnar
 */
@Entity
@Table(name = "gradoacademico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gradoacademico.findAll", query = "SELECT g FROM Gradoacademico g"),
    @NamedQuery(name = "Gradoacademico.findByNumero", query = "SELECT g FROM Gradoacademico g WHERE g.gradoacademicoPK.numero = :numero"),
    @NamedQuery(name = "Gradoacademico.findByIngeniero", query = "SELECT g FROM Gradoacademico g WHERE g.gradoacademicoPK.ingeniero = :ingeniero"),
    @NamedQuery(name = "Gradoacademico.findByNivel", query = "SELECT g FROM Gradoacademico g WHERE g.nivel = :nivel"),
    @NamedQuery(name = "Gradoacademico.findByLugar", query = "SELECT g FROM Gradoacademico g WHERE g.lugar = :lugar"),
    @NamedQuery(name = "Gradoacademico.findByAniotitulacion", query = "SELECT g FROM Gradoacademico g WHERE g.aniotitulacion = :aniotitulacion"),
    @NamedQuery(name = "Gradoacademico.findByTituloobtenido", query = "SELECT g FROM Gradoacademico g WHERE g.tituloobtenido = :tituloobtenido")})
public class Gradoacademico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GradoacademicoPK gradoacademicoPK;
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
    @JoinColumn(name = "ingeniero", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingsoftware ingsoftware;

    public Gradoacademico() {
    }

    public Gradoacademico(GradoacademicoPK gradoacademicoPK) {
        this.gradoacademicoPK = gradoacademicoPK;
    }

    public Gradoacademico(GradoacademicoPK gradoacademicoPK, String nivel, String lugar, int aniotitulacion, String tituloobtenido) {
        this.gradoacademicoPK = gradoacademicoPK;
        this.nivel = nivel;
        this.lugar = lugar;
        this.aniotitulacion = aniotitulacion;
        this.tituloobtenido = tituloobtenido;
    }

    public Gradoacademico(int numero, int ingeniero) {
        this.gradoacademicoPK = new GradoacademicoPK(numero, ingeniero);
    }

    public GradoacademicoPK getGradoacademicoPK() {
        return gradoacademicoPK;
    }

    public void setGradoacademicoPK(GradoacademicoPK gradoacademicoPK) {
        this.gradoacademicoPK = gradoacademicoPK;
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

    public Ingsoftware getIngsoftware() {
        return ingsoftware;
    }

    public void setIngsoftware(Ingsoftware ingsoftware) {
        this.ingsoftware = ingsoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gradoacademicoPK != null ? gradoacademicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gradoacademico)) {
            return false;
        }
        Gradoacademico other = (Gradoacademico) object;
        if ((this.gradoacademicoPK == null && other.gradoacademicoPK != null) || (this.gradoacademicoPK != null && !this.gradoacademicoPK.equals(other.gradoacademicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Gradoacademico[ gradoacademicoPK=" + gradoacademicoPK + " ]";
    }
    
}
