/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UsuarioDaoImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author alumno
 */
@WebServlet(name = "LogIn", urlPatterns = {"/LogIn"})
public class LogIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LogIn</title>");
            out.println("</head>");
            out.println("<body>");
            String u, p;
            u = request.getParameter("user");
            p = request.getParameter("pass");

            ArrayList<Usuario> usuario = new UsuarioDaoImplement().getUsuarios(u, p);

            if (usuario.isEmpty()) {
                out.println("<h1>El Usuario Indicao o contraseña son incorrectos</h1>");
                out.println("<form id='redirect' method='post' action='index.jsp'>");
                out.println("<input type='submit' value='Salir'/>");
                out.println("</form>");
            } else {
                HttpSession session = request.getSession();
                out.println("<form id='redirect' method='post' action='verPrincipal.jsp'>");
                //out.println("<input type='hidden' name='id' value='" + usuario.get(0).getNumero() + "'>");
                out.println("</form>");
                
                session.setAttribute("conectado", true);
                session.setAttribute("nombre", usuario.get(0).getNombre());
                session.setAttribute("id", usuario.get(0).getNumero());
                session.setAttribute("pass", usuario.get(0).getPassword());
                session.setAttribute("foto", usuario.get(0).getFoto());
                
                out.println("<script type=\"text/javascript\">\n"
                        + "\n"
                        + "function formAutoSubmit () {\n"
                        + "\n"
                        + "var frm = document.getElementById(\"redirect\");\n"
                        + "\n"
                        + "frm.submit();\n"
                        + "\n"
                        + "}\n"
                        + "\n"
                        + "window.onload = formAutoSubmit;\n"
                        + "\n"
                        + "</script>");
            }

            out.println("</body>");
            out.println("</html>");
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
