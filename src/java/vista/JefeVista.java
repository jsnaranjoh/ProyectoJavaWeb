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
        
    }
    
    public void limpiar(){
        
    }
    
    public void action_registrar(){
        
    }
    
    public void action_modificar(){
        
    }
    
    public void action_eliminar(){
        
    }
    
    /**
     * Creates a new instance of JefeVista
     */
    public JefeVista() {
    }
    
}
