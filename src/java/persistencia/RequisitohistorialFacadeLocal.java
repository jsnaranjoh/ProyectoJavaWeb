/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Requisitohistorial;

/**
 *
 * @author NOREÑA
 */
@Local
public interface RequisitohistorialFacadeLocal {

    void create(Requisitohistorial requisitohistorial);

    void edit(Requisitohistorial requisitohistorial);

    void remove(Requisitohistorial requisitohistorial);

    Requisitohistorial find(Object id);

    List<Requisitohistorial> findAll();

    List<Requisitohistorial> findRange(int[] range);

    int count();
    
}
