/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.ColaboraLogicaLocal;
import logica.JuniorLogicaLocal;
import logica.ProyectoLogicaLocal;
import modelo.Colabora;
import modelo.ColaboraPK;
import modelo.Junior;
import modelo.Proyecto;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author crisd
 */
@Named(value = "colaboraVista")
@RequestScoped
public class ColaboraVista implements Serializable {

    private SelectOneMenu cmbJuniors;
    private ArrayList<SelectItem> itemsJuniors;
    
    private SelectOneMenu cmbProyectos;
    private ArrayList<SelectItem> itemsProyectos;
    
    private InputText txtHorasDedicadas;
    private Date txtFechaInicio;
    private Date txtFechaFin;

    private List<Colabora> listaColaboraciones;
    private Colabora selectedColaboracion;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;    

    @EJB
    ColaboraLogicaLocal colaboraLogica;

    @EJB
    JuniorLogicaLocal juniorLogica;
    
    @EJB
    ProyectoLogicaLocal proyectoLogica;
        
    public SelectOneMenu getCmbJuniors() {
        return cmbJuniors;
    }

    public void setCmbJuniors(SelectOneMenu cmbJuniors) {
        this.cmbJuniors = cmbJuniors;
    }

    public ArrayList<SelectItem> getItemsJuniors() {
        try {
            List<Junior> listaJuniors = juniorLogica.consultarTodos();
            itemsJuniors = new ArrayList<>();
            
            for(Junior junior : listaJuniors){
                itemsJuniors.add(new SelectItem(junior.getCedula(), junior.getIngsoftware().getNombres() + " " + junior.getIngsoftware().getApellidos()));
            }
        } catch (Exception ex) {
            Logger.getLogger(ColaboraVista.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return itemsJuniors;
    }

    public void setItemsJuniors(ArrayList<SelectItem> itemsJuniors) {
        this.itemsJuniors = itemsJuniors;
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
            
            for(Proyecto proyecto : listaProyectos){
                itemsProyectos.add(new SelectItem(proyecto.getCodigo(), proyecto.getNombre()));
            }
        } catch (Exception ex) {
            Logger.getLogger(ColaboraVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return itemsProyectos;
    }

    public void setItemsProyectos(ArrayList<SelectItem> itemsProyectos) {
        this.itemsProyectos = itemsProyectos;
    }

    public InputText getTxtHorasDedicadas() {
        return txtHorasDedicadas;
    }

    public void setTxtHorasDedicadas(InputText txtHorasDedicadas) {
        this.txtHorasDedicadas = txtHorasDedicadas;
    }

    public Date getTxtFechaInicio() {
        return txtFechaInicio;
    }

    public void setTxtFechaInicio(Date txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public Date getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(Date txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public List<Colabora> getListaColaboraciones() {
        if(listaColaboraciones == null){
            try {
                listaColaboraciones = colaboraLogica.consultarTodas();
            } catch (Exception ex) {
                Logger.getLogger(ColaboraVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaColaboraciones;
    }

    public void setListaColaboraciones(List<Colabora> listaColaboraciones) {
        this.listaColaboraciones = listaColaboraciones;
    }

    public Colabora getSelectedColaboracion() {
        return selectedColaboracion;
    }

    public void setSelectedColaboracion(Colabora selectedColaboracion) {
        this.selectedColaboracion = selectedColaboracion;
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
        this.selectedColaboracion = (Colabora) event.getObject();
        
        this.cmbJuniors.setValue(this.selectedColaboracion.getJunior1().getCedula());
        this.cmbProyectos.setValue(this.selectedColaboracion.getProyecto1().getCodigo());
        this.txtHorasDedicadas.setValue(this.selectedColaboracion.getHorasdedicadas());
        this.txtFechaInicio = this.selectedColaboracion.getFechainicio();
        this.txtFechaFin = this.selectedColaboracion.getFechafin();
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.cmbJuniors.setDisabled(true);
        this.cmbProyectos.setDisabled(true);
    }
    
    public void limpiar(){
        this.cmbJuniors.setValue("");
        this.cmbProyectos.setValue("");
        this.txtHorasDedicadas.setValue("");
        this.txtFechaInicio = null;
        this.txtFechaFin = null;
        
        this.cmbJuniors.setDisabled(false);
        this.cmbProyectos.setDisabled(false);
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try {
            Junior objJunior = new Junior();
            try{ objJunior.setCedula(Integer.parseInt(this.cmbJuniors.getValue().toString())); } catch(Exception ex){}
            
            Proyecto objProyecto = new Proyecto();
            try{ objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            Colabora objColabora = new Colabora();
            try{ 
                ColaboraPK objColaboraPK = new ColaboraPK(objJunior.getCedula(), objProyecto.getCodigo());
                objColabora.setColaboraPK(objColaboraPK);
            }
            catch(Exception ex){}

            objColabora.setJunior1(objJunior);
            objColabora.setProyecto1(objProyecto);
            try{ objColabora.setHorasdedicadas(Integer.parseInt(this.txtHorasDedicadas.getValue().toString())); } catch(Exception ex){}
            objColabora.setFechainicio(txtFechaInicio);
            objColabora.setFechafin(txtFechaFin);
            
            colaboraLogica.registrarColaboracion(objColabora);
            listaColaboraciones = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Colaboración", "La Colaboración fue registrada con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }
    
    public void action_modificar(){
        try {
            Junior objJunior = new Junior();
            try{ objJunior.setCedula(Integer.parseInt(this.cmbJuniors.getValue().toString())); } catch(Exception ex){}
            
            Proyecto objProyecto = new Proyecto();
            try{ objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            Colabora objColabora = new Colabora();
            try{ 
                ColaboraPK objColaboraPK = new ColaboraPK(objJunior.getCedula(), objProyecto.getCodigo());
                objColabora.setColaboraPK(objColaboraPK);
            }
            catch(Exception ex){}

            objColabora.setJunior1(objJunior);
            objColabora.setProyecto1(objProyecto);
            try{ objColabora.setHorasdedicadas(Integer.parseInt(this.txtHorasDedicadas.getValue().toString())); } catch(Exception ex){}
            objColabora.setFechainicio(txtFechaInicio);
            objColabora.setFechafin(txtFechaFin);
            
            colaboraLogica.modificarColaboracion(objColabora);
            listaColaboraciones = null;
            limpiar();            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de Colaboración", "La Colaboración fue modificada con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_eliminar(){
        try {
            Junior objJunior = new Junior();
            try{ objJunior.setCedula(Integer.parseInt(this.cmbJuniors.getValue().toString())); } catch(Exception ex){}
            
            Proyecto objProyecto = new Proyecto();
            try{ objProyecto.setCodigo(Integer.parseInt(this.cmbProyectos.getValue().toString())); } catch(Exception ex){}
            
            Colabora objColabora = new Colabora();
            try{ 
                ColaboraPK objColaboraPK = new ColaboraPK(objJunior.getCedula(), objProyecto.getCodigo());
                objColabora.setColaboraPK(objColaboraPK);
            }
            catch(Exception ex){}

            objColabora.setJunior1(objJunior);
            objColabora.setProyecto1(objProyecto);
            try{ objColabora.setHorasdedicadas(Integer.parseInt(this.txtHorasDedicadas.getValue().toString())); } catch(Exception ex){}
            objColabora.setFechainicio(txtFechaInicio);
            objColabora.setFechafin(txtFechaFin);
            
            colaboraLogica.eliminarColaboracion(objColabora);
            listaColaboraciones = null;
            limpiar();            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Colaboración", "La Colaboración fue eliminada con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    /**
     * Creates a new instance of ColaboraVista
     */
    public ColaboraVista() {
    }
    
}
