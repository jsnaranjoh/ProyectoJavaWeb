/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Requisito;

/**
 *
 * @author NOREÑA
 */
@Local
public interface RequisitoLogicaLocal {
    
    public void registrarRequisito(Requisito requisito) throws Exception;
    public void modificarRequisito(Requisito requisito) throws Exception;
    public void eliminarRequisito(Requisito requisito) throws Exception;
    public List<Requisito> consultarTodos() throws Exception;
    
}
