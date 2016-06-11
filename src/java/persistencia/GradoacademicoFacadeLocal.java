/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Gradoacademico;

/**
 *
 * @author crisd
 */
@Local
public interface GradoacademicoFacadeLocal {

    void create(Gradoacademico gradoacademico);

    void edit(Gradoacademico gradoacademico);

    void remove(Gradoacademico gradoacademico);

    Gradoacademico find(Object id);

    List<Gradoacademico> findAll();

    List<Gradoacademico> findRange(int[] range);

    int count();
    
}
