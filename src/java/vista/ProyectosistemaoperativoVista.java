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
import logica.ProyectosistemaoperativoLogicaLocal;
import modelo.Proyecto;
import modelo.Proyectosistemaoperativo;
import modelo.ProyectosistemaoperativoPK;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author crisd
 */
@Named(value = "proyectosistemaoperativoVista")
@RequestScoped
public class ProyectosistemaoperativoVista {
    
    private SelectOneMenu cmbProyectos;
    private ArrayList<SelectItem> itemsProyectos;
    private InputText txtSistemaOperativo;
    
    private List<Proyectosistemaoperativo> listaProyectosistemaoperativos;
    private Proyectosistemaoperativo selectedProyectosistemaoperativo;
    
    private CommandButton btnRegistrar;
    //private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;    

    @EJB
    private ProyectoLogicaLocal proyectoLogica;
    
    @EJB
    private ProyectosistemaoperativoLogicaLocal sistemaoperativoLogica;    
    
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
            Logger.getLogger(ProyectosistemaoperativoVista.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return itemsProyectos;
    }

    public void setItemsProyectos(ArrayList<SelectItem> itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

    public InputText getTxtSistemaOperativo() {
        return txtSistemaOperativo;
    }

    public void setTxtSistemaOperativo(InputText txtSistemaOperativo) {
        this.txtSistemaOperativo = txtSistemaOperativo;
    }

    public List<Proyectosistemaoperativo> getListaProyectosistemaoperativos() {
        if(listaProyectosistemaoperativos == null){
            try {
                listaProyectosistemaoperativos = sistemaoperativoLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(ProyectosistemaoperativoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaProyectosistemaoperativos;
    }

    public void setListaProyectosistemaoperativos(List<Proyectosistemaoperativo> listaProyectosistemaoperativos) {
        this.listaProyectosistemaoperativos = listaProyectosistemaoperativos;
    }

    public Proyectosistemaoperativo getSelectedProyectosistemaoperativo() {
        return selectedProyectosistemaoperativo;
    }

    public void setSelectedProyectosistemaoperativo(Proyectosistemaoperativo selectedProyectosistemaoperativo) {
        this.selectedProyectosistemaoperativo = selectedProyectosistemaoperativo;
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
        this.selectedProyectosistemaoperativo = (Proyectosistemaoperativo) event.getObject();
        this.cmbProyectos.setValue(this.selectedProyectosistemaoperativo.getProyecto().getCodigo());
        this.txtSistemaOperativo.setValue(this.selectedProyectosistemaoperativo.getProyectosistemaoperativoPK().getSistemaoperativo());
        
        this.btnRegistrar.setDisabled(true);
        //this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
    }
    
    public void limpiar(){
        this.cmbProyectos.setValue("");
        this.txtSistemaOperativo.setValue("");
        
        this.btnRegistrar.setDisabled(false);
        //this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }    

    public void action_registrar(){
        try {
            Proyecto objProyecto = new Proyecto();            
            try { objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            ProyectosistemaoperativoPK objLengProgPK = new ProyectosistemaoperativoPK(objProyecto.getCodigo(), this.txtSistemaOperativo.getValue().toString());
            
            Proyectosistemaoperativo objLengProg = new Proyectosistemaoperativo();
            objLengProg.setProyectosistemaoperativoPK(objLengProgPK);
            objLengProg.setProyecto(objProyecto);
            
            sistemaoperativoLogica.registrarSistemaoperativo(objLengProg);
            listaProyectosistemaoperativos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Sistema Operativo realizado en el Proyecto.", 
                    "Sistema Operativo registrado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }    

    public void action_eliminar(){
        try {
            Proyecto objProyecto = new Proyecto();            
            try { objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            ProyectosistemaoperativoPK objLengProgPK = new ProyectosistemaoperativoPK(objProyecto.getCodigo(), this.txtSistemaOperativo.getValue().toString());
            
            Proyectosistemaoperativo objLengProg = new Proyectosistemaoperativo();
            objLengProg.setProyectosistemaoperativoPK(objLengProgPK);
            objLengProg.setProyecto(objProyecto);
            
            sistemaoperativoLogica.eliminarSistemaoperativo(objLengProg);
            listaProyectosistemaoperativos = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Sistema Operativo realizado en el Proyecto.", 
                    "Sistema Operativo eliminado con éxito.")); 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }         
    }
    /**
     * Creates a new instance of ProyectosistemaoperativoVista
     */
    public ProyectosistemaoperativoVista() {
    }
    
}
