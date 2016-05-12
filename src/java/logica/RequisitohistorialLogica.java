/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Requisito;
import modelo.Requisitohistorial;
import persistencia.RequisitohistorialFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class RequisitohistorialLogica implements RequisitohistorialLogicaLocal {

    @EJB
    RequisitohistorialFacadeLocal requisitoHDAO;
    
    @Override
    public void registrarRequisitohistorial(Requisitohistorial requisitoH) throws Exception {
        requisitoHDAO.create(requisitoH);
    }

    @Override
    public void eliminarRequisitohistorial(Requisitohistorial requisitoH) throws Exception {
        requisitoHDAO.remove(requisitoH);
    }

    @Override
    public List<Requisitohistorial> consultarTodos() throws Exception {
        return requisitoHDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
