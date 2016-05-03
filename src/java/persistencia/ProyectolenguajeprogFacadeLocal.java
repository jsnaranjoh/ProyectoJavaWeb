/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Proyectolenguajeprog;

/**
 *
 * @author jsnar
 */
@Local
public interface ProyectolenguajeprogFacadeLocal {

    void create(Proyectolenguajeprog proyectolenguajeprog);

    void edit(Proyectolenguajeprog proyectolenguajeprog);

    void remove(Proyectolenguajeprog proyectolenguajeprog);

    Proyectolenguajeprog find(Object id);

    List<Proyectolenguajeprog> findAll();

    List<Proyectolenguajeprog> findRange(int[] range);

    int count();
    
}
