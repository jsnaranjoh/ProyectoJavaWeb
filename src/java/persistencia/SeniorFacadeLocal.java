/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Senior;

/**
 *
 * @author jsnar
 */
@Local
public interface SeniorFacadeLocal {

    void create(Senior senior);

    void edit(Senior senior);

    void remove(Senior senior);

    Senior find(Object id);

    List<Senior> findAll();

    List<Senior> findRange(int[] range);

    int count();
    
}
