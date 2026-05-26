package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos funcionários do sistema.
 * 
 * Realiza cadastro, listagem, atualização,
 * remoção, filtros e buscas de funcionários.
 */
public class FuncionarioDAO {

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
     * os funcionários retornados do banco.
     */
    ArrayList<Funcionario> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo funcionário
     * no banco de dados.
     * 
     * @param f objeto contendo os dados
     * do funcionário
     * 
     * @return true caso o cadastro seja realizado
     * com sucesso e false em caso de erro
     */
    public boolean cadastrarFuncionario(Funcionario f) {

        String sql = "INSERT INTO funcionario(idUsuario, nome, telefone, idCargo, dataContratacao) VALUES (?, ?, ?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, f.getIdUsuario());
            prep.setString(2, f.getNome());
            prep.setString(3, f.getTelefone());
            prep.setInt(4, f.getIdCargo());
            prep.setString(5, f.getDataContratacao());

            prep.execute();
            prep.close();

            return true;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "FuncionarioDAO cadastrar: "
                    + erro.getMessage());

            return false;
        }
    }


    /**
     * Retorna todos os funcionários cadastrados
     * no sistema.
     * 
     * O método realiza JOIN com a tabela cargo
     * para retornar o nome do cargo do funcionário.
     * 
     * @return lista contendo os funcionários cadastrados
     */
    public ArrayList<Funcionario> listarFuncionarios() {

        String sql = "SELECT "
                + "f.id, "
                + "f.idUsuario, "
                + "f.nome, "
                + "f.telefone, "
                + "c.nome AS cargo, "
                + "f.dataContratacao "
                + "FROM funcionario f "
                + "JOIN cargo c "
                + "ON f.idCargo = c.id";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            rs = prep.executeQuery();

            while (rs.next()) {

                Funcionario f = new Funcionario();

                f.setId(rs.getInt("id"));

                f.setIdUsuario(
                        rs.getInt("idUsuario")
                );

                f.setNome(rs.getString("nome"));

                f.setTelefone(
                        rs.getString("telefone")
                );

                f.setCargo(
                        rs.getString("cargo")
                );

                f.setDataContratacao(
                        rs.getString("dataContratacao")
                );

                lista.add(f);
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "FuncionarioDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza os dados de um funcionário
     * já cadastrado no banco de dados.
     * 
     * @param f objeto contendo os novos dados
     * do funcionário
     */
    public void alterarFuncionario(Funcionario f) {

        String sql = "UPDATE funcionario SET "
                + "idUsuario=?, nome=?, telefone=?, "
                + "idCargo=?, dataContratacao=? "
                + "WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, f.getIdUsuario());
            prep.setString(2, f.getNome());
            prep.setString(3, f.getTelefone());
            prep.setInt(4, f.getIdCargo());
            prep.setString(5, f.getDataContratacao());
            prep.setInt(6, f.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "FuncionarioDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um funcionário do banco de dados
     * utilizando o ID informado.
     * 
     * @param id identificador do funcionário
     * que será removido
     */
    public void excluirFuncionario(int id) {

        String sql =
                "DELETE FROM funcionario "
                + "WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            prep.execute();

            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "FuncionarioDAO remover: "
                    + erro.getMessage());
        }
    }


    /**
     * Filtra funcionários utilizando o ID informado.
     * 
     * O filtro utiliza LIKE para permitir
     * buscas parciais.
     * 
     * @param filtro texto utilizado na pesquisa
     * @return lista contendo os funcionários encontrados
     */
    public ArrayList<Funcionario> filtrarFuncionarios(
            String filtro) {

        String sql = "SELECT "
                + "f.id, "
                + "f.idUsuario, "
                + "f.nome, "
                + "f.telefone, "
                + "c.nome AS cargo, "
                + "f.dataContratacao "
                + "FROM funcionario f "
                + "JOIN cargo c "
                + "ON f.idCargo = c.id "
                + "WHERE f.id LIKE ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1,
                    "%" + filtro + "%");

            rs = prep.executeQuery();

            while (rs.next()) {

                Funcionario f =
                        new Funcionario();

                f.setId(
                        rs.getInt("id")
                );

                f.setIdUsuario(
                        rs.getInt("idUsuario")
                );

                f.setNome(
                        rs.getString("nome")
                );

                f.setTelefone(
                        rs.getString("telefone")
                );

                f.setCargo(
                        rs.getString("cargo")
                );

                f.setDataContratacao(
                        rs.getString("dataContratacao")
                );

                lista.add(f);
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "FuncionarioDAO filtrarFuncionarios: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Retorna a quantidade de funcionários
     * cadastrados em um determinado cargo.
     * 
     * @param cargo nome do cargo utilizado na busca
     * @return total de funcionários do cargo informado
     */
    public int contarFuncionariosPorCargo(
            String cargo) {

        int total = 0;

        String sql = "SELECT COUNT(*) AS total "
                + "FROM funcionario f "
                + "JOIN cargo c "
                + "ON f.idCargo = c.id "
                + "WHERE c.nome = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, cargo);

            rs = prep.executeQuery();

            if (rs.next()) {

                total = rs.getInt("total");
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "FuncionarioDAO contarFuncionariosPorCargo: "
                    + erro.getMessage());
        }

        return total;
    }


    /**
     * Retorna a quantidade total
     * de funcionários cadastrados.
     * 
     * @return total de funcionários
     */
    public int contarFuncionarios() {

        int total = 0;

        String sql = "SELECT COUNT(*) AS total "
                + "FROM funcionario";

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
                    "FuncionarioDAO contarFuncionarios: "
                    + erro.getMessage());
        }

        return total;
    }


    /**
     * Busca um funcionário no banco de dados
     * utilizando o ID informado.
     * 
     * @param id identificador do funcionário
     * @return objeto Funcionario encontrado
     * ou null caso não exista
     */
    public Funcionario buscarFuncionarioPorId(int id) {

        Funcionario f = null;

        String sql = "SELECT "
                + "f.id, "
                + "f.idUsuario, "
                + "f.nome, "
                + "f.telefone, "
                + "f.dataContratacao, "
                + "c.nome AS cargo "
                + "FROM funcionario f "
                + "JOIN cargo c "
                + "ON f.idCargo = c.id "
                + "WHERE f.id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            rs = prep.executeQuery();

            if (rs.next()) {

                f = new Funcionario();

                f.setId(
                        rs.getInt("id")
                );

                f.setIdUsuario(
                        rs.getInt("idUsuario")
                );

                f.setNome(
                        rs.getString("nome")
                );

                f.setTelefone(
                        rs.getString("telefone")
                );

                f.setCargo(
                        rs.getString("cargo")
                );

                f.setDataContratacao(
                        rs.getString("dataContratacao")
                );
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "FuncionarioDAO buscarFuncionarioPorId: "
                    + erro.getMessage());
        }

        return f;
    }
}