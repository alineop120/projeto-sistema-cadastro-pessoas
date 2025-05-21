package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aline
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            // Certifique-se de que o driver JDBC está registrado
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL de conexão com o banco de dados MySQL
            String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados?useSSL=false&serverTimezone=UTC";
            String usuario = "root";  // Altere se necessário
            String senha = "root";    // Altere se necessário

            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
        }
    }
}

