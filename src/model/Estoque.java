
package model;



/**
 * Classe modelo responsável por representar
 * os itens do estoque da pizzaria.
 * 
 * A classe armazena informações
 * dos produtos e ingredientes utilizados
 * no sistema.
 */
public class Estoque {

    /**
     * Identificador do item do estoque.
     */
    private int id;

    /**
     * Nome do produto ou ingrediente.
     */
    private String nome;

    /**
     * Quantidade disponível no estoque.
     */
    private int quantidade;

    /**
     * Data de validade do produto.
     */
    private String validade;

    /**
     * Nome do fornecedor do produto.
     */
    private String fornecedor;

    /**
     * Categoria do item do estoque.
     * 
     * Exemplos:
     * Ingrediente, Bebida, Massa.
     */
    private String categoria;

    /**
     * Observações relacionadas ao item.
     * 
     * Exemplos:
     * informações extras,
     * armazenamento ou detalhes adicionais.
     */
    private String observacao;


    /**
     * Retorna o ID do item do estoque.
     * 
     * @return identificador do item
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do item do estoque.
     * 
     * @param id identificador do item
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o nome do item.
     * 
     * @return nome do item
     */
    public String getNome() {
        return nome;
    }


    /**
     * Define o nome do item.
     * 
     * @param nome nome do item
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Retorna a quantidade disponível.
     * 
     * @return quantidade do item
     */
    public int getQuantidade() {
        return quantidade;
    }


    /**
     * Define a quantidade disponível.
     * 
     * @param quantidade quantidade do item
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    /**
     * Retorna a validade do item.
     * 
     * @return validade do item
     */
    public String getValidade() {
        return validade;
    }


    /**
     * Define a validade do item.
     * 
     * @param validade validade do item
     */
    public void setValidade(String validade) {
        this.validade = validade;
    }


    /**
     * Retorna o fornecedor do item.
     * 
     * @return fornecedor do item
     */
    public String getFornecedor() {
        return fornecedor;
    }


    /**
     * Define o fornecedor do item.
     * 
     * @param fornecedor fornecedor do item
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }


    /**
     * Retorna a categoria do item.
     * 
     * @return categoria do item
     */
    public String getCategoria() {
        return categoria;
    }


    /**
     * Define a categoria do item.
     * 
     * @param categoria categoria do item
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    /**
     * Retorna as observações do item.
     * 
     * @return observações do item
     */
    public String getObservacao() {
        return observacao;
    }


    /**
     * Define as observações do item.
     * 
     * @param observacao observações do item
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}