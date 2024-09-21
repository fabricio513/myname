/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.marcas;
import com.modelo.modelos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabricio
 */
public class modelodao extends Conexion {
    
    
    
    
     public ArrayList<modelos> mostrarListamodelos() {
        ArrayList<modelos> listmodel = new ArrayList<>();

        try {
            this.conectar();
            String sql = "SELECT * FROM modelo ";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                modelos model = new modelos();
                model.setId_modelo(rs.getInt(1));
                model.setNombre_modelo(rs.getString(2));
        
                listmodel.add(model);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return listmodel;
    }
    
    
    


    
    
}
