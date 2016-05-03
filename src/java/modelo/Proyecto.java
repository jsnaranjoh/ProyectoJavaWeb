/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsnar
 */
@Entity
@Table(name = "proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByCodigo", query = "SELECT p FROM Proyecto p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByAreaaplicacion", query = "SELECT p FROM Proyecto p WHERE p.areaaplicacion = :areaaplicacion"),
    @NamedQuery(name = "Proyecto.findByFechaingreso", query = "SELECT p FROM Proyecto p WHERE p.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "Proyecto.findByFechaasignacion", query = "SELECT p FROM Proyecto p WHERE p.fechaasignacion = :fechaasignacion"),
    @NamedQuery(name = "Proyecto.findByFechaprevistaliberacion", query = "SELECT p FROM Proyecto p WHERE p.fechaprevistaliberacion = :fechaprevistaliberacion"),
    @NamedQuery(name = "Proyecto.findByVersionprograma", query = "SELECT p FROM Proyecto p WHERE p.versionprograma = :versionprograma"),
    @NamedQuery(name = "Proyecto.findByCostototal", query = "SELECT p FROM Proyecto p WHERE p.costototal = :costototal")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "areaaplicacion")
    private String areaaplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaasignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaasignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaprevistaliberacion")
    @Temporal(TemporalType.DATE)
    private Date fechaprevistaliberacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "versionprograma")
    private String versionprograma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costototal")
    private int costototal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto1")
    private List<Colabora> colaboraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<Proyectolenguajeprog> proyectolenguajeprogList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto1")
    private List<Seencuentraen> seencuentraenList;
    @JoinColumn(name = "lider", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Senior lider;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<Proyectosistemaoperativo> proyectosistemaoperativoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<Requisito> requisitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto")
    private List<Proyectosgbd> proyectosgbdList;

    public Proyecto() {
    }

    public Proyecto(Integer codigo) {
        this.codigo = codigo;
    }

    public Proyecto(Integer codigo, String nombre, String areaaplicacion, Date fechaingreso, Date fechaasignacion, Date fechaprevistaliberacion, String versionprograma, int costototal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.areaaplicacion = areaaplicacion;
        this.fechaingreso = fechaingreso;
        this.fechaasignacion = fechaasignacion;
        this.fechaprevistaliberacion = fechaprevistaliberacion;
        this.versionprograma = versionprograma;
        this.costototal = costototal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAreaaplicacion() {
        return areaaplicacion;
    }

    public void setAreaaplicacion(String areaaplicacion) {
        this.areaaplicacion = areaaplicacion;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechaasignacion() {
        return fechaasignacion;
    }

    public void setFechaasignacion(Date fechaasignacion) {
        this.fechaasignacion = fechaasignacion;
    }

    public Date getFechaprevistaliberacion() {
        return fechaprevistaliberacion;
    }

    public void setFechaprevistaliberacion(Date fechaprevistaliberacion) {
        this.fechaprevistaliberacion = fechaprevistaliberacion;
    }

    public String getVersionprograma() {
        return versionprograma;
    }

    public void setVersionprograma(String versionprograma) {
        this.versionprograma = versionprograma;
    }

    public int getCostototal() {
        return costototal;
    }

    public void setCostototal(int costototal) {
        this.costototal = costototal;
    }

    @XmlTransient
    public List<Colabora> getColaboraList() {
        return colaboraList;
    }

    public void setColaboraList(List<Colabora> colaboraList) {
        this.colaboraList = colaboraList;
    }

    @XmlTransient
    public List<Proyectolenguajeprog> getProyectolenguajeprogList() {
        return proyectolenguajeprogList;
    }

    public void setProyectolenguajeprogList(List<Proyectolenguajeprog> proyectolenguajeprogList) {
        this.proyectolenguajeprogList = proyectolenguajeprogList;
    }

    @XmlTransient
    public List<Seencuentraen> getSeencuentraenList() {
        return seencuentraenList;
    }

    public void setSeencuentraenList(List<Seencuentraen> seencuentraenList) {
        this.seencuentraenList = seencuentraenList;
    }

    public Senior getLider() {
        return lider;
    }

    public void setLider(Senior lider) {
        this.lider = lider;
    }

    @XmlTransient
    public List<Proyectosistemaoperativo> getProyectosistemaoperativoList() {
        return proyectosistemaoperativoList;
    }

    public void setProyectosistemaoperativoList(List<Proyectosistemaoperativo> proyectosistemaoperativoList) {
        this.proyectosistemaoperativoList = proyectosistemaoperativoList;
    }

    @XmlTransient
    public List<Requisito> getRequisitoList() {
        return requisitoList;
    }

    public void setRequisitoList(List<Requisito> requisitoList) {
        this.requisitoList = requisitoList;
    }

    @XmlTransient
    public List<Proyectosgbd> getProyectosgbdList() {
        return proyectosgbdList;
    }

    public void setProyectosgbdList(List<Proyectosgbd> proyectosgbdList) {
        this.proyectosgbdList = proyectosgbdList;
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
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyecto[ codigo=" + codigo + " ]";
    }
    
}
