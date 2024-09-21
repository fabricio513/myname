package com.dao;

import com.conexion.Conexion;
import com.modelo.usuarios;
import com.modelo.vehiculos;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Fabricio
 */
public class usuariodao extends Conexion {

    public ArrayList<usuarios> mostrarListusu() {
        ArrayList<usuarios> listausu = new ArrayList<>();

        try {
            this.conectar();
            String sql = "SELECT * FROM usuarios";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs;
            rs = pre.executeQuery();
            while (rs.next()) {
                usuarios usu = new usuarios();
                usu.setId(rs.getInt(1));
                usu.setNombre(rs.getString(2));
                usu.setPassword(rs.getString(3));
                usu.setDni(rs.getString(4));
                listausu.add(usu);
            }

        } catch (SQLException e) {
            System.out.println("Error al mostar " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return listausu;
    }

    public int insertarusario(usuarios usuario) {
        int res = 0;
        try {
            this.conectar();

            String sql = "INSERT INTO usuarios (nombre, dni, password) VALUES (?, ?, ?)";
            PreparedStatement pro = this.getCon().prepareStatement(sql);
            pro.setString(1, usuario.getNombre());
            pro.setString(2, usuario.getDni());
            pro.setString(3, usuario.getPassword());

            res = pro.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return res;
    }

    public int editarusuarios(usuarios usu) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE usuarios SET nombre=? ,password=?, dni=? WHERE idusuarios=?";

            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, usu.getNombre());
            pre.setString(2, usu.getPassword());
            pre.setString(3, usu.getDni());
            pre.setInt(4, usu.getId());

            res = pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al modificar: " + e.getMessage());
            e.printStackTrace(); // Imprime el stack trace completo para depurar
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarusuario(usuarios usu) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM usuarios WHERE idusuarios= ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, usu.getId());
            res = pre.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

}
