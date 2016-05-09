/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingsoftwaresgbd;

/**
 *
 * @author NOREÑA
 */
@Local
public interface IngsoftwaresgbdLogicaLocal {

    public void registrarSGBD(Ingsoftwaresgbd sgbd) throws Exception;
    public void modificarSGBD(Ingsoftwaresgbd sgbd) throws Exception;
    public void eliminarSGBD(Ingsoftwaresgbd sgbd) throws Exception;
    public List<Ingsoftwaresgbd> consultarTodos() throws Exception;
    
}
