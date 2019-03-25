/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.servicio;

import com.furukawa.reportsystem.common.HibernateProxyTypeAdapter;
import com.furukawa.reportsystem.entidad.Empleado;
import com.furukawa.reportsystem.entidad.Lider;
import com.furukawa.reportsystem.integracion.ServiceFacadeLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Elliot
 */
@Path("/lider")
public class LiderServices {

    /***
     * @GET es el tipo de Peticion a la cual el metodo se convertira
     * @PATH es el url bajo el cual se llamara al metodo getAllLideres desde el navegador, en este caso /lider
     * @Produces es el tipo de formato MIME bajo el cual se dara la respuesta, en este caso JSON
     * @return todos los lideres encontrados en String con formato JSON ; null
     */    
    @GET
    @Path("/allLideres")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllLideres() {
        List<Lider> lista = ServiceFacadeLocator.getInstanceLiderFacade().getAllLideres();
        return responseOut(lista, "", Response.Status.CREATED);
    }
    
    /***
     * 
     * @param codigo codigo de empleado del lider
     * @return el lider encontrado en String con formato JSON ; null
     */
    @GET
    @Path("/liderByCodigo/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLiderByCodigoEmpleado(@PathParam("codigo") String codigo){
        Lider lider = ServiceFacadeLocator.getInstanceLiderFacade().getLiderByCodigoEmpleado(codigo);
        return responseOut(lider,"",Response.Status.CREATED);
    }
    
    /***
     * 
     * @param nombre de lider(es) a buscar
     * @return todos los lideres encontrados en String con formato JSON ; null
     */
    @GET
    @Path("/allLideresByNombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllLideresByNombre(@PathParam("nombre") String nombre){
        List<Lider> lista = ServiceFacadeLocator.getInstanceLiderFacade().getAllLideresByNombre(nombre);
        return responseOut(lista,"",Response.Status.CREATED);
    }
    
    /***
     * 
     * @param codigoEmpleado codigo de empleado a hacer Lider
     * @param area del empleado a crear
     * @param nombre de lidera crear
     * @param linea en la que trabajara el lider
     * @param puesto del empleado
     * @param turno del empleado a ser lider ,,
     * @return todos los lideres encontrados en String con formato JSON ; null
     */
    @POST
    @Path("/nuevoLider")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveLider(@FormParam("codigoEmpleado") String codigoEmpleado, 
                            @FormParam("area") String area,
                            @FormParam("linea") String linea, 
                            @FormParam("nombre") String nombre,
                            @FormParam("puesto") String puesto,
                            @FormParam("turno") String turno){
        
        Empleado e = new Empleado();
        e.setCodigoEmpleado(codigoEmpleado);
        e.setNombre(nombre);
        e.setPuesto(puesto);
        e.setTurno(turno);
        
        ServiceFacadeLocator.getInstanceLiderFacade().saveLider(codigoEmpleado, area, linea, e);
        return responseOut("","",Response.Status.ACCEPTED);
    }
    
    
    /***
     * 
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
