/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Stateless;
import modelo.Proyectosistemaoperativo;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ProyectosistemaoperativoLogica implements ProyectosistemaoperativoLogicaLocal {

    @Override
    public void registrarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proyectosistemaoperativo> consultarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
