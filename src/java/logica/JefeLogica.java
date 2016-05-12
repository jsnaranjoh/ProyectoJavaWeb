/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Jefe;
import persistencia.JefeFacadeLocal;

/**
 *
 * @author jsnar
 */
@Stateless
public class JefeLogica implements JefeLogicaLocal {

    @EJB
    JefeFacadeLocal jefeDAO;
    
    @Override
    public void registrarJefe(Jefe jefe) throws Exception {
        if(jefe.getIngsoftware().getCedula() == null){
            throw new Exception("No se ha seleccionado ningún Ingeniero de Software.");
        }
        
        Jefe objJefe = jefeDAO.find(jefe.getIngsoftware().getCedula());
        if(objJefe != null){
            throw new Exception("Jefe ya existe.");
        }
        else{
            jefeDAO.create(jefe);
        }
    }

    @Override
    public void modificarJefe(Jefe jefe) throws Exception {
        if(jefe.getIngsoftware() == null){
            throw new Exception("Ingeniero de Software No Registrado.");
        }
        
        Jefe objJefe = jefeDAO.find(jefe.getIngsoftware().getCedula());
        if(objJefe == null){
            throw new Exception("Jefe a modificar no existe.");
        }
        else{
            objJefe.setPresupuesto(jefe.getPresupuesto());
            jefeDAO.edit(jefe);
        }
    }

    @Override
    public void eliminarJefe(Jefe jefe) throws Exception {
        Jefe objJefe = jefeDAO.find(jefe.getIngsoftware().getCedula());
        if(objJefe == null){
            throw new Exception("Jefe a eliminar no existe.");
        }
        else{
            if(objJefe.getSolicitudList().size() > 0){
                throw new Exception("El Ingeniero Jefe tiene solicitudes verificadas. Elimínelas primero.");
            }
            jefeDAO.remove(jefe);
        }
    }

    @Override
    public List<Jefe> consultarTodos() throws Exception {
        return jefeDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
