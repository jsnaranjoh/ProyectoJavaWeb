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
import logica.GradoacademicoLogicaLocal;
import logica.IngsoftwareLogicaLocal;
import modelo.Gradoacademico;
import modelo.Ingsoftware;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "gradoacademicoVista")
@RequestScoped
public class GradoacademicoVista {

    private InputText txtNumero;
    private SelectOneMenu cmbIngenieros;
    private ArrayList<SelectItem> itemsIngenieros;
    private SelectOneMenu cmbNiveles;
    private InputText txtLugar;
    private InputText txtAnioTitulacion;
    private InputText txtTituloObtenido;

    private List<Gradoacademico> listaGradosacademicos;
    private Gradoacademico selectedGradoacademico;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;

    @EJB
    GradoacademicoLogicaLocal gradoacademicoLogica;
    
    @EJB
    IngsoftwareLogicaLocal ingsoftwareLogica;
    
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
            Logger.getLogger(JefeVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsIngenieros;
    }

    public void setItemsIngenieros(ArrayList<SelectItem> itemsIngenieros) {
        this.itemsIngenieros = itemsIngenieros;
    }

    public SelectOneMenu getCmbNiveles() {
        return cmbNiveles;
    }

    public void setCmbNiveles(SelectOneMenu cmbNiveles) {
        this.cmbNiveles = cmbNiveles;
    }

    public InputText getTxtLugar() {
        return txtLugar;
    }

    public void setTxtLugar(InputText txtLugar) {
        this.txtLugar = txtLugar;
    }

    public InputText getTxtAnioTitulacion() {
        return txtAnioTitulacion;
    }

    public void setTxtAnioTitulacion(InputText txtAnioTitulacion) {
        this.txtAnioTitulacion = txtAnioTitulacion;
    }

    public InputText getTxtTituloObtenido() {
        return txtTituloObtenido;
    }

    public void setTxtTituloObtenido(InputText txtTituloObtenido) {
        this.txtTituloObtenido = txtTituloObtenido;
    }

    public List<Gradoacademico> getListaGradosacademicos() {
        if(listaGradosacademicos == null){
            try {
                listaGradosacademicos = gradoacademicoLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(GradoacademicoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaGradosacademicos;
    }

    public void setListaGradosacademicos(List<Gradoacademico> listaGradosacademicos) {
        this.listaGradosacademicos = listaGradosacademicos;
    }

    public Gradoacademico getSelectedGradoacademico() {
        return selectedGradoacademico;
    }

    public void setSelectedGradoacademico(Gradoacademico selectedGradoacademico) {
        this.selectedGradoacademico = selectedGradoacademico;
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
        this.selectedGradoacademico = (Gradoacademico) event.getObject();
        this.txtNumero.setValue(this.selectedGradoacademico.getNumero());
        this.cmbIngenieros.setValue(this.selectedGradoacademico.getIngeniero().getCedula());
        this.cmbNiveles.setValue(this.selectedGradoacademico.getNivel());
        this.txtLugar.setValue(this.selectedGradoacademico.getLugar());
        this.txtAnioTitulacion.setValue(this.selectedGradoacademico.getAniotitulacion());
        this.txtTituloObtenido.setValue(this.selectedGradoacademico.getTituloobtenido());
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.txtNumero.setDisabled(true);        
    }
    
    public void limpiar(){
        this.txtNumero.setValue("");
        this.cmbIngenieros.setValue("");
        this.cmbNiveles.setValue("");
        this.txtLugar.setValue("");
        this.txtAnioTitulacion.setValue("");
        this.txtTituloObtenido.setValue("");
        
        this.txtNumero.setDisabled(false);
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);         
    }
    
    public void action_registrar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngenieros.getValue().toString())); } catch(Exception ex){}
            
            Gradoacademico objGradoacademico = new Gradoacademico();
            try{ objGradoacademico.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objGradoacademico.setIngeniero(objIngsoftware);
            objGradoacademico.setNivel(this.cmbNiveles.getValue().toString());
            objGradoacademico.setLugar(this.txtLugar.getValue().toString());
            try{ objGradoacademico.setAniotitulacion(Integer.parseInt(this.txtAnioTitulacion.getValue().toString())); } catch(Exception ex){}
            objGradoacademico.setTituloobtenido(this.txtTituloObtenido.getValue().toString());
            
            gradoacademicoLogica.registrarGradoacademico(objGradoacademico);
            listaGradosacademicos = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Grado Académico", "El Grado Académico fue registrado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }
    
    public void action_modificar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngenieros.getValue().toString())); } catch(Exception ex){}
            
            Gradoacademico objGradoacademico = new Gradoacademico();
            try{ objGradoacademico.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objGradoacademico.setIngeniero(objIngsoftware);
            objGradoacademico.setNivel(this.cmbNiveles.getValue().toString());
            objGradoacademico.setLugar(this.txtLugar.getValue().toString());
            try{ objGradoacademico.setAniotitulacion(Integer.parseInt(this.txtAnioTitulacion.getValue().toString())); } catch(Exception ex){}
            objGradoacademico.setTituloobtenido(this.txtTituloObtenido.getValue().toString());
            
            gradoacademicoLogica.modificarGradoacademico(objGradoacademico);
            listaGradosacademicos = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de Grado Académico", "El Grado Académico fue modificado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }

    public void action_eliminar(){
        try {
            Ingsoftware objIngsoftware = new Ingsoftware();
            try { objIngsoftware.setCedula(Integer.parseInt(this.cmbIngenieros.getValue().toString())); } catch(Exception ex){}
            
            Gradoacademico objGradoacademico = new Gradoacademico();
            try{ objGradoacademico.setNumero(Integer.parseInt(this.txtNumero.getValue().toString())); } catch(Exception ex){}
            objGradoacademico.setIngeniero(objIngsoftware);
            objGradoacademico.setNivel(this.cmbNiveles.getValue().toString());
            objGradoacademico.setLugar(this.txtLugar.getValue().toString());
            try{ objGradoacademico.setAniotitulacion(Integer.parseInt(this.txtAnioTitulacion.getValue().toString())); } catch(Exception ex){}
            objGradoacademico.setTituloobtenido(this.txtTituloObtenido.getValue().toString());
            
            gradoacademicoLogica.eliminarGradoacademico(objGradoacademico);
            listaGradosacademicos = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Grado Académico", "El Grado Académico fue eliminado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }    
    
    /**
     * Creates a new instance of GradoacademicoVista
     */
    public GradoacademicoVista() {
    }
    
}
