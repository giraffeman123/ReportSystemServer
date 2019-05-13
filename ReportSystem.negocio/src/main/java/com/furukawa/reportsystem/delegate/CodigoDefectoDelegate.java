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
    public List<CodigoDefecto> getAllCodigoDefecto(){
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
    
    /**
     * @param area
     *  return Codigo de Defecto por busqueda de area
     * @return 
     */
    public List<CodigoDefecto> getAllCodigoDefectoByArea(String area){ 
        return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameter(area,"area");
    }
    
    /***
     * 
     * @param maquina
     * @return 
     */
    public List<CodigoDefecto> getAllCodigoDefectoByMaquina(String maquina){
        return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameter(maquina,"maquina");
    }
   

    /***
     * 
     * @param gravedad
     * @return 
     */
    public List<CodigoDefecto> getAllCodigoDefectoByGravedad(String gravedad) {
        return ServiceLocator.getInstanceCodigoDefectoDAO().findByOneParameter(gravedad,"gravedad");
    }    
    
    /***
     * 
     * @param area
     * @param maquina
     * @return 
     */
    public List<CodigoDefecto> getAllCodigoByAreaAndMaquina(String area, String maquina){
        List<CodigoDefecto> allCodigoDefecto = ServiceLocator.getInstanceCodigoDefectoDAO().findAll();
        List<CodigoDefecto> codigoDefecto = new ArrayList<CodigoDefecto>();
        
        for(CodigoDefecto codigo : allCodigoDefecto)
            if(codigo.getArea().equalsIgnoreCase(area) && codigo.getMaquina().equalsIgnoreCase(maquina))
                codigoDefecto.add(codigo);
        
        return codigoDefecto;
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
      
    /***
     * 
     * @param codigo
     * @return 
     */
    public boolean deleteCodigoDefecto(String codigo){
        CodigoDefecto cod = ServiceLocator.getInstanceCodigoDefectoDAO()
                .findByOneParameterUnique(codigo, "codigoDefecto");
        if(cod == null)
            return false;
        
        try{
            ServiceLocator.getInstanceCodigoDefectoDAO().delete(cod);
            //remakeCodigosAfterDelete(cod.getArea(),cod.getMaquina());
        }catch(Exception ex){
            System.err.println("Error: "+ex);
            return false;
        }
        return true;
    }    
    
    /***
     * 
     * @param area
     * @param maquina
     */
    public void remakeCodigosAfterDelete(String area, String maquina){
        int contador = 0;
        
        // obtiene el primer caracter de area para hacer el codigo
        String codigo = "" + area.charAt(0);
        
        // separa la cadena maquina por espacios,& o y y realiza un foreach por cada palabra
        // obteniendo el primer caracter para hacer el codigo
        String[] palabras = maquina.split(" |&");
        for(String palabra : palabras){
            codigo += palabra.charAt(0);
        }
        
        // se obtienen todos los codigos de defecto con la misma maquina e area y se cuentan para obtener 
        // el numero que sera el codigo
        List<CodigoDefecto> codigos = ServiceLocator.getInstanceCodigoDefectoDAO().findAll();
        for(CodigoDefecto codigoDf : codigos){
            if(codigoDf.getMaquina().equalsIgnoreCase(maquina) && codigoDf.getArea().equalsIgnoreCase(area)){
                contador++;
                codigoDf.setCodigoDefecto(codigo+contador);
                ServiceLocator.getInstanceCodigoDefectoDAO().update(codigoDf);
            }
        }
    }    
    
}
