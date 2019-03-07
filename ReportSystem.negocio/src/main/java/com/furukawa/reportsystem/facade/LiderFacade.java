/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.facade;

import com.furukawa.reportsystem.delegate.LiderDelegate;
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
     * @param id de lider a buscar
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
     * @param codigoEmpleado de lider
     * @param nombre de lider
     * @param area de lider
     * @param linea de lider
     * @param turno de lider 
     * @param foto de lider
     * @return si pudo realizar actualizacion, 1 = si; 0 = no
     */
    public Boolean updateLider(String codigoEmpleado,String nombre,String area,int linea,String turno,byte[] foto){
        Lider liderToUpdate = new Lider();
        liderToUpdate.setCodigoEmpleado(codigoEmpleado);
        liderToUpdate.setArea(area);
        liderToUpdate.setLinea(linea);
        
        return delegate.updateLider(liderToUpdate);
    }
    
    /***
     * 
     * @param codigoEmpleado
     * @param area
     * @param linea
     * @return si pudo realizar la creacion de lider, 1 = si; 0 = no
     */
    public Boolean createLider(String codigoEmpleado,String nombre,String area,int linea,String turno,byte[] foto){
        Lider liderToCreate = new Lider();
        liderToCreate.setCodigoEmpleado(codigoEmpleado);
        liderToCreate.setArea(area);
        liderToCreate.setLinea(linea);

        return delegate.createLider(liderToCreate);
    }
    
    /***
     * 
     * @param id
     * @return si pudo realizar el borrado, 1 = si; 0 = no
     */
    public Boolean deleteLiderByCodigoEmpleado(String codigoEmpleado){
        return delegate.deleteLiderByCodigoEmpleado(codigoEmpleado);
    }
    
    /***
     * 
     * @param codigoEmpleado
     * @param area
     * @param linea
     * @return si pudo realizar el borrado, 1 = si; 0 = no
     */
    public Boolean deleteLider(String codigoEmpleado,String nombre,String area,int linea,String turno,byte[] foto){
        Lider liderToDelete = new Lider();
        liderToDelete.setCodigoEmpleado(codigoEmpleado);
        liderToDelete.setArea(area);
        liderToDelete.setLinea(linea);
        
        return delegate.deleteLider(liderToDelete);
    }
}
