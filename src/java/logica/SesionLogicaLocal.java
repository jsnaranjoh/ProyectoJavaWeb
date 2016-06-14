/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import javax.ejb.Local;
import modelo.Jefe;
import modelo.Senior;
import modelo.Junior;

/**
 *
 * @author jsnar
 */
@Local
public interface SesionLogicaLocal {
    public void buscarCamposInvalidosOVacios(Integer documento, String clave) throws Exception;
    public Jefe iniciarSesionJefe(Integer documento, String clave) throws Exception;
    public Senior iniciarSesionSenior(Integer documento, String clave) throws Exception;
    public Junior iniciarSesionJunior(Integer documento, String clave) throws Exception;
}
