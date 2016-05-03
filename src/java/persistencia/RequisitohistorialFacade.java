/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Requisitohistorial;

/**
 *
 * @author jsnar
 */
@Stateless
public class RequisitohistorialFacade extends AbstractFacade<Requisitohistorial> implements RequisitohistorialFacadeLocal {

    @PersistenceContext(unitName = "ProyectoJavaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequisitohistorialFacade() {
        super(Requisitohistorial.class);
    }
    
}
