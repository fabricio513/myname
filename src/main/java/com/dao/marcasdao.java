/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.marcas;
import com.modelo.vehiculos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabricio
 */
public class marcasdao extends Conexion {
    
     public ArrayList<marcas> mostrarlasmarcas() {
        ArrayList<marcas> listmarc = new ArrayList<>();

        try {
            this.conectar();
            String sql = "SELECT * FROM marcas";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                marcas marc = new marcas();
                marc.setIdmarcas(rs.getInt(1));
                marc.setNombre_marca(rs.getString(2));
        
                listmarc.add(marc);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return listmarc;
    }
    
    
    
}
