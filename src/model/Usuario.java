
package model;


/**
 * Classe modelo responsável por representar
 * os usuários do sistema.
 *
 * A classe armazena informações
 * de autenticação e dados do funcionário
 * vinculados ao login.
 */
public class Usuario {

    /**
     * Identificador do usuário.
     */
    private int id;

    /**
     * Login utilizado para acessar o sistema.
     */
    private String login;

    /**
     * Senha utilizada para autenticação.
     */
    private String senha;

    /**
     * Identificador do cargo do usuário.
     *
     * Exemplos:
     * 1 = Gerente
     * 2 = Atendente
     * 3 = Cozinheiro
     * 4 = Entregador
     */
    private int idCargo;

    /**
     * Nome do funcionário vinculado
     * ao usuário.
     */
    private String nomeFuncionario;

    /**
     * Identificador do funcionário
     * vinculado ao usuário.
     */
    private int idFuncionario;


    /**
     * Retorna o ID do usuário.
     *
     * @return identificador do usuário
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do usuário.
     *
     * @param id identificador do usuário
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o login do usuário.
     *
     * @return login do usuário
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define o login do usuário.
     *
     * @param login login do usuário
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha senha do usuário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna o ID do cargo do usuário.
     *
     * @return identificador do cargo
     */
    public int getIdCargo() {
        return idCargo;
    }

    /**
     * Define o ID do cargo do usuário.
     *
     * @param idCargo identificador do cargo
     */
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    /**
     * Retorna o nome do funcionário vinculado.
     *
     * @return nome do funcionário
     */
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    /**
     * Define o nome do funcionário vinculado.
     *
     * @param nomeFuncionario nome do funcionário
     */
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    /**
     * Retorna o ID do funcionário vinculado.
     *
     * @return identificador do funcionário
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Define o ID do funcionário vinculado.
     *
     * @param idFuncionario identificador do funcionário
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}