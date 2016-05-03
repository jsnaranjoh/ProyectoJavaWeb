/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Proyectosistemaoperativo;

/**
 *
 * @author jsnar
 */
@Local
public interface ProyectosistemaoperativoFacadeLocal {

    void create(Proyectosistemaoperativo proyectosistemaoperativo);

    void edit(Proyectosistemaoperativo proyectosistemaoperativo);

    void remove(Proyectosistemaoperativo proyectosistemaoperativo);

    Proyectosistemaoperativo find(Object id);

    List<Proyectosistemaoperativo> findAll();

    List<Proyectosistemaoperativo> findRange(int[] range);

    int count();
    
}
