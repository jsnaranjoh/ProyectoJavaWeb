/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Colabora;
import persistencia.ColaboraFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ColaboraLogica implements ColaboraLogicaLocal {

    @EJB
    ColaboraFacadeLocal colaboraDAO;
    
    @Override
    public void registrarColaboracion(Colabora colabora) throws Exception {
        
    }

    @Override
    public void modificarColaboracion(Colabora colabora) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarColaboracion(Colabora colabora) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Colabora> consultarTodas() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
