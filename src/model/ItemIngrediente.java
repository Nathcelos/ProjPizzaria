
package model;


/**
 * Classe modelo responsável por representar
 * os ingredientes necessários
 * para a produção de um item do cardápio.
 * 
 * A classe relaciona produtos do cardápio
 * com itens do estoque utilizados
 * no preparo.
 */
public class ItemIngrediente {

    /**
     * Identificador do item ingrediente.
     */
    private int id;

    /**
     * Identificador do item do cardápio.
     */
    private int idCardapio;

    /**
     * Identificador do item do estoque.
     */
    private int idEstoque;

    /**
     * Quantidade necessária do ingrediente
     * para produzir o item do cardápio.
     */
    private double qtdNecessaria;

    /**
     * Unidade de medida utilizada.
     * 
     * Exemplos:
     * Kg, g, L, ml, unidade.
     */
    private String medida;


    /**
     * Retorna o ID do item ingrediente.
     * 
     * @return identificador do item ingrediente
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do item ingrediente.
     * 
     * @param id identificador do item ingrediente
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o ID do item do cardápio.
     * 
     * @return identificador do cardápio
     */
    public int getIdCardapio() {
        return idCardapio;
    }


    /**
     * Define o ID do item do cardápio.
     * 
     * @param idCardapio identificador do cardápio
     */
    public void setIdCardapio(int idCardapio) {
        this.idCardapio = idCardapio;
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
     * Retorna a quantidade necessária
     * do ingrediente.
     * 
     * @return quantidade necessária
     */
    public double getQtdNecessaria() {
        return qtdNecessaria;
    }


    /**
     * Define a quantidade necessária
     * do ingrediente.
     * 
     * @param qtdNecessaria quantidade necessária
     */
    public void setQtdNecessaria(double qtdNecessaria) {
        this.qtdNecessaria = qtdNecessaria;
    }


    /**
     * Retorna a unidade de medida
     * do ingrediente.
     * 
     * @return medida utilizada
     */
    public String getMedida() {
        return medida;
    }


    /**
     * Define a unidade de medida
     * do ingrediente.
     * 
     * @param medida unidade de medida
     */
    public void setMedida(String medida) {
        this.medida = medida;
    }
}