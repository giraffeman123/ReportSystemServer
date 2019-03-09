/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
import java.util.List;

/**
 *
 * @author Elliot
 */
public class Test {
    public static void main(String[] args){    
        List<Lider> lista = ServiceFacadeLocator.getInstanceLiderFacade().getAllLideres();
        for(Lider lider : lista){   System.out.println("id: "+lider.getEmpleado().getNombre());   }
//      System.out.println("Modifico?"+ServiceFacadeLocator.
//                getInstanceLiderFacade().actualizarLider("AAAA", "kevin", "Fusebox", 0, "Vespertino", null));
    }
}
