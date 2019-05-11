/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.delegate;

import com.furukawa.reportsystem.entidad.CodigoDefecto;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
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
     * @param codigodefecto
     * @return 
     */
    public CodigoDefecto getCodigoDefectoByCodigoDefecto(String codigodefecto){
      return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameterUnique(codigodefecto,"codigoDefecto");
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
    public boolean saveCodigoDefecto(String codigo, String area, String maquina, String gravedad,
                                        String descripcion){
        
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
    
    
    /***
     * 
     * @param codigo
     * @param gravedad
     * @param descripcion
     * @return verdadero si se actualizo ; falso en caso contrario
     */
    public boolean updateCodigoDefecto(String codigo, String gravedad
                                        , String descripcion){
        //se verifica si existe un codigoDefecto a modificar         
        CodigoDefecto codigoDefecto = ServiceLocator.getInstanceCodigoDefectoDAO()
                .findByOneParameterUnique(codigo, "codigoDefecto");
        
        if(codigoDefecto == null)
            return false;
        
        codigoDefecto.setCodigoDefecto(codigo);
        //codigoDefecto.setArea(area);
        //codigoDefecto.setMaquina(maquina);
        codigoDefecto.setGravedad(gravedad);
        codigoDefecto.setDescripcion(descripcion);
        codigoDefecto.setFotografia(null);
        
        try{
            ServiceLocator.getInstanceCodigoDefectoDAO().update(codigoDefecto);
        }catch(Exception e){
            System.err.println("Error: "+e.getMessage());
            return false;
        }
        
        return true;
    }
      
}
