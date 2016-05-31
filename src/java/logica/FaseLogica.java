/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Fase;
import persistencia.FaseFacadeLocal;

/**
 *
 * @author crisd
 */
@Stateless
public class FaseLogica implements FaseLogicaLocal {

    @EJB
    FaseFacadeLocal faseDAO;
    
    @Override
    public List<Fase> consultarFases() throws Exception {
        return faseDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
