
package model;


/**
 * Classe modelo responsável por representar
 * os itens adicionados em um pedido.
 * 
 * A classe armazena informações
 * dos produtos selecionados,
 * quantidade e valores do pedido.
 */
public class ItensPedido {

    /**
     * Identificador do item do pedido.
     */
    private int id;

    /**
     * Identificador do pedido relacionado.
     */
    private int idPedido;

    /**
     * Identificador do item do cardápio.
     */
    private int idCardapio;

    /**
     * Quantidade do produto adicionada
     * ao pedido.
     */
    private int quantidade;

    /**
     * Valor subtotal do item do pedido.
     * 
     * O subtotal é calculado utilizando:
     * quantidade × preço do produto.
     */
    private double subtotal;

    /**
     * Nome do produto do cardápio.
     */
    private String nomeProduto;

    /**
     * Preço unitário do produto.
     */
    private double precoProduto;


    /**
     * Retorna o ID do item do pedido.
     * 
     * @return identificador do item
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do item do pedido.
     * 
     * @param id identificador do item
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o ID do pedido.
     * 
     * @return identificador do pedido
     */
    public int getIdPedido() {
        return idPedido;
    }


    /**
     * Define o ID do pedido.
     * 
     * @param idPedido identificador do pedido
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


    /**
     * Retorna o ID do item do cardápio.
     * 
     * @return identificador do produto
     */
    public int getIdCardapio() {
        return idCardapio;
    }


    /**
     * Define o ID do item do cardápio.
     * 
     * @param idCardapio identificador do produto
     */
    public void setIdCardapio(int idCardapio) {
        this.idCardapio = idCardapio;
    }


    /**
     * Retorna a quantidade do produto
     * adicionada ao pedido.
     * 
     * @return quantidade do produto
     */
    public int getQuantidade() {
        return quantidade;
    }


    /**
     * Define a quantidade do produto
     * adicionada ao pedido.
     * 
     * @param quantidade quantidade do produto
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    /**
     * Retorna o subtotal do item do pedido.
     * 
     * @return subtotal do item
     */
    public double getSubtotal() {
        return subtotal;
    }


    /**
     * Define o subtotal do item do pedido.
     * 
     * @param subtotal subtotal do item
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }


    /**
     * Retorna o nome do produto.
     * 
     * @return nome do produto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }


    /**
     * Define o nome do produto.
     * 
     * @param nomeProduto nome do produto
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }


    /**
     * Retorna o preço unitário do produto.
     * 
     * @return preço do produto
     */
    public double getPrecoProduto() {
        return precoProduto;
    }


    /**
     * Define o preço unitário do produto.
     * 
     * @param precoProduto preço do produto
     */
    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }
}