<%-- 
    Document   : index
    Created on : 16 sept 2024, 17:28:31
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilos.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        
    </head>
    <body>
        <div class="login-container">
            <form method="post" action="/myname/login">
                <div class="card bg-light">
                    <div class="card-body">
                        <div class="text-center mb-2">
                            <img src="IMG/imagen.png" class="img-fluid mx-auto"> 
                        </div>
                        <div class="form-group">
                            <label class="mb-1" for="txtnombre">Usuario</label>
                            <input type="text" name="txtnombre" class="form-control" id="txtnombre" placeholder="Ejem1" minlength="3" maxlength="12" required>
                        </div>
                        <div class="form-group">
                            <label class="mb-1" for="txtpassword">Contraseña</label>
                            <input type="password" name="txtpassword" class="form-control" id="txtpassword" maxlength="45" required>
                        </div>
                        <%
                            String error = request.getParameter("error");
                            if (error != null && !error.isEmpty()) {
                        %>
                        <div class="error-message text-center text-danger">
                            <%= error%>
                        </div>
                        <%
                            }
                        %>
                        <div class="form-group text-center  mt-4">
                            <input type="submit" class="btn btn-primary btn-block login" name="btn-login" value="Ingresar">
                        </div>
                    </div>
                </div>

            </form>
        </div>
    </body>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" ></script>
    <script>
        window.addEventListener('focus', function () {
            // Limpiar campos de usuario y contraseña
            document.getElementsByName('txtnombre')[0].value = '';
            document.getElementsByName('txtpassword')[0].value = '';
        });
    </script>
    
    

</html>