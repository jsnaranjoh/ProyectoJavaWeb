/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Proyectosgbd;

/**
 *
 * @author NOREÑA
 */
@Local
public interface ProyectosgbdFacadeLocal {

    void create(Proyectosgbd proyectosgbd);

    void edit(Proyectosgbd proyectosgbd);

    void remove(Proyectosgbd proyectosgbd);

    Proyectosgbd find(Object id);

    List<Proyectosgbd> findAll();

    List<Proyectosgbd> findRange(int[] range);

    int count();
    
}
