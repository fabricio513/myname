<%@page import="com.dao.vehiculosdao"%>
<%@page import="com.modelo.vehiculos"%>
<%@page import="com.dao.marcasdao" %>
<%@page import="com.modelo.marcas" %>
<%@page import="com.modelo.modelos" %>
<%@page import="com.dao.modelodao" %>
<%@page import="java.util.ArrayList" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::HOLA::..</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"><!-- necesario para usar los iconos-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"><!-- boostrapp css necesario-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script><!-- boostrapp js necesario-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" /><!-- alertas necesario-->
    </head>
    <body>


        <%
                     vehiculosdao vhDAO = new vehiculosdao(); 
                     marcasdao marcdao= new marcasdao();
                     modelodao modeldao= new modelodao();
        %>

        <%@include file="../template/menu.jsp" %>

        <h1 class="text-center">Listado de Vehículos</h1>

        <hr>


        <div class="container  mt-5">
            <div class="row ">
                <div class="col-10">
                    <h1 class="card-title ">

                        PRODUCTOS REGISTRADOS
                    </h1>
                </div>
                <div class="col-2 align-self-center">
                    <button type="button" class="btn btn-success btnAdd" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar vehiculo</button>
                </div>
            </div>
        </div>




        <div class="container mt-3">

            <table class="table">
                <thead>
                    <tr>
                        <th hidden scope="col">idvehiculo</th>
                        <th scope="col">nombre</th>
                        <th scope="col">precio</th>
                        <th hidden scope="col">idmarca</th>
                        <th scope="col">marca</th>
                        <th hidden scope="col">idmodelo</th>
                        <th scope="col">modelo</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<vehiculos> listavehiculos = vhDAO.mostrarList();
                        for (vehiculos vh : listavehiculos) {
                    %>
                    <tr>
                        <th class="id" hidden scope="row"><%=vh.getIdvehiculo()%></th>
                        <td class="nombre" ><%=vh.getNombre()%></td>
                        <td class="precio"><%=vh.getPrecio()%></td>
                        <td class="idmarcas" hidden><%=vh.getIdmarcas()%></td>
                        <td class="marca" ><%=vh.getNombre_marca()%></td>
                        <td class="idmodelo"  hidden ><%=vh.getId_modelo()%></td>
                        <td class="nombre_modelo"><%=vh.getNombre_modelo()%></td>
                        <td >

                            <button type="button" class="btn btn-dark btnEditar bi-pencil-square" data-bs-toggle="modal" data-bs-target="#exampleModal"></button>
                            <button type="button" class="btn btn-danger btnEliminar bi bi-tencent-qq"data-bs-toggle="modal" data-bs-target="#exampleModal"></button>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
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
                        <form action="${pageContext.servletContext.contextPath}/vista/controladorvehiculo" method="post" role="form">
                            <!-- BLOQUE 1 -->
                            <div class="row">
                                <div class="col-6" hidden>
                                    <label>Id</label>
                                    <input type="text" name="txtidvehiculo" class="form-control" id="txtidvehiculo" value="0">
                                </div>
                                <div class="col-6">
                                    <label>nombres</label>
                                    <input type="text" name="txtNombre" class="form-control" id="txtNombre" required  maxlength="12">
                                </div>
                                <div class="col-6">
                                    <label>precio</label>
                                    <input type="text" name="txtPrecio" class="form-control" id="txtPrecio" required maxlength="45">
                                </div>

                                <div class="col-6">
                                    <label>marca</label>
                                    <select name="txtidmarcas" id="txtidmarcas" class="form-select" required>
                                        <option value="">Seleccionar marcas</option>
                                        <%
                                                                                ArrayList<marcas> listamarcas = marcdao.mostrarlasmarcas();
                                                                                for (marcas marc : listamarcas) {
                                        %>
                                        <option value="<%= marc.getIdmarcas()%>"><%= marc.getNombre_marca()%></option>
                                        <%
                                                                                }
                                        %>


                                    </select>
                                </div>
                                <div class="col-6">
                                    <label>modelo</label>
                                    <select name="txtidmodelo" id="txtidmodelo" class="form-select" required>
                                        <option value="">Seleccionar modelo</option>
                                        <%
                                                                                ArrayList<modelos> listamodelos = modeldao.mostrarListamodelos();
                                                                                for (modelos model : listamodelos) {
                                        %>
                                        <option value="<%= model.getId_modelo()%>"><%= model.getNombre_modelo()%></option>
                                        <%
                                                                                }
                                        %>
                                    </select>                                </div><br>
                                <br>
                                <br>
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
        </div>  
    </body>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script><!-- necesario para usar las alertar-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script><!-- necesario para usar las alertas-->
    <script src="../js/productos.js" type="text/javascript"></script>

    <!-- ALERTAS -->
    <%
    String message = (String) request.getAttribute("message");

    if (message != null && !message.isEmpty()) {
        if (message.equals("Vehículo agregado con éxito") || message.equals("Vehículo editado con éxito") || message.equals("Vehículo eliminado con éxito")) {
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
