
package model;


/**
 * Classe modelo responsável por representar
 * os cargos dos funcionários do sistema.
 * 
 * A classe armazena informações
 * relacionadas ao nome do cargo
 * e suas permissões de acesso.
 */
public class Cargo {

    /**
     * Identificador do cargo.
     */
    private int id;

    /**
     * Nome do cargo.
     * 
     * Exemplos:
     * Gerente, Atendente,
     * Cozinheiro e Entregador.
     */
    private String nome;

    /**
     * Permissões atribuídas ao cargo.
     * 
     * Define quais funcionalidades
     * o usuário poderá acessar.
     */
    private String permissoes;


    /**
     * Retorna o ID do cargo.
     * 
     * @return identificador do cargo
     */
    public int getId() {
        return id;
    }


    /**
     * Define o ID do cargo.
     * 
     * @param id identificador do cargo
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Retorna o nome do cargo.
     * 
     * @return nome do cargo
     */
    public String getNome() {
        return nome;
    }


    /**
     * Define o nome do cargo.
     * 
     * @param nome nome do cargo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Retorna as permissões do cargo.
     * 
     * @return permissões do cargo
     */
    public String getPermissoes() {
        return permissoes;
    }


    /**
     * Define as permissões do cargo.
     * 
     * @param permissoes permissões do cargo
     */
    public void setPermissoes(String permissoes) {
        this.permissoes = permissoes;
    }
}