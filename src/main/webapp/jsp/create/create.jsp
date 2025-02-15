<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
        <c:import url="/INC/meta.inc"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${applicationScope.bootstrap}"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}"/>
        <script src="${applicationScope.contexto}/JS/js.js" defer></script>
    </head>

    <body>
        <!-- Cabecera con el menú de navegación  -->
        <c:import url="/INC/cabecera.jsp"/>
        <section class="py-5">
            <div class="container">
                <h2 class="text-center highlight mb-4">Nuevo Registro</h2>
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <form action="${applicationScope.contexto}/Create" method="post">

                            <div class="mb-3">
                                <label class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingresa el nombre del Ciclo" maxlength="30" >
                            </div>
                            <div id="contenedorInputs"></div>
                            <button type="button" class="btn btn-lila" onclick="crearInput(event)">Añadir Input</button>
                            <p class="p text-white">${requestScope.smsOcupado}</p>
                            <p class="p text-white">${requestScope.smsVacio}</p>
                            <div class="d-flex justify-content-center gap-2">
                                <input type="submit" class="btn btn-highlight w-100" name="registrarse" value="Registrarse" />
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
