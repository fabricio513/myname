/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Fabricio
 */
public class vehiculosguadar {
    
    
    private  int idvehiculo;
    private String nombre;
    private String precio;
    private int idmarcas;
    private int  id_modelo;

    public vehiculosguadar() {
    }

    public vehiculosguadar(int idvehiculo, String nombre, String precio, int idmarcas, int id_modelo) {
        this.idvehiculo = idvehiculo;
        this.nombre = nombre;
        this.precio = precio;
        this.idmarcas = idmarcas;
        this.id_modelo = id_modelo;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getIdmarcas() {
        return idmarcas;
    }

    public void setIdmarcas(int idmarcas) {
        this.idmarcas = idmarcas;
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }



   
    
    
    
    
    
    
    
    

    
    
    
}
