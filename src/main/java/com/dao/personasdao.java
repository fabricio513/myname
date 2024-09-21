/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.personas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabricio
 */
public class personasdao extends Conexion {

    public ArrayList<personas> mostrarList() {
        ArrayList<personas> listapersonas = new ArrayList<>();

        try {
            this.conectar();
            String sql = "SELECT * FROM personas";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                personas per = new personas();
                per.setId(rs.getInt(1));
                per.setNombre(rs.getString(2));
                per.setApellidos(rs.getString(3));
                per.setEdad(rs.getNString(4));
                per.setSexo(rs.getString(5));

                listapersonas.add(per);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return listapersonas;
    }

    public int insertarpersona(personas per) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO personas(nombre, apellidos, edad, sexo) VALUES(?, ?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);

            // Asignar los valores a los parámetros
            pre.setString(1, per.getNombre().toUpperCase()); // Parámetro 1: nombre
            pre.setString(2, per.getApellidos());            // Parámetro 2: apellidos
            pre.setString(3, per.getEdad());                 // Parámetro 3: edad
            pre.setString(4, per.getSexo());                 // Parámetro 4: sexo

            res = pre.executeUpdate(); // Ejecutar la inserción

        } catch (SQLException e) {
            System.out.println("Error al insertar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int editarpersona(personas per) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE personas SET nombre=?, apellidos=?, edad=?, sexo=? WHERE idperry=?";

            PreparedStatement pre = this.getCon().prepareStatement(sql);

            // Asignar los valores a los parámetros
            pre.setString(1, per.getNombre().toUpperCase()); // Parámetro 1: nombre
            pre.setString(2, per.getApellidos());            // Parámetro 2: apellidos
            pre.setString(3, per.getEdad());                 // Parámetro 3: edad
            pre.setString(4, per.getSexo());                 // Parámetro 4: sexo
            pre.setInt(5, per.getId());                      // Parámetro 5: idperry

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
            e.printStackTrace(); // Imprime el stack trace completo para depurar
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarpersonas(personas per) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM personas WHERE idperry = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, per.getId());
            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

}
