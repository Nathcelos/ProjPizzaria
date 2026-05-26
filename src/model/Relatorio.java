
package model;

import java.time.LocalDate;


/**
 * Classe modelo responsável por representar
 * os relatórios gerados pelo sistema.
 *
 * A classe armazena informações
 * sobre o tipo do relatório,
 * data de geração
 * e período analisado.
 */
public class Relatorio {

    /**
     * Identificador do relatório.
     */
    private int id;

    /**
     * Tipo do relatório gerado.
     *
     * Exemplos:
     * Vendas, Pedidos, Clientes.
     */
    private String tipo;

    /**
     * Data em que o relatório foi gerado.
     */
    private LocalDate dataGeracao;

    /**
     * Data inicial do período
     * utilizado no relatório.
     */
    private LocalDate periodoInicio;

    /**
     * Data final do período
     * utilizado no relatório.
     */
    private LocalDate periodoFinal;


    /**
     * Retorna o ID do relatório.
     *
     * @return identificador do relatório
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do relatório.
     *
     * @param id identificador do relatório
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o tipo do relatório.
     *
     * @return tipo do relatório
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do relatório.
     *
     * @param tipo tipo do relatório
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna a data de geração do relatório.
     *
     * @return data de geração
     */
    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    /**
     * Define a data de geração do relatório.
     *
     * @param dataGeracao data de geração
     */
    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    /**
     * Retorna a data inicial do período.
     *
     * @return data inicial do período
     */
    public LocalDate getPeriodoInicio() {
        return periodoInicio;
    }

    /**
     * Define a data inicial do período.
     *
     * @param periodoInicio data inicial do período
     */
    public void setPeriodoInicio(LocalDate periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    /**
     * Retorna a data final do período.
     *
     * @return data final do período
     */
    public LocalDate getPeriodoFinal() {
        return periodoFinal;
    }

    /**
     * Define a data final do período.
     *
     * @param periodoFinal data final do período
     */
    public void setPeriodoFinal(LocalDate periodoFinal) {
        this.periodoFinal = periodoFinal;
    }
}