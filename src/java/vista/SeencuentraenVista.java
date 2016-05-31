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
import logica.FaseLogicaLocal;
import logica.ProyectoLogicaLocal;
import logica.SeencuentraenLogicaLocal;
import modelo.Fase;
import modelo.Proyecto;
import modelo.Seencuentraen;
import modelo.SeencuentraenPK;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author crisd
 */
@Named(value = "seencuentraenVista")
@RequestScoped
public class SeencuentraenVista {

    private SelectOneMenu cmbProyectos;
    private ArrayList<SelectItem> itemsProyectos;    
    
    private SelectOneMenu cmbFases;
    private ArrayList<SelectItem> itemsFases;
    
    private Date txtFechaInicio;
    private Date txtFechaFin;
    
    private List<Seencuentraen> listaDesarrollos;
    private Seencuentraen selectedDesarrollo;

    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;    

    @EJB
    SeencuentraenLogicaLocal desarrolloLogica;
    
    @EJB
    ProyectoLogicaLocal proyectoLogica;    

    @EJB
    FaseLogicaLocal faseLogica;

    public SelectOneMenu getCmbProyectos() {
        return cmbProyectos;
    }

    public void setCmbProyectos(SelectOneMenu cmbProyectos) {
        this.cmbProyectos = cmbProyectos;
    }

    public ArrayList<SelectItem> getItemsProyectos() {
        try {
            List<Proyecto> listaProyectos = proyectoLogica.consultarTodos();
            itemsProyectos = new ArrayList<>();
            
            for(Proyecto proyecto : listaProyectos){
                itemsProyectos.add(new SelectItem(proyecto.getCodigo(), proyecto.getNombre()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SeencuentraenVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemsProyectos;
    }

    public void setItemsProyectos(ArrayList<SelectItem> itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

    public SelectOneMenu getCmbFases() {
        return cmbFases;
    }

    public void setCmbFases(SelectOneMenu cmbFases) {
        this.cmbFases = cmbFases;
    }

    public ArrayList<SelectItem> getItemsFases() {
        try {
            List<Fase> listaFases = faseLogica.consultarFases();
            itemsFases = new ArrayList<>();
            
            for(Fase fase: listaFases){
                itemsFases.add(new SelectItem(fase.getCodigo(), fase.getNombre()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SeencuentraenVista.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return itemsFases;
    }

    public void setItemsFases(ArrayList<SelectItem> itemsFases) {
        this.itemsFases = itemsFases;
    }

    public Date getTxtFechaInicio() {
        return txtFechaInicio;
    }

    public void setTxtFechaInicio(Date txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public Date getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(Date txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public List<Seencuentraen> getListaDesarrollos() {
        if(listaDesarrollos == null){
            try {
                listaDesarrollos = desarrolloLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(SeencuentraenVista.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
        return listaDesarrollos;
    }

    public void setListaDesarrollos(List<Seencuentraen> listaDesarrollos) {
        this.listaDesarrollos = listaDesarrollos;
    }

    public Seencuentraen getSelectedDesarrollo() {
        return selectedDesarrollo;
    }

    public void setSelectedDesarrollo(Seencuentraen selectedDesarrollo) {
        this.selectedDesarrollo = selectedDesarrollo;
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
        this.selectedDesarrollo = (Seencuentraen) event.getObject();
        
        this.cmbProyectos.setValue(this.selectedDesarrollo.getProyecto1().getCodigo());
        this.cmbFases.setValue(this.selectedDesarrollo.getFase1().getCodigo());
        this.txtFechaInicio = this.selectedDesarrollo.getFechainicio();
        this.txtFechaFin = this.selectedDesarrollo.getFechafin();
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.cmbProyectos.setDisabled(true);
        this.cmbFases.setDisabled(true);        
    }
    
    public void limpiar(){
        this.cmbProyectos.setValue("");
        this.cmbFases.setValue("");
        this.txtFechaInicio = null;
        this.txtFechaFin = null;        
        
        this.cmbProyectos.setDisabled(false);
        this.cmbFases.setDisabled(false);        
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try {            
            Proyecto objProyecto = new Proyecto();
            try{ objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            Fase objFase = new Fase();
            try{ objFase.setCodigo(Integer.parseInt(this.cmbFases.getValue().toString())); } catch(Exception ex){}            
            
            Seencuentraen objDesarrollo = new Seencuentraen();
            try{ 
                SeencuentraenPK objDesarrolloPK = new SeencuentraenPK(objProyecto.getCodigo(), objFase.getCodigo());
                objDesarrollo.setSeencuentraenPK(objDesarrolloPK);
            }
            catch(Exception ex){}

            objDesarrollo.setFase1(objFase);
            objDesarrollo.setProyecto1(objProyecto);
            objDesarrollo.setFechainicio(txtFechaInicio);
            objDesarrollo.setFechafin(txtFechaFin);
            
            desarrolloLogica.registrarDesarrollo(objDesarrollo);
            listaDesarrollos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Desarrollo", "El Desarrollo fue registrado con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_modificar(){
        try {            
            Proyecto objProyecto = new Proyecto();
            try{ objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            Fase objFase = new Fase();
            try{ objFase.setCodigo(Integer.parseInt(this.cmbFases.getValue().toString())); } catch(Exception ex){}            
            
            Seencuentraen objDesarrollo = new Seencuentraen();
            try{ 
                SeencuentraenPK objDesarrolloPK = new SeencuentraenPK(objProyecto.getCodigo(), objFase.getCodigo());
                objDesarrollo.setSeencuentraenPK(objDesarrolloPK);
            }
            catch(Exception ex){}

            objDesarrollo.setFase1(objFase);
            objDesarrollo.setProyecto1(objProyecto);
            objDesarrollo.setFechainicio(txtFechaInicio);
            objDesarrollo.setFechafin(txtFechaFin);
            
            desarrolloLogica.modificarDesarrollo(objDesarrollo);
            listaDesarrollos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Desarrollo", "El Desarrollo fue registrado con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }

    public void action_eliminar(){
        try {            
            Proyecto objProyecto = new Proyecto();
            try{ objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            Fase objFase = new Fase();
            try{ objFase.setCodigo(Integer.parseInt(this.cmbFases.getValue().toString())); } catch(Exception ex){}            
            
            Seencuentraen objDesarrollo = new Seencuentraen();
            try{ 
                SeencuentraenPK objDesarrolloPK = new SeencuentraenPK(objProyecto.getCodigo(), objFase.getCodigo());
                objDesarrollo.setSeencuentraenPK(objDesarrolloPK);
            }
            catch(Exception ex){}

            objDesarrollo.setFase1(objFase);
            objDesarrollo.setProyecto1(objProyecto);
            objDesarrollo.setFechainicio(txtFechaInicio);
            objDesarrollo.setFechafin(txtFechaFin);
            
            desarrolloLogica.eliminarDesarrollo(objDesarrollo);
            listaDesarrollos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Desarrollo", "El Desarrollo fue registrado con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    /**
     * Creates a new instance of SeencuentraenVista
     */
    public SeencuentraenVista() {
    }
    
}
