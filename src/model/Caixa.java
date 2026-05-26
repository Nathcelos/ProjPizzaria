
package model;

import java.time.LocalDate;


/**
 * Classe modelo responsável por representar
 * o caixa do sistema.
 * 
 * A classe armazena informações financeiras
 * relacionadas às vendas, gastos
 * e saldo final do dia.
 */
public class Caixa {

    /**
     * Identificador do caixa.
     */
    private int id;

    /**
     * Data referente ao caixa.
     */
    private LocalDate data;

    /**
     * Valor total de vendas realizadas.
     */
    private double totalVendas;

    /**
     * Valor total de gastos registrados.
     */
    private double totalGasto;

    /**
     * Saldo final calculado do caixa.
     */
    private double saldoFinal;


    /**
     * Retorna o ID do caixa.
     * 
     * @return identificador do caixa
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do caixa.
     * 
     * @param id identificador do caixa
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna a data do caixa.
     * 
     * @return data do caixa
     */
    public LocalDate getData() {
        return data;
    }


    /**
     * Define a data do caixa.
     * 
     * @param data data do caixa
     */
    public void setData(LocalDate data) {
        this.data = data;
    }


    /**
     * Retorna o valor total de vendas.
     * 
     * @return total de vendas
     */
    public double getTotalVendas() {
        return totalVendas;
    }


    /**
     * Define o valor total de vendas.
     * 
     * @param totalVendas total de vendas
     */
    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }


    /**
     * Retorna o valor total de gastos.
     * 
     * @return total de gastos
     */
    public double getTotalGasto() {
        return totalGasto;
    }


    /**
     * Define o valor total de gastos.
     * 
     * @param totalGasto total de gastos
     */
    public void setTotalGasto(double totalGasto) {
        this.totalGasto = totalGasto;
    }


    /**
     * Retorna o saldo final do caixa.
     * 
     * @return saldo final
     */
    public double getSaldoFinal() {
        return saldoFinal;
    }


    /**
     * Define o saldo final do caixa.
     * 
     * @param saldoFinal saldo final
     */
    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
}