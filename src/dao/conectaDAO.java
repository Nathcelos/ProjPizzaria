package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 * Classe responsável por realizar
 * a conexão com o banco de dados MySQL.
 * 
 * A conexão é utilizada pelos DAOs
 * do sistema para executar comandos SQL.
 */
public class conectaDAO {

    /**
     * Realiza a conexão com o banco de dados.
     * 
     * O método utiliza DriverManager
     * para conectar ao banco da pizzaria.
     * 
     * @return objeto Connection conectado ao banco,
     * ou null caso ocorra erro na conexão
     */
    public Connection connectDB() {

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proj_pizzaria",
                    "root",
                    "senha"
            );

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "Erro ao Conectar no BD: "
                    + erro.getMessage());

        }

        return conn;
    }
}