package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void conectar() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculos", "root", "123456");
        System.out.println("Conexión establecida con éxito.");
    } catch (Exception e) {
        System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        e.printStackTrace();
    }
}


    public void desconectar(){
        try {
            if(!con.isClosed()){
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexion "+e.getMessage());
        }

    }
}