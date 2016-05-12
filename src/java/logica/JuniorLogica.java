/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Junior;
import persistencia.JuniorFacadeLocal;

/**
 *
 * @author jsnar
 */
@Stateless
public class JuniorLogica implements JuniorLogicaLocal {

    @EJB
    JuniorFacadeLocal juniorDAO;
    
    @Override
    public void registrarJunior(Junior junior) throws Exception {
        if(junior.getIngsoftware().getCedula() == null){
            throw new Exception("Debes seleccionar un Ingeniero de Software.");
        }
        
        Junior objJunior = juniorDAO.find(junior.getIngsoftware().getCedula());
        if(objJunior != null){
            throw new Exception("Junior ya existe.");
        }
        else{
            juniorDAO.create(junior);
        }
    }

    @Override
    public void modificarJunior(Junior junior) throws Exception {
        if(junior.getIngsoftware() == null){
            throw new Exception("Ingeniero de Software No Registrado.");
        }
        
        Junior objJunior = juniorDAO.find(junior.getIngsoftware().getCedula());
        if(objJunior == null){
            throw new Exception("Junior a modificar no existe.");
        }
        else{
            objJunior.setHorastrabajoxdia(junior.getHorastrabajoxdia());
            juniorDAO.edit(junior);
        }
    }

    @Override
    public void eliminarJunior(Junior junior) throws Exception {
        Junior objJunior = juniorDAO.find(junior.getIngsoftware().getCedula());
        if(objJunior == null){
            throw new Exception("Junior a eliminar no existe.");
        }
        else{
            if(objJunior.getColaboraList().size() > 0){
                throw new Exception("El Ingeniero Junior tiene colaboraciones realizadas. Elimínelas primero.");
            }
            juniorDAO.remove(junior);
        }
    }

    @Override
    public List<Junior> consultarTodos() throws Exception {
        return juniorDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
