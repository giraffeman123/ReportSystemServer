/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.delegate;

import com.furukawa.reportsystem.entidad.CodigoDefecto;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
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
     * @return listado de CodigoDefectoes
     */
    public List<CodigoDefecto> getAllCodigoDefectos(){
        return ServiceLocator.getInstanceCodigoDefectoDAO().findAll();
    }
    
    public boolean saveCodigoDefecto(String codigoDefecto, String area, String maquina, String gravedad, String descripcion){
        
        CodigoDefecto cd = new CodigoDefecto();
        
        cd.getCodigoDefecto();
        cd.getArea();
        cd.getMaquina();
        cd.getGravedad();
        cd.getDescripcion();
        
        
        try{
            ServiceLocator.getInstanceCodigoDefectoDAO().save(cd);            
        }catch(Exception ex){
            System.err.println("Error: "+ex);
            return false;
        }
        return true;
    }   
    
}
