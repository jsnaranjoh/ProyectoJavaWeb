/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Proyectolenguajeprog;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ProyectolenguajeprogFacade extends AbstractFacade<Proyectolenguajeprog> implements ProyectolenguajeprogFacadeLocal {

    @PersistenceContext(unitName = "ProyectoJavaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectolenguajeprogFacade() {
        super(Proyectolenguajeprog.class);
    }
    
}
