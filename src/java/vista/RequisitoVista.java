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
import logica.RequisitoLogicaLocal;
import modelo.Proyecto;
import modelo.Requisito;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author crisd
 */
@Named(value = "requisitoVista")
@RequestScoped
public class RequisitoVista {

    private InputText txtCodigo;
    private SelectOneMenu cmbProyectos;
    private ArrayList<SelectItem> itemsProyectos;
    private InputTextarea txtDescripcion;
    private SelectOneMenu cmbTipos;
    private SelectOneMenu cmbEstados;

    private Requisito selectedRequisito;
    private List<Requisito> listaRequisitos;
    
    private CommandButton btnRegistrar;
    private CommandButton btnLimpiar;     

    @EJB
    private RequisitoLogicaLocal requisitoLogica;
    
    @EJB
    private ProyectoLogicaLocal proyectoLogica;
    
    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public SelectOneMenu getCmbProyectos() {
        return cmbProyectos;
    }

    public void setCmbProyectos(SelectOneMenu cmbProyectos) {
        this.cmbProyectos = cmbProyectos;
    }

    public ArrayList<SelectItem> getItemsProyectos() {
        try {
            List<Proyecto> listaProyectos = proyectoLogica.consultarTodos();
            itemsProyectos = new ArrayList<>();
            
            for(Proyecto p: listaProyectos){
                itemsProyectos.add(new SelectItem(p.getCodigo(), p.getNombre()));
            }
        } catch (Exception ex) {
            Logger.getLogger(RequisitoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsProyectos;
    }

    public void setItemsProyectos(ArrayList<SelectItem> itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

    public InputTextarea getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputTextarea txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public SelectOneMenu getCmbTipos() {
        return cmbTipos;
    }

    public void setCmbTipos(SelectOneMenu cmbTipos) {
        this.cmbTipos = cmbTipos;
    }

    public SelectOneMenu getCmbEstados() {
        return cmbEstados;
    }

    public void setCmbEstados(SelectOneMenu cmbEstados) {
        this.cmbEstados = cmbEstados;
    }

    public Requisito getSelectedRequisito() {
        return selectedRequisito;
    }

    public void setSelectedRequisito(Requisito selectedRequisito) {
        this.selectedRequisito = selectedRequisito;
    }

    public List<Requisito> getListaRequisitos() {
        if(listaRequisitos == null){
            try {
                listaRequisitos = requisitoLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(RequisitoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaRequisitos;
    }

    public void setListaRequisitos(List<Requisito> listaRequisitos) {
        this.listaRequisitos = listaRequisitos;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public void onRowSelect(SelectEvent event){
        this.selectedRequisito = (Requisito) event.getObject();
        
        this.txtCodigo.setValue(this.selectedRequisito.getCodigo());
        this.cmbProyectos.setValue(this.selectedRequisito.getProyecto().getCodigo());
        this.txtDescripcion.setValue(this.selectedRequisito.getDescripcion());
        this.cmbTipos.setValue(this.selectedRequisito.getTipo());        
        this.cmbEstados.setValue(this.selectedRequisito.getEstado());
        
        this.txtCodigo.setDisabled(true);
    }

    public void limpiar(){
        this.txtCodigo.setValue("");
        this.cmbProyectos.setValue("");
        this.txtDescripcion.setValue("");
        this.cmbTipos.setValue("");        
        this.cmbEstados.setValue("");    
        
        this.txtCodigo.setDisabled(false);
    }
    
    public void action_registrar(){
        try{
            Proyecto objProyecto = new Proyecto();
            try{ objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            Requisito objRequisito = new Requisito();
            try{ objRequisito.setCodigo(Integer.parseInt(this.txtCodigo.getValue().toString())); } catch(Exception ex){}
            objRequisito.setProyecto(objProyecto);
            objRequisito.setDescripcion(this.txtDescripcion.getValue().toString());
            objRequisito.setTipo(this.cmbTipos.getValue().toString());
            objRequisito.setEstado(this.cmbEstados.getValue().toString());
            
            requisitoLogica.registrarRequisito(objRequisito);
            listaRequisitos = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de requisito", "El Requisito de Proyecto fue registrado con éxito."));
        }
        catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));            
        }
    }
    
    /**
     * Creates a new instance of RequisitoVista
     */
    public RequisitoVista() {
    }
    
}
