/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Solicitud;
import persistencia.SolicitudFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class SolicitudLogica implements SolicitudLogicaLocal {

    @EJB
    SolicitudFacadeLocal solicitudDAO;
    
    @Override
    public void registrarSolicitud(Solicitud solicitud) throws Exception {
        if(solicitud.getNumero() == null || solicitud.getNumero() == 0){
            throw new Exception("Campo Número Solicitud Obligatorio.");
        }
        if(solicitud.getRequisito().getCodigo() == null){
            throw new Exception("Debes seleccionar el Requisito al cual se le realiza la Solicitud.");
        }
        if(solicitud.getVerificador().getCedula() == null){
            throw new Exception("Debes seleccionar el Jefe que verifica la Solicitud.");
        }
        if(solicitud.getSolicitante().getCedula() == null){
            throw new Exception("Debes seleccionar el Ingeniero de Software que realiza la Solicitud.");
        }
        if(solicitud.getTipo().equals("0")){
            throw new Exception("Campo Tipo Solicitud Obligatorio.");
        }
        if(solicitud.getTitulo().equals("")){
            throw new Exception("Campo Título Solicitud Obligatorio.");
        }
        if(solicitud.getFecha() == null){
            throw new Exception("Campo Fecha Solicitud Obligatorio.");
        }
        // Campo Origen sí puede ir vacío
        if(solicitud.getEstado().equals("0")){
            throw new Exception("Campo Estado Solicitud Obligatorio.");
        }
        if(solicitud.getPrioridadsolicitante() == 0){
            throw new Exception("Campo Prioridad Solicitante Obligatorio.");
        }
        if(solicitud.getPrioridadrealizacion() == 0){
            throw new Exception("Campo Prioridad Realización de Solicitud Obligatorio.");
        }
        if(solicitud.getFechaultimaactualizacion() == null){
            throw new Exception("Campo Fecha de Última Actualización de Solicitud Obligatorio.");
        }
        if(solicitud.getRelease().equals("")){
            throw new Exception("Campo Release de Solicitud Obligatorio.");
        }
        if(solicitud.getEsfuerzo() == 0){
            throw new Exception("Campo Esfuerzo Solicitud Obligatorio.");
        }
        if(solicitud.getDescripcion().equals("")){
            throw new Exception("Campos Descripción de Solicitud Obligatorio.");
        }
        // Campo Comentarios sí puede ir vacío
        
        Solicitud objSolicitud = solicitudDAO.find(solicitud.getNumero());
        if(objSolicitud != null){
            throw new Exception("Solicitud ya existe.");
        }
        else{
            solicitudDAO.create(solicitud);
        }
    }

    @Override
    public void modificarSolicitud(Solicitud solicitud) throws Exception {
        if(solicitud.getNumero() == null || solicitud.getNumero() == 0){
            throw new Exception("Campo Número Solicitud Obligatorio.");
        }
        if(solicitud.getRequisito().getCodigo() == null){
            throw new Exception("Debes seleccionar el Requisito al cual se le realiza la Solicitud.");
        }
        if(solicitud.getVerificador().getCedula() == null){
            throw new Exception("Debes seleccionar el Jefe que verifica la Solicitud.");
        }
        if(solicitud.getSolicitante().getCedula() == null){
            throw new Exception("Debes seleccionar el Ingeniero de Software que realiza la Solicitud.");
        }
        if(solicitud.getTipo().equals("0")){
            throw new Exception("Campo Tipo Solicitud Obligatorio.");
        }
        if(solicitud.getTitulo().equals("")){
            throw new Exception("Campo Título Solicitud Obligatorio.");
        }
        if(solicitud.getFecha() == null){
            throw new Exception("Campo Fecha Solicitud Obligatorio.");
        }
        // Campo Origen sí puede ir vacío
        if(solicitud.getEstado().equals("0")){
            throw new Exception("Campo Estado Solicitud Obligatorio.");
        }
        if(solicitud.getPrioridadsolicitante() == 0){
            throw new Exception("Campo Prioridad Solicitante Obligatorio.");
        }
        if(solicitud.getPrioridadrealizacion() == 0){
            throw new Exception("Campo Prioridad Realización de Solicitud Obligatorio.");
        }
        if(solicitud.getFechaultimaactualizacion() == null){
            throw new Exception("Campo Fecha de Última Actualización de Solicitud Obligatorio.");
        }
        if(solicitud.getRelease().equals("")){
            throw new Exception("Campo Release de Solicitud Obligatorio.");
        }
        if(solicitud.getEsfuerzo() == 0){
            throw new Exception("Campo Esfuerzo Solicitud Obligatorio.");
        }
        if(solicitud.getDescripcion().equals("")){
            throw new Exception("Campos Descripción de Solicitud Obligatorio.");
        }
        // Campo Comentarios sí puede ir vacío
        
        Solicitud objSolicitud = solicitudDAO.find(solicitud.getNumero());
        if(objSolicitud == null){
            throw new Exception("Solicitud a modificar no existe.");
        }
        else{
            objSolicitud.setRequisito(solicitud.getRequisito());
            objSolicitud.setVerificador(solicitud.getVerificador());
            objSolicitud.setSolicitante(solicitud.getSolicitante());
            objSolicitud.setTipo(solicitud.getTipo());
            objSolicitud.setTitulo(solicitud.getTitulo());
            objSolicitud.setFecha(solicitud.getFecha());
            objSolicitud.setOrigen(solicitud.getOrigen());
            objSolicitud.setEstado(solicitud.getEstado());
            objSolicitud.setPrioridadsolicitante(solicitud.getPrioridadsolicitante());
            objSolicitud.setPrioridadrealizacion(solicitud.getPrioridadrealizacion());
            objSolicitud.setFechaultimaactualizacion(solicitud.getFechaultimaactualizacion());
            objSolicitud.setRelease(solicitud.getRelease());
            objSolicitud.setEsfuerzo(solicitud.getEsfuerzo());
            objSolicitud.setDescripcion(solicitud.getDescripcion());
            objSolicitud.setComentarios(solicitud.getComentarios());
            solicitudDAO.edit(objSolicitud);
        }
    }

    @Override
    public void eliminarSolicitud(Solicitud solicitud) throws Exception {
        if(solicitud.getNumero() == null || solicitud.getNumero() == 0){
            throw new Exception("Campo Número Solicitud Obligatorio.");
        }
        
        Solicitud objSolicitud = solicitudDAO.find(solicitud.getNumero());
        if(objSolicitud == null){
            throw new Exception("Solicitud a eliminar no existe.");
        }
        else{
            solicitudDAO.remove(solicitud);
        }
    }

    @Override
    public List<Solicitud> consultarTodas() throws Exception {
        return solicitudDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
