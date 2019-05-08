/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.servicio;

import com.furukawa.reportsystem.common.HibernateProxyTypeAdapter;
import com.furukawa.reportsystem.entidad.CodigoDefecto;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author JoseMarianoGarfelGar
 */

@Path("/codigoDefecto")
public class CodigoDefectoServices {

    /***
     * @GET es el tipo de Peticion a la cual el metodo se convertira
     * @PATH es el url bajo el cual se llamara al metodo getAllCodigoDefectoes desde el navegador, en este caso /CodigoDefecto
     * @Produces es el tipo de formato MIME bajo el cual se dara la respuesta, en este caso JSON
     * @return todos los CodigoDefectoes encontrados en String con formato JSON ; null
     */    
    @GET
    @Path("/allCodigoDefectos")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCodigoDefectoes() {
        List<CodigoDefecto> lista = ServiceFacadeLocator.getInstanceCodigoDefectoFacade().getAllCodigoDefectos();
        return responseOut(lista, "", Response.Status.ACCEPTED);
    }
    
 

     /* 
     * @param lista el objeto que se va parsear a JSON
     * @param mensaje un mensaje de texto para el cliente
     * @param status el status de la peticion HTTP a enviar
     * @return el objeto lista en formato JSON
     */    
    private String responseOut(Object lista, String mensaje, Response.Status status) {
        GsonBuilder b = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Gson gson = b.create();
        String returnData = gson.toJson(lista);
        return returnData;
    }    
    
  
    
    
}
