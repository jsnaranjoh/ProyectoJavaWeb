/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import logica.SesionLogicaLocal;
import modelo.Jefe;
import modelo.Senior;
import modelo.Junior;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author jsnar
 */
@ManagedBean (name = "sesionVista")
@RequestScoped
public class SesionVista {
    
    @EJB
    private SesionLogicaLocal sesionLogica;
    
    private InputText txtUsuario;
    private Password txtClave;
    private CommandButton btnIngresar;

    /**
     * Creates a new instance of SesionVista
     */
    public SesionVista() {
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public Password getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(Password txtClave) {
        this.txtClave = txtClave;
    }

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }
    
    public void funcion_ingresar() {
        try {
            String urlJe, urlSe, urlJu;
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext = context.getExternalContext();
            
            urlJe = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/gestionProyectos.xhtml"));
            
            urlSe = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/gestionRequisitos.xhtml"));
            
            urlJu = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/gestionSolicitudes.xhtml"));
            
            Integer documento = null;
            try {
                documento = Integer.parseInt(txtUsuario.getValue().toString());
            } catch (Exception ex) {}
            String clave = txtClave.getValue().toString();
            
            sesionLogica.buscarCamposInvalidosOVacios(documento, clave);
            Jefe je = sesionLogica.iniciarSesionJefe(documento, clave);
            if(je!=null){
                extContext.getSessionMap().put("tipo", "jefe");
                extContext.getSessionMap().put("usuario", je);
                extContext.redirect(urlJe);
            }else{
                Senior se = sesionLogica.iniciarSesionSenior(documento, clave);
                if(se!=null){
                    extContext.getSessionMap().put("tipo", "senior");
                    extContext.getSessionMap().put("usuario", se);
                    extContext.redirect(urlSe);
                }else{
                    Junior ju = sesionLogica.iniciarSesionJunior(documento, clave);
                    if(ju!=null){
                        extContext.getSessionMap().put("tipo", "junior");
                        extContext.getSessionMap().put("usuario", ju);
                        extContext.redirect(urlJu);
                    }
                }
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
        }
    }
    
    public void cerrarSesion_action()
    {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext= context.getExternalContext();
            extContext.getSessionMap().remove("tipo");
            extContext.getSessionMap().remove("usuario");
            String url=extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,"/index.xhtml"));
            extContext.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(SesionVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
