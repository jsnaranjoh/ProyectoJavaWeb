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
import logica.JefeLogicaLocal;
import modelo.Ingsoftware;
import modelo.Jefe;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "jefeVista")
@RequestScoped
public class JefeVista {

    private SelectOneMenu cmbIngSoftware;
    private ArrayList<SelectItem> itemsIngsoftware;
    private InputText txtPresupuesto;
    
    private List<Jefe> listaJefes;
    private Jefe selectedJefe;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;
    
    @EJB
    private JefeLogicaLocal jefeLogica;

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
            Logger.getLogger(JefeVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsIngsoftware;
    }

    public void setItemsIngsoftware(ArrayList<SelectItem> itemsIngsoftware) {
        this.itemsIngsoftware = itemsIngsoftware;
    }

    public InputText getTxtPresupuesto() {
        return txtPresupuesto;
    }

    public void setTxtPresupuesto(InputText txtPresupuesto) {
        this.txtPresupuesto = txtPresupuesto;
    }

    public List<Jefe> getListaJefes() {
        if(listaJefes == null){
            try {
                listaJefes = jefeLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(JefeVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaJefes;
    }

    public void setListaJefes(List<Jefe> listaJefes) {        
        this.listaJefes = listaJefes;
    }

    public Jefe getSelectedJefe() {
        return selectedJefe;
    }

    public void setSelectedJefe(Jefe selectedJefe) {
        this.selectedJefe = selectedJefe;
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
        this.selectedJefe = (Jefe) event.getObject();
        this.cmbIngSoftware.setValue(this.selectedJefe.getIngsoftware().getCedula());
        this.txtPresupuesto.setValue(this.selectedJefe.getPresupuesto());
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbIngSoftware.setValue("");
        this.txtPresupuesto.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Jefe objJefe = new Jefe();
            objJefe.setCedula(objIngsoftware.getCedula());
            try { objJefe.setPresupuesto(Integer.parseInt(this.txtPresupuesto.getValue().toString())); } catch(Exception ex){}
            objJefe.setIngsoftware(objIngsoftware); 
            
            jefeLogica.registrarJefe(objJefe);
            listaJefes = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de creación de asignación de Jefe", "El Ingeniero de software fue asigando a Jefe con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }
    
    public void action_modificar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Jefe objJefe = new Jefe();
            objJefe.setCedula(objIngsoftware.getCedula());
            try { objJefe.setPresupuesto(Integer.parseInt(this.txtPresupuesto.getValue().toString())); } catch(Exception ex){}
            objJefe.setIngsoftware(objIngsoftware); 
            
            jefeLogica.modificarJefe(objJefe);
            listaJefes = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de asignación de Jefe", "La asignación de Jefe fue modificada con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_eliminar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Jefe objJefe = new Jefe();
            objJefe.setCedula(objIngsoftware.getCedula());
            try { objJefe.setPresupuesto(Integer.parseInt(this.txtPresupuesto.getValue().toString())); } catch(Exception ex){}
            objJefe.setIngsoftware(objIngsoftware);            
            
            jefeLogica.eliminarJefe(objJefe);
            listaJefes = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de asignación de Jefe", "La asignación de Jefe fue eliminada con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    /**
     * Creates a new instance of JefeVista
     */
    public JefeVista() {
    }
    
}
