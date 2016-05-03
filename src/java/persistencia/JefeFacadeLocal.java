/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Jefe;

/**
 *
 * @author NOREÑA
 */
@Local
public interface JefeFacadeLocal {

    void create(Jefe jefe);

    void edit(Jefe jefe);

    void remove(Jefe jefe);

    Jefe find(Object id);

    List<Jefe> findAll();

    List<Jefe> findRange(int[] range);

    int count();
    
}
