package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Relatorio;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos relatórios do sistema.
 * 
 * Realiza cadastro, listagem, atualização
 * e remoção dos relatórios gerados.
 */
public class RelatorioDAO {

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
     * os relatórios retornados do banco.
     */
    ArrayList<Relatorio> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo relatório
     * no banco de dados.
     * 
     * @param r objeto contendo os dados
     * do relatório que será cadastrado
     */
    public void cadastrarRelatorio(Relatorio r) {

        String sql = "INSERT INTO relatorio(tipo, dataGeracao, periodoInicio, periodoFim) VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, r.getTipo());
            prep.setDate(2, java.sql.Date.valueOf(r.getDataGeracao()));
            prep.setDate(3, java.sql.Date.valueOf(r.getPeriodoInicio()));
            prep.setDate(4, java.sql.Date.valueOf(r.getPeriodoFinal()));

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "RelatorioDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os relatórios
     * cadastrados no banco de dados.
     * 
     * @return lista contendo os relatórios cadastrados
     */
    public ArrayList<Relatorio> listarRelatorio() {

        String sql = "SELECT * FROM relatorio";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                Relatorio r = new Relatorio();

                r.setId(rs.getInt("id"));
                r.setTipo(rs.getString("tipo"));
                r.setDataGeracao(
                        rs.getDate("dataGeracao").toLocalDate()
                );
                r.setPeriodoInicio(
                        rs.getDate("periodoInicio").toLocalDate()
                );
                r.setPeriodoFinal(
                        rs.getDate("periodoFim").toLocalDate()
                );

                lista.add(r);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "RelatorioDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza os dados de um relatório
     * já cadastrado no banco de dados.
     * 
     * @param r objeto contendo os novos dados
     * do relatório
     */
    public void alterarRelatorio(Relatorio r) {

        String sql = "UPDATE relatorio SET "
                + "tipo=?, dataGeracao=?, "
                + "periodoInicio=?, periodoFim=? "
                + "WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, r.getTipo());
            prep.setDate(2, java.sql.Date.valueOf(r.getDataGeracao()));
            prep.setDate(3, java.sql.Date.valueOf(r.getPeriodoInicio()));
            prep.setDate(4, java.sql.Date.valueOf(r.getPeriodoFinal()));
            prep.setInt(5, r.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "RelatorioDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um relatório do banco de dados.
     * 
     * @param r objeto contendo o ID
     * do relatório que será removido
     */
    public void excluirRelatorio(Relatorio r) {

        String sql = "DELETE FROM relatorio WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, r.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "RelatorioDAO excluir: "
                    + erro.getMessage());
        }
    }
}