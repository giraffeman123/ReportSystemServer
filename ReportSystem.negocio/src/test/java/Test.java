/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.furukawa.reportsystem.entidad.CodigoDefecto;
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
import com.furukawa.reportsystem.integracion.ServiceLocator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Elliot
 */
public class Test {
    public static void main(String[] args){    
////------------------------------------------------------------------------------------------------------------------
        String area = "Fusebox";
        String maquina = "Laser machine";

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
        List<CodigoDefecto> lista = ServiceFacadeLocator.getInstanceCodigoDefectoFacade().getAllCodigoDefecto();
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

            for(CodigoDefecto CodigoDefecto : lista){
                String caden = CodigoDefecto.getCodigoDefecto();
                if(caden.equalsIgnoreCase(ConcatenadoNo)){
                    contador ++;
                    ConcatenadoNo = Concatenado + contador; 
                    
                }
            }
            
            System.out.println("----------");
            System.out.println(ConcatenadoNo);
    }    
    
    
    
}


            