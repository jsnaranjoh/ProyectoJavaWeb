/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingsoftwarelenguajeprog;

/**
 *
 * @author NOREÑA
 */
@Local
public interface IngsoftwarelenguajeprogLogicaLocal {

    public void registrarLenguajeprog(Ingsoftwarelenguajeprog lenguajeprog) throws Exception;
    public void modificarLenguajeprog(Ingsoftwarelenguajeprog lenguajeprog) throws Exception;
    public void eliminarLenguajeprog(Ingsoftwarelenguajeprog lenguajeprog) throws Exception;
    public List<Ingsoftwarelenguajeprog> consultarTodos() throws Exception;
        
}
