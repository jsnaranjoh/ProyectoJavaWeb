/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Fase;

/**
 *
 * @author jsnar
 */
@Local
public interface FaseFacadeLocal {

    void create(Fase fase);

    void edit(Fase fase);

    void remove(Fase fase);

    Fase find(Object id);

    List<Fase> findAll();

    List<Fase> findRange(int[] range);

    int count();
    
}
