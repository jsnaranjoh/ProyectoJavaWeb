/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ingsoftwaresgbd;
import persistencia.IngsoftwaresgbdFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class IngsoftwaresgbdLogica implements IngsoftwaresgbdLogicaLocal {

    @EJB
    IngsoftwaresgbdFacadeLocal sgbdDAO;
    
    @Override
    public void registrarSGBD(Ingsoftwaresgbd sgbd) throws Exception {
        if(sgbd.getIngsoftware().getCedula() == null){
            throw new Exception("Debes seleccionar un Ingeniero Software.");
        }
        if(sgbd.getIngsoftwaresgbdPK().getSgbd().equals("")){
            throw new Exception("Campo Lenguaje Programación Obligatorio.");
        }
        
        Ingsoftwaresgbd objSgbd = sgbdDAO.find(sgbd);
        if(objSgbd != null){
            throw new Exception("Lenguaje de Programación de Ingeniero Software ya existe.");
        }
        else{
            sgbdDAO.create(sgbd);
        }
    }

    @Override
    public void modificarSGBD(Ingsoftwaresgbd sgbd) throws Exception {
        if(sgbd.getIngsoftware().getCedula() == null){
            throw new Exception("Debes seleccionar un Ingeniero Software.");
        }
        if(sgbd.getIngsoftwaresgbdPK().getSgbd().equals("")){
            throw new Exception("Campo Lenguaje Programación Obligatorio.");
        }
        
        Ingsoftwaresgbd objSgbd = sgbdDAO.find(sgbd);
        if(objSgbd == null){
            throw new Exception("Lenguaje de Programación de Ingeniero Software a modificar no existe.");
        }
        else{
            sgbdDAO.edit(sgbd);
        }
    }

    @Override
    public void eliminarSGBD(Ingsoftwaresgbd sgbd) throws Exception {
        Ingsoftwaresgbd objSgbd = sgbdDAO.find(sgbd.getIngsoftwaresgbdPK());
        
        if(objSgbd == null){
            throw new Exception("Lenguaje de Programación de Ingeniero Software a eliminar no existe.");
        }
        else{
            sgbdDAO.remove(sgbd);
        }
    }

    @Override
    public List<Ingsoftwaresgbd> consultarTodos() throws Exception {
        return sgbdDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
