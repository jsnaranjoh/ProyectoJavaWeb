/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Colabora;
import persistencia.ColaboraFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ColaboraLogica implements ColaboraLogicaLocal {

    @EJB
    ColaboraFacadeLocal colaboraDAO;
    
    @Override
    public void registrarColaboracion(Colabora colabora) throws Exception {
        if(colabora.getJunior1().getCedula() == null){
            throw new Exception("Debes registrar un Ingeniero Junior.");
        }
        if(colabora.getProyecto1().getCodigo() == null){
            throw new Exception("Debes registrar un Proyecto.");
        }
        if(colabora.getFechainicio() == null){
            throw new Exception("Campo Fecha Inicio Colaboración Obligatorio.");
        }
        if(colabora.getFechafin() == null){
            throw new Exception("Campo Fecha Fin Colaboración Obligatorio.");
        }
        
        Colabora objColabora = colaboraDAO.find(colabora);
        if(objColabora != null){
            throw new Exception("Colaboración ya existe.");
        }
        else{
            colaboraDAO.create(colabora);
        }
    }

    @Override
    public void modificarColaboracion(Colabora colabora) throws Exception {
        if(colabora.getJunior1().getCedula() == null){
            throw new Exception("Debes registrar un Ingeniero Junior.");
        }
        if(colabora.getProyecto1().getCodigo() == null){
            throw new Exception("Debes registrar un Proyecto.");
        }
        if(colabora.getFechainicio() == null){
            throw new Exception("Campo Fecha Inicio Colaboración Obligatorio.");
        }
        if(colabora.getFechafin() == null){
            throw new Exception("Campo Fecha Fin Colaboración Obligatorio.");
        }
        
        Colabora objColabora = colaboraDAO.find(colabora);
        if(objColabora == null){
            throw new Exception("Colaboración a modificar no existe.");
        }
        else{
            objColabora.setFechainicio(colabora.getFechainicio());
            objColabora.setFechafin(colabora.getFechafin());
            objColabora.setHorasdedicadas(colabora.getHorasdedicadas());
            colaboraDAO.edit(colabora);
        }
    }

    @Override
    public void eliminarColaboracion(Colabora colabora) throws Exception {
        Colabora objColabora = colaboraDAO.find(colabora.getColaboraPK());
        
        if(objColabora == null){
            throw new Exception("Colaboración a eliminar no existe.");
        }
        else{
            colaboraDAO.remove(colabora);
        }
    }

    @Override
    public List<Colabora> consultarTodas() throws Exception {
        return colaboraDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
