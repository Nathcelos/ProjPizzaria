package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cardapio;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas ao cardápio do sistema.
 * 
 * Realiza cadastro, listagem, atualização,
 * remoção e filtros dos produtos do cardápio.
 */
public class CardapioDAO {

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
     * os produtos do cardápio.
     */
    ArrayList<Cardapio> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo item
     * no cardápio do sistema.
     * 
     * @param c objeto contendo os dados
     * do item do cardápio
     */
    public void cadastrarCardapio(Cardapio c) {

        String sql = "INSERT INTO cardapio(nome, descricao, preco, categoria) VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, c.getNome());
            prep.setString(2, c.getDescricao());
            prep.setDouble(3, c.getPreco());
            prep.setString(4, c.getCategoria());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CardapioDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os itens cadastrados
     * no cardápio.
     * 
     * @return lista contendo os itens do cardápio
     */
    public ArrayList<Cardapio> listarCardapio() {

        String sql = "SELECT * FROM cardapio";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                Cardapio c = new Cardapio();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDescricao(rs.getString("descricao"));
                c.setPreco(rs.getDouble("preco"));
                c.setCategoria(rs.getString("categoria"));

                lista.add(c);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CardapioDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza os dados de um item
     * do cardápio já existente.
     * 
     * @param c objeto contendo os novos dados
     * do item do cardápio
     */
    public void alterarCardapio(Cardapio c) {

        String sql = "UPDATE cardapio SET nome=?, descricao=?, preco=?, categoria=? WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, c.getNome());
            prep.setString(2, c.getDescricao());
            prep.setDouble(3, c.getPreco());
            prep.setString(4, c.getCategoria());
            prep.setInt(5, c.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CardapioDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um item do cardápio
     * utilizando o ID informado.
     * 
     * @param id identificador do item
     * que será removido
     */
    public void excluirCardapio(int id) {

        String sql = "DELETE FROM cardapio WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            prep.executeUpdate();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "CardapioDAO excluir: "
                    + erro.getMessage());
        }
    }


    /**
     * Realiza a busca de itens do cardápio
     * pelo nome informado.
     * 
     * O filtro utiliza o operador LIKE
     * para permitir buscas parciais.
     * 
     * @param nome nome utilizado na pesquisa
     * @return lista contendo os itens encontrados
     */
    public ArrayList<Cardapio> filtrar(String nome) {

        String sql = "SELECT * FROM cardapio WHERE nome LIKE ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, "%" + nome + "%");

            rs = prep.executeQuery();

            while (rs.next()) {

                Cardapio c = new Cardapio();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDescricao(rs.getString("descricao"));
                c.setPreco(rs.getDouble("preco"));
                c.setCategoria(rs.getString("categoria"));

                lista.add(c);
            }

        } catch (SQLException e) {

            System.out.println(
                    "CardapioDAO filtrar: "
                    + e.getMessage()
            );
        }

        return lista;
    }


    /**
     * Filtra os itens do cardápio
     * pela categoria selecionada.
     * 
     * Caso a categoria seja "todas",
     * retorna todos os itens cadastrados.
     * 
     * @param categoria categoria utilizada no filtro
     * @return lista contendo os itens filtrados
     */
    public ArrayList<Cardapio> filtrarPorCategoria(String categoria) {

        ArrayList<Cardapio> lista = new ArrayList<>();

        String sql;

        if (categoria.equalsIgnoreCase("todas")) {

            sql = "SELECT * FROM cardapio";

        } else {

            sql = "SELECT * FROM cardapio WHERE categoria = ?";
        }

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            if (!categoria.equalsIgnoreCase("todas")) {

                prep.setString(1, categoria);
            }

            rs = prep.executeQuery();

            while (rs.next()) {

                Cardapio c = new Cardapio();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCategoria(rs.getString("categoria"));
                c.setDescricao(rs.getString("descricao"));
                c.setPreco(rs.getDouble("preco"));

                lista.add(c);
            }

        } catch (SQLException e) {

            System.out.println(
                    "CardapioDAO filtrarPorCategoria: "
                    + e.getMessage()
            );
        }

        return lista;
    }


    /**
     * Retorna a quantidade total de itens
     * cadastrados no cardápio.
     * 
     * @return total de itens do cardápio
     */
    public int contarCardapio() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM cardapio";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            if (rs.next()) {

                total = rs.getInt(1);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro contar cardapio: "
                    + e
            );
        }

        return total;
    }
}