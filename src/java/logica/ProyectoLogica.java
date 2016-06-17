/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jxl.Sheet;
import jxl.Workbook;
import modelo.Proyecto;
import modelo.Senior;
import persistencia.ProyectoFacadeLocal;
import persistencia.SeniorFacadeLocal;

/**
 *
 * @author NOREÑA
 */
@Stateless
public class ProyectoLogica implements ProyectoLogicaLocal {

    @EJB
    ProyectoFacadeLocal proyectoDAO;

    @EJB
    SeniorFacadeLocal seniorDAO;
    
    @Override
    public void registrarProyecto(Proyecto proyecto) throws Exception {
        if(proyecto.getCodigo() == null || proyecto.getCodigo() == 0){
            throw new Exception("Campo Código Proyecto Obligatorio.");
        }
        if(proyecto.getLider().getCedula() == null){
            throw new Exception("Debe tener un Ingeniero de Software que lidere el proyecto.");
        }
        if(proyecto.getNombre().equals("")){
            throw new Exception("Campo Nombre Proyecto Obligatorio.");
        }
        if(proyecto.getAreaaplicacion().equals("0")){
            throw new Exception("Campo Área Aplicación Proyecto Obligatorio.");
        }
        if(proyecto.getFechaingreso() == null){
            throw new Exception("Campo Fecha Ingreso Proyecto Obligatorio.");
        }
        if(proyecto.getFechaasignacion() == null){
            throw new Exception("Campo Fecha Asignación Proyecto Obligatorio.");
        }
        if(proyecto.getFechaprevistaliberacion() == null){
            throw new Exception("Campo Fecha Prevista Liberación Proyecto Obligatorio.");
        }
        if(proyecto.getVersionprograma().equals("")){
            throw new Exception("Campo Versión Programa Proyecto Obligatorio.");
        }
        if(proyecto.getCostototal() == 0){
            throw new Exception("Campo Costo Total Proyecto Obligatorio.");
        }
        
        Proyecto objProyecto = proyectoDAO.find(proyecto.getCodigo());
        if(objProyecto != null){
            throw new Exception("Proyecto ya existe.");
        }
        else{
            proyectoDAO.create(proyecto);
        }
    }

    @Override
    public void modificarProyecto(Proyecto proyecto) throws Exception {
        if(proyecto.getCodigo() == null || proyecto.getCodigo() == 0){
            throw new Exception("Campo Código Proyecto Obligatorio.");
        }
        if(proyecto.getLider().getCedula() == null){
            throw new Exception("Debe tener un Ingeniero de Software que lidere el proyecto.");
        }
        if(proyecto.getNombre().equals("")){
            throw new Exception("Campo Nombre Proyecto Obligatorio.");
        }
        if(proyecto.getAreaaplicacion().equals("0")){
            throw new Exception("Campo Área Aplicación Proyecto Obligatorio.");
        }
        if(proyecto.getFechaingreso() == null){
            throw new Exception("Campo Fecha Ingreso Proyecto Obligatorio.");
        }
        if(proyecto.getFechaasignacion() == null){
            throw new Exception("Campo Fecha Asignación Proyecto Obligatorio.");
        }
        if(proyecto.getFechaprevistaliberacion() == null){
            throw new Exception("Campo Fecha Prevista Liberación Proyecto Obligatorio.");
        }
        if(proyecto.getVersionprograma().equals("")){
            throw new Exception("Campo Versión Programa Proyecto Obligatorio.");
        }
        if(proyecto.getCostototal() == 0){
            throw new Exception("Campo Costo Total Proyecto Obligatorio.");
        }
        
        Proyecto objProyecto = proyectoDAO.find(proyecto.getCodigo());
        if(objProyecto == null){
            throw new Exception("Proyecto a modificar no existe.");
        }
        else{
            objProyecto.setLider(proyecto.getLider());
            objProyecto.setNombre(proyecto.getNombre());
            objProyecto.setAreaaplicacion(proyecto.getAreaaplicacion());
            objProyecto.setFechaingreso(proyecto.getFechaingreso());
            objProyecto.setFechaasignacion(proyecto.getFechaasignacion());
            objProyecto.setFechaprevistaliberacion(proyecto.getFechaprevistaliberacion());
            objProyecto.setVersionprograma(proyecto.getVersionprograma());
            objProyecto.setCostototal(proyecto.getCostototal());
            proyectoDAO.edit(objProyecto);
        }
    }

    @Override
    public void eliminarProyecto(Proyecto proyecto) throws Exception {
        if(proyecto.getCodigo() == null || proyecto.getCodigo() == 0){
            throw new Exception("Campo Código Proyecto Obligatorio.");
        }
        
        Proyecto objProyecto = proyectoDAO.find(proyecto.getCodigo());
        
        if(objProyecto == null){
            throw new Exception("Proyecto a eliminar no existe.");
        }
        else{
            if(objProyecto.getColaboraList().size() > 0){
                throw new Exception("El Proyecto tiene colaboraciones asociadas. Elimínelas primero.");
            }
            if(objProyecto.getProyectolenguajeprogList().size() > 0){
                throw new Exception("El Proyecto tiene características asociadas." + 
                        " Por lo tanto, elimine primero los lenguajes de programación en que se tienen implementado el proyecto.");
            }
            if(objProyecto.getProyectosgbdList().size() > 0){
                throw new Exception("El Proyecto tiene características asociadas." + 
                        " Por lo tanto, elimine primero los sistemas gestores de bases de datos en que se tienen implementado el proyecto.");                
            }
            if(objProyecto.getProyectosistemaoperativoList().size() > 0){
                throw new Exception("El Proyecto tiene características asociadas." + 
                        " Por lo tanto, elimine primero los sistemas operativos en que se pueden ejecutar el proyecto.");
            }
            if(objProyecto.getRequisitoList().size() > 0){
                throw new Exception("El Proyecto contiene requisitos. Elimínelos primero.");
            }
            if(objProyecto.getSeencuentraenList().size() > 0){
                throw new Exception("El Proyecto tiene fases de desarrollo asociados. Elíminelos primero.");
            }
            proyectoDAO.remove(proyecto);
        }
    }

    @Override
    public List<Proyecto> consultarTodos() throws Exception {
        return proyectoDAO.findAll();
    }

    @Override
    public String importarProyectos(String archivo) throws Exception {
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        Sheet hoja = archivoExcel.getSheet(0);
        int numFilas = hoja.getRows();
        
        Integer proyectosRegistrados = 0;
        Integer proyectosExistentes = 0;
        
        for(int fila = 1; fila < numFilas; fila++){
            Proyecto proyecto = new Proyecto();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");            

            proyecto.setCodigo(Integer.parseInt(hoja.getCell(0, fila).getContents()));
            
            int cedulaLider = Integer.parseInt(hoja.getCell(1, fila).getContents());
            Senior lider = seniorDAO.find(cedulaLider);            
            proyecto.setLider(lider);
            
            proyecto.setNombre(hoja.getCell(2, fila).getContents());
            proyecto.setAreaaplicacion(hoja.getCell(3, fila).getContents());
            
            String fechaI = hoja.getCell(4, fila).getContents();            
            Date fechaIngreso = formatoFecha.parse(fechaI);
            proyecto.setFechaingreso(fechaIngreso);
            
            String fechaA = hoja.getCell(5, fila).getContents();            
            Date fechaAsignacion = formatoFecha.parse(fechaA);
            proyecto.setFechaasignacion(fechaAsignacion);            

            String fechaP = hoja.getCell(6, fila).getContents();            
            Date fechaPrevistaLiberacion = formatoFecha.parse(fechaP);
            proyecto.setFechaprevistaliberacion(fechaPrevistaLiberacion);
            
            proyecto.setVersionprograma(hoja.getCell(7, fila).getContents());
            proyecto.setCostototal(Integer.parseInt(hoja.getCell(8, fila).getContents()));

            if(proyectoDAO.find(proyecto.getCodigo()) == null){
                proyectoDAO.create(proyecto);
                proyectosRegistrados++;
            }            
            else{
                proyectosExistentes++;
            }
        }
        return "Se importaron " + proyectosRegistrados + " proyectos, ya existían " + proyectosExistentes + ".";

    }
}
