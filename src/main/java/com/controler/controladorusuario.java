package com.controler;

import com.dao.usuariodao;
import java.io.IOException;
import com.dao.vehiculosdao;
import com.modelo.usuarios;
import com.modelo.vehiculosguadar;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class controladorusuario extends HttpServlet {

    // Este método procesa las solicitudes GET y POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensaje = "Error";
        int res;

        try {
            // Obtener los parámetros de la solicitud
            int id = Integer.parseInt(request.getParameter("txtidusuarios"));
            String nombre = request.getParameter("txtNombre");
            String password = request.getParameter("txtpassword");
            String dni = request.getParameter("txtdni");

            // Crear el objeto del modelo y el DAO
            usuarios usu = new usuarios(id, nombre, password, dni);
            usuariodao usudao = new usuariodao();

            // Guardar el vehículo si se presionó el botón Guardar
            if (request.getParameter("btnGuardar") != null) {
                res = usudao.insertarusario(usu);
                if (res != 0) {
                    mensaje = "usuario agregado con éxito";
                }
            } else if (request.getParameter("btnEditar") != null) {
                res = usudao.editarusuarios(usu);
                if (res != 0) {
                    mensaje = "usuario editado con éxito";
                }
            }else if (request.getParameter("btnEliminar") != null) {
                res = usudao.eliminarusuario(usu);
                if (res != 0) {
                    mensaje = "usuario eliminado con éxito";
                }

            }
            
            
            
        } catch (NumberFormatException e) {
            mensaje = "Error de formato numérico: " + e.getLocalizedMessage();
        } catch (Exception e) {
            mensaje = "Error: " + e.getLocalizedMessage();
        }

        // Establecer el mensaje y redirigir a la vista
        request.setAttribute(
                "message", mensaje);
        request.getRequestDispatcher("/view/usuarios.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para controlar las acciones relacionadas con vehículos";
    }
}
