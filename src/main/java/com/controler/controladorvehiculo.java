package com.controler;

import java.io.IOException;
import com.dao.vehiculosdao;
import com.modelo.vehiculosguadar;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class controladorvehiculo extends HttpServlet {

    // Este método procesa las solicitudes GET y POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensaje = "Error";
        int res;

        try {
            // Obtener los parámetros de la solicitud
            int idvehiculo = Integer.parseInt(request.getParameter("txtidvehiculo"));
            String nombre = request.getParameter("txtNombre");
            String precio = request.getParameter("txtPrecio");
            int idmarcas = Integer.parseInt(request.getParameter("txtidmarcas"));
            int id_modelo = Integer.parseInt(request.getParameter("txtidmodelo"));

            // Crear el objeto del modelo y el DAO
            vehiculosguadar vh = new vehiculosguadar(idvehiculo, nombre, precio, idmarcas, id_modelo);
            vehiculosdao vhdao = new vehiculosdao();

            // Guardar el vehículo si se presionó el botón Guardar
            if (request.getParameter("btnGuardar") != null) {
                res = vhdao.insertarvehiculo(vh);
                if (res != 0) {
                    mensaje = "Vehículo agregado con éxito";
                }
            } else if (request.getParameter("btnEditar") != null) {
                res = vhdao.editarproductos(vh);
                if (res != 0) {
                    mensaje = "Vehículo editado con éxito";
                }
            } else if (request.getParameter("btnEliminar") != null) {
                res = vhdao.eliminarVehiculo(vh);
                if (res != 0) {
                    mensaje = "Vehículo eliminado con éxito";
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
        request.getRequestDispatcher(
                "/view/productos.jsp").forward(request, response);
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
