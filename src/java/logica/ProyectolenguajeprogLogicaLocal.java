/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Proyectolenguajeprog;

/**
 *
 * @author NOREÑA
 */
@Local
public interface ProyectolenguajeprogLogicaLocal {

    public void registrarLenguajeprog(Proyectolenguajeprog lenguajeprog) throws Exception;
    public void modificarLenguajeprog(Proyectolenguajeprog lenguajeprog) throws Exception;
    public void eliminarLenguajeprog(Proyectolenguajeprog lenguajeprog) throws Exception;
    public List<Proyectolenguajeprog> consultarTodos() throws Exception;
    
}
