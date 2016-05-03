/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Colabora;

/**
 *
 * @author NOREÑA
 */
@Local
public interface ColaboraFacadeLocal {

    void create(Colabora colabora);

    void edit(Colabora colabora);

    void remove(Colabora colabora);

    Colabora find(Object id);

    List<Colabora> findAll();

    List<Colabora> findRange(int[] range);

    int count();
    
}
