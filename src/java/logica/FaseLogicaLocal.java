/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Fase;

/**
 *
 * @author crisd
 */
@Local
public interface FaseLogicaLocal {
   public List<Fase> consultarFases() throws Exception; 
}
