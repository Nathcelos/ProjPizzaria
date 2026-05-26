
package model;


/**
 * Classe modelo responsável por representar
 * os pagamentos dos pedidos no sistema.
 * 
 * A classe armazena informações
 * relacionadas ao valor pago,
 * método de pagamento
 * e situação do pagamento.
 */
public class Pagamento {

    /**
     * Identificador do pagamento.
     */
    private int id;

    /**
     * Identificador do pedido relacionado
     * ao pagamento.
     */
    private int idPedido;

    /**
     * Valor total do pagamento.
     */
    private double valor;

    /**
     * Método de pagamento utilizado.
     * 
     * Exemplos:
     * Dinheiro, PIX, Cartão.
     */
    private String metodo;

    /**
     * Status do pagamento.
     * 
     * Exemplos:
     * Pago, Pendente.
     */
    private String status;


    /**
     * Retorna o ID do pagamento.
     * 
     * @return identificador do pagamento
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do pagamento.
     * 
     * @param id identificador do pagamento
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o ID do pedido relacionado.
     * 
     * @return identificador do pedido
     */
    public int getIdPedido() {
        return idPedido;
    }


    /**
     * Define o ID do pedido relacionado.
     * 
     * @param idPedido identificador do pedido
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }


    /**
     * Retorna o valor do pagamento.
     * 
     * @return valor do pagamento
     */
    public double getValor() {
        return valor;
    }


    /**
     * Define o valor do pagamento.
     * 
     * @param valor valor do pagamento
     */
    public void setValor(double valor) {
        this.valor = valor;
    }


    /**
     * Retorna o método de pagamento utilizado.
     * 
     * @return método de pagamento
     */
    public String getMetodo() {
        return metodo;
    }


    /**
     * Define o método de pagamento utilizado.
     * 
     * @param metodo método de pagamento
     */
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }


    /**
     * Retorna o status do pagamento.
     * 
     * @return status do pagamento
     */
    public String getStatus() {
        return status;
    }


    /**
     * Define o status do pagamento.
     * 
     * @param status status do pagamento
     */
    public void setStatus(String status) {
        this.status = status;
    }
}