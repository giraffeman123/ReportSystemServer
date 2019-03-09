/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furukawa.reportsystem.servicio;

import java.util.List;

/**
 *
 * @author Elliot
 */
public class Chingon {
    private String nombre;
    private int edad;
    private List<String> familia;
    
    public Chingon(String nombre, int edad, List<String> familia){
        this.nombre = nombre;
        this.edad = edad;
        this.familia = familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getFamilia() {
        return familia;
    }

    public void setFamilia(List<String> familia) {
        this.familia = familia;
    }
    
    
}
