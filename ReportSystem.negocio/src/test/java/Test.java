/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.furukawa.reportsystem.entidad.CodigoDefecto;
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
import com.furukawa.reportsystem.integracion.ServiceLocator;
import java.util.List;

/**
 *
 * @author Elliot
 */
public class Test {
    public static void main(String[] args){    
//        List<Lider> lista = ServiceFacadeLocator.getInstanceLiderFacade().getAllLideres();
//        for(Lider lider : lista){   System.out.println("id: "+lider.getEmpleado().getNombre());   }
        
//        List<CodigoDefecto> lista = ServiceFacadeLocator.getInstanceCodigoDefectoFacade().getAllCodigoDefectos();
//        System.out.println("");
//        
//        for(CodigoDefecto CodigoDefecto : lista){
//            System.out.println("Codigo Defecto: "+CodigoDefecto.getCodigoDefecto());   
//        }
//      
        Test test = new Test();
        System.out.println(test.makeCodigoElliot("FuseBox", "Laser Machine"));

    }
    
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
