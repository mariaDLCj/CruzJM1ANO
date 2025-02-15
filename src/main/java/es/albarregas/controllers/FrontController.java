package es.albarregas.controllers;

import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Modulo;
import es.albarregas.dao.IGenericoDao;
import es.albarregas.daoFactory.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

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
        String opcion = request.getParameter("boton");
        //Primero recupero la lista por la opcion pulsada así lo requiere
        //Se trae la lista en un inicio con los objetos Servicio
        List<Ciclo> listaCiclo = new ArrayList<>();
        listaCiclo = gDao.selectAll(Ciclo.class);
        String url = "index.jsp";
        Boolean vacia = false;
        Modulo modulo = null;

        if (listaCiclo == null || listaCiclo.isEmpty()) {
            vacia = true;
            request.setAttribute("sms", "La lista se encuentra vacía");
        } else {
            request.setAttribute("lista", listaCiclo);
        }

        switch (opcion) {
            case "Create":
                url = "/jsp/create/create.jsp";
                break;
            case "Delete":
                if (!vacia) {
                    url = "/jsp/delete/delete.jsp";
                }
                break;
            case "Update":
                if (!vacia) {
                    url = "/jsp/update/elegirActualizar.jsp";
                }
                break;
            case "Ciclos":
                if (!vacia) {
                    url = "/jsp/read/readCiclo.jsp";
                }
                break;
            case "Modulos":
                if (!vacia) {
                    url = "/jsp/read/read.jsp";
                }
                break;

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
