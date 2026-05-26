package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos usuários do sistema.
 * 
 * Realiza cadastro, listagem, atualização,
 * remoção, busca e autenticação de usuários.
 */
public class UsuarioDAO {

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
     * os usuários retornados do banco.
     */
    ArrayList<Usuario> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo usuário
     * no banco de dados.
     * 
     * O método retorna o ID gerado automaticamente,
     * para que ele possa ser vinculado a um funcionário.
     * 
     * @param u objeto contendo login e senha do usuário
     * @return ID do usuário cadastrado
     */
    public int cadastrarUsuario(Usuario u) {

        int idGerado = 0;

        String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?)";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(
                    sql,
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            prep.setString(1, u.getLogin());
            prep.setString(2, u.getSenha());

            prep.executeUpdate();

            rs = prep.getGeneratedKeys();

            if (rs.next()) {
                idGerado = rs.getInt(1);
            }

            prep.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "Erro UsuarioDAO: "
                    + e.getMessage());
        }

        return idGerado;
    }


    /**
     * Retorna todos os usuários
     * cadastrados no banco de dados.
     * 
     * @return lista contendo os usuários cadastrados
     */
    public ArrayList<Usuario> listarUsuario() {

        String sql = "SELECT * FROM usuario";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();

            while (rs.next()) {

                Usuario u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                lista.add(u);
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "UsuarioDAO listar: "
                    + erro.getMessage());
        }

        return lista;
    }


    /**
     * Atualiza o login e a senha
     * de um usuário já cadastrado.
     * 
     * @param u objeto contendo os novos dados
     * do usuário
     */
    public void alterarUsuario(Usuario u) {

        String sql = "UPDATE usuario SET login=?, senha=? WHERE id=?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, u.getLogin());
            prep.setString(2, u.getSenha());
            prep.setInt(3, u.getId());

            prep.execute();
            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "UsuarioDAO alterar: "
                    + erro.getMessage());
        }
    }


    /**
     * Remove um usuário do banco de dados
     * utilizando o ID informado.
     * 
     * @param id identificador do usuário
     * que será removido
     */
    public void excluirUsuario(int id) {

        String sql =
                "DELETE FROM usuario "
                + "WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            prep.execute();

            prep.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "UsuarioDAO remover: "
                    + erro.getMessage());
        }
    }


    /**
     * Busca um usuário pelo ID informado.
     * 
     * @param id identificador do usuário
     * @return objeto Usuario encontrado
     * ou null caso não exista
     */
    public Usuario buscarUsuarioPorId(int id) {

        Usuario u = null;

        String sql = "SELECT * FROM usuario "
                + "WHERE id = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setInt(1, id);

            rs = prep.executeQuery();

            if (rs.next()) {

                u = new Usuario();

                u.setId(rs.getInt("id"));

                u.setLogin(
                        rs.getString("login")
                );

                u.setSenha(
                        rs.getString("senha")
                );
            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "UsuarioDAO buscarUsuarioPorId: "
                    + erro.getMessage());
        }

        return u;
    }


    /**
     * Realiza a autenticação do usuário
     * no sistema.
     * 
     * Além de validar login e senha,
     * o método busca os dados do funcionário
     * vinculado ao usuário, como nome, cargo
     * e ID do funcionário.
     * 
     * @param login login informado pelo usuário
     * @param senha senha informada pelo usuário
     * @return objeto Usuario preenchido caso o login seja válido,
     * ou null caso as credenciais estejam incorretas
     */
    public Usuario logar(String login, String senha) {

        Usuario u = null;

        String sql = "SELECT "
                + "u.id, "
                + "u.login, "
                + "u.senha, "
                + "f.id AS idFuncionario, "
                + "f.nome, "
                + "f.idCargo "
                + "FROM usuario u "
                + "JOIN funcionario f ON u.id = f.idUsuario "
                + "WHERE u.login = ? "
                + "AND u.senha = ?";

        conn = new conectaDAO().connectDB();

        try {

            prep = conn.prepareStatement(sql);

            prep.setString(1, login);
            prep.setString(2, senha);

            rs = prep.executeQuery();

            if (rs.next()) {

                u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setIdCargo(rs.getInt("idCargo"));
                u.setNomeFuncionario(rs.getString("nome"));
                u.setIdFuncionario(
                        rs.getInt("idFuncionario")
                );
            }

            prep.close();
            rs.close();

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null,
                    "UsuarioDAO logar: "
                    + erro.getMessage());
        }

        return u;
    }
}