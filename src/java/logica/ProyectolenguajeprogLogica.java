/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Proyectolenguajeprog;
import persistencia.ProyectolenguajeprogFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ProyectolenguajeprogLogica implements ProyectolenguajeprogLogicaLocal {

    @EJB
    ProyectolenguajeprogFacadeLocal lenguajeprogDAO;
    
    @Override
    public void registrarLenguajeprog(Proyectolenguajeprog lenguajeprog) throws Exception {
        if(lenguajeprog.getProyecto().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto.");
        }
        if(lenguajeprog.getProyectolenguajeprogPK().getLenguajeprog().equals("")){
            throw new Exception("Campo Lenguaje Programación Obligatorio.");
        }
        
        Proyectolenguajeprog objLenguajeprog = lenguajeprogDAO.find(lenguajeprog.getProyectolenguajeprogPK());
        if(objLenguajeprog != null){
            throw new Exception("Lenguaje de Programación del Proyecto ya existe.");
        }
        else{
            lenguajeprogDAO.create(lenguajeprog);
        }
    }

    @Override
    public void modificarLenguajeprog(Proyectolenguajeprog lenguajeprog) throws Exception {
        if(lenguajeprog.getProyecto().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto.");
        }
        if(lenguajeprog.getProyectolenguajeprogPK().getLenguajeprog().equals("")){
            throw new Exception("Campo Lenguaje Programación Obligatorio.");
        }
        
        Proyectolenguajeprog objLenguajeprog = lenguajeprogDAO.find(lenguajeprog.getProyectolenguajeprogPK());
        if(objLenguajeprog == null){
            throw new Exception("Lenguaje de Programación del Proyecto a modificar no existe.");
        }
        else{
            objLenguajeprog.getProyectolenguajeprogPK().setLenguajeprog(lenguajeprog.getProyectolenguajeprogPK().getLenguajeprog());
            lenguajeprogDAO.edit(objLenguajeprog);
        }
    }

    @Override
    public void eliminarLenguajeprog(Proyectolenguajeprog lenguajeprog) throws Exception {
        Proyectolenguajeprog objLenguajeprog = lenguajeprogDAO.find(lenguajeprog.getProyectolenguajeprogPK());
        
        if(objLenguajeprog == null){
            throw new Exception("Lenguaje de Programación del Proyecto a eliminar no existe.");
        }
        else{
            lenguajeprogDAO.remove(lenguajeprog);
        }
    }

    @Override
    public List<Proyectolenguajeprog> consultarTodos() throws Exception {
        return lenguajeprogDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
