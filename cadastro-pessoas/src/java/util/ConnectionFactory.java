package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aline
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/cadastrosbd";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC na o encontrado!", e);
        }
    }
}
