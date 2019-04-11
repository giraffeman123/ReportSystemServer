/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.delegate;

import com.furukawa.reportsystem.entidad.Empleado;
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceLocator;
import java.util.List;

/**
 *
 * @author Elliot
 */
public class LiderDelegate {

    public LiderDelegate() {
    }
    
    /***
     * 
     * @return listado de lideres
     */
    public List<Lider> getAllLideres(){
        return ServiceLocator.getInstanceLiderDAO().findAll();
    }
    
    /***
     * 
     * @param codigoEmpleado
     * @return un lider con el codigo de Empleado que se busco
     */
    public Lider getLiderByCodigoEmpleado(String codigoEmpleado){
        return ServiceLocator.getInstanceLiderDAO().findByOneParameterUnique(codigoEmpleado, "codigoEmpleado");
    }
    
    /***
     * 
     * @param nombre del lider
     * @return un lider con el nombre que se busco
     */
    public List<Lider> getAllLideresByNombre(String nombre){
        Empleado liderEmpleado = ServiceLocator.getInstanceEmpleadoDAO().findByOneParameterUnique(nombre, "nombre");
        return ServiceLocator.getInstanceLiderDAO().findByOneParameter(liderEmpleado.getCodigoEmpleado(), "codigoEmpleado");
    }
    
    
    
  
        /***
     * 
     * @param codigoEmpleado codigo del empleado
     * @param Area Area del lider
     * @param Linea Linea del lider
     * @param e Empleado Objeto
     */
        
    public void saveLider(String codigoEmpleado, String Area, int Linea, Empleado e){
        Lider l = new Lider();
        l.setCodigoEmpleado(codigoEmpleado);
        l.setArea(Area);
        l.setLinea(Linea);
        l.setEmpleado(e);
        ServiceLocator.getInstanceEmpleadoDAO().saveOrUpdate(e);
        ServiceLocator.getInstanceLiderDAO().saveOrUpdate(l);
    }
    
    /***
     * 
     * @param Codigo_empleado
     * @param Linea
     * @param Area
     * @param Nombre
     * @param Puesto
     * @param Turno 
     */
    public void updateLider(String Codigo_empleado, int Linea , String Area , String Nombre,
            String Puesto , String Turno){
       
        Lider r = new Lider();
        Empleado e = new Empleado();
           
           //LIDER
        r.setCodigoEmpleado(Codigo_empleado);
        r.setLinea(Linea);
        r.setArea(Area);
            
            //EMPLEADO
        e.setNombre(Nombre);
        e.setPuesto(Puesto);
        e.setFoto(null);
        e.setTurno(Turno);
        e.setCodigoEmpleado(Codigo_empleado);
          
        r.setEmpleado(e);
        ServiceLocator.getInstanceEmpleadoDAO().update(e);
        ServiceLocator.getInstanceLiderDAO().update(r); //Llamado a la base de datos      
     }    
}
