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
        if(ingsoftware.getCedula() == null || ingsoftware.getCedula() == 0){
            throw new Exception("Campo Cédula Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getNombres().equals("")){
            throw new Exception("Campo Nombres Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getApellidos().equals("")){
            throw new Exception("Campo Apellidos Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getEdad() == 0){
            throw new Exception("Campo Edad Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getSexo().equals("0")){
            throw new Exception("Campo Sexo Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getFechanacimiento() == null){
            throw new Exception("Campo Fecha Nacimiento Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getEmail().equals("")){
            throw new Exception("Campo E-mail Ingeniero Software Obligatorio.");
        }
        if(!ingsoftware.getEmail().contains("@") && (!ingsoftware.getEmail().endsWith(".com") || !ingsoftware.getEmail().endsWith(".es"))){
            throw new Exception("E-mail inválído. Ejemplos válidos: \"example@something.com\" o \"example@something.es\"");
        }
        if(ingsoftware.getTelefono() == 0){
            throw new Exception("Campo Teléfono Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getCelular() == 0){
            throw new Exception("Campo Celular Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getDireccion().equals("")){
            throw new Exception("Campo Dirección Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getFechaingreso() == null){
            throw new Exception("Campo Fecha Ingreso Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getAntiguedad() == 0){
            throw new Exception("Campo Antigüedad Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getClave().equals("")){
            throw new Exception("Campo Clave Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getClave().length() < 10){
            throw new Exception("Tu Clave Ingeniero Software debe contener 10 caracteres o más.");
        }
        
        Ingsoftware objIngsoftware = ingsoftwareDAO.find(ingsoftware.getCedula());
        if(objIngsoftware != null){
            throw new Exception("Ingeniero Software ya existe.");
        }
        else{
            ingsoftwareDAO.create(ingsoftware);
        }
    }

    @Override
    public void modificarIngsoftware(Ingsoftware ingsoftware) throws Exception {
        if(ingsoftware.getCedula() == null || ingsoftware.getCedula() == 0){
            throw new Exception("Campo Cédula Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getNombres().equals("")){
            throw new Exception("Campo Nombres Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getApellidos().equals("")){
            throw new Exception("Campo Apellidos Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getEdad() == 0){
            throw new Exception("Campo Edad Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getSexo().equals("0")){
            throw new Exception("Campo Sexo Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getFechanacimiento() == null){
            throw new Exception("Campo Fecha Nacimiento Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getEmail().equals("")){
            throw new Exception("Campo E-mail Ingeniero Software Obligatorio.");
        }
        if(!ingsoftware.getEmail().contains("@") && (!ingsoftware.getEmail().endsWith(".com") || !ingsoftware.getEmail().endsWith(".es"))){
            throw new Exception("E-mail inválído. Ejemplos válidos: \"example@something.com\" o \"example@something.es\"");
        }
        if(ingsoftware.getTelefono() == 0){
            throw new Exception("Campo Teléfono Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getCelular() == 0){
            throw new Exception("Campo Celular Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getDireccion().equals("")){
            throw new Exception("Campo Dirección Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getFechaingreso() == null){
            throw new Exception("Campo Fecha Ingreso Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getAntiguedad() == 0){
            throw new Exception("Campo Antigüedad Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getClave().equals("")){
            throw new Exception("Campo Clave Ingeniero Software Obligatorio.");
        }
        if(ingsoftware.getClave().length() < 10){
            throw new Exception("Tu Clave Ingeniero Software debe contener 10 caracteres o más.");
        }

        Ingsoftware objIngsoftware = ingsoftwareDAO.find(ingsoftware.getCedula());
        if(objIngsoftware == null){
            throw new Exception("Ingeniero Software a modificar no existe.");
        }
        else{
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
            ingsoftwareDAO.edit(objIngsoftware);
        }
    }

    @Override
    public void eliminarIngsoftware(Ingsoftware ingsoftware) throws Exception {
        if(ingsoftware.getCedula() == null || ingsoftware.getCedula() == 0){
            throw new Exception("Campo Cédula Ingeniero Software Obligatorio.");
        }
        
        Ingsoftware objIngsoftware = ingsoftwareDAO.find(ingsoftware.getCedula());
        
        if(objIngsoftware == null){
            throw new Exception("Ingeniero Software a eliminar no existe.");
        }
        else{
            if(objIngsoftware.getGradoacademicoList().size() > 0){
                throw new Exception("El Ingeniero Software tiene grados académicos asociados. Elimínelos primero.");
            }
            if(objIngsoftware.getIngsoftwarelenguajeprogList().size() > 0){
                throw new Exception("El Ingeniero Software tiene aptitudes asociadas. " + 
                        "Por lo tanto, elimine primero los lenguajes de programación que él o ella sabe.");
            }
            if(objIngsoftware.getIngsoftwaresgbdList().size() > 0){
                throw new Exception("El Ingeniero Software tiene aptitudes asociadas. " + 
                        "Por lo tanto, elimine primero los sistemas gestores de bases de datos que él o ella sabe.");
            }
            if(objIngsoftware.getIngsoftwaresistemaoperativoList().size() > 0){
                throw new Exception("El Ingeniero Software tiene aptitudes asociadas. " +
                        "Por lo tanto, elimine primero los sistemas operativos que él o ella sabe.");
            }
            if(objIngsoftware.getSeminarioList().size() > 0){
                throw new Exception("El Ingeniero Software tiene seminarios asociados. Elimínelos primero.");
            }
            if(objIngsoftware.getSolicitudList().size() > 0){
                throw new Exception("El Ingeniero Software tiene solicitudes realizadas. Elimínelas primero.");
            }
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
