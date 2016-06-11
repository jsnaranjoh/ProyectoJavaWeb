/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Ingsoftwaresistemaoperativo;

/**
 *
 * @author crisd
 */
@Local
public interface IngsoftwaresistemaoperativoFacadeLocal {

    void create(Ingsoftwaresistemaoperativo ingsoftwaresistemaoperativo);

    void edit(Ingsoftwaresistemaoperativo ingsoftwaresistemaoperativo);

    void remove(Ingsoftwaresistemaoperativo ingsoftwaresistemaoperativo);

    Ingsoftwaresistemaoperativo find(Object id);

    List<Ingsoftwaresistemaoperativo> findAll();

    List<Ingsoftwaresistemaoperativo> findRange(int[] range);

    int count();
    
}
