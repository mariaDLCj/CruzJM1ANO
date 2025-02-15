<nav class="navbar bg-dark py-3">
    <div class="container-fluid d-flex align-items-center gap-2 justify-content-center">
        <form action="${applicationScope.contexto}/FrontController" method="post" class="d-flex align-items-center gap-2">
            <button class="btn btn-lila" type="submit" value="Inicio" name="boton">Inicio</button>
            <button class="btn btn-lila" type="submit" value="Create" name="boton">Create</button>
            <button class="btn btn-lila" type="submit" value="Update" name="boton">Update</button>
            
            <div class="dropdown">
                <button class="btn btn-lila dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                    Read
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <li>
                        <input type="submit" class="btn btn-light w-100 mb-2" id="puerto" name="boton" value="Modulos">
                    </li>
                    <li>
                        <input type="submit" class="btn btn-light w-100" id="servicio" name="boton" value="Ciclos">
                    </li>
                </ul>
            </div>
            
            <button class="btn btn-lila" type="submit" value="Delete" name="boton">Delete</button>
        </form>
    </div>
</nav>
