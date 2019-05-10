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
     * @return listado de lideres
     */
    public List<CodigoDefecto> getAllCodigoDefectos(){
        return ServiceLocator.getInstanceCodigoDefectoDAO().findAll();
    }
    
    /***
     * 
     * @param area
     * @param maquina
     * @param gravedad
     * @param descripcion
     * @return verdadero si se actualizo ; falso en caso contrario
     */
    public boolean updateCodigoDefecto(String area, String maquina, String gravedad, String descripcion){

        CodigoDefecto codigoDefecto = new CodigoDefecto();
        
        codigoDefecto.setCodigoDefecto(makeCodigoElliot(area,maquina));
        codigoDefecto.setArea(area);
        codigoDefecto.setMaquina(maquina);
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
     * @param area
     * @param maquina
     * @return un codigo con la inicial de area y las primeras inciales de maquina
     */
    public String makeCodigoElliot(String area, String maquina){
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
            if(codigoDf.getMaquina().equalsIgnoreCase(maquina) && codigoDf.getArea().equalsIgnoreCase(area))
                contador++;
        }
        
        contador++;
        codigo += contador;
        return codigo;
    }
}
