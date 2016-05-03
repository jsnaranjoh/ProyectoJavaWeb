/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Ingsoftwarelenguajeprog;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class IngsoftwarelenguajeprogFacade extends AbstractFacade<Ingsoftwarelenguajeprog> implements IngsoftwarelenguajeprogFacadeLocal {

    @PersistenceContext(unitName = "ProyectoJavaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngsoftwarelenguajeprogFacade() {
        super(Ingsoftwarelenguajeprog.class);
    }
    
}
