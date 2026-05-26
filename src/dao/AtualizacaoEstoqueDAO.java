package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.AtualizacaoEstoque;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas às atualizações de estoque.
 * 
 * Realiza cadastro e listagem das movimentações
 * registradas no estoque do sistema.
 */
public class AtualizacaoEstoqueDAO {

    /**
     * Conexão com o banco de dados.
     */
    Connection conn;
    /**
     * PreparedStatement utilizado para executar comandos SQL.
     */
    PreparedStatement prep;
    /**
     * ResultSet utilizado para armazenar resultados
     * retornados das consultas SQL.
     */
    ResultSet rs;
    /**
     * ResultSet utilizado para armazenar resultados
     * retornados das consultas SQL.
     */
    ArrayList<AtualizacaoEstoque> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de uma nova atualização de estoque
     * no banco de dados.
     * 
     * @param a objeto contendo os dados da atualização
     */
    public void cadastrarAtualizacao(AtualizacaoEstoque a) {

        String sql = "INSERT INTO atualizacaoEstoque(idEstoque, quantidade, dataAtualizacao, tipo) VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, a.getIdEstoque());
            prep.setInt(2, a.getQuantidade());
            prep.setDate(3, java.sql.Date.valueOf(a.getData()));
            prep.setString(4, a.getTipo());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "AtualizacaoEstoqueDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todas as atualizações de estoque
     * cadastradas no banco de dados.
     * 
     * @return lista contendo as atualizações de estoque
     */
    public ArrayList<AtualizacaoEstoque> listarAtualizacoes() {

        String sql = "SELECT * FROM atualizacaoEstoque";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                AtualizacaoEstoque a = new AtualizacaoEstoque();

                a.setId(rs.getInt("id"));
                a.setIdEstoque(rs.getInt("idEstoque"));
                a.setQuantidade(rs.getInt("quantidade"));
                a.setData(rs.getDate("dataAtualizacao").toLocalDate());
                a.setTipo(rs.getString("tipo"));

                lista.add(a);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "AtualizacaoEstoqueDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }



    /**
 * Atualiza os dados de uma atualização de estoque
 * já cadastrada no banco de dados.
 * 
 * O método altera o estoque relacionado,
 * quantidade, data da atualização e tipo
 * da movimentação.
 * 
 * @param a objeto contendo os novos dados
 * da atualização de estoque
 */
public void alterarAtualizacao(AtualizacaoEstoque a) {

    String sql = "UPDATE atualizacaoEstoque "
            + "SET idEstoque=?, quantidade=?, "
            + "dataAtualizacao=?, tipo=? "
            + "WHERE id=?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        prep.setInt(1, a.getIdEstoque());
        prep.setInt(2, a.getQuantidade());
        prep.setDate(3, java.sql.Date.valueOf(a.getData()));
        prep.setString(4, a.getTipo());
        prep.setInt(5, a.getId());

        prep.execute();
        prep.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "AtualizacaoEstoqueDAO alterar: "
                + erro.getMessage());
    }
}


/**
 * Remove uma atualização de estoque
 * do banco de dados.
 * 
 * A exclusão é realizada utilizando
 * o ID da atualização.
 * 
 * @param a objeto contendo o ID
 * da atualização que será removida
 */
public void excluirAtualizacao(AtualizacaoEstoque a) {

    String sql =
            "DELETE FROM atualizacaoEstoque WHERE id=?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        prep.setInt(1, a.getId());

        prep.execute();
        prep.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "AtualizacaoEstoqueDAO excluir: "
                + erro.getMessage());
    }
}

}