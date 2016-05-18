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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NOREÑA
 */
@Entity
@Table(name = "ingsoftware")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingsoftware.findAll", query = "SELECT i FROM Ingsoftware i"),
    @NamedQuery(name = "Ingsoftware.findByCedula", query = "SELECT i FROM Ingsoftware i WHERE i.cedula = :cedula"),
    @NamedQuery(name = "Ingsoftware.findByNombres", query = "SELECT i FROM Ingsoftware i WHERE i.nombres = :nombres"),
    @NamedQuery(name = "Ingsoftware.findByApellidos", query = "SELECT i FROM Ingsoftware i WHERE i.apellidos = :apellidos"),
    @NamedQuery(name = "Ingsoftware.findByEdad", query = "SELECT i FROM Ingsoftware i WHERE i.edad = :edad"),
    @NamedQuery(name = "Ingsoftware.findBySexo", query = "SELECT i FROM Ingsoftware i WHERE i.sexo = :sexo"),
    @NamedQuery(name = "Ingsoftware.findByFechanacimiento", query = "SELECT i FROM Ingsoftware i WHERE i.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Ingsoftware.findByEmail", query = "SELECT i FROM Ingsoftware i WHERE i.email = :email"),
    @NamedQuery(name = "Ingsoftware.findByTelefono", query = "SELECT i FROM Ingsoftware i WHERE i.telefono = :telefono"),
    @NamedQuery(name = "Ingsoftware.findByCelular", query = "SELECT i FROM Ingsoftware i WHERE i.celular = :celular"),
    @NamedQuery(name = "Ingsoftware.findByDireccion", query = "SELECT i FROM Ingsoftware i WHERE i.direccion = :direccion"),
    @NamedQuery(name = "Ingsoftware.findByFechaingreso", query = "SELECT i FROM Ingsoftware i WHERE i.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "Ingsoftware.findByAntiguedad", query = "SELECT i FROM Ingsoftware i WHERE i.antiguedad = :antiguedad"),
    @NamedQuery(name = "Ingsoftware.findByClave", query = "SELECT i FROM Ingsoftware i WHERE i.clave = :clave")})
public class Ingsoftware implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Integer cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "celular")
    private int celular;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "antiguedad")
    private int antiguedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "clave")
    private String clave;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingsoftware")
    private List<Ingsoftwaresistemaoperativo> ingsoftwaresistemaoperativoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingsoftware")
    private List<Ingsoftwarelenguajeprog> ingsoftwarelenguajeprogList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingsoftware")
    private List<Ingsoftwaresgbd> ingsoftwaresgbdList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ingsoftware")
    private Jefe jefe;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ingsoftware")
    private Junior junior;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ingsoftware")
    private Senior senior;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingeniero")
    private List<Seminario> seminarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitante")
    private List<Solicitud> solicitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingeniero")
    private List<Gradoacademico> gradoacademicoList;

    public Ingsoftware() {
    }

    public Ingsoftware(Integer cedula) {
        this.cedula = cedula;
    }

    public Ingsoftware(Integer cedula, String nombres, String apellidos, int edad, String sexo, Date fechanacimiento, String email, int telefono, int celular, String direccion, Date fechaingreso, int antiguedad, String clave) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.fechaingreso = fechaingreso;
        this.antiguedad = antiguedad;
        this.clave = clave;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @XmlTransient
    public List<Ingsoftwaresistemaoperativo> getIngsoftwaresistemaoperativoList() {
        return ingsoftwaresistemaoperativoList;
    }

    public void setIngsoftwaresistemaoperativoList(List<Ingsoftwaresistemaoperativo> ingsoftwaresistemaoperativoList) {
        this.ingsoftwaresistemaoperativoList = ingsoftwaresistemaoperativoList;
    }

    @XmlTransient
    public List<Ingsoftwarelenguajeprog> getIngsoftwarelenguajeprogList() {
        return ingsoftwarelenguajeprogList;
    }

    public void setIngsoftwarelenguajeprogList(List<Ingsoftwarelenguajeprog> ingsoftwarelenguajeprogList) {
        this.ingsoftwarelenguajeprogList = ingsoftwarelenguajeprogList;
    }

    @XmlTransient
    public List<Ingsoftwaresgbd> getIngsoftwaresgbdList() {
        return ingsoftwaresgbdList;
    }

    public void setIngsoftwaresgbdList(List<Ingsoftwaresgbd> ingsoftwaresgbdList) {
        this.ingsoftwaresgbdList = ingsoftwaresgbdList;
    }

    public Jefe getJefe() {
        return jefe;
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe;
    }

    public Junior getJunior() {
        return junior;
    }

    public void setJunior(Junior junior) {
        this.junior = junior;
    }

    public Senior getSenior() {
        return senior;
    }

    public void setSenior(Senior senior) {
        this.senior = senior;
    }

    @XmlTransient
    public List<Seminario> getSeminarioList() {
        return seminarioList;
    }

    public void setSeminarioList(List<Seminario> seminarioList) {
        this.seminarioList = seminarioList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @XmlTransient
    public List<Gradoacademico> getGradoacademicoList() {
        return gradoacademicoList;
    }

    public void setGradoacademicoList(List<Gradoacademico> gradoacademicoList) {
        this.gradoacademicoList = gradoacademicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingsoftware)) {
            return false;
        }
        Ingsoftware other = (Ingsoftware) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ingsoftware[ cedula=" + cedula + " ]";
    }
    
}
