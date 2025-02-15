package es.albarregas.controllers;

import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Modulo;
import es.albarregas.dao.IGenericoDao;
import es.albarregas.daoFactory.DAOFactory;
import es.albarregas.models.Utilidades;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Maria
 */
@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {

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
        Ciclo ciclo = null;
        String url = "index.jsp";
        String sms = null;
        Boolean vacio = false;
        Modulo modulo = null;
        Boolean excede = false;
        IGenericoDao gdao = daof.getGenericoDao();
        
        if (request.getParameter("elegirActualizar") != null) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            ciclo = (Ciclo) gdao.getById(id, Ciclo.class);

            request.getSession().setAttribute("ciclo", ciclo);
            url = "/jsp/update/update.jsp";
        }

        if (request.getParameter("actualizar") != null) {
            Enumeration<String> nombres = request.getParameterNames();
            ciclo = new Ciclo();
            modulo = new Modulo();
            //Se obtienen los campos y se comprueba si están vacíos
            List<String> camposOpcionales = new ArrayList<String>();
            // camposOpcionales.add("apellido2");
            vacio = Utilidades.campoVacio(nombres, camposOpcionales, request);
            //Si los campos no están vacíos y el campo tipo no se pasa del largo
            if (vacio == false) {
                //Se crea la direcciónc argada
                //Hay que pasarle la lista de modulos a los ciclos
                //Tengo que cargar modulo a modulo
                for (Modulo m : Utilidades.extraerModulos(request)) {
                    gdao.insertOrUpdate(m);
                    ciclo.setModulo(m);
                }

                // Se carga el ciclo
                try {
                    BeanUtils.populate(ciclo, request.getParameterMap());
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
                }
                gdao.insertOrUpdate(ciclo);
                //gdao.add(modulo);
                //Recupero el ciclo ya que la fecha se establece al introducirlo en la bbdd
                request.getSession().setAttribute("ciclo", ciclo);
            } else {
                sms = "Todos los campos son obligatorios y no deben exceder el máximo.";
                request.setAttribute("smsOcupado", sms);
                url = "/jsp/update/update.jsp";
            }

        }

        request.getRequestDispatcher(url)
                .forward(request, response);
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
