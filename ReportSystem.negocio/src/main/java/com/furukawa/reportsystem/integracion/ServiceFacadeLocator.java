/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.integracion;

import com.furukawa.reportsystem.facade.LiderFacade;

/**
 *
 * @author Elliot
 */
public class ServiceFacadeLocator {
    private static LiderFacade liderFacade;
    
    /***
     * 
     * @return regresa la clase LiderFacade validando una sola instanciacion de esta
     * para mas informacion checar patron Singleton
     */
    public static LiderFacade getInstanceLiderFacade(){
        if(liderFacade == null){
            liderFacade = new LiderFacade();
            return liderFacade;
        }else{  return liderFacade; }
    }
}
