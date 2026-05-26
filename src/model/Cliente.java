
package model;


/**
 * Classe modelo responsável por representar
 * os clientes cadastrados no sistema.
 * 
 * A classe armazena informações pessoais
 * utilizadas para realização de pedidos
 * e entregas.
 */
public class Cliente {

    /**
     * Identificador do cliente.
     */
    private int id;

    /**
     * Nome do cliente.
     */
    private String nome;

    /**
     * Telefone do cliente.
     */
    private String telefone;

    /**
     * Endereço do cliente.
     */
    private String endereco;

    /**
     * Observações relacionadas ao cliente.
     * 
     * Exemplos:
     * referência de entrega,
     * preferências ou observações gerais.
     */
    private String observacao;


    /**
     * Retorna o ID do cliente.
     * 
     * @return identificador do cliente
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do cliente.
     * 
     * @param id identificador do cliente
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o nome do cliente.
     * 
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }


    /**
     * Define o nome do cliente.
     * 
     * @param nome nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Retorna o telefone do cliente.
     * 
     * @return telefone do cliente
     */
    public String getTelefone() {
        return telefone;
    }


    /**
     * Define o telefone do cliente.
     * 
     * @param telefone telefone do cliente
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    /**
     * Retorna o endereço do cliente.
     * 
     * @return endereço do cliente
     */
    public String getEndereco() {
        return endereco;
    }


    /**
     * Define o endereço do cliente.
     * 
     * @param endereco endereço do cliente
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    /**
     * Retorna as observações do cliente.
     * 
     * @return observações do cliente
     */
    public String getObservacao() {
        return observacao;
    }


    /**
     * Define as observações do cliente.
     * 
     * @param observacao observações do cliente
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}