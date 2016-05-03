/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Seencuentraen;

/**
 *
 * @author NOREÑA
 */
@Local
public interface SeencuentraenFacadeLocal {

    void create(Seencuentraen seencuentraen);

    void edit(Seencuentraen seencuentraen);

    void remove(Seencuentraen seencuentraen);

    Seencuentraen find(Object id);

    List<Seencuentraen> findAll();

    List<Seencuentraen> findRange(int[] range);

    int count();
    
}
