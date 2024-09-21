package com.controler;

import com.modelo.personas;
import com.dao.personasdao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabricio
 */
public class controladorpersona extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String mensaje = "Error";
            int res;

            try {
                // Obtener los parámetros de la solicitud
                int id = Integer.parseInt(request.getParameter("txtid"));
                String nombre = request.getParameter("txtNombre");
                String apellidos = request.getParameter("txtApellidos");
                String edad = request.getParameter("txtEdad");
                String sexo = request.getParameter("txtSexo");

                // Crear el objeto del modelo y el DAO
                personas per = new personas(id, nombre, apellidos, edad, sexo);
                personasdao perdao = new personasdao();

                // Guardar la persona si se presionó el botón Guardar
                if (request.getParameter("btnGuardar") != null) {
                    res = perdao.insertarpersona(per);
                    if (res != 0) {
                        mensaje = "Persona agregada con éxito";
                    }

                } else if (request.getParameter("btnEditar") != null) {
                    res = perdao.editarpersona(per);
                    if (res != 0) {
                        mensaje = "Persona editada con éxito";
                    }

                } else if (request.getParameter("btnEliminar") != null) {
                    res = perdao.eliminarpersonas(per);
                    if (res != 0) {
                        mensaje = "Persona eliminada con éxito";
                    }
                }

            } catch (NumberFormatException e) {
                mensaje = "Error de formato numérico: " + e.getLocalizedMessage();
            } catch (Exception e) {
                mensaje = "Error: " + e.getLocalizedMessage();
            }

            // Establecer el mensaje y redirigir a la vista
            request.setAttribute("message", mensaje);
            request.getRequestDispatcher("/view/personas.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
