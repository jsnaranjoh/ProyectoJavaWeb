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
import logica.IngsoftwaresgbdLogicaLocal;
import modelo.Ingsoftware;
import modelo.Ingsoftwaresgbd;
import modelo.IngsoftwaresgbdPK;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "ingsoftwaresgbdVista")
@RequestScoped
public class IngsoftwaresgbdVista {

    private SelectOneMenu cmbIngSoftware;
    private ArrayList<SelectItem> itemsIngsoftware;
    private InputText txtSGBD;
    
    private List<Ingsoftwaresgbd> listaIngsoftwaresgbds;
    private Ingsoftwaresgbd selectedIngsoftwaresgbd;
    
    private CommandButton btnRegistrar;
    //private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;
    
    @EJB
    private IngsoftwaresgbdLogicaLocal sgbdLogica;

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
            Logger.getLogger(IngsoftwaresgbdVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsIngsoftware;
    }

    public void setItemsIngsoftware(ArrayList<SelectItem> itemsIngsoftware) {
        this.itemsIngsoftware = itemsIngsoftware;
    }

    public InputText getTxtSGBD() {
        return txtSGBD;
    }

    public void setTxtSGBD(InputText txtSGBD) {
        this.txtSGBD = txtSGBD;
    }

    public List<Ingsoftwaresgbd> getListaIngsoftwaresgbds() {
        if(listaIngsoftwaresgbds == null){
            try {
                listaIngsoftwaresgbds = sgbdLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(IngsoftwaresgbdVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaIngsoftwaresgbds;
    }

    public void setListaIngsoftwaresgbds(List<Ingsoftwaresgbd> listaIngsoftwaresgbds) {        
        this.listaIngsoftwaresgbds = listaIngsoftwaresgbds;
    }

    public Ingsoftwaresgbd getSelectedIngsoftwaresgbd() {
        return selectedIngsoftwaresgbd;
    }

    public void setSelectedIngsoftwaresgbd(Ingsoftwaresgbd selectedIngsoftwaresgbd) {
        this.selectedIngsoftwaresgbd = selectedIngsoftwaresgbd;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    /*public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }*/

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
        this.selectedIngsoftwaresgbd = (Ingsoftwaresgbd) event.getObject();
        this.cmbIngSoftware.setValue(this.selectedIngsoftwaresgbd.getIngsoftware().getCedula());
        this.txtSGBD.setValue(this.selectedIngsoftwaresgbd.getIngsoftwaresgbdPK().getSgbd());
        
        this.btnRegistrar.setDisabled(true);
        //this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbIngSoftware.setValue("");
        this.txtSGBD.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        //this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            IngsoftwaresgbdPK objSGBDPK = new IngsoftwaresgbdPK(objIngsoftware.getCedula(), this.txtSGBD.getValue().toString());
            
            Ingsoftwaresgbd objSGBD = new Ingsoftwaresgbd();
            objSGBD.setIngsoftwaresgbdPK(objSGBDPK);
            objSGBD.setIngsoftware(objIngsoftware);
            
            sgbdLogica.registrarSGBD(objSGBD);
            listaIngsoftwaresgbds = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Sistema Gestor de Bases de Datos conocido por el Ingeniero Software", "SGBD registrado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }
    
    /*public void action_modificar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            IngsoftwaresgbdPK objSGBDPK = new IngsoftwaresgbdPK(objIngsoftware.getCedula(), this.txtSGBD.getValue().toString());
            
            Ingsoftwaresgbd objSGBD = new Ingsoftwaresgbd();
            objSGBD.setIngsoftwaresgbdPK(objSGBDPK);
            objSGBD.setIngsoftware(objIngsoftware);
            
            sgbdLogica.modificarSGBD(objSGBD);
            listaIngsoftwaresgbds = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de Sistema Operativo conocido por el Ingeniero Software", "Sistema Operativo modificado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }*/
    
    public void action_eliminar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            IngsoftwaresgbdPK objSGBDPK = new IngsoftwaresgbdPK(objIngsoftware.getCedula(), this.txtSGBD.getValue().toString());
            
            Ingsoftwaresgbd objSGBD = new Ingsoftwaresgbd();
            objSGBD.setIngsoftwaresgbdPK(objSGBDPK);
            objSGBD.setIngsoftware(objIngsoftware);
            
            sgbdLogica.eliminarSGBD(objSGBD);
            listaIngsoftwaresgbds = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Sistema Gestor de Bases de Datos conocido por el Ingeniero Software", "SGBD eliminado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }    
    /**
     * Creates a new instance of IngsoftwaresgbdVista
     */
    public IngsoftwaresgbdVista() {
    }
    
}
