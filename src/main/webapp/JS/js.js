let contadorInputs = 0;

function crearInput(event) {
    event.preventDefault();

    var inputDiv = document.createElement("div");
    inputDiv.className = "mb-3";

    var input = document.createElement("input");
    input.type = "text";
    input.name = "denominacion_" + contadorInputs;
    input.id = "denominacion_" + contadorInputs;
    input.className = "form-control";
    input.placeholder = "Añadir nuevo módulo";
    input.required = true;

    inputDiv.appendChild(input);
    var contenedor = document.getElementById("contenedorInputs");
    contenedor.appendChild(inputDiv);

    contadorInputs++;
}
