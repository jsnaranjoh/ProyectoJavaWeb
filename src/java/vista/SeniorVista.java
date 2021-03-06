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
import logica.IngsoftwareLogicaLocal;
import logica.SeniorLogicaLocal;
import modelo.Ingsoftware;
import modelo.Senior;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "seniorVista")
@RequestScoped
public class SeniorVista {

    private SelectOneMenu cmbIngSoftware;
    private ArrayList<SelectItem> itemsIngsoftware;
    private InputText txtProyectosquelidera;
    
    private List<Senior> listaSeniors;
    private Senior selectedSenior;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;
    
    @EJB
    private SeniorLogicaLocal seniorLogica;

    public SelectOneMenu getCmbIngSoftware() {
        return cmbIngSoftware;
    }

    public void setCmbIngSoftware(SelectOneMenu cmbIngSoftware) {
        this.cmbIngSoftware = cmbIngSoftware;
    }

    public ArrayList<SelectItem> getItemsIngsoftware() {
        try {
            List<Ingsoftware> listaIng = ingsoftwareLogica.consultarTodos();
            itemsIngsoftware = new ArrayList<>();
            
            for(Ingsoftware ing: listaIng){
                itemsIngsoftware.add(new SelectItem(ing.getCedula(), ing.getNombres() + " " + ing.getApellidos()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SeniorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsIngsoftware;
    }

    public void setItemsIngsoftware(ArrayList<SelectItem> itemsIngsoftware) {
        this.itemsIngsoftware = itemsIngsoftware;
    }

    public InputText getTxtProyectosquelidera() {
        return txtProyectosquelidera;
    }

    public void setTxtProyectosquelidera(InputText txtProyectosquelidera) {
        this.txtProyectosquelidera = txtProyectosquelidera;
    }

    public List<Senior> getListaSeniors() {
        if(listaSeniors == null){
            try {
                listaSeniors = seniorLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(SeniorVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaSeniors;
    }

    public void setListaSeniors(List<Senior> listaSeniors) {        
        this.listaSeniors = listaSeniors;
    }

    public Senior getSelectedSenior() {
        return selectedSenior;
    }

    public void setSelectedSenior(Senior selectedSenior) {
        this.selectedSenior = selectedSenior;
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
        this.selectedSenior = (Senior) event.getObject();
        this.cmbIngSoftware.setValue(this.selectedSenior.getIngsoftware().getCedula());
        this.txtProyectosquelidera.setValue(this.selectedSenior.getProyectosquelidera());
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbIngSoftware.setValue("");
        this.txtProyectosquelidera.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }    
    
    public void action_registrar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Senior objSenior = new Senior();
            objSenior.setCedula(objIngsoftware.getCedula());
            try { objSenior.setProyectosquelidera(Integer.parseInt(this.txtProyectosquelidera.getValue().toString())); } catch(Exception ex){}
            objSenior.setIngsoftware(objIngsoftware); 
            
            seniorLogica.registrarSenior(objSenior);
            listaSeniors = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de creación de asignación de Senior", "El Ingeniero de software fue asigando a Senior con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_modificar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Senior objSenior = new Senior();
            objSenior.setCedula(objIngsoftware.getCedula());
            try { objSenior.setProyectosquelidera(Integer.parseInt(this.txtProyectosquelidera.getValue().toString())); } catch(Exception ex){}
            objSenior.setIngsoftware(objIngsoftware); 
            
            seniorLogica.modificarSenior(objSenior);
            listaSeniors = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de asignación de Senior", "La asignación de Senior fue modificada con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_eliminar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Senior objSenior = new Senior();
            objSenior.setCedula(objIngsoftware.getCedula());
            try { objSenior.setProyectosquelidera(Integer.parseInt(this.txtProyectosquelidera.getValue().toString())); } catch(Exception ex){}
            objSenior.setIngsoftware(objIngsoftware); 
            
            seniorLogica.eliminarSenior(objSenior);
            listaSeniors = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de asignación de Senior", "La asignación de Senior fue eliminada con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    /**
     * Creates a new instance of SeniorVista
     */
    public SeniorVista() {
    }
    
}
