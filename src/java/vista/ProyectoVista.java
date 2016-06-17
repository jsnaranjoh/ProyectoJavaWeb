/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.servlet.ServletContext;
import logica.ProyectoLogicaLocal;
import logica.SeniorLogicaLocal;
import modelo.Proyecto;
import modelo.Senior;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "proyectoVista")
@RequestScoped
public class ProyectoVista {

    private InputText txtCodigo;
    private SelectOneMenu cmbLideres;
    private ArrayList<SelectItem> itemsLideres;
    private InputText txtNombre;
    private SelectOneMenu cmbAreasAplicacion;
    private Date txtFechaIngreso;
    private Date txtFechaAsignacion;
    private Date txtFechaPrevistaLiberacion;
    private InputText txtVersionPrograma;
    private InputText txtCostoTotal;

    private List<Proyecto> listaProyectos;
    private Proyecto selectedProyecto;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;      
    
    @EJB
    ProyectoLogicaLocal proyectoLogica;
    
    @EJB
    SeniorLogicaLocal seniorLogica;
    
    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public SelectOneMenu getCmbLideres() {        
        return cmbLideres;
    }

    public void setCmbLideres(SelectOneMenu cmbLideres) {        
        this.cmbLideres = cmbLideres;
    }

    public ArrayList<SelectItem> getItemsLideres() {
        try {        
            List<Senior> listaSenior = seniorLogica.consultarTodos();
            itemsLideres = new ArrayList<>();
            
            for(Senior senior : listaSenior){
                itemsLideres.add(new SelectItem(senior.getCedula(), senior.getIngsoftware().getNombres() + " " + senior.getIngsoftware().getApellidos()));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProyectoVista.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return itemsLideres;
    }

    public void setItemsLideres(ArrayList<SelectItem> itemsLideres) {
        this.itemsLideres = itemsLideres;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public SelectOneMenu getCmbAreasAplicacion() {
        return cmbAreasAplicacion;
    }

    public void setCmbAreasAplicacion(SelectOneMenu cmbAreasAplicacion) {
        this.cmbAreasAplicacion = cmbAreasAplicacion;
    }

    public Date getTxtFechaIngreso() {
        return txtFechaIngreso;
    }

    public void setTxtFechaIngreso(Date txtFechaIngreso) {
        this.txtFechaIngreso = txtFechaIngreso;
    }

    public Date getTxtFechaAsignacion() {
        return txtFechaAsignacion;
    }

    public void setTxtFechaAsignacion(Date txtFechaAsignacion) {
        this.txtFechaAsignacion = txtFechaAsignacion;
    }

    public Date getTxtFechaPrevistaLiberacion() {
        return txtFechaPrevistaLiberacion;
    }

    public void setTxtFechaPrevistaLiberacion(Date txtFechaPrevistaLiberacion) {
        this.txtFechaPrevistaLiberacion = txtFechaPrevistaLiberacion;
    }

    public InputText getTxtVersionPrograma() {
        return txtVersionPrograma;
    }

    public void setTxtVersionPrograma(InputText txtVersionPrograma) {
        this.txtVersionPrograma = txtVersionPrograma;
    }

    public InputText getTxtCostoTotal() {
        return txtCostoTotal;
    }

    public void setTxtCostoTotal(InputText txtCostoTotal) {
        this.txtCostoTotal = txtCostoTotal;
    }

    public List<Proyecto> getListaProyectos() {
        if(listaProyectos == null){
            try {
                listaProyectos = proyectoLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(ProyectoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaProyectos;
    }

    public void setListaProyectos(List<Proyecto> listaProyectos) {
        this.listaProyectos = listaProyectos;
    }

    public Proyecto getSelectedProyecto() {
        return selectedProyecto;
    }

    public void setSelectedProyecto(Proyecto selectedProyecto) {
        this.selectedProyecto = selectedProyecto;
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
        this.selectedProyecto = (Proyecto) event.getObject();
        
        this.txtCodigo.setValue(this.selectedProyecto.getCodigo());
        this.cmbLideres.setValue(this.selectedProyecto.getLider().getCedula());
        this.txtNombre.setValue(this.selectedProyecto.getNombre());
        this.cmbAreasAplicacion.setValue(this.selectedProyecto.getAreaaplicacion());
        this.txtFechaIngreso = this.selectedProyecto.getFechaingreso();
        this.txtFechaAsignacion = this.selectedProyecto.getFechaasignacion();
        this.txtFechaPrevistaLiberacion = this.selectedProyecto.getFechaprevistaliberacion();
        this.txtVersionPrograma.setValue(this.selectedProyecto.getVersionprograma());
        this.txtCostoTotal.setValue(this.selectedProyecto.getCostototal());
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.txtCodigo.setDisabled(true);        
    }
    
    public void limpiar(){
        this.txtCodigo.setValue("");
        this.cmbLideres.setValue("");
        this.txtNombre.setValue("");
        this.cmbAreasAplicacion.setValue("");
        this.txtFechaIngreso = null;
        this.txtFechaAsignacion = null;
        this.txtFechaPrevistaLiberacion = null;
        this.txtVersionPrograma.setValue("");
        this.txtCostoTotal.setValue("");        
        
        this.txtCodigo.setDisabled(false);
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);                
    }
    
    public void action_registrar(){
        try {
            Senior objSenior = new Senior();
            try{ objSenior.setCedula(Integer.parseInt(this.cmbLideres.getValue().toString())); } catch(Exception ex){}
            
            Proyecto objProyecto = new Proyecto();            
            try{ objProyecto.setCodigo(Integer.parseInt(this.txtCodigo.getValue().toString())); } catch(Exception ex){}
            objProyecto.setLider(objSenior);
            objProyecto.setNombre(this.txtNombre.getValue().toString());
            objProyecto.setAreaaplicacion(this.cmbAreasAplicacion.getValue().toString());
            objProyecto.setFechaingreso(this.txtFechaIngreso);
            objProyecto.setFechaasignacion(this.txtFechaAsignacion);
            objProyecto.setFechaprevistaliberacion(this.txtFechaPrevistaLiberacion);
            objProyecto.setVersionprograma(this.txtVersionPrograma.getValue().toString());
            try { objProyecto.setCostototal(Integer.parseInt(this.txtCostoTotal.getValue().toString())); } catch(Exception ex){}
                        
            proyectoLogica.registrarProyecto(objProyecto);
            listaProyectos = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de registro de Proyecto", "El Proyecto fue registrado con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_modificar(){
        try {
            Senior objSenior = new Senior();
            try{ objSenior.setCedula(Integer.parseInt(this.cmbLideres.getValue().toString())); } catch(Exception ex){}
            
            Proyecto objProyecto = new Proyecto();            
            try{ objProyecto.setCodigo(Integer.parseInt(this.txtCodigo.getValue().toString())); } catch(Exception ex){}
            objProyecto.setLider(objSenior);
            objProyecto.setNombre(this.txtNombre.getValue().toString());
            objProyecto.setAreaaplicacion(this.cmbAreasAplicacion.getValue().toString());
            objProyecto.setFechaingreso(this.txtFechaIngreso);
            objProyecto.setFechaasignacion(this.txtFechaAsignacion);
            objProyecto.setFechaprevistaliberacion(this.txtFechaPrevistaLiberacion);
            objProyecto.setVersionprograma(this.txtVersionPrograma.getValue().toString());
            try { objProyecto.setCostototal(Integer.parseInt(this.txtCostoTotal.getValue().toString())); } catch(Exception ex){}
                        
            proyectoLogica.modificarProyecto(objProyecto);
            listaProyectos = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de modificación de Proyecto", "El Proyecto fue modificado con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }
    
    public void action_eliminar(){
        try {
            Senior objSenior = new Senior();
            try{ objSenior.setCedula(Integer.parseInt(this.cmbLideres.getValue().toString())); } catch(Exception ex){}
            
            Proyecto objProyecto = new Proyecto();            
            try{ objProyecto.setCodigo(Integer.parseInt(this.txtCodigo.getValue().toString())); } catch(Exception ex){}
            objProyecto.setLider(objSenior);
            objProyecto.setNombre(this.txtNombre.getValue().toString());
            objProyecto.setAreaaplicacion(this.cmbAreasAplicacion.getValue().toString());
            objProyecto.setFechaingreso(this.txtFechaIngreso);
            objProyecto.setFechaasignacion(this.txtFechaAsignacion);
            objProyecto.setFechaprevistaliberacion(this.txtFechaPrevistaLiberacion);
            objProyecto.setVersionprograma(this.txtVersionPrograma.getValue().toString());
            try { objProyecto.setCostototal(Integer.parseInt(this.txtCostoTotal.getValue().toString())); } catch(Exception ex){}
                        
            proyectoLogica.eliminarProyecto(objProyecto);
            listaProyectos = null;
            limpiar();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de eliminación de Proyecto", "El Proyecto fue eliminado con éxito."));            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }

    public void handleFileUpload(FileUploadEvent event) {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("/");
        File f = new File (path + "excel");
        f.mkdir();
        String rutaDestino = (String) servletContext.getRealPath("/excel");

        try {
            copyFile(rutaDestino, event.getFile().getFileName(), event.getFile().getInputstream());
            String resultado = proyectoLogica.importarProyectos(rutaDestino + "\\" + event.getFile().getFileName());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información de importación:", resultado));
           
        } catch(Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", ex.getMessage()));
        }
    }
    
    public void copyFile(String rutaDestino, String fileName, InputStream in) {
        try {
            OutputStream out = new FileOutputStream(new File(rutaDestino + "\\" + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
        } catch(Exception ex) {
            Logger.getLogger(ProyectoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    /**
     * Creates a new instance of ProyectoVista
     */
    public ProyectoVista() {
    }
    
}
