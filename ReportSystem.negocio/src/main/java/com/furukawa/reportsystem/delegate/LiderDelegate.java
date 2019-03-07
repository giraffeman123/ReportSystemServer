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
     * @param id de lider
     * @return un lider con el id que se busco
     */
    public Lider getLiderByCodigoEmpleado(String codigoEmpleado){
        Empleado liderEmpleado = ServiceLocator.getInstanceEmpleadoDAO().findByOneParameterUnique(codigoEmpleado, "codigoEmpleado");
        return ServiceLocator.getInstanceLiderDAO().findByOneParameterUnique(liderEmpleado.getCodigoEmpleado(), codigoEmpleado);
    }
    
    /***
     * 
     * @param nombre del lider
     * @return un lider con el nombre que se busco
     */
    public List<Lider> getAllLideresByNombre(String nombre){
        Empleado liderEmpleado = ServiceLocator.getInstanceEmpleadoDAO().findByOneParameterUnique(nombre, nombre);
        return ServiceLocator.getInstanceLiderDAO().findByOneParameter(liderEmpleado.getCodigoEmpleado(), "codigoEmpleado");
    }
    
    /***
     * 
     * @param lider para actualizar lider
     * @return si pudo realizar la actualizacion, 1 = si; 0 = no
     */
    public Boolean updateLider(Lider lider){
        try{
            ServiceLocator.getInstanceLiderDAO().update(lider);
        }catch(Exception e){
            System.err.println("Error:"+e.getMessage());
            return false;
        }
        return true;
    }
    
    /***
     * 
     * @param lider para crear lider
     * @return si pudo realizar la creacion, 1 = si; 0 = no
     */
    public Boolean createLider(Lider lider){
        try{
            ServiceLocator.getInstanceLiderDAO().save(lider);
        }catch(Exception e){
            System.err.println("Error: "+e.getMessage());
            return false;
        }
        
        return true;
    }
    
    /***
     * 
     * @param codigoEmpleado de lider a borrar
     * @return si pudo realizar el borrado, 1 = si; 0 = no
     */
    public Boolean deleteLiderByCodigoEmpleado(String codigoEmpleado){
        try{
            Lider liderToDelete = ServiceLocator.getInstanceLiderDAO().
                    findByOneParameterUnique(codigoEmpleado, codigoEmpleado);
            ServiceLocator.getInstanceLiderDAO().delete(liderToDelete);
        }catch(Exception e){
            System.err.println("Error: "+e.getMessage());
            return false;
        }
        
        return true;
    }
    
    /***
     * 
     * @param lider a borrar
     * @return si pudo realizar el borrado, 1 = si; 0 = no
     */
    public Boolean deleteLider(Lider lider){
        try{
            ServiceLocator.getInstanceLiderDAO().delete(lider);
        }catch(Exception e){
            System.err.println("Error: "+e.getMessage());
            return false;
        }
        
        return true;
    }
}
