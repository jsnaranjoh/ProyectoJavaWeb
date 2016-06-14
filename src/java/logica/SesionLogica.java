/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Jefe;
import modelo.Senior;
import modelo.Junior;
import org.apache.commons.codec.digest.DigestUtils;
import persistencia.JefeFacadeLocal;
import persistencia.SeniorFacadeLocal;
import persistencia.JuniorFacadeLocal;

/**
 *
 * @author jsnar
 */
@Stateless
public class SesionLogica implements SesionLogicaLocal {
    @EJB
    private JefeFacadeLocal jefeDAO;
    
    @EJB
    private SeniorFacadeLocal seniorDAO;
    
    @EJB
    private JuniorFacadeLocal juniorDAO;

    @Override
    public void buscarCamposInvalidosOVacios(Integer documento, String clave) throws Exception {
        if(documento==null) {
            throw new Exception("Ingrese un usuario válido.");
        }
        if(clave.equals("")) {
            throw new Exception("La clave es obligatoria.");
        }
    }
    
    @Override
    public Jefe iniciarSesionJefe(Integer documento, String clave) throws Exception {
        Jefe j = jefeDAO.find(documento);
        if(j!=null) {
            String claveEncriptada = DigestUtils.md5Hex(clave);
            if(!j.getIngsoftware().getClave().equals(claveEncriptada)) {
                throw new Exception("La clave es incorrecta.");
            }
        }
        return j;
    }

    @Override
    public Senior iniciarSesionSenior(Integer documento, String clave) throws Exception {
        Senior s = seniorDAO.find(documento);
        if(s!=null) {
            String claveEncriptada = DigestUtils.md5Hex(clave);
            if(!s.getIngsoftware().getClave().equals(claveEncriptada)) {
                throw new Exception("La clave es incorrecta.");
            }
        }
        return s;
    }
    
    @Override
    public Junior iniciarSesionJunior(Integer documento, String clave) throws Exception {
        Junior j = juniorDAO.find(documento);
        if(j!=null) {
            String claveEncriptada = DigestUtils.md5Hex(clave);
            if(!j.getIngsoftware().getClave().equals(claveEncriptada)) {
                throw new Exception("La clave es incorrecta.");
            }
        }
        return j;
    }
}