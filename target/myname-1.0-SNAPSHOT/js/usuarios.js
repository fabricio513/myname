$(document).ready(function () {

    // Función para llenar el formulario modal con los datos de la fila seleccionada
    function llenarFormulario(fila) {
        var id = fila.find(".idusu").text();
        var nombre = fila.find(".nombre").text();
        var dni = fila.find(".dni").text();
        var pass = fila.find(".pass").text();

        // Asignar valores a los campos del formulario modal
        $("#txtidusuarios").val(id);
        $("#txtNombre").val(nombre);
        $("#txtdni").val(dni);
        $("#txtpassword").val(pass);

        // Seleccionar la opción correcta en el select de Rol

        // Seleccionar la opción correcta en el select de Estado

    }

    // Evento click para el botón de Editar en cada fila de la tabla
    $(document).on('click', '.btnEditar', function () {
        var fila = $(this).closest('tr');
        llenarFormulario(fila); // Llenar el formulario modal con los datos de la fila seleccionada
        $('.btnDesGuar').hide();
        $('.btnDesEli').hide();
        $('.btnDesEdi').show(); // Mostrar botón de Editar en el modal
    });

    // Evento click para el botón de Eliminar en cada fila de la tabla
    $(document).on('click', '.btnEliminar', function () {
        var fila = $(this).closest('tr');
        llenarFormulario(fila); // Llenar el formulario modal con los datos de la fila seleccionada
        $('.btnDesGuar').hide();
        $('.btnDesEdi').hide();
        $('.btnDesEli').show(); // Mostrar botón de Eliminar en el modal
    });

    // Evento click para el botón de Agregar
    $(document).on('click', '.btnGuardar', function () {
        $('.btnDesEdi').hide(); // Ocultar botón de Editar
        $('.btnDesEli').hide(); // Ocultar botón de Eliminar
        $('.btnDesGuar').show(); // Mostrar botón de Guardar
    });

    // Evento para resetear el formulario modal al cerrar
    $("#exampleModal").on("hidden.bs.modal", function () {
        $('form')[0].reset(); // Resetear el formulario

    });
});



