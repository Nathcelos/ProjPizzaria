package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Caixa;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas ao caixa do sistema.
 * 
 * Realiza cadastro, listagem, atualização
 * e remoção das movimentações financeiras.
 */
public class CaixaDAO {

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
     * os registros do caixa.
     */
    ArrayList<Caixa> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo registro
     * de caixa no banco de dados.
     * 
     * @param c objeto contendo os dados
     * do caixa que será cadastrado
     */
    public void cadastrarCaixa(Caixa c) {

        String sql = "INSERT INTO caixa(dataCaixa, totalVendas, totalGastos, saldoFinal) VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setDate(1, java.sql.Date.valueOf(c.getData()));
            prep.setDouble(2, c.getTotalVendas());
            prep.setDouble(3, c.getTotalGasto());
            prep.setDouble(4, c.getSaldoFinal());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CaixaDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os registros de caixa
     * cadastrados no banco de dados.
     * 
     * @return lista contendo os registros do caixa
     */
    public ArrayList<Caixa> listarCaixa() {

        String sql = "SELECT * FROM caixa";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            rs = prep.executeQuery();

            while (rs.next()) {

                Caixa c = new Caixa();

                c.setId(rs.getInt("id"));

                c.setData(
                        rs.getDate("dataCaixa")
                                .toLocalDate()
                );

                c.setTotalVendas(
                        rs.getDouble("totalVendas")
                );

                c.setTotalGasto(
                        rs.getDouble("totalGasto")
                );

                c.setSaldoFinal(
                        rs.getDouble("saldoFinal")
                );

                lista.add(c);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CaixaDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza os dados de um registro
     * de caixa já existente no banco de dados.
     * 
     * @param c objeto contendo os novos dados
     * do caixa
     */
    public void alterarCaixa(Caixa c) {

        String sql = "UPDATE caixa SET "
                + "dataCaixa=?, "
                + "totalVendas=?, "
                + "totalGastos=?, "
                + "saldoFinal=? "
                + "WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setDate(1,
                    java.sql.Date.valueOf(c.getData()));

            prep.setDouble(2,
                    c.getTotalVendas());

            prep.setDouble(3,
                    c.getTotalGasto());

            prep.setDouble(4,
                    c.getSaldoFinal());

            prep.setInt(5,
                    c.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CaixaDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um registro de caixa
     * do banco de dados.
     * 
     * A exclusão é realizada utilizando
     * o ID do caixa.
     * 
     * @param c objeto contendo o ID
     * do caixa que será removido
     */
    public void excluirCaixa(Caixa c) {

        String sql = "DELETE FROM caixa WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, c.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CaixaDAO excluir: "
                    + erro.getMessage());
        }
    }
}