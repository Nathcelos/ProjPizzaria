
package model;


/**
 * Classe modelo responsável por representar
 * um item do cardápio da pizzaria.
 * 
 * A classe armazena informações
 * dos produtos vendidos no sistema,
 * como nome, descrição, preço e categoria.
 */
public class Cardapio {

    /**
     * Identificador do item do cardápio.
     */
    private int id;

    /**
     * Nome do produto.
     */
    private String nome;

    /**
     * Descrição do produto.
     */
    private String descricao;

    /**
     * Preço do produto.
     */
    private double preco;

    /**
     * Categoria do produto.
     * 
     * Exemplos:
     * Pizza, Bebida, Sobremesa.
     */
    private String categoria;


    /**
     * Retorna o ID do item do cardápio.
     * 
     * @return identificador do produto
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do item do cardápio.
     * 
     * @param id identificador do produto
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o nome do produto.
     * 
     * @return nome do produto
     */
    public String getNome() {
        return nome;
    }


    /**
     * Define o nome do produto.
     * 
     * @param nome nome do produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Retorna a descrição do produto.
     * 
     * @return descrição do produto
     */
    public String getDescricao() {
        return descricao;
    }


    /**
     * Define a descrição do produto.
     * 
     * @param descricao descrição do produto
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    /**
     * Retorna o preço do produto.
     * 
     * @return preço do produto
     */
    public double getPreco() {
        return preco;
    }


    /**
     * Define o preço do produto.
     * 
     * @param preco preço do produto
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }


    /**
     * Retorna a categoria do produto.
     * 
     * @return categoria do produto
     */
    public String getCategoria() {
        return categoria;
    }


    /**
     * Define a categoria do produto.
     * 
     * @param categoria categoria do produto
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}