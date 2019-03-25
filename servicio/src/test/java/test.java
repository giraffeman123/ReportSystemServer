
import com.furukawa.reportsystem.common.HibernateProxyTypeAdapter;
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elliot
 */
public class test {
    public static void main(String[] args){    
        
//        List<Chingon> lista = new ArrayList<Chingon>();
//        
//        List<String> familia = new ArrayList<String>();
//        familia.add("gerardo");
//        familia.add("sophia");
//        familia.add("irene");
//        Chingon chingon1 = new Chingon("Elliot",22,familia);
//        Chingon chingon2 = new Chingon("Ana",25,familia);
//        Chingon chingon3 = new Chingon("Kevin",30,familia);
//        
//        lista.add(chingon1);
//        lista.add(chingon2);
//        lista.add(chingon3);
//        
//        GsonBuilder b = new GsonBuilder();
//        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
//        b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//        Gson gson = b.create();
//        System.out.println(gson.toJson(lista));
        
        List<Lider> lista = ServiceFacadeLocator.getInstanceLiderFacade().getAllLideres();        
        GsonBuilder b = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Gson gson = b.create();
        String returnData = gson.toJson(lista);
        System.out.println(returnData);
    }
}
