/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Requisito;
import persistencia.RequisitoFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class RequisitoLogica implements RequisitoLogicaLocal {

    @EJB
    RequisitoFacadeLocal requisitoDAO;
    
    @Override
    public void registrarRequisito(Requisito requisito) throws Exception {
        if(requisito.getCodigo() == null || requisito.getCodigo() == 0){
            throw new Exception("Campo Código Requisito Obligatorio.");
        }
        if(requisito.getProyecto().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto a realizar el requisito.");
        }
        if(requisito.getDescripcion().equals("")){
            throw new Exception("Campo Descripción del Requisito Obligatorio.");
        }
        if(requisito.getTipo().equals("0")){
            throw new Exception("Campo Tipo de Requisito Obligatorio.");
        }
        if(requisito.getEstado().equals("0")){
            throw new Exception("Campo Estado de Requisito Obligatorio.");
        }
        
        Requisito objRequisito = requisitoDAO.find(requisito.getCodigo());
        if(objRequisito != null){
            throw new Exception("Requisito ya existe.");
        }
        else{
            requisitoDAO.create(requisito);
        }
    }

    @Override
    public void modificarRequisito(Requisito requisito) throws Exception {
        if(requisito.getCodigo() == null || requisito.getCodigo() == 0){
            throw new Exception("Campo Código Requisito Obligatorio.");
        }
        if(requisito.getProyecto().getCodigo() == null){
            throw new Exception("Debes seleccionar un Proyecto a realizar el requisito.");
        }
        if(requisito.getDescripcion().equals("")){
            throw new Exception("Campo Descripción del Requisito Obligatorio.");
        }
        if(requisito.getTipo().equals("")){
            throw new Exception("Campo Tipo de Requisito Obligatorio.");
        }
        if(requisito.getEstado().equals("")){
            throw new Exception("Campo Estado de Requisito Obligatorio.");
        }
        
        Requisito objRequisito = requisitoDAO.find(requisito.getCodigo());
        if(objRequisito == null){
            throw new Exception("Requisito a modificar no existe.");
        }
        else{
            objRequisito.setProyecto(requisito.getProyecto());
            objRequisito.setDescripcion(requisito.getDescripcion());
            objRequisito.setTipo(requisito.getTipo());
            objRequisito.setEstado(requisito.getEstado());
            requisitoDAO.edit(objRequisito);
        }
    }

    @Override
    public void eliminarRequisito(Requisito requisito) throws Exception {
        if(requisito.getCodigo() == null || requisito.getCodigo() == 0){
            throw new Exception("Campo Código Requisito Obligatorio.");
        }
        
        Requisito objRequisito = requisitoDAO.find(requisito.getCodigo());
        
        if(objRequisito == null){
            throw new Exception("Requisito a eliminar no existe.");
        }
        else{
            if(objRequisito.getRequisitohistorialList().size() > 0){
                throw new Exception("Este Requisito tiene otros asociados. Elimínelos primero.");
            }
            if(objRequisito.getSolicitudList().size() > 0){
                throw new Exception("Este Requisito tiene solicitudes asociadas. Elimínelas primero.");
            }
            requisitoDAO.remove(requisito);
        }
    }

    @Override
    public List<Requisito> consultarTodos() throws Exception {
        return requisitoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
