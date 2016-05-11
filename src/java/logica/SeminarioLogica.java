/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Seminario;
import persistencia.SeminarioFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class SeminarioLogica implements SeminarioLogicaLocal {

    @EJB
    SeminarioFacadeLocal seminarioDAO;
    
    @Override
    public void registrarSeminario(Seminario seminario) throws Exception {
        if(seminario.getIngeniero().getCedula() == null){
            throw new Exception("Campo Ingeniero Software Obligatorio.");
        }
        if(seminario.getNombre().equals("")){
            throw new Exception("Campo Nombre Seminario Obligatorio.");
        }
        if(seminario.getLugar().equals("")){
            throw new Exception("Campo Lugar Seminario Obligatorio.");
        }
        if(seminario.getFechainicio() == null){
            throw new Exception("Campo Fecha de inicio de Seminario Obligatorio.");
        }
        if(seminario.getFechafin() == null){
            throw new Exception("Campo Fecha de fin de Seminario Obligatorio.");
        }
        
        Seminario objSeminario = seminarioDAO.find(seminario.getNumero());
        if(objSeminario != null){
            throw new Exception("Seminario ya existe.");
        }
        else{
            seminarioDAO.create(seminario);
        }
    }

    @Override
    public void modificarSeminario(Seminario seminario) throws Exception {
        if(seminario.getIngeniero().getCedula() == null){
            throw new Exception("Campo Ingeniero Software Obligatorio.");
        }
        if(seminario.getNombre().equals("")){
            throw new Exception("Campo Nombre Seminario Obligatorio.");
        }
        if(seminario.getLugar().equals("")){
            throw new Exception("Campo Lugar Seminario Obligatorio.");
        }
        if(seminario.getFechainicio() == null){
            throw new Exception("Campo Fecha de inicio de Seminario Obligatorio.");
        }
        if(seminario.getFechafin() == null){
            throw new Exception("Campo Fecha de fin de Seminario Obligatorio.");
        }
        
        Seminario objSeminario = seminarioDAO.find(seminario.getNumero());
        if(objSeminario == null){
            throw new Exception("Seminario a modificar no existe.");
        }
        else{
            objSeminario.setNombre(seminario.getNombre());
            objSeminario.setLugar(seminario.getLugar());
            objSeminario.setFechainicio(seminario.getFechainicio());
            objSeminario.setFechafin(seminario.getFechafin());
            seminarioDAO.edit(seminario);
        }
    }

    @Override
    public void eliminarSeminario(Seminario seminario) throws Exception {
        Seminario objSeminario = seminarioDAO.find(seminario.getNumero());
        if(objSeminario == null){
            throw new Exception("Seminario a eliminar no existe.");
        }
        else{
            seminarioDAO.remove(seminario);
        }
    }

    @Override
    public List<Seminario> consultarTodos() throws Exception {
        return seminarioDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
