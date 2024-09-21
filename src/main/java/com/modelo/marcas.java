/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Fabricio
 */
public class marcas {
    
    
    private int idmarcas;
    private String nombre_marca;

    public marcas() {
    }

    public marcas(int idmarcas, String nombre_marca) {
        this.idmarcas = idmarcas;
        this.nombre_marca = nombre_marca;
    }

    public int getIdmarcas() {
        return idmarcas;
    }

    public void setIdmarcas(int idmarcas) {
        this.idmarcas = idmarcas;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }
    
    
    
    
}
