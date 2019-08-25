//BUSQUEDA
package edu.ulima.servlet;

import edu.ulima.bean.Libro;
import edu.ulima.mongo.LibroIF;
import edu.ulima.mongo.LibroMongo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet05 extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String tituloIngresado = request.getParameter("tituloBusqueda");
            String tituloAct= tituloIngresado.toUpperCase();
            HttpSession ses = request.getSession(true);
      
            LibroIF dao = new LibroMongo();
            //Libro l = dao.getLibroByTitulo(tituloAct);
            //System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            
            
            //Primera forma
            //ses.setAttribute("BusqLib",l);
            
            //Otra forma
            //ses.setAttribute("BusqCodigo", Integer.toString(l.getCodigo()));
            //ses.setAttribute("BusqTitulo", l.getTitulo());
            //ses.setAttribute("BusqImagen", l.getImagen());
            //ses.setAttribute("BusqAutor", l.getAutor());
            //ses.setAttribute("BusqPrecio", Double.toString(l.getPrecio()));
            //ses.setAttribute("BusqUrl", l.getUrl());
            
            List<Libro> ll = dao.getLibroByPalabra(tituloAct);
            ses.setAttribute("listaBusqueda", ll);
        
        
            String respuesta = "ventanaBusqueda.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(respuesta);
        rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
