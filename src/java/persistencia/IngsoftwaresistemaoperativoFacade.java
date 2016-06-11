/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Ingsoftwaresistemaoperativo;

/**
 *
 * @author crisd
 */
@Stateless
public class IngsoftwaresistemaoperativoFacade extends AbstractFacade<Ingsoftwaresistemaoperativo> implements IngsoftwaresistemaoperativoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoJavaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngsoftwaresistemaoperativoFacade() {
        super(Ingsoftwaresistemaoperativo.class);
    }
    
}
