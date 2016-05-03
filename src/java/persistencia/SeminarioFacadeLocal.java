/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Seminario;

/**
 *
 * @author jsnar
 */
@Local
public interface SeminarioFacadeLocal {

    void create(Seminario seminario);

    void edit(Seminario seminario);

    void remove(Seminario seminario);

    Seminario find(Object id);

    List<Seminario> findAll();

    List<Seminario> findRange(int[] range);

    int count();
    
}
