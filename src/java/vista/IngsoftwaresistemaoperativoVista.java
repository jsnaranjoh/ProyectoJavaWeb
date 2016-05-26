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
import logica.IngsoftwaresistemaoperativoLogicaLocal;
import modelo.Ingsoftware;
import modelo.Ingsoftwaresistemaoperativo;
import modelo.IngsoftwaresistemaoperativoPK;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "ingsoftwaresistemaoperativoVista")
@RequestScoped
public class IngsoftwaresistemaoperativoVista {

    private SelectOneMenu cmbIngSoftware;
    private ArrayList<SelectItem> itemsIngsoftware;
    private InputText txtSistemaoperativo;
    
    private List<Ingsoftwaresistemaoperativo> listaIngsoftwaresistemasoperativos;
    private Ingsoftwaresistemaoperativo selectedIngsoftwaresistemaoperativo;
    
    private CommandButton btnRegistrar;
    //private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;
    
    @EJB
    private IngsoftwaresistemaoperativoLogicaLocal sistemaoperativoLogica;

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
            Logger.getLogger(IngsoftwaresistemaoperativoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsIngsoftware;
    }

    public void setItemsIngsoftware(ArrayList<SelectItem> itemsIngsoftware) {
        this.itemsIngsoftware = itemsIngsoftware;
    }

    public InputText getTxtSistemaoperativo() {
        return txtSistemaoperativo;
    }

    public void setTxtSistemaoperativo(InputText txtSistemaoperativo) {
        this.txtSistemaoperativo = txtSistemaoperativo;
    }

    public List<Ingsoftwaresistemaoperativo> getListaIngsoftwaresistemasoperativos() {
        if(listaIngsoftwaresistemasoperativos == null){
            try {
                listaIngsoftwaresistemasoperativos = sistemaoperativoLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(IngsoftwaresistemaoperativoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaIngsoftwaresistemasoperativos;
    }

    public void setListaIngsoftwaresistemasoperativos(List<Ingsoftwaresistemaoperativo> listaIngsoftwaresistemaoperativos) {        
        this.listaIngsoftwaresistemasoperativos = listaIngsoftwaresistemaoperativos;
    }

    public Ingsoftwaresistemaoperativo getSelectedIngsoftwaresistemaoperativo() {
        return selectedIngsoftwaresistemaoperativo;
    }

    public void setSelectedIngsoftwaresistemaoperativo(Ingsoftwaresistemaoperativo selectedIngsoftwaresistemaoperativo) {
        this.selectedIngsoftwaresistemaoperativo = selectedIngsoftwaresistemaoperativo;
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
        this.selectedIngsoftwaresistemaoperativo = (Ingsoftwaresistemaoperativo) event.getObject();
        this.cmbIngSoftware.setValue(this.selectedIngsoftwaresistemaoperativo.getIngsoftware().getCedula());
        this.txtSistemaoperativo.setValue(this.selectedIngsoftwaresistemaoperativo.getIngsoftwaresistemaoperativoPK().getSistemaoperativo());
        
        this.btnRegistrar.setDisabled(true);
        //this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbIngSoftware.setValue("");
        this.txtSistemaoperativo.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        //this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            IngsoftwaresistemaoperativoPK objSistemaoperativoPK = new IngsoftwaresistemaoperativoPK(objIngsoftware.getCedula(), this.txtSistemaoperativo.getValue().toString());
            
            Ingsoftwaresistemaoperativo objSistemaoperativo = new Ingsoftwaresistemaoperativo();
            objSistemaoperativo.setIngsoftwaresistemaoperativoPK(objSistemaoperativoPK);
            objSistemaoperativo.setIngsoftware(objIngsoftware);
            
            sistemaoperativoLogica.registrarSistemaoperativo(objSistemaoperativo);
            listaIngsoftwaresistemasoperativos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Sistema Operativo conocido por el Ingeniero Software", "Sistema Operativo registrado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }
    
    /*public void action_modificar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();            
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngSoftware.getValue().toString())); } catch(Exception ex){}
            
            IngsoftwaresistemaoperativoPK objSistemaoperativoPK = new IngsoftwaresistemaoperativoPK(objIngsoftware.getCedula(), this.txtSistemaoperativo.getValue().toString());
            
            Ingsoftwaresistemaoperativo objSistemaoperativo = new Ingsoftwaresistemaoperativo();
            objSistemaoperativo.setIngsoftwaresistemaoperativoPK(objSistemaoperativoPK);
            objSistemaoperativo.setIngsoftware(objIngsoftware);
            
            sistemaoperativoLogica.modificarSistemaoperativo(objSistemaoperativo);
            listaIngsoftwaresistemasoperativos = null;
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
            
            IngsoftwaresistemaoperativoPK objSistemaoperativoPK = new IngsoftwaresistemaoperativoPK(objIngsoftware.getCedula(), this.txtSistemaoperativo.getValue().toString());
            
            Ingsoftwaresistemaoperativo objSistemaoperativo = new Ingsoftwaresistemaoperativo();
            objSistemaoperativo.setIngsoftwaresistemaoperativoPK(objSistemaoperativoPK);
            objSistemaoperativo.setIngsoftware(objIngsoftware);
            
            sistemaoperativoLogica.eliminarSistemaoperativo(objSistemaoperativo);
            listaIngsoftwaresistemasoperativos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Sistema Operativo conocido por el Ingeniero Software", "Sistema Operativo eliminado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    /**
     * Creates a new instance of IngsoftwaresistemaoperativoVista
     */
    public IngsoftwaresistemaoperativoVista() {
    }
    
}
