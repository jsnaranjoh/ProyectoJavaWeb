/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Requisitohistorial;

/**
 *
 * @author NOREÑA
 */
@Local
public interface RequisitohistorialLogicaLocal {
    
    public void registrarRequisitohistorial(Requisitohistorial requisitoH) throws Exception;
    public void eliminarRequisitohistorial(Requisitohistorial requisitoH) throws Exception;
    public List<Requisitohistorial> consultarTodos() throws Exception;
    
}
