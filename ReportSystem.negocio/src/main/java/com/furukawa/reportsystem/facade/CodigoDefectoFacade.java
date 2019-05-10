/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.facade;

import com.furukawa.reportsystem.delegate.CodigoDefectoDelegate;
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
    
    /***
     * 
     * @param codigo
     * @param gravedad
     * @param descripcion
     * @return verdadero si se actualizo el codigo defecto ; falso en caso contrario
     */    
    public Boolean updateCodigoDefecto(String codigo, String gravedad, 
                                        String descripcion){
        return delegate.updateCodigoDefecto(codigo, gravedad, descripcion);
    }
    
    /***
     * 
     * @param area
     * @param maquina
     * @param gravedad
     * @param descripcion
     * @return 
     */
    public boolean saveCodigoDefecto(String area, String maquina, String gravedad, String descripcion){
        String codigo = ObtenerCodigoDefecto(area,maquina);
        return delegate.saveCodigoDefecto(codigo, area, maquina, gravedad, descripcion);
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
    
    /***
     * @author Mariano Garfel
     * @param area
     * @param maquina
     * @return un codigo con la inicial de area y las primeras inciales de maquina
     */    
    public String ObtenerCodigoDefecto(String area, String maquina){
    // METODO PARA CREAR EL CODIGO DE DEFECTO SIN NUMERO
        String mIniciales = "";
        String aIniciales = "";
        String Concatenado = "";
        String ConcatenadoNo = "";

        StringTokenizer areaPalabra = new StringTokenizer(area);
        String aPalabra = areaPalabra.nextToken().toUpperCase();
        aIniciales = aPalabra.substring(0,1);


        StringTokenizer maquinaPalabras = new StringTokenizer(maquina);
        while (maquinaPalabras.hasMoreTokens()) {
        String mPalabra = maquinaPalabras.nextToken();
        if(mPalabra.substring(0,1).equalsIgnoreCase("&") || 
           mPalabra.substring(0,1).equalsIgnoreCase("y")){
            // No guardar 
        }else{
        mIniciales = mIniciales + mPalabra.substring(0,1).toUpperCase();
        }
        }

        Concatenado = aIniciales + mIniciales;

        //---------------------------------------------------------------------------------------------------------------

        String codigoDefecto = Concatenado;
        List<CodigoDefecto> lista = ServiceFacadeLocator.getInstanceCodigoDefectoFacade().getAllCodigoDefectos();
        String cdsn = "";

    // -------------------------------------------------------------------------------------------------
            List<String> ListaTemp = new ArrayList<String>();

            for(CodigoDefecto CodigoDefecto : lista){

                System.out.println("Codigo Defecto: "+CodigoDefecto.getCodigoDefecto()); 

                // Metodo para identificar Codigos de defectos sin numeros
                String cadena = CodigoDefecto.getCodigoDefecto();
                char [] cadena_div = cadena.toCharArray();
                for(int i = 0; i<cadena_div.length;i++){
                    if(Character.isAlphabetic(cadena_div[i])){
                        cdsn = cdsn + cadena_div[i];
                    }
                }
                ListaTemp.add(cdsn);
                cdsn = "";
            }

        System.out.println(ListaTemp);

        //----------------------------------------------------------------------------------

        int contador = 0;
            //Encontrar el Codigo de Defecto sin numero en la lista y cuantos de estos mismos ya existen
            contador = ListaTemp.stream().filter((CodigoDefecto) -> (CodigoDefecto.equalsIgnoreCase(codigoDefecto))).map((_item) -> 1).reduce(contador, Integer::sum);
            if(contador == 0){
                ConcatenadoNo = Concatenado + "1";
            }else{
                contador ++;
                ConcatenadoNo = Concatenado + contador;
            }

            System.out.println("----------");
            System.out.println(ConcatenadoNo);
        
        return ConcatenadoNo;
    }
}
