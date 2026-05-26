package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cargo;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos cargos dos funcionários.
 * 
 * Realiza cadastro e listagem dos cargos
 * disponíveis no sistema.
 */
public class CargoDAO {

    /**
     * Conexão com o banco de dados.
     */
    Connection conn;

    /**
     * PreparedStatement utilizado para executar comandos SQL.
     */
    PreparedStatement prep;

    /**
     * ResultSet utilizado para armazenar
     * os resultados das consultas SQL.
     */
    ResultSet rs;

    /**
     * Lista utilizada para armazenar
     * os cargos cadastrados.
     */
    ArrayList<Cargo> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo cargo
     * no banco de dados.
     * 
     * @param c objeto contendo os dados
     * do cargo
     */
    public void cadastrarCargo(Cargo c) {

        String sql = "INSERT INTO cargo(nome, permissoes) VALUES (?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, c.getNome());
            prep.setString(2, c.getPermissoes());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CargoDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os cargos cadastrados
     * no banco de dados.
     * 
     * @return lista contendo os cargos cadastrados
     */
    public ArrayList<Cargo> listarCargo() {

        String sql = "SELECT * FROM cargo";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                Cargo objCargo = new Cargo();

                objCargo.setId(rs.getInt("id"));
                objCargo.setNome(rs.getString("nome"));
                objCargo.setPermissoes(
                        rs.getString("permissoes")
                );

                lista.add(objCargo);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CargoDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }
}