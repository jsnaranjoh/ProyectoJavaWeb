/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Senior;
import persistencia.SeniorFacadeLocal;

/**
 *
 * @author jsnar
 */
@Stateless
public class SeniorLogica implements SeniorLogicaLocal {

    @EJB
    SeniorFacadeLocal seniorDAO;
    
    @Override
    public void registrarSenior(Senior senior) throws Exception {
        if(senior.getIngsoftware().getCedula() == null){
            throw new Exception("Debes seleccionar un Ingeniero de Software.");
        }
        if(senior.getProyectosquelidera() == 0){
            throw new Exception("Campo Cantidad de Proyectos liderados por Senior Ingeniero Software Obligatorio.");
        }
        
        Senior objSenior = seniorDAO.find(senior.getIngsoftware().getCedula());
        if(objSenior != null){
            throw new Exception("Senior ya existe.");
        }
        else{
            seniorDAO.create(senior);
        }
    }

    @Override
    public void modificarSenior(Senior senior) throws Exception {
        if(senior.getIngsoftware().getCedula() == null){
            throw new Exception("Ingeniero de Software No Registrado.");
        }
        if(senior.getProyectosquelidera() == 0){
            throw new Exception("Campo Cantidad de Proyectos liderados por Senior Ingeniero Software Obligatorio.");
        }
        
        Senior objSenior = seniorDAO.find(senior.getIngsoftware().getCedula());
        if(objSenior == null){
            throw new Exception("Senior a modificar no existe.");
        }
        else{
            objSenior.setProyectosquelidera(senior.getProyectosquelidera());
            seniorDAO.edit(objSenior);
        }
    }

    @Override
    public void eliminarSenior(Senior senior) throws Exception {
        if(senior.getIngsoftware().getCedula() == null){
            throw new Exception("Ingeniero de Software No Registrado.");
        }
        
        Senior objSenior = seniorDAO.find(senior.getIngsoftware().getCedula());
        if(objSenior == null){
            throw new Exception("Senior a eliminar no existe.");
        }
        else{
            if(objSenior.getProyectoList().size() > 0){
                throw new Exception("El Ingeniero Senior tiene proyectos liderados. Elimínelos primero.");
            }
            seniorDAO.remove(senior);
        }
    }

    @Override
    public List<Senior> consultarTodos() throws Exception {
        return seniorDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
