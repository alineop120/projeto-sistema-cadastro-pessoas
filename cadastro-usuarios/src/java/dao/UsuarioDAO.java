package dao;

import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import model.Usuario;

/**
 *
 * @author Aline
 */
public class UsuarioDAO {

    public List<Usuario> listarTodos() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getInt("acesso")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public void inserir(Usuario usuario) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                    "insert into usuarios(nome, senha, email, acesso) values( ?,  ?,  ?,  ?)");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getNivelAcesso());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizar(Usuario usuario) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "update usuarios set nome=?,senha=?,email=?,acesso=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getNivelAcesso());
            ps.setInt(5, usuario.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deletar(int id) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "delete from usuarios where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Usuario buscarPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id=?";
        try (Connection conexao = ConnectionFactory.getConnection();
                PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivelAcesso(rs.getInt("acesso"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE email=? AND senha=? AND nivelAcesso != 0";
        try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, username);  // Email
            pstm.setString(2, password);  // Senha

            System.out.println("Executando a consulta: " + sql);  // Verificar SQL
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    // Quando encontrar o usuário, exibe o nome dele no console para debug
                    System.out.println("Usuário encontrado: " + rs.getString("nome"));
                    return true;  // Retorna true se encontrou o usuário
                } else {
                    System.out.println("Usuário não encontrado");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        }

        return false;  // Retorna false se não encontrou o usuário
    }

}
