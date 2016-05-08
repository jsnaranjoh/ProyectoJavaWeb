/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingsoftware;

/**
 *
 * @author jsnar
 */
@Local
public interface IngsoftwareLogicaLocal {

    public void registrarIngsoftware(Ingsoftware ingsoftware) throws Exception;
    public void modificarIngsoftware(Ingsoftware ingsoftware) throws Exception;
    public void eliminarIngsoftware(Ingsoftware ingsoftware) throws Exception;
    public List<Ingsoftware> consultarTodos() throws Exception;
    
}
