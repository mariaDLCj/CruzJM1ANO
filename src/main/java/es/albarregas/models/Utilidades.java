package es.albarregas.models;

import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Modulo;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maria
 */
public class Utilidades {

    public static Boolean campoVacio(Enumeration<String> nombres, List<String> camposOpcionales, HttpServletRequest request) {
        Boolean vacio = false;
        while (nombres.hasMoreElements()) {
            String nombre = nombres.nextElement();
            String valor = request.getParameter(nombre);
            if (!nombre.startsWith("idModulo_") && !nombre.startsWith("denominacion_")) {
                if (valor == null || valor.trim().isEmpty()) {
                    if (!camposOpcionales.contains(nombre)) {
                        vacio = true;
                    }
                }
            }
        }

        return vacio;
    }

    public static List<Modulo> rellenarModulos(HttpServletRequest request) {
        Modulo modulo = null;
        List<Modulo> modulos = new ArrayList<>();
        int i = 0;

        while (request.getParameter("denominacion_" + i) != null) {
            String denominacion = request.getParameter("denominacion_" + i);
            if (denominacion != null && !denominacion.trim().isEmpty()) {
                modulo = new Modulo();
                modulo.setDenominacion(denominacion);
                modulos.add(modulo);
            }
            i++;
        }
        return modulos;
    }

    public static List<Modulo> extraerModulos(HttpServletRequest request) {
        List<Modulo> modulos = new ArrayList<>();
        int i = 0;

        while (request.getParameter("denominacion_" + i) != null) {
            String denom = request.getParameter("denominacion_" + i);
            String idStr = request.getParameter("idModulo_" + i);

            if (denom != null && !denom.trim().isEmpty()) {
                Modulo modulo = new Modulo();

                if (idStr != null && !idStr.isEmpty()) {
                    modulo.setIdModulo(Integer.parseInt(idStr));
                }

                modulo.setDenominacion(denom);
                modulos.add(modulo);
            }

            i++;
        }
        return modulos;
    }

}
