/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Proyectosistemaoperativo;
import persistencia.ProyectosistemaoperativoFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ProyectosistemaoperativoLogica implements ProyectosistemaoperativoLogicaLocal {

    @EJB
    ProyectosistemaoperativoFacadeLocal sistemaoperativoDAO;
    
    @Override
    public void registrarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception {
        if(sistemaoperativo.getProyecto().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto.");
        }
        if(sistemaoperativo.getProyectosistemaoperativoPK().getSistemaoperativo().equals("")){
            throw new Exception("Campo Sistema Operativo Obligatorio.");
        }
        
        Proyectosistemaoperativo objSistemaoperativo = sistemaoperativoDAO.find(sistemaoperativo.getProyectosistemaoperativoPK());
        if(objSistemaoperativo != null){
            throw new Exception("Sistema Operativo del Proyecto ya existe.");
        }
        else{
            sistemaoperativoDAO.create(sistemaoperativo);
        }
    }

    @Override
    public void modificarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception {
        if(sistemaoperativo.getProyecto().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto.");
        }
        if(sistemaoperativo.getProyectosistemaoperativoPK().getSistemaoperativo().equals("")){
            throw new Exception("Campo Sistema Operativo Obligatorio.");
        }
        
        Proyectosistemaoperativo objSistemaoperativo = sistemaoperativoDAO.find(sistemaoperativo.getProyectosistemaoperativoPK());
        if(objSistemaoperativo == null){
            throw new Exception("Sistema Operativo del Proyecto a modificar no existe.");
        }
        else{
            objSistemaoperativo.getProyectosistemaoperativoPK().setSistemaoperativo(sistemaoperativo.getProyectosistemaoperativoPK().getSistemaoperativo());            
            sistemaoperativoDAO.edit(objSistemaoperativo);
        }
    }

    @Override
    public void eliminarSistemaoperativo(Proyectosistemaoperativo sistemaoperativo) throws Exception {
        Proyectosistemaoperativo objSistemaoperativo = sistemaoperativoDAO.find(sistemaoperativo.getProyectosistemaoperativoPK());
        
        if(objSistemaoperativo == null){
            throw new Exception("Sistema Operativo del Proyecto a eliminar no existe.");
        }
        else{
            sistemaoperativoDAO.remove(sistemaoperativo);
        }
    }

    @Override
    public List<Proyectosistemaoperativo> consultarTodos() throws Exception {
        return sistemaoperativoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
