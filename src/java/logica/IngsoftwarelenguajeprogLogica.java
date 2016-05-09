/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ingsoftwarelenguajeprog;
import persistencia.IngsoftwarelenguajeprogFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class IngsoftwarelenguajeprogLogica implements IngsoftwarelenguajeprogLogicaLocal {

    @EJB
    IngsoftwarelenguajeprogFacadeLocal lenguajeprogDAO;
    
    @Override
    public void registrarLenguajeprog(Ingsoftwarelenguajeprog lenguajeprog) throws Exception {
        if(lenguajeprog.getIngsoftware().getCedula() == null){
            throw new Exception("Debes seleccionar un Ingeniero Software.");
        }
        if(lenguajeprog.getIngsoftwarelenguajeprogPK().getLenguajeprog().equals("")){
            throw new Exception("Campo Lenguaje Programación Obligatorio.");
        }
        
        Ingsoftwarelenguajeprog objLenguajeprog = lenguajeprogDAO.find(lenguajeprog);
        if(objLenguajeprog != null){
            throw new Exception("Lenguaje de Programación de Ingeniero Software ya existe.");
        }
        else{
            lenguajeprogDAO.create(lenguajeprog);
        }
    }

    @Override
    public void modificarLenguajeprog(Ingsoftwarelenguajeprog lenguajeprog) throws Exception {
        if(lenguajeprog.getIngsoftware().getCedula() == null){
            throw new Exception("Debes seleccionar un Ingeniero Software.");
        }
        if(lenguajeprog.getIngsoftwarelenguajeprogPK().getLenguajeprog().equals("")){
            throw new Exception("Campo Lenguaje Programación Obligatorio.");
        }
        
        Ingsoftwarelenguajeprog objLenguajeprog = lenguajeprogDAO.find(lenguajeprog);
        if(objLenguajeprog == null){
            throw new Exception("Lenguaje de Programación de Ingeniero Software a modificar no existe.");
        }
        else{
            lenguajeprogDAO.edit(lenguajeprog);
        }
    }

    @Override
    public void eliminarLenguajeprog(Ingsoftwarelenguajeprog lenguajeprog) throws Exception {
        Ingsoftwarelenguajeprog objLenguajeprog = lenguajeprogDAO.find(lenguajeprog.getIngsoftwarelenguajeprogPK());
        
        if(objLenguajeprog == null){
            throw new Exception("Lenguaje de Programación de Ingeniero Software a eliminar no existe.");
        }
        else{
            lenguajeprogDAO.remove(lenguajeprog);
        }
    }

    @Override
    public List<Ingsoftwarelenguajeprog> consultarTodos() throws Exception {
        return lenguajeprogDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
