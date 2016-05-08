/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Senior;

/**
 *
 * @author jsnar
 */
@Local
public interface SeniorLogicaLocal {
    
    public void registrarSenior(Senior senior) throws Exception;
    public void modificarSenior(Senior senior) throws Exception;
    public void eliminarSenior(Senior senior) throws Exception;
    public List<Senior> consultarTodos() throws Exception;
    
}
