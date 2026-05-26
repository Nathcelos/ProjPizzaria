
package model;

import java.util.ArrayList;



/**
 * Classe modelo responsável por representar
 * os pedidos realizados no sistema.
 *
 * A classe armazena informações do pedido,
 * cliente, funcionário, pagamento,
 * itens comprados e status da entrega.
 */
public class Pedido {

    /**
     * Identificador do pedido.
     */
    private int id;

    /**
     * Identificador do cliente relacionado
     * ao pedido.
     */
    private int idCliente;

    /**
     * Identificador do funcionário
     * responsável pelo pedido.
     */
    private int idFuncionario;

    /**
     * Data em que o pedido foi realizado.
     */
    private String data;

    /**
     * Hora em que o pedido foi realizado.
     */
    private String hora;

    /**
     * Status atual do pedido.
     *
     * Exemplos:
     * Em andamento, Em preparo,
     * Finalizado, Entregue, Cancelado.
     */
    private String status;

    /**
     * Observações relacionadas ao pedido.
     */
    private String observacao;

    /**
     * Valor total do pedido.
     */
    private double total;

    /**
     * Nome do cliente relacionado ao pedido.
     */
    private String nomeCliente;

    /**
     * Método de pagamento utilizado no pedido.
     */
    private String metodoPagamento;

    /**
     * Telefone do cliente.
     */
    private String telefone;

    /**
     * Endereço do cliente.
     */
    private String endereco;

    /**
     * Lista simples com os nomes dos itens
     * do pedido.
     */
    private ArrayList<String> itens;

    /**
     * Observações cadastradas no cliente.
     */
    private String observacaoCliente;

    /**
     * Lista detalhada dos itens do pedido.
     */
    private ArrayList<ItensPedido> itensDetalhados;

    /**
     * Status do pagamento do pedido.
     *
     * Exemplos:
     * Pago ou Pendente.
     */
    private String statusPagamento;

    /**
     * Texto contendo os itens do pedido
     * agrupados em uma única String.
     */
    private String itensTexto;

    /**
     * Retorna o ID do pedido.
     *
     * @return identificador do pedido
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do pedido.
     *
     * @param id identificador do pedido
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o ID do cliente.
     *
     * @return identificador do cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Define o ID do cliente.
     *
     * @param idCliente identificador do cliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Retorna o ID do funcionário.
     *
     * @return identificador do funcionário
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * Define o ID do funcionário.
     *
     * @param idFuncionario identificador do funcionário
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * Retorna a data do pedido.
     *
     * @return data do pedido
     */
    public String getData() {
        return data;
    }

    /**
     * Define a data do pedido.
     *
     * @param data data do pedido
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Retorna a hora do pedido.
     *
     * @return hora do pedido
     */
    public String getHora() {
        return hora;
    }

    /**
     * Define a hora do pedido.
     *
     * @param hora hora do pedido
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Retorna o status do pedido.
     *
     * @return status do pedido
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status do pedido.
     *
     * @param status status do pedido
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retorna a observação do pedido.
     *
     * @return observação do pedido
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Define a observação do pedido.
     *
     * @param observacao observação do pedido
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * Retorna o valor total do pedido.
     *
     * @return total do pedido
     */
    public double getTotal() {
        return total;
    }

    /**
     * Define o valor total do pedido.
     *
     * @param total total do pedido
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Retorna o nome do cliente.
     *
     * @return nome do cliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Define o nome do cliente.
     *
     * @param nomeCliente nome do cliente
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * Retorna o método de pagamento.
     *
     * @return método de pagamento
     */
    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    /**
     * Define o método de pagamento.
     *
     * @param metodoPagamento método de pagamento
     */
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
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
     * Retorna a lista simples de itens.
     *
     * @return lista de nomes dos itens
     */
    public ArrayList<String> getItens() {
        return itens;
    }

    /**
     * Define a lista simples de itens.
     *
     * @param itens lista de nomes dos itens
     */
    public void setItens(ArrayList<String> itens) {
        this.itens = itens;
    }

    /**
     * Retorna a observação do cliente.
     *
     * @return observação do cliente
     */
    public String getObservacaoCliente() {
        return observacaoCliente;
    }

    /**
     * Define a observação do cliente.
     *
     * @param observacaoCliente observação do cliente
     */
    public void setObservacaoCliente(String observacaoCliente) {
        this.observacaoCliente = observacaoCliente;
    }

    /**
     * Retorna a lista detalhada de itens.
     *
     * @return lista de itens detalhados
     */
    public ArrayList<ItensPedido> getItensDetalhados() {
        return itensDetalhados;
    }

    /**
     * Define a lista detalhada de itens.
     *
     * @param itensDetalhados lista de itens detalhados
     */
    public void setItensDetalhados(ArrayList<ItensPedido> itensDetalhados) {
        this.itensDetalhados = itensDetalhados;
    }

    /**
     * Retorna o status do pagamento.
     *
     * @return status do pagamento
     */
    public String getStatusPagamento() {
        return statusPagamento;
    }

    /**
     * Define o status do pagamento.
     *
     * @param statusPagamento status do pagamento
     */
    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    /**
     * Retorna os itens do pedido em formato de texto.
     *
     * @return texto com os itens do pedido
     */
    public String getItensTexto() {
        return itensTexto;
    }

    /**
     * Define os itens do pedido em formato de texto.
     *
     * @param itensTexto texto com os itens do pedido
     */
    public void setItensTexto(String itensTexto) {
        this.itensTexto = itensTexto;
    }
}