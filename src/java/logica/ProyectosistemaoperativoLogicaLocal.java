/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Proyectosistemaoperativo;

/**
 *
 * @author NOREÑA
 */
@Local
public interface ProyectosistemaoperativoLogicaLocal {

    public void registrarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception;
    public void modificarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception;
    public void eliminarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception;
    public List<Proyectosistemaoperativo> consultarTodos() throws Exception;
    
}
