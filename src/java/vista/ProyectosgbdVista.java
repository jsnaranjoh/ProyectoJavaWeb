/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.ProyectoLogicaLocal;
import logica.ProyectosgbdLogicaLocal;
import modelo.Proyecto;
import modelo.Proyectosgbd;
import modelo.ProyectosgbdPK;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author crisd
 */
@Named(value = "proyectosgbdVista")
@RequestScoped
public class ProyectosgbdVista {
    
    private SelectOneMenu cmbProyectos;
    private ArrayList<SelectItem> itemsProyectos;
    private InputText txtSGBD;
    
    private List<Proyectosgbd> listaProyectoSGBDs;
    private Proyectosgbd selectedProyectosgbd;
    
    private CommandButton btnRegistrar;
    //private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;    

    @EJB
    private ProyectoLogicaLocal proyectoLogica;
    
    @EJB
    private ProyectosgbdLogicaLocal sgbdLogica;    
    
    public SelectOneMenu getCmbProyectos() {
        return cmbProyectos;
    }

    public void setCmbProyectos(SelectOneMenu cmbProyectos) {
        this.cmbProyectos = cmbProyectos;
    }

    public ArrayList<SelectItem> getItemsProyectos() {
        try {
            List<Proyecto> listaProy = proyectoLogica.consultarTodos();
            itemsProyectos = new ArrayList<>();
            
            for(Proyecto proy: listaProy){
                itemsProyectos.add(new SelectItem(proy.getCodigo(), proy.getNombre()));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProyectosgbdVista.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return itemsProyectos;
    }

    public void setItemsProyectos(ArrayList<SelectItem> itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

    public InputText getTxtSGBD() {
        return txtSGBD;
    }

    public void setTxtSGBD(InputText txtSGBD) {
        this.txtSGBD = txtSGBD;
    }

    public List<Proyectosgbd> getListaProyectoSGBDs() {
        if(listaProyectoSGBDs == null){
            try {
                listaProyectoSGBDs = sgbdLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(ProyectosgbdVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaProyectoSGBDs;
    }

    public void setListaProyectoSGBDs(List<Proyectosgbd> listaProyectoSGBDs) {
        this.listaProyectoSGBDs = listaProyectoSGBDs;
    }

    public Proyectosgbd getSelectedProyectosgbd() {
        return selectedProyectosgbd;
    }

    public void setSelectedProyectosgbd(Proyectosgbd selectedProyectosgbd) {
        this.selectedProyectosgbd = selectedProyectosgbd;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
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
        this.selectedProyectosgbd = (Proyectosgbd) event.getObject();
        this.cmbProyectos.setValue(this.selectedProyectosgbd.getProyecto().getCodigo());
        this.txtSGBD.setValue(this.selectedProyectosgbd.getProyectosgbdPK().getSgbd());
        
        this.btnRegistrar.setDisabled(true);
        //this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbProyectos.setValue("");
        this.txtSGBD.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        //this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }    

    public void action_registrar(){
        try {
            Proyecto objProyecto = new Proyecto();            
            try { objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            ProyectosgbdPK objSGBDPK = new ProyectosgbdPK(objProyecto.getCodigo(), this.txtSGBD.getValue().toString());
            
            Proyectosgbd objSGBD = new Proyectosgbd();
            objSGBD.setProyectosgbdPK(objSGBDPK);
            objSGBD.setProyecto(objProyecto);
            
            sgbdLogica.registrarSGBD(objSGBD);
            listaProyectoSGBDs = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Sistema Gestor de Bases de Datos realizado en el Proyecto.", 
                    "SGBD registrado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }    

    public void action_eliminar(){
        try {
            Proyecto objProyecto = new Proyecto();            
            try { objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            ProyectosgbdPK objSGBDPK = new ProyectosgbdPK(objProyecto.getCodigo(), this.txtSGBD.getValue().toString());
            
            Proyectosgbd objSGBD = new Proyectosgbd();
            objSGBD.setProyectosgbdPK(objSGBDPK);
            objSGBD.setProyecto(objProyecto);
            
            sgbdLogica.eliminarSGBD(objSGBD);
            listaProyectoSGBDs = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Sistema Gestor de Bases de Datos realizado en el Proyecto.", 
                    "SGBD eliminado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }
    /**
     * Creates a new instance of ProyectosgbdVista
     */
    public ProyectosgbdVista() {
    }
    
}
