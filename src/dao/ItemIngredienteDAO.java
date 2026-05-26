package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ItemIngrediente;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos ingredientes utilizados nos itens do cardápio.
 * 
 * Realiza cadastro, listagem, atualização e remoção
 * dos ingredientes vinculados aos produtos.
 */
public class ItemIngredienteDAO {

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
     * os itens e ingredientes retornados do banco.
     */
    ArrayList<ItemIngrediente> lista = new ArrayList<>();


    /**
     * Cadastra um ingrediente necessário
     * para um item do cardápio.
     * 
     * @param i objeto contendo os dados
     * do vínculo entre item do cardápio e ingrediente
     */
    public void cadastrarItemIngrediente(ItemIngrediente i) {

        String sql = "INSERT INTO itemIngrediente(idCardapio, idEstoque, qtdNecessaria, medida) VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, i.getIdCardapio());
            prep.setInt(2, i.getIdEstoque());
            prep.setDouble(3, i.getQtdNecessaria());
            prep.setString(4, i.getMedida());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ItemIngredienteDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os vínculos cadastrados
     * entre itens do cardápio e ingredientes.
     * 
     * @return lista contendo os itens e ingredientes cadastrados
     */
    public ArrayList<ItemIngrediente> listarItemIngrediente() {

        String sql = "SELECT * FROM itemIngrediente";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                ItemIngrediente i =
                        new ItemIngrediente();

                i.setId(rs.getInt("id"));
                i.setIdCardapio(rs.getInt("idCardapio"));
                i.setIdEstoque(rs.getInt("idEstoque"));
                i.setQtdNecessaria(rs.getDouble("qtdNecessaria"));
                i.setMedida(rs.getString("medida"));

                lista.add(i);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ItemIngredienteDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza os dados de um vínculo
     * entre item do cardápio e ingrediente.
     * 
     * @param i objeto contendo os novos dados
     * do item ingrediente
     */
    public void alterarItemIngrediente(ItemIngrediente i) {

        String sql = "UPDATE itemIngrediente SET "
                + "idCardapio=?, idEstoque=?, "
                + "qtdNecessaria=?, medida=? "
                + "WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, i.getIdCardapio());
            prep.setInt(2, i.getIdEstoque());
            prep.setDouble(3, i.getQtdNecessaria());
            prep.setString(4, i.getMedida());
            prep.setInt(5, i.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ItemIngredienteDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um vínculo entre item do cardápio
     * e ingrediente do banco de dados.
     * 
     * @param objItem objeto contendo o ID
     * do vínculo que será removido
     */
    public void excluirItemIngrediente(ItemIngrediente objItem) {

        String sql =
                "DELETE FROM itemIngrediente WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, objItem.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ItemIngredienteDAO excluir: "
                    + erro.getMessage());
        }
    }
}