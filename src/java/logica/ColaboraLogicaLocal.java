/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Colabora;

/**
 *
 * @author NOREÑA
 */
@Local
public interface ColaboraLogicaLocal {
    
    public void registrarColaboracion(Colabora colabora) throws Exception;
    public void modificarColaboracion(Colabora colabora) throws Exception;
    public void eliminarColaboracion(Colabora colabora) throws Exception;
    public List<Colabora> consultarTodas() throws Exception;
    
}
