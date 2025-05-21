package dao;

import util.ConnectionFactory;
import java.sql.*;
import java.util.*;
import model.Usuario;

/**
 * Classe de acesso a dados para a entidade Usuario.
 */
public class UsuarioDAO {

    // -------------------- LISTAR TODOS OS USUÁRIOS --------------------
    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getInt("nivelAcesso") // Corrigido nome da coluna
                );
                lista.add(u);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return lista;
    }

    // -------------------- INSERIR USUÁRIO --------------------
    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, senha, email, nivelAcesso) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getNivelAcesso());
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }

    // -------------------- ATUALIZAR USUÁRIO --------------------
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome=?, senha=?, email=?, nivelAcesso=? WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getEmail());
            ps.setInt(4, usuario.getNivelAcesso());
            ps.setInt(5, usuario.getId());
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    // -------------------- DELETAR USUÁRIO --------------------
    public void deletar(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        }
    }

    // -------------------- BUSCAR USUÁRIO POR ID --------------------
    public Usuario buscarPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivelAcesso(rs.getInt("nivelAcesso")); // Corrigido
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao buscar usuário por ID: " + e.getMessage());
        }

        return usuario;
    }

    // -------------------- LOGIN --------------------
    public boolean login(String nome, String senha) {
        String sql = "SELECT * FROM usuarios WHERE nome=? AND senha=? AND nivelAcesso != 0";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // retorna true se encontrou o usuário

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }

}
