/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingsoftwaresistemaoperativo;

/**
 *
 * @author NOREÑA
 */
@Local
public interface IngsoftwaresistemaoperativoLogicaLocal {

    public void registrarSistemaoperativo(Ingsoftwaresistemaoperativo sistemaoperativo) throws Exception;
    public void modificarSistemaoperativo(Ingsoftwaresistemaoperativo sistemaoperativo) throws Exception;
    public void eliminarSistemaoperativo(Ingsoftwaresistemaoperativo sistemaoperativo) throws Exception;
    public List<Ingsoftwaresistemaoperativo> consultarTodos() throws Exception;
    
}
