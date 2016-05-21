/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.IngsoftwareLogicaLocal;
import modelo.Ingsoftware;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author NOREÑA
 */
@Named(value = "ingsoftwareVista")
@RequestScoped
public class IngsoftwareVista {

    private InputText txtCedula;
    private InputText txtNombres;
    private InputText txtApellidos;
    private InputText txtEdad;
    private SelectOneMenu cmbSexos;
    private Date txtFechaNacimiento;
    private InputText txtEmail;
    private InputText txtTelefono;
    private InputText txtCelular;
    private InputText txtDireccion;
    private Date txtFechaIngreso;
    private InputText txtAntiguedad;
    private String txtClave;

    private List<Ingsoftware> listaIngsSoftware;
    private Ingsoftware selectedIngsoftware;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private IngsoftwareLogicaLocal ingsoftwareLogica;

    public InputText getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(InputText txtCedula) {
        this.txtCedula = txtCedula;
    }

    public InputText getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(InputText txtNombres) {
        this.txtNombres = txtNombres;
    }

    public InputText getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(InputText txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public InputText getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(InputText txtEdad) {
        this.txtEdad = txtEdad;
    }

    public SelectOneMenu getCmbSexos() {
        return cmbSexos;
    }

    public void setCmbSexos(SelectOneMenu cmbSexos) {
        this.cmbSexos = cmbSexos;
    }

    public Date getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(Date txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public InputText getTxtCelular() {
        return txtCelular;
    }

    public void setTxtCelular(InputText txtCelular) {
        this.txtCelular = txtCelular;
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public Date getTxtFechaIngreso() {
        return txtFechaIngreso;
    }

    public void setTxtFechaIngreso(Date txtFechaIngreso) {
        this.txtFechaIngreso = txtFechaIngreso;
    }

    public InputText getTxtAntiguedad() {
        return txtAntiguedad;
    }

    public void setTxtAntiguedad(InputText txtAntiguedad) {
        this.txtAntiguedad = txtAntiguedad;
    }

    public String getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(String txtClave) {
        this.txtClave = txtClave;
    }

    public List<Ingsoftware> getListaIngsSoftware() {
        if(listaIngsSoftware == null){
            try {
                listaIngsSoftware = ingsoftwareLogica.consultarTodos();
            } catch (Exception ex) {
                Logger.getLogger(IngsoftwareVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaIngsSoftware;
    }

    public void setListaIngsSoftware(List<Ingsoftware> listaIngsSoftware) {
        this.listaIngsSoftware = listaIngsSoftware;
    }

    public Ingsoftware getSelectedIngsoftware() {
        return selectedIngsoftware;
    }

    public void setSelectedIngsoftware(Ingsoftware selectedIngsoftware) {
        this.selectedIngsoftware = selectedIngsoftware;
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
        this.selectedIngsoftware = (Ingsoftware) event.getObject();
        this.txtCedula.setValue(this.selectedIngsoftware.getCedula());
        this.txtNombres.setValue(this.selectedIngsoftware.getNombres());
        this.txtApellidos.setValue(this.selectedIngsoftware.getApellidos());
        this.txtEdad.setValue(this.selectedIngsoftware.getEdad());
        this.cmbSexos.setValue(this.selectedIngsoftware.getSexo());
        this.txtFechaNacimiento = this.selectedIngsoftware.getFechanacimiento();
        this.txtEmail.setValue(this.selectedIngsoftware.getEmail());
        this.txtCelular.setValue(this.selectedIngsoftware.getCelular());
        this.txtTelefono.setValue(this.selectedIngsoftware.getTelefono());
        this.txtDireccion.setValue(this.selectedIngsoftware.getDireccion());
        this.txtFechaIngreso = this.selectedIngsoftware.getFechaingreso();
        this.txtAntiguedad.setValue(this.selectedIngsoftware.getAntiguedad());
        
        this.btnRegistrar.setDisabled(true);
        this.btnModificar.setDisabled(false);
        this.btnEliminar.setDisabled(false);
        this.txtCedula.setDisabled(true);        
    }
    
    public void limpiar(){
        this.txtCedula.setValue("");
        this.txtNombres.setValue("");
        this.txtApellidos.setValue("");
        this.txtEdad.setValue("");
        this.cmbSexos.setValue("");
        this.txtFechaNacimiento = null;
        this.txtEmail.setValue("");
        this.txtTelefono.setValue("");
        this.txtCelular.setValue("");
        this.txtDireccion.setValue("");
        this.txtFechaIngreso = null;        
        this.txtAntiguedad.setValue("");
        
        this.txtCedula.setDisabled(false);
        this.btnRegistrar.setDisabled(false);
        this.btnModificar.setDisabled(true);
        this.btnEliminar.setDisabled(true);        
    }
    
    public void action_registrar(){
        try{
            Ingsoftware objIngsoftware = new Ingsoftware();
            
            try{ objIngsoftware.setCedula(Integer.parseInt(this.txtCedula.getValue().toString()));} catch(Exception ex){}
            objIngsoftware.setNombres(this.txtNombres.getValue().toString());
            objIngsoftware.setApellidos(this.txtApellidos.getValue().toString());
            try{ objIngsoftware.setEdad(Integer.parseInt(this.txtEdad.getValue().toString())); } catch(Exception ex){}
            objIngsoftware.setSexo(this.txtEdad.getValue().toString());
            objIngsoftware.setFechanacimiento(this.txtFechaNacimiento);
            objIngsoftware.setEmail(this.txtEmail.getValue().toString());
            try{ objIngsoftware.setTelefono(Integer.parseInt(this.txtTelefono.toString())); } catch(Exception ex){}
            try{ objIngsoftware.setCelular(Integer.parseInt(this.txtCelular.toString())); } catch(Exception ex){}
            objIngsoftware.setDireccion(this.txtDireccion.getValue().toString());
            objIngsoftware.setFechaingreso(this.txtFechaIngreso);
            try{ objIngsoftware.setAntiguedad(Integer.parseInt(this.txtAntiguedad.getValue().toString())); } catch(Exception ex){}
            objIngsoftware.setClave(this.txtClave);
            
            ingsoftwareLogica.registrarIngsoftware(objIngsoftware);
            listaIngsSoftware = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de creación de Ingeniero de Software", "El Ingeniero de software fue registrado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }
    }
    
    public void action_modificar(){
        try{
            Ingsoftware objIngsoftware = new Ingsoftware();
            
            try{ objIngsoftware.setCedula(Integer.parseInt(this.txtCedula.getValue().toString()));} catch(Exception ex){}
            objIngsoftware.setNombres(this.txtNombres.getValue().toString());
            objIngsoftware.setApellidos(this.txtApellidos.getValue().toString());
            try{ objIngsoftware.setEdad(Integer.parseInt(this.txtEdad.getValue().toString())); } catch(Exception ex){}
            objIngsoftware.setSexo(this.txtEdad.getValue().toString());
            objIngsoftware.setFechanacimiento(this.txtFechaNacimiento);
            objIngsoftware.setEmail(this.txtEmail.getValue().toString());
            try{ objIngsoftware.setTelefono(Integer.parseInt(this.txtTelefono.toString())); } catch(Exception ex){}
            try{ objIngsoftware.setCelular(Integer.parseInt(this.txtCelular.toString())); } catch(Exception ex){}
            objIngsoftware.setDireccion(this.txtDireccion.getValue().toString());
            objIngsoftware.setFechaingreso(this.txtFechaIngreso);
            try{ objIngsoftware.setAntiguedad(Integer.parseInt(this.txtAntiguedad.getValue().toString())); } catch(Exception ex){}
            objIngsoftware.setClave(this.txtClave);
            
            ingsoftwareLogica.modificarIngsoftware(objIngsoftware);
            listaIngsSoftware = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de creación de Ingeniero de Software", "El Ingeniero de software fue registrado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }        
    }
    
    public void action_eliminar(){
        try{
            Ingsoftware objIngsoftware = new Ingsoftware();
            
            try{ objIngsoftware.setCedula(Integer.parseInt(this.txtCedula.getValue().toString()));} catch(Exception ex){}
            objIngsoftware.setNombres(this.txtNombres.getValue().toString());
            objIngsoftware.setApellidos(this.txtApellidos.getValue().toString());
            try{ objIngsoftware.setEdad(Integer.parseInt(this.txtEdad.getValue().toString())); } catch(Exception ex){}
            objIngsoftware.setSexo(this.txtEdad.getValue().toString());
            objIngsoftware.setFechanacimiento(this.txtFechaNacimiento);
            objIngsoftware.setEmail(this.txtEmail.getValue().toString());
            try{ objIngsoftware.setTelefono(Integer.parseInt(this.txtTelefono.toString())); } catch(Exception ex){}
            try{ objIngsoftware.setCelular(Integer.parseInt(this.txtCelular.toString())); } catch(Exception ex){}
            objIngsoftware.setDireccion(this.txtDireccion.getValue().toString());
            objIngsoftware.setFechaingreso(this.txtFechaIngreso);
            try{ objIngsoftware.setAntiguedad(Integer.parseInt(this.txtAntiguedad.getValue().toString())); } catch(Exception ex){}
            objIngsoftware.setClave(this.txtClave);
            
            ingsoftwareLogica.eliminarIngsoftware(objIngsoftware);
            listaIngsSoftware = null;
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Información de creación de Ingeniero de Software", "El Ingeniero de software fue registrado con éxito."));            
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error.", ex.getMessage()));
        }    
    }
    
    /**
     * Creates a new instance of IngsoftwareVista
     */
    public IngsoftwareVista() {
    }
    
}
