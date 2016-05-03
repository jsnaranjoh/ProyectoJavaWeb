/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Gradoacademico;

/**
 *
 * @author jsnar
 */
@Stateless
public class GradoacademicoFacade extends AbstractFacade<Gradoacademico> implements GradoacademicoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoJavaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GradoacademicoFacade() {
        super(Gradoacademico.class);
    }
    
}
