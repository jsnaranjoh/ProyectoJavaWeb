/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ingsoftwaresistemaoperativo;
import persistencia.IngsoftwaresistemaoperativoFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class IngsoftwaresistemaoperativoLogica implements IngsoftwaresistemaoperativoLogicaLocal {

    @EJB
    IngsoftwaresistemaoperativoFacadeLocal sistemaoperativoDAO;
    
    @Override
    public void registrarSistemaoperativo(Ingsoftwaresistemaoperativo sistemaoperativo) throws Exception {
        if(sistemaoperativo.getIngsoftware().getCedula() == null){
            throw new Exception("Debes seleccionar un Ingeniero Software.");
        }
        if(sistemaoperativo.getIngsoftwaresistemaoperativoPK().getSistemaoperativo().equals("")){
            throw new Exception("Campo Sistema Operativo Obligatorio.");
        }
        
        Ingsoftwaresistemaoperativo objSistemaoperativo = sistemaoperativoDAO.find(sistemaoperativo.getIngsoftwaresistemaoperativoPK());
        if(objSistemaoperativo != null){
            throw new Exception("Sistema Operativo de Ingeniero Software ya existe.");
        }
        else{
            sistemaoperativoDAO.create(sistemaoperativo);
        }
    }

    @Override
    public void modificarSistemaoperativo(Ingsoftwaresistemaoperativo sistemaoperativo) throws Exception {
        if(sistemaoperativo.getIngsoftware().getCedula() == null){
            throw new Exception("Debes seleccionar un Ingeniero Software.");
        }
        if(sistemaoperativo.getIngsoftwaresistemaoperativoPK().getSistemaoperativo().equals("")){
            throw new Exception("Campo Sistema Operativo Obligatorio.");
        }
        
        Ingsoftwaresistemaoperativo objSistemaoperativo = sistemaoperativoDAO.find(sistemaoperativo.getIngsoftwaresistemaoperativoPK());
        if(objSistemaoperativo == null){
            throw new Exception("Sistema Operativo de Ingeniero Software a modificar no existe.");
        }
        else{
            objSistemaoperativo.getIngsoftwaresistemaoperativoPK().setSistemaoperativo(sistemaoperativo.getIngsoftwaresistemaoperativoPK().getSistemaoperativo());
            sistemaoperativoDAO.edit(objSistemaoperativo);
        }
    }

    @Override
    public void eliminarSistemaoperativo(Ingsoftwaresistemaoperativo sistemaoperativo) throws Exception {
        Ingsoftwaresistemaoperativo objSistemaoperativo = sistemaoperativoDAO.find(sistemaoperativo.getIngsoftwaresistemaoperativoPK());
        
        if(objSistemaoperativo == null){
            throw new Exception("Sistema Operativo de Ingeniero Software a eliminar no existe.");
        }
        else{
            sistemaoperativoDAO.remove(sistemaoperativo);
        }
    }

    @Override
    public List<Ingsoftwaresistemaoperativo> consultarTodos() throws Exception {
        return sistemaoperativoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
