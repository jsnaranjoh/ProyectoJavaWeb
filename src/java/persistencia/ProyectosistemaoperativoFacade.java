/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Proyectosistemaoperativo;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ProyectosistemaoperativoFacade extends AbstractFacade<Proyectosistemaoperativo> implements ProyectosistemaoperativoFacadeLocal {

    @PersistenceContext(unitName = "ProyectoJavaWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosistemaoperativoFacade() {
        super(Proyectosistemaoperativo.class);
    }
    
}
