
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        List<Lider> lista = ServiceFacadeLocator.getInstanceLiderFacade().getAllLideres();
        //GsonBuilder b = new GsonBuilder();
        //b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        //b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Gson gson = new Gson();
        String returnData = gson.toJson(lista);
        System.out.println(returnData);
    }
}
