/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Jefe;

/**
 *
 * @author jsnar
 */
@Local
public interface JefeLogicaLocal {

    public void registrarJefe(Jefe jefe) throws Exception;
    public void modificarJefe(Jefe jefe) throws Exception;
    public void eliminarJefe(Jefe jefe) throws Exception;
    public List<Jefe> consultarTodos() throws Exception;
    
}
