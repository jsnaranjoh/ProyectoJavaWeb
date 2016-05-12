/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Proyecto;
import persistencia.ProyectoFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ProyectoLogica implements ProyectoLogicaLocal {

    @EJB
    ProyectoFacadeLocal proyectoDAO;
    
    @Override
    public void registrarProyecto(Proyecto proyecto) throws Exception {
        if(proyecto.getLider().getCedula() == null){
            throw new Exception("Debe tener un Ingeniero de Software que lidere el proyecto.");
        }
        if(proyecto.getNombre().equals("")){
            throw new Exception("Campo Nombre Proyecto Obligatorio.");
        }
        if(proyecto.getAreaaplicacion().equals("") || proyecto.getAreaaplicacion() == null){
            throw new Exception("Campo Área Aplicación Proyecto Obligatorio.");
        }
        if(proyecto.getFechaingreso() == null){
            throw new Exception("Campo Fecha Ingreso Proyecto Obligatorio.");
        }
        if(proyecto.getFechaasignacion() == null){
            throw new Exception("Campo Fecha Asignación Proyecto Obligatorio.");
        }
        if(proyecto.getFechaprevistaliberacion() == null){
            throw new Exception("Campo Fecha Prevista Liberación Proyecto Obligatorio.");
        }
        if(proyecto.getVersionprograma().equals("")){
            throw new Exception("Campo Versión Programa Proyecto Obligatorio.");
        }
        
        Proyecto objProyecto = proyectoDAO.find(proyecto.getCodigo());
        if(objProyecto != null){
            throw new Exception("Proyecto ya existe.");
        }
        else{
            proyectoDAO.create(proyecto);
        }
    }

    @Override
    public void modificarProyecto(Proyecto proyecto) throws Exception {
        if(proyecto.getLider().getCedula() == null){
            throw new Exception("Debe tener un Ingeniero de Software que lidere el proyecto.");
        }
        if(proyecto.getNombre().equals("")){
            throw new Exception("Campo Nombre Proyecto Obligatorio.");
        }
        if(proyecto.getAreaaplicacion().equals("") || proyecto.getAreaaplicacion() == null){
            throw new Exception("Campo Área Aplicación Proyecto Obligatorio.");
        }
        if(proyecto.getFechaingreso() == null){
            throw new Exception("Campo Fecha Ingreso Proyecto Obligatorio.");
        }
        if(proyecto.getFechaasignacion() == null){
            throw new Exception("Campo Fecha Asignación Proyecto Obligatorio.");
        }
        if(proyecto.getFechaprevistaliberacion() == null){
            throw new Exception("Campo Fecha Prevista Liberación Proyecto Obligatorio.");
        }
        if(proyecto.getVersionprograma().equals("")){
            throw new Exception("Campo Versión Programa Proyecto Obligatorio.");
        }
        
        Proyecto objProyecto = proyectoDAO.find(proyecto.getCodigo());
        if(objProyecto == null){
            throw new Exception("Proyecto a modificar no existe.");
        }
        else{
            objProyecto.setLider(proyecto.getLider());
            objProyecto.setNombre(proyecto.getNombre());
            objProyecto.setAreaaplicacion(proyecto.getAreaaplicacion());
            objProyecto.setFechaingreso(proyecto.getFechaingreso());
            objProyecto.setFechaasignacion(proyecto.getFechaasignacion());
            objProyecto.setFechaprevistaliberacion(proyecto.getFechaprevistaliberacion());
            objProyecto.setVersionprograma(proyecto.getVersionprograma());
            objProyecto.setCostototal(proyecto.getCostototal());
            proyectoDAO.edit(proyecto);
        }
    }

    @Override
    public void eliminarProyecto(Proyecto proyecto) throws Exception {       
        Proyecto objProyecto = proyectoDAO.find(proyecto.getCodigo());
        
        if(objProyecto == null){
            throw new Exception("Proyecto a eliminar no existe.");
        }
        else{
            if(objProyecto.getColaboraList().size() > 0){
                throw new Exception("El Proyecto tiene colaboraciones asociadas. Elimínelas primero.");
            }
            if(objProyecto.getProyectolenguajeprogList().size() > 0){
                throw new Exception("El Proyecto tiene características asociadas." + 
                        " Por lo tanto, elimine primero los lenguajes de programación en que se tienen implementado el proyecto.");
            }
            if(objProyecto.getProyectosgbdList().size() > 0){
                throw new Exception("El Proyecto tiene características asociadas." + 
                        " Por lo tanto, elimine primero los sistemas gestores de bases de datos en que se tienen implementado el proyecto.");                
            }
            if(objProyecto.getProyectosistemaoperativoList().size() > 0){
                throw new Exception("El Proyecto tiene características asociadas." + 
                        " Por lo tanto, elimine primero los sistemas operativos en que se pueden ejecutar el proyecto.");
            }
            if(objProyecto.getRequisitoList().size() > 0){
                throw new Exception("El Proyecto contiene requisitos. Elimínelos primero.");
            }
            if(objProyecto.getSeencuentraenList().size() > 0){
                throw new Exception("El Proyecto tiene fases de desarrollo asociados. Elíminelos primero.");
            }
            proyectoDAO.remove(proyecto);
        }
    }

    @Override
    public List<Proyecto> consultarTodos() throws Exception {
        return proyectoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
