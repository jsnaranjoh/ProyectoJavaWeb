/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Seencuentraen;

/**
 *
 * @author NOREÑA
 */
@Local
public interface SeencuentraenLogicaLocal {
    
    public void registrarDesarrollo(Seencuentraen desarrollo) throws Exception;
    public void modificarDesarrollo(Seencuentraen desarrollo) throws Exception;
    public void eliminarDesarrollo(Seencuentraen desarrollo) throws Exception;
    public List<Seencuentraen> consultarTodos() throws Exception;
    
}
