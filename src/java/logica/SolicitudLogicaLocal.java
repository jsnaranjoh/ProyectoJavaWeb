/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Solicitud;

/**
 *
 * @author NOREÑA
 */
@Local
public interface SolicitudLogicaLocal {
    
    public void registrarSolicitud(Solicitud solicitud) throws Exception;
    public void modificarSolicitud(Solicitud solicitud) throws Exception;
    public void eliminarSolicitud(Solicitud solicitud) throws Exception;
    public List<Solicitud> consultarTodas() throws Exception;
    
}
