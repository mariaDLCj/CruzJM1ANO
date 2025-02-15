<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read</title>
        <c:import url="/INC/meta.inc"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" type="text/css" href="${applicationScope.bootstrap}"/>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}"/>
    </head>

    <body>
        <!-- Cabecera con el menú de navegación  -->
        <c:import url="/INC/cabecera.jsp"/>
        <div class="container mt-5">
            <h2 class="text-center mb-4">Lista de Ciclos</h2>

            <div class="card p-3 shadow-sm">
                <table class="table table-bordered table-striped">
                    <thead class="table-dark">
                        <tr>
                            <th>Id Ciclo</th>
                            <th>Nombre Ciclo</th>
                            <th>Id Módulo</th>
                            <th>Nombre Módulo</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ciclo" items="${requestScope.lista}" varStatus="i">
                            <c:set var="rowspan" value="${fn:length(ciclo.modulos)}" />
                            <c:choose>
                                <c:when test="${rowspan > 0}">
                                    <tr>
                                        <td rowspan="${rowspan}">${ciclo.idCiclo}</td>
                                        <td rowspan="${rowspan}">${ciclo.nombre}</td>
                                        <td>${ciclo.modulos[0].idModulo}</td>
                                        <td>${ciclo.modulos[0].denominacion}</td>
                                    </tr>
                                    <c:forEach var="m" items="${ciclo.modulos}" begin="1">
                                        <tr>
                                            <td>${m.idModulo}</td>
                                            <td>${m.denominacion}</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td>${ciclo.idCiclo}</td>
                                        <td>${ciclo.nombre}</td>
                                        <td colspan="2">Sin módulos</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
