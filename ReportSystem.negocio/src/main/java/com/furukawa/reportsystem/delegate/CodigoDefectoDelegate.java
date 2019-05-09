/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.delegate;

import com.furukawa.reportsystem.entidad.CodigoDefecto;
import com.furukawa.reportsystem.integracion.ServiceLocator;
import java.util.List;
/**
 *
 * @author JoseMarianoGarfelGar
 */
public class CodigoDefectoDelegate {

    public CodigoDefectoDelegate() {
    }
    
    /***
     * 
     * @return listado de lideres
     */
    public List<CodigoDefecto> getAllCodigoDefectos(){
        return ServiceLocator.getInstanceCodigoDefectoDAO().findAll();
    }
    
    /**
     * @param area
     *  return Codigo de Defecto por busqueda de area
     */
    public CodigoDefecto getCodigoDefectoByArea(String area){
        return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameterUnique(area,"area");
    }
    
    /**
     * @param area
     *  return Codigo de Defecto por busqueda de maquina
     */
    public CodigoDefecto getCodigoDefectoByMaquina(String maquina){
        return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameterUnique(maquina,"area");
    }
    
    
    
    
}
