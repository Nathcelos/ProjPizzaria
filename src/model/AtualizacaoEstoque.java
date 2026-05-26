
package model;

import java.time.LocalDate;


/**
 * Classe modelo responsável por representar
 * uma atualização de estoque no sistema.
 * 
 * A classe armazena informações sobre
 * movimentações realizadas no estoque,
 * como entrada ou saída de produtos.
 */
public class AtualizacaoEstoque {

    /**
     * Identificador da atualização de estoque.
     */
    private int id;

    /**
     * Identificador do item do estoque
     * relacionado à atualização.
     */
    private int idEstoque;

    /**
     * Quantidade movimentada
     * na atualização.
     */
    private int quantidade;

    /**
     * Data em que a atualização
     * do estoque foi realizada.
     */
    private LocalDate data;

    /**
     * Tipo da movimentação do estoque.
     * 
     * Exemplos:
     * Entrada, Saída, Ajuste.
     */
    private String tipo;


    /**
     * Retorna o ID da atualização.
     * 
     * @return identificador da atualização
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID da atualização.
     * 
     * @param id identificador da atualização
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o ID do item do estoque.
     * 
     * @return identificador do estoque
     */
    public int getIdEstoque() {
        return idEstoque;
    }


    /**
     * Define o ID do item do estoque.
     * 
     * @param idEstoque identificador do estoque
     */
    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }


    /**
     * Retorna a quantidade movimentada.
     * 
     * @return quantidade da atualização
     */
    public int getQuantidade() {
        return quantidade;
    }


    /**
     * Define a quantidade movimentada.
     * 
     * @param quantidade quantidade da atualização
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    /**
     * Retorna a data da atualização.
     * 
     * @return data da atualização
     */
    public LocalDate getData() {
        return data;
    }


    /**
     * Define a data da atualização.
     * 
     * @param data data da atualização
     */
    public void setData(LocalDate data) {
        this.data = data;
    }


    /**
     * Retorna o tipo da movimentação.
     * 
     * @return tipo da atualização
     */
    public String getTipo() {
        return tipo;
    }


    /**
     * Define o tipo da movimentação.
     * 
     * @param tipo tipo da atualização
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}