//INSERTAR
package edu.ulima.servlet;

import edu.ulima.bean.Libro;
import edu.ulima.mongo.LibroIF;
import edu.ulima.mongo.LibroMongo;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Servlet03 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // int codigo = Integer.parseInt(request.getParameter("codigo")); Si se quiere usar la casilla del codigo
         
        
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String imagenURL = request.getParameter("imagenURL");
        String url = "https://www.crisol.com.pe/";   //No se a donde mandarlos 
        
        
        
        
        HttpSession ses = request.getSession(true);
        
        String SultimoCodigo= (String) ses.getAttribute("ultimoCodigo");  //Para no tener que insertar codigo toma el ultimo y le suma uno
        int ultimoCodigo= parseInt(SultimoCodigo) + 1;
        
        Libro nuevo = new Libro(ultimoCodigo, titulo.toUpperCase(),imagenURL,autor.toUpperCase(),precio, url);
        System.out.println("vbvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"); 
        System.out.println(nuevo.getUrl());
        LibroIF dao = new LibroMongo();
     
        dao.createLibro(nuevo);
        
        String respuesta = "s01";
        RequestDispatcher rd = request.getRequestDispatcher(respuesta);
        rd.forward(request, response);
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
