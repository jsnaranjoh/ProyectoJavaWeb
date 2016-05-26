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
import logica.JuniorLogicaLocal;
import modelo.Ingsoftware;
import modelo.Junior;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "juniorVista")
@RequestScoped
public class JuniorVista {

    private SelectOneMenu cmbIngSoftware;
    private ArrayList<SelectItem> itemsIngsoftware;
    private InputText txtHorastrabajoxdia;
    
    private List<Junior> listaJuniors;
    private Junior selectedJunior;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;
    
    @EJB
    private JuniorLogicaLocal juniorLogica;

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
            Logger.getLogger(JuniorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsIngsoftware;
    }

    public void setItemsIngsoftware(ArrayList<SelectItem> itemsIngsoftware) {
        this.itemsIngsoftware = itemsIngsoftware;
    }

    public InputText getTxtHorastrabajoxdia() {
        return txtHorastrabajoxdia;
    }

    public void setTxtHorastrabajoxdia(InputText txtHorastrabajoxdia) {
        this.txtHorastrabajoxdia = txtHorastrabajoxdia;
    }

    public List<Junior> getListaJuniors() {
        if(listaJuniors == null){
            try {
                listaJuniors = juniorLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(JuniorVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaJuniors;
    }

    public void setListaJuniors(List<Junior> listaJuniors) {        
        this.listaJuniors = listaJuniors;
    }

    public Junior getSelectedJunior() {
        return selectedJunior;
    }

    public void setSelectedJunior(Junior selectedJunior) {
        this.selectedJunior = selectedJunior;
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
        this.selectedJunior = (Junior) event.getObject();
        this.cmbIngSoftware.setValue(this.selectedJunior.getIngsoftware().getCedula());
        this.txtHorastrabajoxdia.setValue(this.selectedJunior.getHorastrabajoxdia());
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbIngSoftware.setValue("");
        this.txtHorastrabajoxdia.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Junior objJunior = new Junior();
            objJunior.setCedula(objIngsoftware.getCedula());
            try { objJunior.setHorastrabajoxdia(Integer.parseInt(this.txtHorastrabajoxdia.getValue().toString())); } catch(Exception ex){}
            objJunior.setIngsoftware(objIngsoftware); 
            
            juniorLogica.registrarJunior(objJunior);
            listaJuniors = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de creación de asignación de Junior", "El Ingeniero de software fue asigando a Junior con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_modificar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Junior objJunior = new Junior();
            objJunior.setCedula(objIngsoftware.getCedula());
            try { objJunior.setHorastrabajoxdia(Integer.parseInt(this.txtHorastrabajoxdia.getValue().toString())); } catch(Exception ex){}
            objJunior.setIngsoftware(objIngsoftware); 
            
            juniorLogica.modificarJunior(objJunior);
            listaJuniors = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de asignación de Junior", "La asignación de Junior fue modificada con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }
    
    public void action_eliminar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            Junior objJunior = new Junior();
            objJunior.setCedula(objIngsoftware.getCedula());
            try { objJunior.setHorastrabajoxdia(Integer.parseInt(this.txtHorastrabajoxdia.getValue().toString())); } catch(Exception ex){}
            objJunior.setIngsoftware(objIngsoftware); 
            
            juniorLogica.eliminarJunior(objJunior);
            listaJuniors = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de asignación de Junior", "La asignación de Junior fue eliminada con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }          
    }
    
    /**
     * Creates a new instance of JuniorVisita
     */
    public JuniorVista() {
    }
    
}
