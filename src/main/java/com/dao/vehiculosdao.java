
package com.dao;

import java.util.ArrayList;
import com.conexion.Conexion;
import com.modelo.vehiculos;
import com.modelo.vehiculosguadar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




/**
 *
 * @author Fabricio
 */
public class vehiculosdao extends Conexion {
    
    
    
    public ArrayList<vehiculos> mostrarList() {
        ArrayList<vehiculos> listaveh = new ArrayList<>();

        try {
            this.conectar();
            String sql = "SELECT vh.idvehiculo, vh.nombre, vh.precio, vh.idmarcas, marc.nombre_marca, vh.id_modelo, model.nombre_modelo FROM vehiculo vh INNER JOIN marcas marc ON vh.idmarcas=marc.idmarcas INNER JOIN modelo model ON vh.id_modelo= model.id_modelo;";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                vehiculos vh = new vehiculos();
                vh.setIdvehiculo(rs.getInt(1));
                vh.setNombre(rs.getString(2));
                vh.setPrecio(rs.getString(3));
                vh.setIdmarcas(rs.getInt(4));
                vh.setNombre_marca(rs.getString(5));
                vh.setId_modelo(rs.getInt(6));
                vh.setNombre_modelo(rs.getNString(7));
                listaveh.add(vh);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return listaveh;
    }
    
    
    
    public int insertarvehiculo(vehiculosguadar vh) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO vehiculo(nombre, precio, idmarcas, id_modelo) VALUES(?, ?, ?, ? )";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, vh.getNombre().toUpperCase());
            pre.setString(2, vh.getPrecio());
            pre.setInt(3, vh.getIdmarcas());
            pre.setInt(4, vh.getId_modelo());
 
            res = pre.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("Error al insertar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
    
    
    
    
    
      public int editarproductos(vehiculosguadar vh) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE vehiculo SET nombre=? ,precio=?, idmarcas=?, id_modelo=? WHERE idvehiculo=?";
 
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, vh.getNombre().toUpperCase());
            pre.setString(2, vh.getPrecio());
            pre.setInt(3, vh.getIdmarcas());
            pre.setInt(4, vh.getId_modelo());
            pre.setInt(5, vh.getIdvehiculo());
 
            res = pre.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
            e.printStackTrace(); // Imprime el stack trace completo para depurar
        } finally {
            this.desconectar();
        }
        return res;
    }
    
      
      public int eliminarVehiculo(vehiculosguadar vh) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM vehiculo WHERE idvehiculo= ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, vh.getIdvehiculo());
            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

      
      
      
      
      
      
      
      
      
    
    
    
}
