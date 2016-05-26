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
import logica.IngsoftwarelenguajeprogLogicaLocal;
import modelo.Ingsoftware;
import modelo.Ingsoftwarelenguajeprog;
import modelo.IngsoftwarelenguajeprogPK;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "ingsoftwarelenguajeprogVista")
@RequestScoped
public class IngsoftwarelenguajeprogVista {

    private SelectOneMenu cmbIngSoftware;
    private ArrayList<SelectItem> itemsIngsoftware;
    private InputText txtLengProg;
    
    private List<Ingsoftwarelenguajeprog> listaIngsoftwarelenguajeprogs;
    private Ingsoftwarelenguajeprog selectedIngsoftwarelenguajeprog;
    
    private CommandButton btnRegistrar;
    //private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;
    
    @EJB
    private IngsoftwarelenguajeprogLogicaLocal lenguajeprogLogica;

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
            Logger.getLogger(IngsoftwarelenguajeprogVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsIngsoftware;
    }

    public void setItemsIngsoftware(ArrayList<SelectItem> itemsIngsoftware) {
        this.itemsIngsoftware = itemsIngsoftware;
    }

    public InputText getTxtLengProg() {
        return txtLengProg;
    }

    public void setTxtLengProg(InputText txtLengProg) {
        this.txtLengProg = txtLengProg;
    }

    public List<Ingsoftwarelenguajeprog> getListaIngsoftwarelenguajeprogs() {
        if(listaIngsoftwarelenguajeprogs == null){
            try {
                listaIngsoftwarelenguajeprogs = lenguajeprogLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(IngsoftwarelenguajeprogVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaIngsoftwarelenguajeprogs;
    }

    public void setListaIngsoftwarelenguajeprogs(List<Ingsoftwarelenguajeprog> listaIngsoftwarelenguajeprogs) {        
        this.listaIngsoftwarelenguajeprogs = listaIngsoftwarelenguajeprogs;
    }

    public Ingsoftwarelenguajeprog getSelectedIngsoftwarelenguajeprog() {
        return selectedIngsoftwarelenguajeprog;
    }

    public void setSelectedIngsoftwarelenguajeprog(Ingsoftwarelenguajeprog selectedIngsoftwarelenguajeprog) {
        this.selectedIngsoftwarelenguajeprog = selectedIngsoftwarelenguajeprog;
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
        this.selectedIngsoftwarelenguajeprog = (Ingsoftwarelenguajeprog) event.getObject();
        this.cmbIngSoftware.setValue(this.selectedIngsoftwarelenguajeprog.getIngsoftware().getCedula());
        this.txtLengProg.setValue(this.selectedIngsoftwarelenguajeprog.getIngsoftwarelenguajeprogPK().getLenguajeprog());
        
        this.btnRegistrar.setDisabled(true);
        //this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbIngSoftware.setValue("");
        this.txtLengProg.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        //this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            IngsoftwarelenguajeprogPK objLengProgPK = new IngsoftwarelenguajeprogPK(objIngsoftware.getCedula(), this.txtLengProg.getValue().toString());
            
            Ingsoftwarelenguajeprog objLengProg = new Ingsoftwarelenguajeprog();
            objLengProg.setIngsoftwarelenguajeprogPK(objLengProgPK);
            objLengProg.setIngsoftware(objIngsoftware);
            
            lenguajeprogLogica.registrarLenguajeprog(objLengProg);
            listaIngsoftwarelenguajeprogs = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Lenguaje de Programación conocido por el Ingeniero Software", 
                    "Lenguaje de Programación registrado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }
    
    /*public void action_modificar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            IngsoftwarelenguajeprogPK objLengProgPK = new IngsoftwarelenguajeprogPK(objIngsoftware.getCedula(), this.txtLengProg.getValue().toString());
            
            Ingsoftwarelenguajeprog objLengProg = new Ingsoftwarelenguajeprog();
            objLengProg.setIngsoftwarelenguajeprogPK(objLengProgPK);
            objLengProg.setIngsoftware(objIngsoftware);
            
            lenguajeprogLogica.modificarLengProg(objLengProg);
            listaIngsoftwarelenguajeprogs = null;
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
            
            IngsoftwarelenguajeprogPK objLengProgPK = new IngsoftwarelenguajeprogPK(objIngsoftware.getCedula(), this.txtLengProg.getValue().toString());
            
            Ingsoftwarelenguajeprog objLengProg = new Ingsoftwarelenguajeprog();
            objLengProg.setIngsoftwarelenguajeprogPK(objLengProgPK);
            objLengProg.setIngsoftware(objIngsoftware);
            
            lenguajeprogLogica.eliminarLenguajeprog(objLengProg);
            listaIngsoftwarelenguajeprogs = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Lenguaje de Programación de Datos conocido por el Ingeniero Software", 
                    "Lenguaje Programación eliminado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    /**
     * Creates a new instance of IngsoftwarelenguajeprogVista
     */
    public IngsoftwarelenguajeprogVista() {
    }
    
}
