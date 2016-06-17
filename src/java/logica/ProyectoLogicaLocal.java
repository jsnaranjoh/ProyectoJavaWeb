/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Proyecto;

/**
 *
 * @author NOREÑA
 */
@Local
public interface ProyectoLogicaLocal {

    public void registrarProyecto(Proyecto proyecto) throws Exception;
    public void modificarProyecto(Proyecto proyecto) throws Exception;
    public void eliminarProyecto(Proyecto proyecto) throws Exception;
    public List<Proyecto> consultarTodos() throws Exception;
    public String importarProyectos(String archivo) throws Exception;
}
