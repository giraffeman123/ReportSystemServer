/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.integracion;

import com.furukawa.reportsystem.dao.CodigoDefectoDAO;
import com.furukawa.reportsystem.dao.DefectoDAO;
import com.furukawa.reportsystem.dao.EmpleadoDAO;
import com.furukawa.reportsystem.dao.LiderDAO;

/**
 *
 * @author Elliot
 */
public class ServiceLocator {
    private static LiderDAO liderDAO;
    private static EmpleadoDAO empleadoDAO;
    private static DefectoDAO defectoDAO;
    private static CodigoDefectoDAO codigoDefectoDAO;
    
    /***
     * 
     * @return regresa la clase LiderDAO validando una sola instanciacion de esta
     * para mas informacion checar patron Singleton
     */    
    public static LiderDAO getInstanceLiderDAO(){
        if(liderDAO == null){
            liderDAO = new LiderDAO();
            return liderDAO;
        }else{
            return liderDAO;
        }
    }
    
    /***
     * 
     * @return regresa la clase EmpleadoDAO validando una sola instanciacion de esta
     * para mas informacion checar patron Singleton
     */    
    public static EmpleadoDAO getInstanceEmpleadoDAO(){
        if(empleadoDAO == null){
            empleadoDAO = new EmpleadoDAO();
            return empleadoDAO;
        }else{
            return empleadoDAO;
        }
    }  
    
    /***
     * 
     * @return regresa la clase DefectoDAO validando una sola instanciacion de esta
     * para mas informacion checar patron Singleton
     */    
    public static DefectoDAO getInstanceDefectoDAO(){
        if(defectoDAO == null){
            defectoDAO = new DefectoDAO();
            return defectoDAO;
        }else{
            return defectoDAO;
        }
    }  
    
    /***
     * 
     * @return regresa la clase CodigoDefectoDAO validando una sola instanciacion de esta
     * para mas informacion checar patron Singleton
     */    
    public static CodigoDefectoDAO getInstanceCodigoDefectoDAO(){
        if(codigoDefectoDAO == null){
            codigoDefectoDAO = new CodigoDefectoDAO();
            return codigoDefectoDAO;
        }else{
            return codigoDefectoDAO;
        }
    }      
}
