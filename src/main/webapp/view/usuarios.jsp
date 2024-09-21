<%@ page import="java.util.ArrayList" %>
<%@ page import="com.modelo.usuarios" %>
<%@ page import="com.dao.usuariodao" %>
<%@ page import="com.controler.controladorusuario" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"><!-- necesario para usar los iconos-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" /><!-- alertas necesario-->
    </head>
    <body>

        <% 
            usuariodao usudao = new usuariodao();
            
        %>

        <%@ include file="../template/menu.jsp" %>

        <h1 class="text-center">USUARIOS</h1>

        <div class="container">
            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar</button>
            <div class="table-responsive mt-3">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">DNI</th>
                            <th scope="col">Password</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%
                       ArrayList<usuarios> listausuarios = usudao.mostrarListusu();
                       for (usuarios usu : listausuarios) {
                        %>
                        <tr>
                            <th class="idusu" scope="row"><%= usu.getId()%></th>
                            <td class="nombre"><%= usu.getNombre()%></td>
                            <td class="dni"><%= usu.getDni()%></td>
                            <td class="pass"><%= usu.getPassword()%></td>
                            <td>

                                <button type="button" class="btn btn-dark btnEditar bi-pencil-square" data-bs-toggle="modal" data-bs-target="#exampleModal"></button>
                                <button type="button" class="btn btn-danger btnEliminar bi bi-tencent-qq"data-bs-toggle="modal" data-bs-target="#exampleModal"></button>



                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Datos Usuario</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.servletContext.contextPath}/vista/controladorusuario" method="post" role="form">
                            <!-- BLOQUE 1 -->
                            <div class="row">
                                <div class="col-6" hidden="" >
                                    <label>Id</label>
                                    <input type="text" name="txtidusuarios" class ="form-control" id="txtidusuarios" value="0">
                                </div>
                                <div class="col-6">
                                    <label>nombres</label>
                                    <input type="text" name="txtNombre" class="form-control" id="txtNombre" required  maxlength="45">
                                </div>
                                <div class="col-6">
                                    <label>password</label>
                                    <input type="password" name="txtpassword" class="form-control" id="txtpassword" required maxlength="45">
                                </div>

                                <div class="col-6">
                                    <label>dni</label>
                                    <input type="text" name="txtdni" class="form-control" id="txtdni" required minlength="8" maxlength="8">
                                </div>

                                <div class="row">
                                    <div class="col-12">
                                        <button type="submit" name="btnGuardar" class="btn btn-success btnDesGuar">Guardar</button>
                                        <button type="submit" name="btnEditar" class="btn btn-dark btnDesEdi">Editar</button>
                                        <button type="submit" name="btnEliminar" class="btn btn-danger btnDesEli">Eliminar</button>
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>
                                    </div>
                                </div>
                        </form>
                    </div>
                </div>
            </div>


    </body>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script><!-- necesario para usar las alertar-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script><!-- necesario para usar las alertas-->
    <script src="../js/usuarios.js" type="text/javascript"></script>

    <!-- ALERTAS -->
    <%
    String message = (String) request.getAttribute("message");

    if (message != null && !message.isEmpty()) {
        if (message.equals("usuario agregado con éxito") || message.equals("usuario editado con éxito") || message.equals("usuario eliminado con éxito")) {
    %>
    <script>
        $(document).ready(function () {
            Swal.fire({
                position: "top-end",
                icon: "success",
                title: "<%=message%>",
                showConfirmButton: false,
                timer: 3000
            });
        });
    </script>
    <%
    } else {
    %>
    <script>
        $(document).ready(function () {
            Swal.fire({
                position: "top-end",
                icon: "error",
                title: "<%=message%>",
                showConfirmButton: false,
                timer: 3000
            });
        });
    </script>
    <%
            }
        }
    %>



</html>
