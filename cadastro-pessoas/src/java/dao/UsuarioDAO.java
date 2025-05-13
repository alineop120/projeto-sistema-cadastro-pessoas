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

    private Connection conn;

    // Construtor que já conecta
    public UsuarioDAO() {
        this.conectar();
    }

    private void conectar() {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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
        System.out.println("Total usuários encontrados: " + lista.size());
        return lista;
    }

    public void inserir(Usuario u) {
        String sql = "INSERT INTO usuarios (nome, email, senha, acesso) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setInt(4, u.getNivelAcesso());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuário cadastrado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, senha = ?, email = ?, acesso = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
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
        String sql = "DELETE FROM usuarios WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Usuario buscarPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        String sql = "SELECT * FROM usuarios WHERE nome=? AND senha=? AND acesso!=0";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, username);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro no login: " + e.getMessage());
            return false;
        }
    }
}