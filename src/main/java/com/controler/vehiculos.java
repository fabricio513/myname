/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controler;

import com.dao.vehiculosdao;
import com.modelo.vehiculosguadar;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Fabricio
 */
public class vehiculos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int idvehiculo = Integer.parseInt(request.getParameter("txtidvehiculo"));
            String nombre = request.getParameter("txtNombre");
            String precio = request.getParameter("txtPrecio");
            int idmarcas = Integer.parseInt(request.getParameter("txtidmarcas"));
            int id_modelo = Integer.parseInt(request.getParameter("txtidmodelo"));

            String mensaje = "Error ";

            int res;

            vehiculosguadar vh = new vehiculosguadar(idvehiculo, nombre, precio, idmarcas, id_modelo);
            vehiculosdao vhdao = new vehiculosdao();
            if (request.getParameter("btnGuardar") != null) {
                res = vhdao.insertarvehiculo(vh);
                if (res != 0) {
                    mensaje = "vehiculo Agregado";
                }
            }
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/view/productos.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
        }

    }
}
