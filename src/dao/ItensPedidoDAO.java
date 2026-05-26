package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ItensPedido;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos itens dos pedidos.
 * 
 * Realiza cadastro, listagem, atualização,
 * remoção e gerenciamento dos itens vinculados aos pedidos.
 */
public class ItensPedidoDAO {

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
     * os itens dos pedidos retornados do banco.
     */
    ArrayList<ItensPedido> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo item
     * em um pedido.
     * 
     * @param i objeto contendo os dados
     * do item do pedido
     */
    public void cadastrarItemPedido(ItensPedido i) {

        String sql = "INSERT INTO itensPedido(idPedido, idCardapio, quantidade, subtotal) VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, i.getIdPedido());
            prep.setInt(2, i.getIdCardapio());
            prep.setInt(3, i.getQuantidade());
            prep.setDouble(4, i.getSubtotal());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ItensPedidoDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os itens dos pedidos
     * cadastrados no sistema.
     * 
     * O método realiza JOIN com a tabela cardapio
     * para retornar nome e preço do produto.
     * 
     * @return lista contendo os itens dos pedidos
     */
    public ArrayList<ItensPedido> listarItensPedido() {

        lista.clear();

        String sql = "SELECT ip.*, c.nome, c.preco "
                + "FROM itensPedido ip "
                + "JOIN cardapio c "
                + "ON ip.idCardapio = c.id";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            rs = prep.executeQuery();

            while (rs.next()) {

                ItensPedido i = new ItensPedido();

                i.setId(rs.getInt("id"));

                i.setIdPedido(
                        rs.getInt("idPedido")
                );

                i.setIdCardapio(
                        rs.getInt("idCardapio")
                );

                i.setQuantidade(
                        rs.getInt("quantidade")
                );

                i.setSubtotal(
                        rs.getDouble("subtotal")
                );

                i.setNomeProduto(
                        rs.getString("nome")
                );

                i.setPrecoProduto(
                        rs.getDouble("preco")
                );

                lista.add(i);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ItensPedidoDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza os dados de um item
     * de pedido já cadastrado.
     * 
     * @param i objeto contendo os novos dados
     * do item do pedido
     */
    public void alterarItensPedido(ItensPedido i) {

        String sql = "UPDATE itensPedido SET "
                + "idPedido=?, idCardapio=?, "
                + "quantidade=?, subtotal=? "
                + "WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, i.getIdPedido());
            prep.setInt(2, i.getIdCardapio());
            prep.setInt(3, i.getQuantidade());
            prep.setDouble(4, i.getSubtotal());
            prep.setInt(5, i.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ItensPedidoDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um item de pedido
     * utilizando o ID informado.
     * 
     * @param i objeto contendo o ID
     * do item que será removido
     */
    public void excluirItensPedido(ItensPedido i) {

        String sql = "DELETE FROM itensPedido WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, i.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ItensPedidoDAO excluir: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove todos os itens relacionados
     * a um determinado pedido.
     * 
     * @param idPedido identificador do pedido
     */
    public void removerItensPedido(int idPedido) {

        String sql =
                "DELETE FROM itensPedido "
                + "WHERE idPedido=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, idPedido);

            prep.executeUpdate();

            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    null,
                    "ItensPedidoDAO removerItensPedido: "
                    + erro.getMessage()
            );
        }
    }


    /**
     * Salva novamente todos os itens
     * de um pedido.
     * 
     * Utilizado principalmente após edição
     * de pedidos.
     * 
     * @param idPedido identificador do pedido
     * @param lista lista contendo os itens
     * que serão salvos
     */
    public void salvarItensPedido(
            int idPedido,
            ArrayList<ItensPedido> lista) {

        String sql =
                "INSERT INTO itensPedido "
                + "(idPedido, idCardapio, quantidade, subtotal) "
                + "VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            for (ItensPedido item : lista) {

                prep.setInt(1, idPedido);

                prep.setInt(
                        2,
                        item.getIdCardapio()
                );

                prep.setInt(
                        3,
                        item.getQuantidade()
                );

                prep.setDouble(
                        4,
                        item.getSubtotal()
                );

                prep.execute();
            }

            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    null,
                    "ItensPedidoDAO salvarItensPedido: "
                    + erro.getMessage()
            );
        }
    }
}