/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.delegate;

import com.furukawa.reportsystem.entidad.CodigoDefecto;
import com.furukawa.reportsystem.integracion.ServiceLocator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 *
 * @author JoseMarianoGarfelGar
 */
public class CodigoDefectoDelegate {

    public CodigoDefectoDelegate() {
    }
    
    /***
     * 
     * @return listado de CodigoDefectos
     */
    public List<CodigoDefecto> getAllCodigoDefectos(){
        return ServiceLocator.getInstanceCodigoDefectoDAO().findAll();
    }
    /***
     * 
     * @param codigo
     * @param area
     * @param maquina
     * @param gravedad
     * @param descripcion
     * @return 
     */
    public boolean saveCodigoDefecto(String codigo, String area, String maquina, String gravedad, String descripcion){
        
        CodigoDefecto cod = new CodigoDefecto();
//        String codi = ObtenerCodigoDefecto(area,maquina);
 
        cod.setCodigoDefecto(codigo);
        cod.setArea(area);
        cod.setMaquina(maquina);
        cod.setGravedad(gravedad);
        cod.setDescripcion(descripcion);
        

        try{
            ServiceLocator.getInstanceCodigoDefectoDAO().save(cod); 
        }catch(Exception ex){
            System.err.println("Error: "+ex);
            return false;
        }
        return true;
    }   
    
    
    /**
     * @param area
     *  return Codigo de Defecto por busqueda de area
     * @return 
     */
    public List<CodigoDefecto> getAllCodigoDefectoByArea(String area){ 
        return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameter(area,"area");
    }
    /**
     * @param maquina 
     *  return Codigo de Defecto por busqueda de maquina
     */
    public List<CodigoDefecto> getAllCodigoDefectoByMaquina(String maquina){
        return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameter(maquina,"maquina");
    }

    
    /**
     * @param gravedad
     * return Codigo de defecto por busqueda de gravedad
     */
    public List <CodigoDefecto> getAllCodigoDefectoByGravedad(String gravedad) {
        return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameter(gravedad,"gravedad");
    }
    
    /**
     * @param CodigoDefecto
     */
  
    public List<CodigoDefecto> getAllCodigoDefectoByCodigoDefecto(String codigodefecto){
      return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameter(codigodefecto,"codigodefecto");
    }
    
    
   
    
}
