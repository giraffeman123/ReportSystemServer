/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.furukawa.reportsystem.entidad.CodigoDefecto;
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
import java.util.List;

/**
 *
 * @author Elliot
 */
public class Test {
    public static void main(String[] args){    
//        List<Lider> lista = ServiceFacadeLocator.getInstanceLiderFacade().getAllLideres();
//        for(Lider lider : lista){   System.out.println("id: "+lider.getEmpleado().getNombre());   }
        
        List<CodigoDefecto> lista = ServiceFacadeLocator.getInstanceCodigoDefectoFacade().getAllCodigoDefectos();
        System.out.println("");
        
        for(CodigoDefecto CodigoDefecto : lista){
            System.out.println("Codigo Defecto: "+CodigoDefecto.getCodigoDefecto());   
        }

    }
}
