package controller;

import dao.UsuarioDAO;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UsuarioController", urlPatterns = {"/controller/UsuarioController"})
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
        String action = request.getParameter("action");
        UsuarioDAO udao = new UsuarioDAO();

        // Verificando qual ação o usuário deseja realizar
        if ("deletar".equals(action)) {
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                System.out.println("Deletando o usuário com ID: " + id);  // Verifique no console
                udao.deletar(id);
                response.sendRedirect(request.getContextPath() + "/controller/UsuarioController?action=listar");
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido para exclusão.");
            }
        } else if ("alterar".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Usuario usuario = udao.buscarPorId(id);  // Busca o usuário para edição

            if (usuario != null) {
                request.setAttribute("usuario", usuario);  // Passa o usuário para o JSP de edição
                RequestDispatcher rd = request.getRequestDispatcher("/view/editarUsuarios.jsp");
                rd.forward(request, response);
            } else {
                // Caso não encontre o usuário, redireciona para a lista de usuários
                response.sendRedirect(request.getContextPath() + "/controller/UsuarioController?action=listar");
            }

        } else if ("listar".equals(action)) {
            List<Usuario> lista = udao.listarTodos();
            request.setAttribute("usuarios", lista);  // Passa a lista de usuários para o JSP
            RequestDispatcher rd = request.getRequestDispatcher("/view/listaUsuarios.jsp");
            rd.forward(request, response);
        } else {
            // Caso a ação não seja válida, redireciona para o login (index.jsp)
            response.sendRedirect(request.getContextPath() + "/index.jsp");
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
        String nome = request.getParameter("usuarioNome");
        String email = request.getParameter("usuarioEmail");
        String senha = request.getParameter("usuarioSenha");
        int nivel = Integer.parseInt(request.getParameter("nivel"));

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setNivelAcesso(nivel);

        UsuarioDAO udao = new UsuarioDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        if (id == 0) {
            udao.inserir(usuario);
        } else {
            usuario.setId(id);
            udao.atualizar(usuario);
        }

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
