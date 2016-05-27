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
import logica.SeminarioLogicaLocal;
import modelo.Ingsoftware;
import modelo.Seminario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "seminarioVista")
@RequestScoped
public class SeminarioVista {

    private InputText txtNumero;
    private SelectOneMenu cmbIngenieros;
    private ArrayList<SelectItem> itemsIngenieros;
    private InputText txtNombre;
    private InputText txtLugar;
    private Date txtFechainicio;
    private Date txtFechafin;
    
    private List<Seminario> listaSeminarios;
    private Seminario selectedSeminario;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;    

    @EJB
    private SeminarioLogicaLocal seminarioLogica;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;
    
    public InputText getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(InputText txtNumero) {
        this.txtNumero = txtNumero;
    }

    public SelectOneMenu getCmbIngenieros() {
        return cmbIngenieros;
    }

    public void setCmbIngenieros(SelectOneMenu cmbIngenieros) {
        this.cmbIngenieros = cmbIngenieros;
    }

    public ArrayList<SelectItem> getItemsIngenieros() {
        try {
            List<Ingsoftware> listaIng = ingsoftwareLogica.consultarTodos();
            itemsIngenieros = new ArrayList<>();
            
            for(Ingsoftware ing: listaIng){
                itemsIngenieros.add(new SelectItem(ing.getCedula(), ing.getNombres() + " " + ing.getApellidos()));
            }
        } catch (Exception ex) {
            Logger.getLogger(SeminarioVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsIngenieros;
    }

    public void setItemsIngenieros(ArrayList<SelectItem> itemsIngenieros) {
        this.itemsIngenieros = itemsIngenieros;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtLugar() {
        return txtLugar;
    }

    public void setTxtLugar(InputText txtLugar) {
        this.txtLugar = txtLugar;
    }

    public Date getTxtFechainicio() {
        return txtFechainicio;
    }

    public void setTxtFechainicio(Date txtFechainicio) {
        this.txtFechainicio = txtFechainicio;
    }

    public Date getTxtFechafin() {
        return txtFechafin;
    }

    public void setTxtFechafin(Date txtFechafin) {
        this.txtFechafin = txtFechafin;
    }

    public List<Seminario> getListaSeminarios() {
        if(listaSeminarios == null){
            try {
                listaSeminarios = seminarioLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(SeminarioVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaSeminarios;
    }

    public void setListaSeminarios(List<Seminario> listaSeminarios) {
        this.listaSeminarios = listaSeminarios;
    }

    public Seminario getSelectedSeminario() {
        return selectedSeminario;
    }

    public void setSelectedSeminario(Seminario selectedSeminario) {
        this.selectedSeminario = selectedSeminario;
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
        this.selectedSeminario = (Seminario) event.getObject();
        
        this.txtNumero.setValue(this.selectedSeminario.getNumero());
        this.cmbIngenieros.setValue(this.selectedSeminario.getIngeniero().getCedula());
        this.txtNombre.setValue(this.selectedSeminario.getNombre());
        this.txtLugar.setValue(this.selectedSeminario.getLugar());
        this.txtFechainicio = this.selectedSeminario.getFechainicio();
        this.txtFechafin = this.selectedSeminario.getFechafin();
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.txtNumero.setDisabled(true);        
    }

    public void limpiar(){
        this.txtNumero.setValue("");
        this.cmbIngenieros.setValue("");
        this.txtNombre.setValue("");
        this.txtLugar.setValue("");
        this.txtFechainicio = null;
        this.txtFechafin = null;
        
        this.txtNumero.setDisabled(false);
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try{            
            Ingsoftware objIngsoftware = new Ingsoftware();
            try{ objIngsoftware.setCedula(Integer.parseInt(this.cmbIngenieros.getValue().toString())); } catch(Exception ex){}
            
            Seminario objSeminario = new Seminario();
            try{ objSeminario.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objSeminario.setIngeniero(objIngsoftware);
            objSeminario.setNombre(this.txtNombre.getValue().toString());
            objSeminario.setLugar(this.txtLugar.getValue().toString());
            objSeminario.setFechainicio(txtFechainicio);
            objSeminario.setFechafin(txtFechafin);
            
            seminarioLogica.registrarSeminario(objSeminario);
            listaSeminarios = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Seminario", "El Seminario fue registrado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_modificar(){
        try{            
            Ingsoftware objIngsoftware = new Ingsoftware();
            try{ objIngsoftware.setCedula(Integer.parseInt(this.cmbIngenieros.getValue().toString())); } catch(Exception ex){}
            
            Seminario objSeminario = new Seminario();
            try{ objSeminario.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objSeminario.setIngeniero(objIngsoftware);
            objSeminario.setNombre(this.txtNombre.getValue().toString());
            objSeminario.setLugar(this.txtLugar.getValue().toString());
            objSeminario.setFechainicio(txtFechainicio);
            objSeminario.setFechafin(txtFechafin);
            
            seminarioLogica.modificarSeminario(objSeminario);
            listaSeminarios = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de Seminario", "El Seminario fue modificado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }

    public void action_eliminar(){
        try{            
            Ingsoftware objIngsoftware = new Ingsoftware();
            try{ objIngsoftware.setCedula(Integer.parseInt(this.cmbIngenieros.getValue().toString())); } catch(Exception ex){}
            
            Seminario objSeminario = new Seminario();
            try{ objSeminario.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objSeminario.setIngeniero(objIngsoftware);
            objSeminario.setNombre(this.txtNombre.getValue().toString());
            objSeminario.setLugar(this.txtLugar.getValue().toString());
            objSeminario.setFechainicio(txtFechainicio);
            objSeminario.setFechafin(txtFechafin);
            
            seminarioLogica.eliminarSeminario(objSeminario);
            listaSeminarios = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Seminario", "El Seminario fue eliminado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    /**
     * Creates a new instance of SeminarioVista
     */
    public SeminarioVista() {
    }
    
}
