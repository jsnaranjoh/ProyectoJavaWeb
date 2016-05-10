/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Proyectosgbd;

/**
 *
 * @author NOREÑA
 */
@Local
public interface ProyectosgbdLogicaLocal {

    public void registrarSGBD(Proyectosgbd sgbd) throws Exception;
    public void modificarSGBD(Proyectosgbd sgbd) throws Exception;
    public void eliminarSGBD(Proyectosgbd sgbd) throws Exception;
    public List<Proyectosgbd> consultarTodos() throws Exception;
    
}
