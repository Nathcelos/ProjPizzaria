
package model;

/**
 * Classe modelo responsável por representar
 * os funcionários cadastrados no sistema.
 * 
 * A classe armazena informações pessoais,
 * dados de acesso e cargo do funcionário.
 */
public class Funcionario {

    /**
     * Identificador do funcionário.
     */
    private int id;

    /**
     * Identificador do usuário vinculado
     * ao funcionário.
     */
    private int idUsuario;

    /**
     * Nome do funcionário.
     */
    private String nome;

    /**
     * Telefone do funcionário.
     */
    private String telefone;

    /**
     * Identificador do cargo do funcionário.
     */
    private int idCargo;

    /**
     * Data de contratação do funcionário.
     */
    private String dataContratacao;

    /**
     * Nome do cargo do funcionário.
     * 
     * Exemplos:
     * Gerente, Atendente,
     * Cozinheiro e Entregador.
     */
    private String cargo;


    /**
     * Retorna o ID do funcionário.
     * 
     * @return identificador do funcionário
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do funcionário.
     * 
     * @param id identificador do funcionário
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o ID do usuário vinculado.
     * 
     * @return identificador do usuário
     */
    public int getIdUsuario() {
        return idUsuario;
    }


    /**
     * Define o ID do usuário vinculado.
     * 
     * @param idUsuario identificador do usuário
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Retorna o nome do funcionário.
     * 
     * @return nome do funcionário
     */
    public String getNome() {
        return nome;
    }


    /**
     * Define o nome do funcionário.
     * 
     * @param nome nome do funcionário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Retorna o telefone do funcionário.
     * 
     * @return telefone do funcionário
     */
    public String getTelefone() {
        return telefone;
    }


    /**
     * Define o telefone do funcionário.
     * 
     * @param telefone telefone do funcionário
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    /**
     * Retorna o ID do cargo do funcionário.
     * 
     * @return identificador do cargo
     */
    public int getIdCargo() {
        return idCargo;
    }


    /**
     * Define o ID do cargo do funcionário.
     * 
     * @param idCargo identificador do cargo
     */
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }


    /**
     * Retorna a data de contratação.
     * 
     * @return data de contratação
     */
    public String getDataContratacao() {
        return dataContratacao;
    }


    /**
     * Define a data de contratação.
     * 
     * @param dataContratacao data de contratação
     */
    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }


    /**
     * Retorna o nome do cargo do funcionário.
     * 
     * @return nome do cargo
     */
    public String getCargo() {
        return cargo;
    }


    /**
     * Define o nome do cargo do funcionário.
     * 
     * @param cargo nome do cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}