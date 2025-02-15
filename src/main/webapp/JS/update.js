let contadorInputs = window.contadorInputsGlobal || 0;
function crearInput(event) {
    event.preventDefault();
    debugger;
    var inputDiv = document.createElement("div");
    inputDiv.className = "mb-3";
    var inputId = document.createElement("input");
    inputId.type = "hidden";
    inputId.name = "idModulo_" + contadorInputs;
    inputId.value = "";
    var inputDenom = document.createElement("input");
    inputDenom.type = "text";
    inputDenom.name = "denominacion_" + contadorInputs;
    inputDenom.id = "denominacion_" + contadorInputs;
    inputDenom.className = "form-control";
    inputDenom.placeholder = "Añadir nuevo módulo";
    inputDiv.appendChild(inputId);
    inputDiv.appendChild(inputDenom);
    document.getElementById("contenedorInputs").appendChild(inputDiv);
    contadorInputs++;
}
