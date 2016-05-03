/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Proyectosgbd;

/**
 *
 * @author jsnar
 */
@Stateless
public class ProyectosgbdFacade extends AbstractFacade<Proyectosgbd> implements ProyectosgbdFacadeLocal {

    @PersistenceContext(unitName = "ProyectoJavaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosgbdFacade() {
        super(Proyectosgbd.class);
    }
    
}
