/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.facade;

import com.furukawa.reportsystem.delegate.LiderDelegate;
import com.furukawa.reportsystem.entidad.Empleado;
import com.furukawa.reportsystem.entidad.Lider;
import java.util.List;

/**
 *
 * @author Elliot
 */
public class LiderFacade {
    
    private final LiderDelegate delegate;
    
    public LiderFacade(){
        delegate = new LiderDelegate();
    }
    
    /***
     * 
     * @return listado de lideres
     */
    public List<Lider> getAllLideres(){
        return delegate.getAllLideres();
    }
    
    /***
     * 
     * @param codigoEmpleado
     * @return lider encontrado
     */
    public Lider getLiderByCodigoEmpleado(String codigoEmpleado){
        return delegate.getLiderByCodigoEmpleado(codigoEmpleado);
    }
    
    /***
     * 
     * @param nombre de lider(es) a buscar
     * @return lider(es) encontrado(s)
     */
    public List<Lider> getAllLideresByNombre(String nombre){
        return delegate.getAllLideresByNombre(nombre);
    }
    
    /***
     * 
     * @param codigoEmpleado codigo del empleado
     * @param Area Area del lider
     * @param Linea Linea del lider
     * @param e Empleado Objeto
     * @return
     */
    public boolean saveLider(String codigoEmpleado, String Area, String Linea, Empleado e){
        int Line = Integer.parseInt(Linea);
        return delegate.saveLider(codigoEmpleado, Area, Line, e);
    }    
    

    /***
     * 
     * @param codigoEmpleado de lider a eliminar
     * @return
     */
    public boolean deleteLider(String codigoEmpleado){
        return delegate.deleteLider(codigoEmpleado);
    }

    
    /***
     * 
     * @param Codigo_empleado
     * @param Linea
     * @param Area
     * @param Nombre
     * @param Puesto
     * @param Turno 
     * @return
     */
    public boolean updateLider(String Codigo_empleado, String Linea , String Area , String Nombre , String Puesto , String Turno){
        int linea = Integer.parseInt(Linea); 
        return delegate.updateLider(Codigo_empleado, linea, Area, Nombre, Puesto, Turno);
    }        
}
