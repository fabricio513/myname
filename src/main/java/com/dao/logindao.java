/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logindao{

    private Conexion conexion;

    public logindao(Conexion conexion) {
        this.conexion = conexion;
    }

    public boolean verificarCredenciales(String nombre, String password) { 
        boolean valido = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = conexion.getCon();
            String query = "SELECT * FROM usuarios WHERE nombre = ? AND password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                valido = true; // Las credenciales son válidas
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar credenciales: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return valido;
    }
}
