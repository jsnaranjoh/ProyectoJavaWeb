/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.IngsoftwareLogicaLocal;
import logica.JefeLogicaLocal;
import logica.RequisitoLogicaLocal;
import logica.SolicitudLogicaLocal;
import modelo.Ingsoftware;
import modelo.Jefe;
import modelo.Requisito;
import modelo.Solicitud;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author crisd
 */
@Named(value = "solicitudVista")
@RequestScoped
public class SolicitudVista {

    private InputText txtNumero;
    
    private SelectOneMenu cmbRequisitos;
    private ArrayList<SelectItem> itemsRequisitos;
    
    private SelectOneMenu cmbVerificadores;
    private ArrayList<SelectItem> itemsVerificadores;
    
    private SelectOneMenu cmbSolicitantes;
    private ArrayList<SelectItem> itemsSolicitantes;
    
    private SelectOneMenu cmbTipos;
    private InputText txtTitulo;
    private Date txtFecha;
    private InputText txtOrigen;
    private SelectOneMenu cmbEstados;
    private InputText txtPrioridadSolicitante;
    private InputText txtPrioridadRealizacion;
    private Date txtFechaUltimaActualizacion;
    private InputText txtLanzamiento;
    private InputText txtEsfuerzo;
    private InputTextarea txtDescripcion;
    private InputTextarea txtComentarios;
 
    private Solicitud selectedSolicitud;
    private List<Solicitud> listaSolicitudes;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;    

    @EJB
    private SolicitudLogicaLocal solicitudLogica;
    
    @EJB
    private RequisitoLogicaLocal requisitoLogica;
    
    @EJB
    private JefeLogicaLocal jefeLogica;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;
    
    public InputText getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(InputText txtNumero) {
        this.txtNumero = txtNumero;
    }

    public SelectOneMenu getCmbRequisitos() {
        return cmbRequisitos;
    }

    public void setCmbRequisitos(SelectOneMenu cmbRequisitos) {
        this.cmbRequisitos = cmbRequisitos;
    }

    public ArrayList<SelectItem> getItemsRequisitos() {
        try {
            List<Requisito> listaRequisitos = requisitoLogica.consultarTodos();
            itemsRequisitos = new ArrayList<>();
            
            for(Requisito req: listaRequisitos){
                itemsRequisitos.add(new SelectItem(req.getCodigo(), req.getDescripcion()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SolicitudVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemsRequisitos;
    }

    public void setItemsRequisitos(ArrayList<SelectItem> itemsRequisitos) {
        this.itemsRequisitos = itemsRequisitos;
    }

    public SelectOneMenu getCmbVerificadores() {
        return cmbVerificadores;
    }

    public void setCmbVerificadores(SelectOneMenu cmbVerificadores) {
        this.cmbVerificadores = cmbVerificadores;
    }

    public ArrayList<SelectItem> getItemsVerificadores() {
        try {
            List<Jefe> listaVerificadores = jefeLogica.consultarTodos();
            itemsVerificadores = new ArrayList<>();
            
            for(Jefe jefe: listaVerificadores){
                itemsVerificadores.add(new SelectItem(jefe.getCedula(), jefe.getIngsoftware().getNombres() + " " + jefe.getIngsoftware().getApellidos()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SolicitudVista.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return itemsVerificadores;
    }

    public void setItemsVerificadores(ArrayList<SelectItem> itemsVerificadores) {
        this.itemsVerificadores = itemsVerificadores;
    }

    public SelectOneMenu getCmbSolicitantes() {
        return cmbSolicitantes;
    }

    public void setCmbSolicitantes(SelectOneMenu cmbSolicitantes) {
        this.cmbSolicitantes = cmbSolicitantes;
    }

    public ArrayList<SelectItem> getItemsSolicitantes() {
        try {
            List<Ingsoftware> listaSolicitantes = ingsoftwareLogica.consultarTodos();
            itemsSolicitantes = new ArrayList<>();
            
            for(Ingsoftware solicitante: listaSolicitantes){
                itemsSolicitantes.add(new SelectItem(solicitante.getCedula(), solicitante.getNombres() + " " + solicitante.getApellidos()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SolicitudVista.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return itemsSolicitantes;
    }

    public void setItemsSolicitantes(ArrayList<SelectItem> itemsSolicitantes) {
        this.itemsSolicitantes = itemsSolicitantes;
    }

    public SelectOneMenu getCmbTipos() {
        return cmbTipos;
    }

    public void setCmbTipos(SelectOneMenu cmbTipos) {
        this.cmbTipos = cmbTipos;
    }

    public InputText getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(InputText txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public Date getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(Date txtFecha) {
        this.txtFecha = txtFecha;
    }

    public InputText getTxtOrigen() {
        return txtOrigen;
    }

    public void setTxtOrigen(InputText txtOrigen) {
        this.txtOrigen = txtOrigen;
    }

    public SelectOneMenu getCmbEstados() {
        return cmbEstados;
    }

    public void setCmbEstados(SelectOneMenu cmbEstados) {
        this.cmbEstados = cmbEstados;
    }

    public InputText getTxtPrioridadSolicitante() {
        return txtPrioridadSolicitante;
    }

    public void setTxtPrioridadSolicitante(InputText txtPrioridadSolicitante) {
        this.txtPrioridadSolicitante = txtPrioridadSolicitante;
    }

    public InputText getTxtPrioridadRealizacion() {
        return txtPrioridadRealizacion;
    }

    public void setTxtPrioridadRealizacion(InputText txtPrioridadRealizacion) {
        this.txtPrioridadRealizacion = txtPrioridadRealizacion;
    }

    public Date getTxtFechaUltimaActualizacion() {
        return txtFechaUltimaActualizacion;
    }

    public void setTxtFechaUltimaActualizacion(Date txtFechaUltimaActualizacion) {
        this.txtFechaUltimaActualizacion = txtFechaUltimaActualizacion;
    }

    public InputText getTxtLanzamiento() {
        return txtLanzamiento;
    }

    public void setTxtLanzamiento(InputText txtLanzamiento) {
        this.txtLanzamiento = txtLanzamiento;
    }

    public InputText getTxtEsfuerzo() {
        return txtEsfuerzo;
    }

    public void setTxtEsfuerzo(InputText txtEsfuerzo) {
        this.txtEsfuerzo = txtEsfuerzo;
    }

    public InputTextarea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputTextarea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputTextarea getTxtComentarios() {
        return txtComentarios;
    }

    public void setTxtComentarios(InputTextarea txtComentarios) {
        this.txtComentarios = txtComentarios;
    }

    public Solicitud getSelectedSolicitud() {
        return selectedSolicitud;
    }

    public void setSelectedSolicitud(Solicitud selectedSolicitud) {
        this.selectedSolicitud = selectedSolicitud;
    }

    public List<Solicitud> getListaSolicitudes() {
        if(listaSolicitudes == null){
            try {
                listaSolicitudes = solicitudLogica.consultarTodas();
            } catch (Exception ex) {
                Logger.getLogger(SolicitudVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaSolicitudes;
    }

    public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }
    
    public void onRowSelect(SelectEvent event){
        this.selectedSolicitud = (Solicitud) event.getObject();
        
        this.txtNumero.setValue(this.selectedSolicitud.getNumero());
        this.cmbRequisitos.setValue(this.selectedSolicitud.getRequisito().getCodigo());
        this.cmbVerificadores.setValue(this.selectedSolicitud.getVerificador().getCedula());
        this.cmbSolicitantes.setValue(this.selectedSolicitud.getSolicitante().getCedula());
        this.cmbTipos.setValue(this.selectedSolicitud.getTipo());
        this.txtTitulo.setValue(this.selectedSolicitud.getTitulo());
        this.txtFecha = this.selectedSolicitud.getFecha();
        this.txtOrigen.setValue(this.selectedSolicitud.getOrigen());
        this.cmbEstados.setValue(this.selectedSolicitud.getEstado());
        this.txtPrioridadSolicitante.setValue(this.selectedSolicitud.getPrioridadsolicitante());
        this.txtPrioridadRealizacion.setValue(this.selectedSolicitud.getPrioridadrealizacion());
        this.txtFechaUltimaActualizacion = this.selectedSolicitud.getFechaultimaactualizacion();
        this.txtLanzamiento.setValue(this.selectedSolicitud.getLanzamiento());
        this.txtEsfuerzo.setValue(this.selectedSolicitud.getEsfuerzo());
        this.txtDescripcion.setValue(this.selectedSolicitud.getDescripcion());
        this.txtComentarios.setValue(this.selectedSolicitud.getComentarios());
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.txtNumero.setDisabled(true);        
    }
    
    public void limpiar(){
        this.txtNumero.setValue("");
        this.cmbRequisitos.setValue("");
        this.cmbVerificadores.setValue("");
        this.cmbSolicitantes.setValue("");
        this.cmbTipos.setValue("");
        this.txtTitulo.setValue("");
        this.txtFecha = null;
        this.txtOrigen.setValue("");
        this.cmbEstados.setValue("");
        this.txtPrioridadSolicitante.setValue("");
        this.txtPrioridadRealizacion.setValue("");
        this.txtFechaUltimaActualizacion = null;
        this.txtLanzamiento.setValue("");
        this.txtEsfuerzo.setValue("");
        this.txtDescripcion.setValue("");
        this.txtComentarios.setValue("");

        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);
        this.txtNumero.setDisabled(false);         
    }
    
    public void action_registrar(){
        try {
            Requisito objRequisito = new Requisito();
            try{ objRequisito.setCodigo(Integer.parseInt(this.cmbRequisitos.getValue().toString())); } catch(Exception ex){}
            
            Jefe objVerificador = new Jefe();
            try{ objVerificador.setCedula(Integer.parseInt(this.cmbVerificadores.getValue().toString())); } catch(Exception ex){}
            
            Ingsoftware objSolicitante = new Ingsoftware();
            try{ objSolicitante.setCedula(Integer.parseInt(this.cmbSolicitantes.getValue().toString())); } catch(Exception ex){}
            
            Solicitud objSolicitud = new Solicitud();
            try{ objSolicitud.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setRequisito(objRequisito);
            objSolicitud.setVerificador(objVerificador);
            objSolicitud.setSolicitante(objSolicitante);
            objSolicitud.setTipo(this.cmbTipos.getValue().toString());
            objSolicitud.setTitulo(this.txtTitulo.getValue().toString());
            objSolicitud.setFecha(txtFecha);
            objSolicitud.setOrigen(this.txtOrigen.getValue().toString());
            objSolicitud.setEstado(this.cmbEstados.getValue().toString());
            try{ objSolicitud.setPrioridadsolicitante(Integer.parseInt(this.txtPrioridadSolicitante.getValue().toString())); } catch(Exception ex){}
            try{ objSolicitud.setPrioridadrealizacion(Integer.parseInt(this.txtPrioridadRealizacion.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setFechaultimaactualizacion(txtFechaUltimaActualizacion);
            objSolicitud.setLanzamiento(this.txtLanzamiento.getValue().toString());
            try{ objSolicitud.setEsfuerzo(Integer.parseInt(this.txtEsfuerzo.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setDescripcion(this.txtDescripcion.getValue().toString());
            objSolicitud.setComentarios(this.txtComentarios.getValue().toString());
            
            solicitudLogica.registrarSolicitud(objSolicitud);
            listaSolicitudes = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de solicitud", "La Solicitud fue registrada con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }
    
    public void action_modificar(){
        try {
            Requisito objRequisito = new Requisito();
            try{ objRequisito.setCodigo(Integer.parseInt(this.cmbRequisitos.getValue().toString())); } catch(Exception ex){}
            
            Jefe objVerificador = new Jefe();
            try{ objVerificador.setCedula(Integer.parseInt(this.cmbVerificadores.getValue().toString())); } catch(Exception ex){}
            
            Ingsoftware objSolicitante = new Ingsoftware();
            try{ objSolicitante.setCedula(Integer.parseInt(this.cmbSolicitantes.getValue().toString())); } catch(Exception ex){}
            
            Solicitud objSolicitud = new Solicitud();
            try{ objSolicitud.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setRequisito(objRequisito);
            objSolicitud.setVerificador(objVerificador);
            objSolicitud.setSolicitante(objSolicitante);
            objSolicitud.setTipo(this.cmbTipos.getValue().toString());
            objSolicitud.setTitulo(this.txtTitulo.getValue().toString());
            objSolicitud.setFecha(txtFecha);
            objSolicitud.setOrigen(this.txtOrigen.getValue().toString());
            objSolicitud.setEstado(this.cmbEstados.getValue().toString());
            try{ objSolicitud.setPrioridadsolicitante(Integer.parseInt(this.txtPrioridadSolicitante.getValue().toString())); } catch(Exception ex){}
            try{ objSolicitud.setPrioridadrealizacion(Integer.parseInt(this.txtPrioridadRealizacion.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setFechaultimaactualizacion(txtFechaUltimaActualizacion);
            objSolicitud.setLanzamiento(this.txtLanzamiento.getValue().toString());
            try{ objSolicitud.setEsfuerzo(Integer.parseInt(this.txtEsfuerzo.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setDescripcion(this.txtDescripcion.getValue().toString());
            objSolicitud.setComentarios(this.txtComentarios.getValue().toString());
            
            solicitudLogica.modificarSolicitud(objSolicitud);
            listaSolicitudes = null;
            limpiar();            
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de solicitud", "La Solicitud fue modificada con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }

    public void action_eliminar(){
        try {
            Requisito objRequisito = new Requisito();
            try{ objRequisito.setCodigo(Integer.parseInt(this.cmbRequisitos.getValue().toString())); } catch(Exception ex){}
            
            Jefe objVerificador = new Jefe();
            try{ objVerificador.setCedula(Integer.parseInt(this.cmbVerificadores.getValue().toString())); } catch(Exception ex){}
            
            Ingsoftware objSolicitante = new Ingsoftware();
            try{ objSolicitante.setCedula(Integer.parseInt(this.cmbSolicitantes.getValue().toString())); } catch(Exception ex){}
            
            Solicitud objSolicitud = new Solicitud();
            try{ objSolicitud.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setRequisito(objRequisito);
            objSolicitud.setVerificador(objVerificador);
            objSolicitud.setSolicitante(objSolicitante);
            objSolicitud.setTipo(this.cmbTipos.getValue().toString());
            objSolicitud.setTitulo(this.txtTitulo.getValue().toString());
            objSolicitud.setFecha(txtFecha);
            objSolicitud.setOrigen(this.txtOrigen.getValue().toString());
            objSolicitud.setEstado(this.cmbEstados.getValue().toString());
            try{ objSolicitud.setPrioridadsolicitante(Integer.parseInt(this.txtPrioridadSolicitante.getValue().toString())); } catch(Exception ex){}
            try{ objSolicitud.setPrioridadrealizacion(Integer.parseInt(this.txtPrioridadRealizacion.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setFechaultimaactualizacion(txtFechaUltimaActualizacion);
            objSolicitud.setLanzamiento(this.txtLanzamiento.getValue().toString());
            try{ objSolicitud.setEsfuerzo(Integer.parseInt(this.txtEsfuerzo.getValue().toString())); } catch(Exception ex){}
            objSolicitud.setDescripcion(this.txtDescripcion.getValue().toString());
            objSolicitud.setComentarios(this.txtComentarios.getValue().toString());
            
            solicitudLogica.eliminarSolicitud(objSolicitud);
            listaSolicitudes = null;
            limpiar();            
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de solicitud", "La Solicitud fue eliminada con éxito."));              
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    /**
     * Creates a new instance of SolicitudVista
     */
    public SolicitudVista() {
    }
    
}
