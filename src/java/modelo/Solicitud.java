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
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByNumero", query = "SELECT s FROM Solicitud s WHERE s.numero = :numero"),
    @NamedQuery(name = "Solicitud.findByTipo", query = "SELECT s FROM Solicitud s WHERE s.tipo = :tipo"),
    @NamedQuery(name = "Solicitud.findByTitulo", query = "SELECT s FROM Solicitud s WHERE s.titulo = :titulo"),
    @NamedQuery(name = "Solicitud.findByFecha", query = "SELECT s FROM Solicitud s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Solicitud.findByOrigen", query = "SELECT s FROM Solicitud s WHERE s.origen = :origen"),
    @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado"),
    @NamedQuery(name = "Solicitud.findByPrioridadsolicitante", query = "SELECT s FROM Solicitud s WHERE s.prioridadsolicitante = :prioridadsolicitante"),
    @NamedQuery(name = "Solicitud.findByPrioridadrealizacion", query = "SELECT s FROM Solicitud s WHERE s.prioridadrealizacion = :prioridadrealizacion"),
    @NamedQuery(name = "Solicitud.findByFechaultimaactualizacion", query = "SELECT s FROM Solicitud s WHERE s.fechaultimaactualizacion = :fechaultimaactualizacion"),
    @NamedQuery(name = "Solicitud.findByLanzamiento", query = "SELECT s FROM Solicitud s WHERE s.lanzamiento = :lanzamiento"),
    @NamedQuery(name = "Solicitud.findByEsfuerzo", query = "SELECT s FROM Solicitud s WHERE s.esfuerzo = :esfuerzo"),
    @NamedQuery(name = "Solicitud.findByDescripcion", query = "SELECT s FROM Solicitud s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Solicitud.findByComentarios", query = "SELECT s FROM Solicitud s WHERE s.comentarios = :comentarios")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prioridadsolicitante")
    private int prioridadsolicitante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prioridadrealizacion")
    private int prioridadrealizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaultimaactualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaultimaactualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lanzamiento")
    private String lanzamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esfuerzo")
    private int esfuerzo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "solicitante", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Ingsoftware solicitante;
    @JoinColumn(name = "verificador", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Jefe verificador;
    @JoinColumn(name = "requisito", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Requisito requisito;

    public Solicitud() {
    }

    public Solicitud(Integer numero) {
        this.numero = numero;
    }

    public Solicitud(Integer numero, String tipo, String titulo, Date fecha, String estado, int prioridadsolicitante, int prioridadrealizacion, Date fechaultimaactualizacion, String lanzamiento, int esfuerzo, String descripcion) {
        this.numero = numero;
        this.tipo = tipo;
        this.titulo = titulo;
        this.fecha = fecha;
        this.estado = estado;
        this.prioridadsolicitante = prioridadsolicitante;
        this.prioridadrealizacion = prioridadrealizacion;
        this.fechaultimaactualizacion = fechaultimaactualizacion;
        this.lanzamiento = lanzamiento;
        this.esfuerzo = esfuerzo;
        this.descripcion = descripcion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrioridadsolicitante() {
        return prioridadsolicitante;
    }

    public void setPrioridadsolicitante(int prioridadsolicitante) {
        this.prioridadsolicitante = prioridadsolicitante;
    }

    public int getPrioridadrealizacion() {
        return prioridadrealizacion;
    }

    public void setPrioridadrealizacion(int prioridadrealizacion) {
        this.prioridadrealizacion = prioridadrealizacion;
    }

    public Date getFechaultimaactualizacion() {
        return fechaultimaactualizacion;
    }

    public void setFechaultimaactualizacion(Date fechaultimaactualizacion) {
        this.fechaultimaactualizacion = fechaultimaactualizacion;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public int getEsfuerzo() {
        return esfuerzo;
    }

    public void setEsfuerzo(int esfuerzo) {
        this.esfuerzo = esfuerzo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Ingsoftware getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Ingsoftware solicitante) {
        this.solicitante = solicitante;
    }

    public Jefe getVerificador() {
        return verificador;
    }

    public void setVerificador(Jefe verificador) {
        this.verificador = verificador;
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
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Solicitud[ numero=" + numero + " ]";
    }
    
}
