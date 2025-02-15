<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar</title>
        <c:import url="/INC/meta.inc"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${applicationScope.bootstrap}"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}"/>
    </head>

    <body>
        <!-- Cabecera con el menú de navegación  -->
        <c:import url="/INC/cabecera.jsp"/>
        <div class="container mt-5">
            <h2 class="text-center mb-4">Registro Eliminar</h2>
            <form method="post" action="${applicationScope.contexto}/Delete">
                <div class="mb-3">
                    <label class="form-label">Id Ciclo</label>
                    <input type="text" class="form-control" id="idCiclo" name="idCiclo" value="${sessionScope.ciclo.idCiclo}" readonly/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Nombre Ciclo</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="${sessionScope.ciclo.nombre}" readonly/>
                </div>
                <div id="contenedorInputs">
                    <c:forEach var="m" items="${sessionScope.ciclo.modulos}" varStatus="i">
                        <div class="mb-3">
                            <!-- el index se va incrementando automaticamente con el foreach es 
                            los att.id del js-->
                            <input type="hidden" name="idModulo_${i.index}" value="${m.idModulo}"/>
                            <label class="form-label">Módulo ${i.index + 1}</label>
                            <input type="text" class="form-control" name="denominacion_${i.index}" id="denominacion_${i.index}" value="${m.denominacion}" readonly/>
                            <input type="radio" name="moduloSeleccionado" value="${m.idModulo}_${sessionScope.ciclo.idCiclo}" class="form-check-input" <c:if test="${i.first}">checked</c:if> />
                        </div>
                    </c:forEach>
                </div>

                <div class="d-flex justify-content-center gap-2">
                    <input type="submit" class="btn btn-highlight w-100" name="eliminarModulo" value="Eliminar Módulo Elegido" />
                    <input type="submit" class="btn btn-highlight w-100" name="confirmarElminiar" value="Eliminar Ciclo Completo" />
                </div>

            </form>
        </div>
    </body>
</html>
