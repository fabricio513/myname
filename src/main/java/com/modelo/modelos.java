/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author Fabricio
 */
public class modelos {
    
    private int id_modelo;
    private String nombre_modelo;

    public modelos() {
    }

    public modelos(int id_modelo, String nombre_modelo) {
        this.id_modelo = id_modelo;
        this.nombre_modelo = nombre_modelo;
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
