package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pagamento;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos pagamentos dos pedidos.
 * 
 * Realiza cadastro, listagem, atualização,
 * remoção e confirmação de pagamentos.
 */
public class PagamentoDAO {

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
     * os pagamentos retornados do banco.
     */
    ArrayList<Pagamento> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo pagamento
     * no banco de dados.
     * 
     * @param p objeto contendo os dados
     * do pagamento
     */
    public void cadastrarPagamento(Pagamento p) {

        String sql = "INSERT INTO pagamento(idPedido, valor, metodo, status) VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, p.getIdPedido());
            prep.setDouble(2, p.getValor());
            prep.setString(3, p.getMetodo());
            prep.setString(4, p.getStatus());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "PagamentoDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os pagamentos
     * cadastrados no banco de dados.
     * 
     * @return lista contendo os pagamentos cadastrados
     */
    public ArrayList<Pagamento> listarPagamento() {

        String sql = "SELECT * FROM pagamento";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                Pagamento p = new Pagamento();

                p.setId(rs.getInt("id"));
                p.setIdPedido(rs.getInt("idPedido"));
                p.setValor(rs.getDouble("valor"));
                p.setMetodo(rs.getString("metodo"));
                p.setStatus(rs.getString("status"));

                lista.add(p);
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "PagamentoDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza os dados de um pagamento
     * já cadastrado no banco de dados.
     * 
     * @param p objeto contendo os novos dados
     * do pagamento
     */
    public void alterarPagamento(Pagamento p) {

        String sql = "UPDATE pagamento SET idPedido=?, valor=?, metodo=?, status=? WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, p.getIdPedido());
            prep.setDouble(2, p.getValor());
            prep.setString(3, p.getMetodo());
            prep.setString(4, p.getStatus());
            prep.setInt(5, p.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "PagamentoDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um pagamento do banco de dados.
     * 
     * @param p objeto contendo o ID
     * do pagamento que será removido
     */
    public void excluirPagamento(Pagamento p) {

        String sql = "DELETE FROM pagamento WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, p.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "PagamentoDAO excluir: "
                    + erro.getMessage());
        }
    }


    /**
     * Confirma o pagamento de um pedido,
     * alterando seu status para "Pago".
     * 
     * @param idPedido identificador do pedido
     * que terá o pagamento confirmado
     */
    public void confirmarPagamento(int idPedido) {

        String sql = "UPDATE pagamento "
                + "SET status = 'Pago' "
                + "WHERE idPedido = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, idPedido);

            prep.executeUpdate();

            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "PagamentoDAO confirmarPagamento: "
                    + erro.getMessage());
        }
    }
}