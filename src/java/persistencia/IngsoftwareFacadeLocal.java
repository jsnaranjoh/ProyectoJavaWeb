/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingsoftware;

/**
 *
 * @author NOREÑA
 */
@Local
public interface IngsoftwareFacadeLocal {

    void create(Ingsoftware ingsoftware);

    void edit(Ingsoftware ingsoftware);

    void remove(Ingsoftware ingsoftware);

    Ingsoftware find(Object id);

    List<Ingsoftware> findAll();

    List<Ingsoftware> findRange(int[] range);

    int count();
    
}
