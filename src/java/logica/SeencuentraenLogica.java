/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Seencuentraen;
import persistencia.SeencuentraenFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class SeencuentraenLogica implements SeencuentraenLogicaLocal {

    @EJB
    SeencuentraenFacadeLocal desarrolloDAO;
    
    @Override
    public void registrarDesarrollo(Seencuentraen desarrollo) throws Exception {
        if(desarrollo.getProyecto1().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto que se encuentra en desarrollo.");
        }
        if(desarrollo.getFase1().getCodigo() == null){
            throw new Exception("Debes seleccionar una fase en la que el Proyecto se encuentra desarrollado");
        }
        if(desarrollo.getFechainicio() == null){
            throw new Exception("Campo Fecha Inicio de Desarrollo Obligatorio.");
        }
        if(desarrollo.getFechafin() == null){
            throw new Exception("Campo Fecha Fin de Desarrollo Obligatorio.");
        }
        
        Seencuentraen objDesarrollo = desarrolloDAO.find(desarrollo.getSeencuentraenPK());
        if(objDesarrollo != null){
            throw new Exception("Desarrollo ya existe.");
        }
        else{
            desarrolloDAO.create(desarrollo);
        }
    }

    @Override
    public void modificarDesarrollo(Seencuentraen desarrollo) throws Exception {
        if(desarrollo.getProyecto1().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto que se encuentra en desarrollo.");
        }
        if(desarrollo.getFase1().getCodigo() == null){
            throw new Exception("Debes seleccionar una fase en la que el Proyecto se encuentra desarrollado");
        }
        if(desarrollo.getFechainicio() == null){
            throw new Exception("Campo Fecha Inicio de Desarrollo Obligatorio.");
        }
        if(desarrollo.getFechafin() == null){
            throw new Exception("Campo Fecha Fin de Desarrollo Obligatorio.");
        }
        
        Seencuentraen objDesarrollo = desarrolloDAO.find(desarrollo.getSeencuentraenPK());
        if(objDesarrollo == null){
            throw new Exception("Desarrollo a modificar no existe.");
        }
        else{
            objDesarrollo.setFechainicio(desarrollo.getFechainicio());
            objDesarrollo.setFechafin(desarrollo.getFechafin());
            desarrolloDAO.edit(desarrollo);
        }
    }

    @Override
    public void eliminarDesarrollo(Seencuentraen desarrollo) throws Exception {
        Seencuentraen objDesarrollo = desarrolloDAO.find(desarrollo.getSeencuentraenPK());
        if(objDesarrollo == null){
            throw new Exception("Desarrollo a eliminar no existe.");
        }
        else{
            desarrolloDAO.remove(desarrollo);
        }
    }

    @Override
    public List<Seencuentraen> consultarTodos() throws Exception {
        return desarrolloDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
