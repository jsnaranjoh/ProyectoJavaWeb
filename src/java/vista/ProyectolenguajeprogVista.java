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
import logica.ProyectolenguajeprogLogicaLocal;
import modelo.Proyecto;
import modelo.Proyectolenguajeprog;
import modelo.ProyectolenguajeprogPK;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author crisd
 */
@Named(value = "proyectolenguajeprogVista")
@RequestScoped
public class ProyectolenguajeprogVista {

    private SelectOneMenu cmbProyectos;
    private ArrayList<SelectItem> itemsProyectos;
    private InputText txtLengProg;
    
    private List<Proyectolenguajeprog> listaProyectolenguajeprogs;
    private Proyectolenguajeprog selectedProyectolenguajeprog;
    
    private CommandButton btnRegistrar;
    //private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;    

    @EJB
    private ProyectoLogicaLocal proyectoLogica;
    
    @EJB
    private ProyectolenguajeprogLogicaLocal lenguajeprogLogica;    
    
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
            Logger.getLogger(ProyectolenguajeprogVista.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return itemsProyectos;
    }

    public void setItemsProyectos(ArrayList<SelectItem> itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

    public InputText getTxtLengProg() {
        return txtLengProg;
    }

    public void setTxtLengProg(InputText txtLengProg) {
        this.txtLengProg = txtLengProg;
    }

    public List<Proyectolenguajeprog> getListaProyectolenguajeprogs() {
        if(listaProyectolenguajeprogs == null){
            try {
                listaProyectolenguajeprogs = lenguajeprogLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(ProyectolenguajeprogVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaProyectolenguajeprogs;
    }

    public void setListaProyectolenguajeprogs(List<Proyectolenguajeprog> listaProyectolenguajeprogs) {
        this.listaProyectolenguajeprogs = listaProyectolenguajeprogs;
    }

    public Proyectolenguajeprog getSelectedProyectolenguajeprog() {
        return selectedProyectolenguajeprog;
    }

    public void setSelectedProyectolenguajeprog(Proyectolenguajeprog selectedProyectolenguajeprog) {
        this.selectedProyectolenguajeprog = selectedProyectolenguajeprog;
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
        this.selectedProyectolenguajeprog = (Proyectolenguajeprog) event.getObject();
        this.cmbProyectos.setValue(this.selectedProyectolenguajeprog.getProyecto().getCodigo());
        this.txtLengProg.setValue(this.selectedProyectolenguajeprog.getProyectolenguajeprogPK().getLenguajeprog());
        
        this.btnRegistrar.setDisabled(true);
        //this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbProyectos.setValue("");
        this.txtLengProg.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        //this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }    

    public void action_registrar(){
        try {
            Proyecto objProyecto = new Proyecto();            
            try { objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            ProyectolenguajeprogPK objLengProgPK = new ProyectolenguajeprogPK(objProyecto.getCodigo(), this.txtLengProg.getValue().toString());
            
            Proyectolenguajeprog objLengProg = new Proyectolenguajeprog();
            objLengProg.setProyectolenguajeprogPK(objLengProgPK);
            objLengProg.setProyecto(objProyecto);
            
            lenguajeprogLogica.registrarLenguajeprog(objLengProg);
            listaProyectolenguajeprogs = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Lenguaje de Programación realizado en el Proyecto.", 
                    "Lenguaje de Programación registrado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }    

    public void action_eliminar(){
        try {
            Proyecto objProyecto = new Proyecto();            
            try { objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            ProyectolenguajeprogPK objLengProgPK = new ProyectolenguajeprogPK(objProyecto.getCodigo(), this.txtLengProg.getValue().toString());
            
            Proyectolenguajeprog objLengProg = new Proyectolenguajeprog();
            objLengProg.setProyectolenguajeprogPK(objLengProgPK);
            objLengProg.setProyecto(objProyecto);
            
            lenguajeprogLogica.eliminarLenguajeprog(objLengProg);
            listaProyectolenguajeprogs = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Lenguaje de Programación realizado en el Proyecto.", 
                    "Lenguaje de Programación eliminado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }
    
    /**
     * Creates a new instance of ProyectolenguajeprogVista
     */
    public ProyectolenguajeprogVista() {
    }
    
}
