<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Actualizar Ciclo</title>
  <c:import url="/INC/meta.inc"/>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${applicationScope.bootstrap}"/>
  <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}"/>
  <script>
    window.contadorInputsGlobal = ${fn:length(sessionScope.ciclo.modulos)};
  </script>
  <script src="${applicationScope.contexto}/JS/update.js" defer></script>
</head>
<body>
  <c:import url="/INC/cabecera.jsp"/>
  <div class="container mt-5">
    <h2 class="text-center mb-4">Actualizar Ciclo</h2>
    <form method="post" action="${applicationScope.contexto}/Update" class="card p-4 shadow-sm">
      <div class="mb-3">
        <label class="form-label">Id Ciclo</label>
        <input type="text" class="form-control" id="idCiclo" name="idCiclo" value="${sessionScope.ciclo.idCiclo}" readonly/>
      </div>
      <div class="mb-3">
        <label class="form-label">Nombre Ciclo</label>
        <input type="text" class="form-control" id="nombre" name="nombre" value="${sessionScope.ciclo.nombre}" required/>
      </div>
      <div id="contenedorInputs">
          <c:forEach var="m" items="${sessionScope.ciclo.modulos}" varStatus="i">
            <div class="mb-3">
                <!-- el index se va incrementando automaticamente con el foreach es 
                los att.id del js-->
              <input type="hidden" name="idModulo_${i.index}" value="${m.idModulo}"/>
              <label class="form-label">Módulo ${i.index + 1}</label>
              <input type="text" class="form-control" name="denominacion_${i.index}" id="denominacion_${i.index}" value="${m.denominacion}" required/>
            </div>
          </c:forEach>
      </div>
      <button type="button" class="btn btn-lila" onclick="crearInput(event)">Añadir Nuevo Módulo</button>
      <div class="d-flex justify-content-center gap-2 mt-3">
        <input type="submit" class="btn btn-highlight w-100" name="actualizar" value="Actualizar"/>
      </div>
    </form>
  </div>
</body>
</html>
