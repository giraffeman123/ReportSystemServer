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
        ServiceLocator.getInstanceEmpleadoDAO().save(e);
        ServiceLocator.getInstanceLiderDAO().save(l);
    }   
    
    /***
     * 
     * @param codigoEmpleado de lider a eliminar
     */
    public void deleteLider(String codigoEmpleado){
        Lider l = ServiceLocator.getInstanceLiderDAO().findByOneParameterUnique(codigoEmpleado,
                "codigoEmpleado");
        ServiceLocator.getInstanceLiderDAO().delete(l);
    }
}
