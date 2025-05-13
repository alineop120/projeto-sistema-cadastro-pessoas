package controller;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author Aline
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

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
            out.println("<title>Servlet UsuarioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
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
        UsuarioDAO udao = new UsuarioDAO();
        if ("deletar".equals(request.getParameter("action"))) {
            int id = Integer.parseInt(request.getParameter("id"));
            udao.deletar(id);
            response.sendRedirect("UsuarioController");
        } else if ("alterar".equals(request.getParameter("action"))) {
            Usuario usuario = udao.buscarPorId(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("usuario", usuario);
            RequestDispatcher rs = request.getRequestDispatcher("/index.jsp");
            rs.forward(request, response);
        } else {
            List lista = udao.listarTodos();
            request.setAttribute("usuarios", lista);
            RequestDispatcher rs = request.getRequestDispatcher("/listaUsuarios.jsp");
            rs.forward(request, response);
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
        // Recebe os dados do formulário
        String nome = request.getParameter("usuarioNome");
        String email = request.getParameter("usuarioEmail");
        String senha = request.getParameter("usuarioSenha");
        int nivel = Integer.parseInt(request.getParameter("nivel"));

        // Verifica se o ID do usuário é 0 (novo) ou maior (atualização)
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = new Usuario();

        usuario.setNome(nome != null ? nome : "");
        usuario.setEmail(email != null ? email : "");
        usuario.setSenha(senha != null ? senha : "");
        usuario.setNivelAcesso(nivel);

        UsuarioDAO uDAO = new UsuarioDAO();

        if (id == 0) {
            uDAO.inserir(usuario); // Novo usuário
        } else {
            usuario.setId(id); // Atualiza usuário existente
            uDAO.atualizar(usuario);
        }

        // Redireciona para a lista de usuários após o cadastro
        response.sendRedirect("UsuarioController");
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
