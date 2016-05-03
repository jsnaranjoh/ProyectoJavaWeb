/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingsoftwarelenguajeprog;

/**
 *
 * @author jsnar
 */
@Local
public interface IngsoftwarelenguajeprogFacadeLocal {

    void create(Ingsoftwarelenguajeprog ingsoftwarelenguajeprog);

    void edit(Ingsoftwarelenguajeprog ingsoftwarelenguajeprog);

    void remove(Ingsoftwarelenguajeprog ingsoftwarelenguajeprog);

    Ingsoftwarelenguajeprog find(Object id);

    List<Ingsoftwarelenguajeprog> findAll();

    List<Ingsoftwarelenguajeprog> findRange(int[] range);

    int count();
    
}
