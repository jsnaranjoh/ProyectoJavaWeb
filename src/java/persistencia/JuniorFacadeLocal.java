/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Junior;

/**
 *
 * @author jsnar
 */
@Local
public interface JuniorFacadeLocal {

    void create(Junior junior);

    void edit(Junior junior);

    void remove(Junior junior);

    Junior find(Object id);

    List<Junior> findAll();

    List<Junior> findRange(int[] range);

    int count();
    
}
