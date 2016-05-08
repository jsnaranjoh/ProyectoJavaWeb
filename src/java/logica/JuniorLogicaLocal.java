/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Junior;

/**
 *
 * @author jsnar
 */
@Local
public interface JuniorLogicaLocal {

    public void registrarJunior(Junior junior) throws Exception;
    public void modificarJunior(Junior junior) throws Exception;
    public void eliminarJunior(Junior junior) throws Exception;
    public List<Junior> consultarTodos() throws Exception;    
    
}
