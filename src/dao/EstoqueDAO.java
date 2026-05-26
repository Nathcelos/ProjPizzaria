package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Estoque;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas ao estoque do sistema.
 * 
 * Realiza cadastro, listagem, atualização,
 * remoção, busca e filtros de itens do estoque.
 */
public class EstoqueDAO {

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
     * os itens do estoque retornados do banco.
     */
    ArrayList<Estoque> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo item
     * no estoque do sistema.
     * 
     * @param e objeto contendo os dados
     * do item do estoque
     */
    public void cadastrarEstoque(Estoque e) {

        String sql = "INSERT INTO estoque(nome, quantidade, validade, fornecedor, categoria, observacao) VALUES (?, ?, ?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, e.getNome());
            prep.setInt(2, e.getQuantidade());
            prep.setDate(3,
                    java.sql.Date.valueOf(e.getValidade()));
            prep.setString(4, e.getFornecedor());
            prep.setString(5, e.getCategoria());
            prep.setString(6, e.getObservacao());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os itens cadastrados
     * no estoque.
     * 
     * @return lista contendo os itens do estoque
     */
    public ArrayList<Estoque> listarEstoque() {

        String sql = "SELECT * FROM estoque";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                Estoque e = new Estoque();

                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setValidade(rs.getString("validade"));
                e.setFornecedor(rs.getString("fornecedor"));
                e.setCategoria(rs.getString("categoria"));
                e.setObservacao(rs.getString("observacao"));

                lista.add(e);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza todos os dados de um item
     * do estoque já existente.
     * 
     * @param e objeto contendo os novos dados
     * do item do estoque
     */
    public void atualizarEstoque(Estoque e) {

        String sql = "UPDATE estoque SET "
                + "nome = ?, "
                + "fornecedor = ?, "
                + "quantidade = ?, "
                + "validade = ?, "
                + "categoria = ?, "
                + "observacao = ? "
                + "WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, e.getNome());
            prep.setString(2, e.getFornecedor());
            prep.setInt(3, e.getQuantidade());
            prep.setString(4, e.getValidade());
            prep.setString(5, e.getCategoria());
            prep.setString(6, e.getObservacao());
            prep.setInt(7, e.getId());

            prep.executeUpdate();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um item do estoque
     * utilizando o ID informado.
     * 
     * @param id identificador do item
     * que será removido
     */
    public void excluirEstoque(int id) {

        String sql = "DELETE FROM estoque WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            prep.execute();

            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO removerEstoque: "
                    + erro.getMessage());
        }
    }


    /**
     * Busca um item do estoque
     * utilizando o ID informado.
     * 
     * @param id identificador do item
     * @return objeto Estoque encontrado
     * ou null caso não exista
     */
    public Estoque buscarEstoquePorId(int id) {

        Estoque e = null;

        String sql = "SELECT * FROM estoque "
                + "WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            rs = prep.executeQuery();

            if (rs.next()) {

                e = new Estoque();

                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setFornecedor(rs.getString("fornecedor"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setValidade(rs.getString("validade"));
                e.setCategoria(rs.getString("categoria"));
                e.setObservacao(rs.getString("observacao"));
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO buscarEstoquePorId: "
                    + erro.getMessage());
        }

        return e;
    }


    /**
     * Retorna a quantidade total
     * de itens cadastrados no estoque.
     * 
     * @return total de itens do estoque
     */
    public int contarEstoque() {

        int total = 0;

        String sql = "SELECT COUNT(*) AS total FROM estoque";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            if (rs.next()) {

                total = rs.getInt("total");
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO contarItens: "
                    + erro.getMessage());
        }

        return total;
    }


    /**
     * Filtra os itens do estoque
     * utilizando o ID informado.
     * 
     * @param filtro texto utilizado no filtro
     * @return lista contendo os itens encontrados
     */
    public ArrayList<Estoque> filtrar(String filtro) {

        String sql = "SELECT * FROM estoque WHERE id LIKE ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, "%" + filtro + "%");

            rs = prep.executeQuery();

            while (rs.next()) {

                Estoque e = new Estoque();

                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setFornecedor(rs.getString("fornecedor"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setValidade(rs.getString("validade"));
                e.setCategoria(rs.getString("categoria"));

                lista.add(e);
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO filtrar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Retorna a quantidade de itens
     * com estoque baixo.
     * 
     * Considera itens com quantidade
     * menor ou igual a 5.
     * 
     * @return total de itens com estoque baixo
     */
    public int contarEstoqueBaixo() {

        int total = 0;

        String sql =
                "SELECT COUNT(*) AS total "
                + "FROM estoque "
                + "WHERE quantidade <= 5";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            rs = prep.executeQuery();

            if (rs.next()) {

                total = rs.getInt("total");
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO contarEstoqueBaixo: "
                    + erro.getMessage());
        }

        return total;
    }


    /**
     * Retorna a quantidade de itens
     * próximos do vencimento.
     * 
     * Considera itens vencendo
     * nos próximos 7 dias.
     * 
     * @return total de itens vencendo
     */
    public int contarItensVencendo() {

        int total = 0;

        String sql =
                "SELECT COUNT(*) AS total "
                + "FROM estoque "
                + "WHERE validade "
                + "BETWEEN CURDATE() "
                + "AND DATE_ADD(CURDATE(), INTERVAL 7 DAY)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            rs = prep.executeQuery();

            if (rs.next()) {

                total = rs.getInt("total");
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO contarItensVencendo: "
                    + erro.getMessage());
        }

        return total;
    }


    /**
     * Atualiza apenas quantidade,
     * validade e observação
     * de um item do estoque.
     * 
     * @param e objeto contendo os novos dados
     */
    public void atualizarEstoque2(Estoque e) {

        String sql = "UPDATE estoque SET "
                + "quantidade = ?, "
                + "validade = ?, "
                + "observacao = ? "
                + "WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, e.getQuantidade());
            prep.setString(2, e.getValidade());
            prep.setString(3, e.getObservacao());
            prep.setInt(4, e.getId());

            prep.executeUpdate();

            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO atualizarEstoque: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna os produtos
     * com estoque baixo.
     * 
     * Considera produtos com quantidade
     * menor ou igual a 5.
     * 
     * @return lista contendo os produtos
     * com estoque baixo
     */
    public ArrayList<Estoque> listarProdutosBaixoEstoque() {

        String sql = "SELECT nome, quantidade "
                + "FROM estoque "
                + "WHERE quantidade <= 5";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            rs = prep.executeQuery();

            while (rs.next()) {

                Estoque e = new Estoque();

                e.setNome(rs.getString("nome"));

                e.setQuantidade(rs.getInt("quantidade"));

                lista.add(e);
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "EstoqueDAO listarProdutosBaixoEstoque: "
                    + erro.getMessage());
        }

        return lista;
    }
}