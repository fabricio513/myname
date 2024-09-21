/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;


/**
 *
 * @author Fabricio
 */
public class vehiculos {
    
    
    private  int idvehiculo;
    private String nombre;
    private String precio;
    private int idmarcas;
    private String nombre_marca;
    private int  id_modelo;
    private String nombre_modelo;

    public vehiculos() {
    }

    public vehiculos(int idvehiculo, String nombre, String precio, int idmarcas, String nombre_marca, int id_modelo, String nombre_modelo) {
        this.idvehiculo = idvehiculo;
        this.nombre = nombre;
        this.precio = precio;
        this.idmarcas = idmarcas;
        this.nombre_marca = nombre_marca;
        this.id_modelo = id_modelo;
        this.nombre_modelo = nombre_modelo;
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

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public int getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getNombre_modelo() {
        return nombre_modelo;
    }

    public void setNombre_modelo(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }

   
    
    
    
    
    
    
    
}
