/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author crisd
 */
@Entity
@Table(name = "requisito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisito.findAll", query = "SELECT r FROM Requisito r"),
    @NamedQuery(name = "Requisito.findByCodigo", query = "SELECT r FROM Requisito r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Requisito.findByDescripcion", query = "SELECT r FROM Requisito r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Requisito.findByTipo", query = "SELECT r FROM Requisito r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Requisito.findByEstado", query = "SELECT r FROM Requisito r WHERE r.estado = :estado")})
public class Requisito implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisito")
    private List<Requisitohistorial> requisitohistorialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisito")
    private List<Solicitud> solicitudList;
    @JoinColumn(name = "proyecto", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Proyecto proyecto;

    public Requisito() {
    }

    public Requisito(Integer codigo) {
        this.codigo = codigo;
    }

    public Requisito(Integer codigo, String descripcion, String tipo, String estado) {
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

    @XmlTransient
    public List<Requisitohistorial> getRequisitohistorialList() {
        return requisitohistorialList;
    }

    public void setRequisitohistorialList(List<Requisitohistorial> requisitohistorialList) {
        this.requisitohistorialList = requisitohistorialList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisito)) {
            return false;
        }
        Requisito other = (Requisito) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Requisito[ codigo=" + codigo + " ]";
    }
    
}
