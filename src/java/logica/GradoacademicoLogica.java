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
        if(gradoacademico.getNumero() == null || gradoacademico.getNumero() == 0){
            throw new Exception("Campo Número Grado Académico Obligatorio.");
        }
        if(gradoacademico.getIngeniero().getCedula() == null){
            throw new Exception("Campo Ingeniero Software Obligatorio.");
        }
        if(gradoacademico.getNivel().equals("0")){
            throw new Exception("Campo Nivel Académico Obligatorio.");
        }
        if(gradoacademico.getLugar().equals("")){
            throw new Exception("Campo Lugar de Graduación Obligatorio.");
        }
        if(gradoacademico.getAniotitulacion() == 0){
            throw new Exception("Campo Año de Titulación Obligatorio.");
        }
        if(gradoacademico.getTituloobtenido().equals("")){
            throw new Exception("Campo Título Obtenido Obligatorio.");
        }
        
        Gradoacademico objGradoacademico = gradoacademicoDAO.find(gradoacademico.getNumero());
        if(objGradoacademico != null){
            throw new Exception("Grado académico ya existe.");
        }
        else{
            gradoacademicoDAO.create(gradoacademico);
        }
    }

    @Override
    public void modificarGradoacademico(Gradoacademico gradoacademico) throws Exception {
        if(gradoacademico.getNumero() == null || gradoacademico.getNumero() == 0){
            throw new Exception("Campo Número Grado Académico Obligatorio.");
        }
        if(gradoacademico.getIngeniero().getCedula() == null){
            throw new Exception("Campo Ingeniero Software Obligatorio.");
        }
        if(gradoacademico.getNivel().equals("0")){
            throw new Exception("Campo Nivel Académico Obligatorio.");
        }
        if(gradoacademico.getLugar().equals("")){
            throw new Exception("Campo Lugar de Graduación Obligatorio.");
        }
        if(gradoacademico.getAniotitulacion() == 0){
            throw new Exception("Campo Año de Titulación Obligatorio.");
        }
        if(gradoacademico.getTituloobtenido().equals("")){
            throw new Exception("Campo Título Obtenido Obligatorio.");
        }
        
        Gradoacademico objGradoacademico = gradoacademicoDAO.find(gradoacademico.getNumero());
        if(objGradoacademico == null){
            throw new Exception("Grado académico a modificar no existe.");
        }
        else{
            objGradoacademico.setNivel(gradoacademico.getNivel());
            objGradoacademico.setLugar(gradoacademico.getLugar());
            objGradoacademico.setAniotitulacion(gradoacademico.getAniotitulacion());
            objGradoacademico.setTituloobtenido(gradoacademico.getTituloobtenido());
            gradoacademicoDAO.edit(objGradoacademico);
        }
    }

    @Override
    public void eliminarGradoacademico(Gradoacademico gradoacademico) throws Exception {
        if(gradoacademico.getNumero() == null || gradoacademico.getNumero() == 0){
            throw new Exception("Campo Número Grado Académico Obligatorio.");
        }
        
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
