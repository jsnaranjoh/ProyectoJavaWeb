/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Gradoacademico;
import persistencia.GradoacademicoFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class GradoacademicoLogica implements GradoacademicoLogicaLocal {

    @EJB
    GradoacademicoFacadeLocal gradoacademicoDAO;
    
    @Override
    public void registrarGradoacademico(Gradoacademico gradoacademico) throws Exception {
        if(gradoacademico.getIngeniero().getCedula() == null){
            throw new Exception("Campo Ingeniero Software Obligatorio.");
        }
        if(gradoacademico.getNivel().equals("")){
            throw new Exception("Campo Nivel Académico Obligatorio.");
        }
        if(gradoacademico.getLugar().equals("")){
            throw new Exception("Campo Lugradoacademicor de Graduación Obligatorio.");
        }
        if(gradoacademico.getTituloobtenido().equals("")){
            throw new Exception("Campo Título Obtenido Obligatorio.");
        }
        
        Gradoacademico objGradoacademico = gradoacademicoDAO.find(gradoacademico);
        if(objGradoacademico != null){
            throw new Exception("Grado académico ya existe.");
        }
        else{
            gradoacademicoDAO.create(gradoacademico);
        }
    }

    @Override
    public void modificarGradoacademico(Gradoacademico gradoacademico) throws Exception {
        if(gradoacademico.getIngeniero().getCedula() == null){
            throw new Exception("Campo Ingeniero Software Obligatorio.");
        }
        if(gradoacademico.getNivel().equals("")){
            throw new Exception("Campo Nivel Académico Obligatorio.");
        }
        if(gradoacademico.getLugar().equals("")){
            throw new Exception("Campo Lugradoacademicor de Graduación Obligatorio.");
        }
        if(gradoacademico.getTituloobtenido().equals("")){
            throw new Exception("Campo Título Obtenido Obligatorio.");
        }
        
        Gradoacademico objGradoacademico = gradoacademicoDAO.find(gradoacademico);
        if(objGradoacademico == null){
            throw new Exception("Grado académico a modificar no existe.");
        }
        else{
            objGradoacademico.setNivel(gradoacademico.getNivel());
            objGradoacademico.setLugar(gradoacademico.getLugar());
            objGradoacademico.setAniotitulacion(gradoacademico.getAniotitulacion());
            objGradoacademico.setTituloobtenido(gradoacademico.getTituloobtenido());
            gradoacademicoDAO.edit(gradoacademico);
        }
    }

    @Override
    public void eliminarGradoacademico(Gradoacademico gradoacademico) throws Exception {
        Gradoacademico objGradoacademico = gradoacademicoDAO.find(gradoacademico.getNumero());
        if(objGradoacademico == null){
            throw new Exception("Grado académico a eliminar no existe.");
        }
        else{
            gradoacademicoDAO.remove(gradoacademico);
        }
    }

    @Override
    public List<Gradoacademico> consultarTodos() throws Exception {
        return gradoacademicoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
