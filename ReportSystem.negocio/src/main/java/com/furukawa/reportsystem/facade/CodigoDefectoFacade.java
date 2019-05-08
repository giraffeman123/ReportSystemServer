/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.facade;

import com.furukawa.reportsystem.delegate.CodigoDefectoDelegate;
import com.furukawa.reportsystem.entidad.CodigoDefecto;
import java.util.List;
/**
 *
 * @author JoseMarianoGarfelGar
 */
public class CodigoDefectoFacade {
    
    private final CodigoDefectoDelegate delegate;
    
    public CodigoDefectoFacade(){
        delegate = new CodigoDefectoDelegate();
    }
    
    /***
     * 
     * @return listado de Codigos de defectod
     */
    public List<CodigoDefecto> getAllCodigoDefectos(){
        return delegate.getAllCodigoDefectos();
    }
    
    
    public boolean saveCodigoDefecto(String codigoDefecto, String area, String maquina, String gravedad, String descripcion){
        return delegate.saveCodigoDefecto(codigoDefecto, area, maquina, gravedad, descripcion);
    }    
}
