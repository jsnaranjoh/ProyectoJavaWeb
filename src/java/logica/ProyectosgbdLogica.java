/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Proyectosgbd;
import persistencia.ProyectosgbdFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ProyectosgbdLogica implements ProyectosgbdLogicaLocal {

    @EJB
    ProyectosgbdFacadeLocal sgbdDAO;
    
    @Override
    public void registrarSGBD(Proyectosgbd sgbd) throws Exception {
        if(sgbd.getProyecto().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto.");
        }
        if(sgbd.getProyectosgbdPK().getSgbd().equals("")){
            throw new Exception("Campo Sistema Gestor de Base de Datos Obligatorio.");
        }
        
        Proyectosgbd objSgbd = sgbdDAO.find(sgbd);
        if(objSgbd != null){
            throw new Exception("Sistema Gestor de Base de Datos del Proyecto ya existe.");
        }
        else{
            sgbdDAO.create(sgbd);
        }
    }

    @Override
    public void modificarSGBD(Proyectosgbd sgbd) throws Exception {
        if(sgbd.getProyecto().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto.");
        }
        if(sgbd.getProyectosgbdPK().getSgbd().equals("")){
            throw new Exception("Campo Sistema Gestor de Base de Datos Obligatorio.");
        }
        
        Proyectosgbd objSgbd = sgbdDAO.find(sgbd);
        if(objSgbd == null){
            throw new Exception("Sistema Gestor de Base de Datos del Proyecto a modificar no existe.");
        }
        else{
            objSgbd.getProyectosgbdPK().setSgbd(sgbd.getProyectosgbdPK().getSgbd());
            sgbdDAO.edit(sgbd);
        }
    }

    @Override
    public void eliminarSGBD(Proyectosgbd sgbd) throws Exception {
        Proyectosgbd objSgbd = sgbdDAO.find(sgbd.getProyectosgbdPK());
        
        if(objSgbd == null){
            throw new Exception("Sistema Gestor de Base de Datos del Proyecto a eliminar no existe.");
        }
        else{
            sgbdDAO.remove(sgbd);
        }
    }

    @Override
    public List<Proyectosgbd> consultarTodos() throws Exception {
        return sgbdDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
