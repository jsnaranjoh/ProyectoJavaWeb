/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ingsoftware;
import persistencia.IngsoftwareFacadeLocal;

/**
 *
 * @author jsnar
 */
@Stateless
public class IngsoftwareLogica implements IngsoftwareLogicaLocal {

    @EJB
    IngsoftwareFacadeLocal ingsoftwareDAO;
    
    @Override
    public void registrarIngsoftware(Ingsoftware ingsoftware) throws Exception {
        if(ingsoftware.getTipo().equals("")){
            throw new Exception("Campo Tipo Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getNombres().equals("")){
            throw new Exception("Campo Nombres Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getApellidos().equals("")){
            throw new Exception("Campo Apellidos Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getSexo().equals("0")){
            throw new Exception("Campo Sexo Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getFechanacimiento() == null){
            throw new Exception("Campo Fecha Nacimiento Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getEmail().equals("")){
            throw new Exception("Campo E-mail Obligatorio.");
        }
        if(!ingsoftware.getEmail().contains("@java.com") || 
                !ingsoftware.getEmail().contains("@hotmail.com") ||
                !ingsoftware.getEmail().contains("@gmail.com") ||
                !ingsoftware.getEmail().contains("@outlook.com") ||
                !ingsoftware.getEmail().contains("@yahoo.es") ||
                !ingsoftware.getEmail().contains("@correounivalle.edu.co")){
            throw new Exception("Ingrese un E-mail Válido. " + 
                    "Se aceptan dominios hotmail.com, gmail.com, outlook.com, yahoo.es, correounivalle.edu.co y java.com");
        }
        if(ingsoftware.getDireccion().equals("")){
            throw new Exception("Campo Dirección Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getFechaingreso() == null){
            throw new Exception("Campo Fecha Ingreso Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getClave().equals("")){
            throw new Exception("Campo Clave Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getClave().length() < 10){
            throw new Exception("Tu Clave Ingeniero Software debe contener 10 caracteres o más.");
        }
        
        Ingsoftware objIngsoftware = ingsoftwareDAO.find(ingsoftware);
        if(objIngsoftware != null){
            throw new Exception("Ingeniero Software ya existe.");
        }
        else{
            ingsoftwareDAO.create(ingsoftware);
        }
    }

    @Override
    public void modificarIngsoftware(Ingsoftware ingsoftware) throws Exception {
        if(ingsoftware.getTipo().equals("")){
            throw new Exception("Campo Tipo Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getNombres().equals("")){
            throw new Exception("Campo Nombres Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getApellidos().equals("")){
            throw new Exception("Campo Apellidos Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getSexo().equals("0")){
            throw new Exception("Campo Sexo Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getFechanacimiento() == null){
            throw new Exception("Campo Fecha Nacimiento Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getEmail().equals("")){
            throw new Exception("Campo E-mail Obligatorio.");
        }
        if(!ingsoftware.getEmail().contains("@java.com") || 
                !ingsoftware.getEmail().contains("@hotmail.com") ||
                !ingsoftware.getEmail().contains("@gmail.com") ||
                !ingsoftware.getEmail().contains("@outlook.com") ||
                !ingsoftware.getEmail().contains("@yahoo.es") ||
                !ingsoftware.getEmail().contains("@correounivalle.edu.co")){
            throw new Exception("Ingrese un E-mail Válido. " + 
                    "Se aceptan dominios hotmail.com, gmail.com, outlook.com, yahoo.es, correounivalle.edu.co y java.com");
        }
        if(ingsoftware.getDireccion().equals("")){
            throw new Exception("Campo Dirección Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getFechaingreso() == null){
            throw new Exception("Campo Fecha Ingreso Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getClave().equals("")){
            throw new Exception("Campo Clave Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getClave().length() < 10){
            throw new Exception("Tu Clave Ingeniero Software debe contener 10 caracteres o más.");
        }

        Ingsoftware objIngsoftware = ingsoftwareDAO.find(ingsoftware);
        if(objIngsoftware == null){
            throw new Exception("Ingeniero Software a modificar no existe.");
        }
        else{
            objIngsoftware.setTipo(ingsoftware.getTipo());
            objIngsoftware.setNombres(ingsoftware.getNombres());
            objIngsoftware.setApellidos(ingsoftware.getApellidos());
            objIngsoftware.setEdad(ingsoftware.getEdad());
            objIngsoftware.setSexo(ingsoftware.getSexo());
            objIngsoftware.setFechanacimiento(ingsoftware.getFechanacimiento());
            objIngsoftware.setEmail(ingsoftware.getEmail());
            objIngsoftware.setTelefono(ingsoftware.getTelefono());
            objIngsoftware.setCelular(ingsoftware.getCelular());
            objIngsoftware.setDireccion(ingsoftware.getDireccion());
            objIngsoftware.setFechaingreso(ingsoftware.getFechaingreso());
            objIngsoftware.setAntiguedad(ingsoftware.getAntiguedad());
            objIngsoftware.setClave(ingsoftware.getClave());
            ingsoftwareDAO.edit(ingsoftware);
        }
    }

    @Override
    public void eliminarIngsoftware(Ingsoftware ingsoftware) throws Exception {
        Ingsoftware objIngsoftware = ingsoftwareDAO.find(ingsoftware.getCedula());
        
        if(objIngsoftware == null){
            throw new Exception("Ingeniero Software a eliminar no existe.");
        }
        else{
            ingsoftwareDAO.remove(ingsoftware);
        }
    }

    @Override
    public List<Ingsoftware> consultarTodos() throws Exception {
        return ingsoftwareDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
