/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingsoftwaresgbd;

/**
 *
 * @author NOREÑA
 */
@Local
public interface IngsoftwaresgbdFacadeLocal {

    void create(Ingsoftwaresgbd ingsoftwaresgbd);

    void edit(Ingsoftwaresgbd ingsoftwaresgbd);

    void remove(Ingsoftwaresgbd ingsoftwaresgbd);

    Ingsoftwaresgbd find(Object id);

    List<Ingsoftwaresgbd> findAll();

    List<Ingsoftwaresgbd> findRange(int[] range);

    int count();
    
}
