package es.albarregas.controllers;

import es.albarregas.beans.Modulo;
import es.albarregas.beans.Ciclo;
import es.albarregas.dao.IGenericoDao;
import es.albarregas.daoFactory.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maria
 */
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDao gDao = daof.getGenericoDao();
        String url = "index.jsp";
        Ciclo ciclo = null;
        Modulo modulo = null;
        Object objeto = null;

        if (request.getParameter("eliminar") != null) {
            url = "/jsp/delete/confirmar.jsp";

            Integer id = Integer.parseInt(request.getParameter("id"));
            ciclo = (Ciclo) gDao.getById(id, Ciclo.class);

            if (ciclo != null) {
                //lo establezco en la sesión
                request.getSession().setAttribute("ciclo", ciclo);
            }
        }

        if (request.getParameter("eliminarModulo") != null) {
            String moduloSeleccionado = request.getParameter("moduloSeleccionado");
            if (moduloSeleccionado != null && !moduloSeleccionado.trim().isEmpty()) {
                String[] parts = moduloSeleccionado.split("_");
                if (parts.length == 2) {
                    Integer idModulo = Integer.parseInt(parts[0]);
                    Integer idCiclo = Integer.parseInt(parts[1]);
                    ciclo = (Ciclo) gDao.getById(idCiclo, Ciclo.class);
                    if (ciclo != null) {
                        if (ciclo.getModulos() == null) {
                            ciclo.setModulos(new ArrayList<Modulo>());
                        }
                        Iterator<Modulo> it = ciclo.getModulos().iterator();
                        while (it.hasNext()) {
                            Modulo m = it.next();
                            if (m.getIdModulo() == (idModulo)) {
                                it.remove();
                                break;
                            }
                        }
                        gDao.insertOrUpdate(ciclo);
                        request.getSession().setAttribute("ciclo", ciclo);
                    }
                    modulo = (Modulo) gDao.getById(idModulo, Modulo.class);
                    if (modulo != null) {
                        gDao.delete(modulo);
                    }
                }
            }
            List<Ciclo> listaCiclo = gDao.selectAll(Ciclo.class);
            request.setAttribute("lista", listaCiclo);
            url = "/jsp/delete/confirmar.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);

        if (request.getParameter("confirmarElminiar") != null) {
            //Comprobar que el profesor no venga nullo
            ciclo = (Ciclo) request.getSession().getAttribute("ciclo");
            if (ciclo != null) {
                gDao.delete(ciclo);
                request.getSession().removeAttribute("profesor");
            }
        }

        if (request.getParameter("cancelar") != null) {
            //Hay que borrar la sesión si se cancela
            if (request.getSession().getAttribute("ciclo") != null) {
                request.getSession().removeAttribute("ciclo");
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
