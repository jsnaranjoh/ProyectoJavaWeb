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
 * @author jsnar
 */
@Entity
@Table(name = "requisitohistorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisitohistorial.findAll", query = "SELECT r FROM Requisitohistorial r"),
    @NamedQuery(name = "Requisitohistorial.findByCodigo", query = "SELECT r FROM Requisitohistorial r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Requisitohistorial.findByDescripcion", query = "SELECT r FROM Requisitohistorial r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Requisitohistorial.findByTipo", query = "SELECT r FROM Requisitohistorial r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Requisitohistorial.findByEstado", query = "SELECT r FROM Requisitohistorial r WHERE r.estado = :estado")})
public class Requisitohistorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "requisito", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Requisito requisito;

    public Requisitohistorial() {
    }

    public Requisitohistorial(Integer codigo) {
        this.codigo = codigo;
    }

    public Requisitohistorial(Integer codigo, String descripcion, String tipo, String estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Requisito getRequisito() {
        return requisito;
    }

    public void setRequisito(Requisito requisito) {
        this.requisito = requisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisitohistorial)) {
            return false;
        }
        Requisitohistorial other = (Requisitohistorial) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Requisitohistorial[ codigo=" + codigo + " ]";
    }
    
}
