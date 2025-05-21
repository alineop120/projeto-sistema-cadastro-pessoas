/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aline
 */
// @WebServlet(name = "AuthController", urlPatterns = {"/AuthController"})
public class AuthController extends HttpServlet {

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
            out.println("<title>Servlet AuthController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        
        String acao = request.getParameter("acao");
        if (acao.equals("logoff")) {
            session.invalidate();
            response.sendRedirect("./index.jsp");
        }
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
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession();

    String username = request.getParameter("email");
    String password = request.getParameter("senha");

    // Log para ver os valores
    System.out.println("Email: " + username);
    System.out.println("Senha: " + password);


    String mensagem = "";
    String local = "";

    UsuarioDAO uDAO = new UsuarioDAO();
    if (uDAO.login(username, password)) {
        mensagem = "Login Realizado com sucesso";
        local = request.getContextPath() + "/UsuarioController?action=listar";
        session.setAttribute("u", username);
    } else {
        mensagem = "Falha na autenticação, Usuario:" + username + 
                    " não encontrado, por favor consulte o Núcleo de "
                    + "Suporte à Informática do seu Setor"; 
        local = "./index.jsp"; 
    } 
 
    out.println("<script type='text/javascript'>");
    out.println("alert('" + mensagem + "');");
    out.println("location.href='" + local + "';");
    out.println("</script>");

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
