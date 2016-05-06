/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Gradoacademico;

/**
 *
 * @author NOREÑA
 */
@Local
public interface GradoacademicoLogicaLocal {
    
    public void registrarGradoacademico(Gradoacademico ga) throws Exception;
    public void modificarGradoacademico(Gradoacademico ga) throws Exception;
    public void eliminarGradoacadeico(Gradoacademico ga) throws Exception;
    public List<Gradoacademico> consultarTodos() throws Exception;
}
