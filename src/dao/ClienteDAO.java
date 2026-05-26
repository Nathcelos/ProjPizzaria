
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Cliente;


/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos clientes do sistema.
 * 
 * Realiza cadastro, listagem, atualização,
 * remoção, busca e filtros de clientes.
 */
public class ClienteDAO {

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
     * os clientes retornados do banco.
     */
    ArrayList<Cliente> listagem = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo cliente
     * no banco de dados.
     * 
     * @param objCliente objeto contendo os dados
     * do cliente
     */
    public void cadastrarCliente(Cliente objCliente) {

        String sql = "INSERT INTO cliente(nome, telefone, endereco, observacao) VALUES (?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, objCliente.getNome());
            prep.setString(2, objCliente.getTelefone());
            prep.setString(3, objCliente.getEndereco());
            prep.setString(4, objCliente.getObservacao());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ClienteDAO cadastrar: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna todos os clientes cadastrados
     * no banco de dados.
     * 
     * @return lista contendo os clientes cadastrados
     */
    public ArrayList<Cliente> listarClientes() {

        String sql = "SELECT * FROM cliente";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setObservacao(rs.getString("observacao"));

                listagem.add(c);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ClienteDAO listar: "
                    + erro.getMessage());
        }

        return listagem;
    }


    /**
     * Atualiza os dados de um cliente
     * já cadastrado no sistema.
     * 
     * @param c objeto contendo os novos dados
     * do cliente
     */
    public void alterarCliente(Cliente c) {

        String sql = "UPDATE cliente SET nome=?, telefone=?, endereco=?, observacao=? WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, c.getNome());
            prep.setString(2, c.getTelefone());
            prep.setString(3, c.getEndereco());
            prep.setString(4, c.getObservacao());
            prep.setInt(5, c.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ClienteDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um cliente do banco de dados
     * utilizando o ID informado.
     * 
     * @param id identificador do cliente
     * que será removido
     */
    public void excluirCliente(int id) {

        String sql = "DELETE FROM cliente WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ClienteDAO excluir: "
                    + erro.getMessage());
        }
    }


    /**
     * Retorna a quantidade total de clientes
     * cadastrados no sistema.
     * 
     * @return total de clientes cadastrados
     */
    public int contarClientes() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM cliente";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            if (rs.next()) {

                total = rs.getInt(1);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro contarClientes: "
                    + e.getMessage()
            );
        }

        return total;
    }


    /**
     * Realiza o filtro de clientes pelo ID informado.
     * 
     * O filtro utiliza LIKE para permitir
     * buscas parciais.
     * 
     * @param id identificador utilizado na pesquisa
     * @return lista contendo os clientes encontrados
     */
    public ArrayList<Cliente> filtrar(String id) {

        String sql = "SELECT * FROM cliente WHERE CAST(id AS CHAR) LIKE ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, "%" + id + "%");

            rs = prep.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                c.setObservacao(rs.getString("observacao"));

                listagem.add(c);
            }

        } catch (SQLException e) {

            System.out.println(
                    "PedidoDAO filtrar: "
                    + e.getMessage()
            );
        }

        return listagem;
    }


    /**
     * Retorna a quantidade de clientes
     * cadastrados no dia atual.
     * 
     * @return total de clientes cadastrados hoje
     */
    public int contarClientesHoje() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM cliente WHERE DATE(dataCadastro) = CURDATE()";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            if (rs.next()) {

                total = rs.getInt(1);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Erro contar clientes hoje: "
                    + e
            );
        }

        return total;
    }


    /**
     * Busca um cliente no banco de dados
     * utilizando o ID informado.
     * 
     * @param id identificador do cliente
     * @return objeto Cliente encontrado
     * ou null caso não exista
     */
    public Cliente buscarClientePorId(int id) {

        String sql = "SELECT * FROM cliente WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            rs = prep.executeQuery();

            if (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));

                c.setNome(rs.getString("nome"));

                c.setTelefone(rs.getString("telefone"));

                c.setEndereco(rs.getString("endereco"));

                return c;
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "ClienteDAO buscar: "
                    + erro.getMessage());
        }

        return null;
    }
}