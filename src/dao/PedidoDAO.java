package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.ItensPedido;
import model.Pedido;


/**
 * Classe responsável pelas operações de banco de dados
 * relacionadas aos pedidos do sistema.
 * 
 * Realiza cadastro, listagem, atualização,
 * remoção, filtros, buscas e controle
 * de status dos pedidos.
 */
public class PedidoDAO {

    /**
     * Conexão com o banco de dados.
     */
    Connection conn;
    /**
     * PreparedStatement utilizado para executar comandos SQL.
     */
    PreparedStatement prep;
    /**
     * ResultSet utilizado para armazenar
     * os resultados das consultas SQL.
     */
    ResultSet rs;
/**
     * Lista utilizada para armazenar
     * os pedidos retornados do banco.
     */
    ArrayList<Pedido> lista = new ArrayList<>();


    /**
     * Realiza o cadastro de um novo pedido
     * no banco de dados.
     * 
     * O método retorna o ID gerado
     * automaticamente após o cadastro.
     * 
     * @param p objeto contendo os dados do pedido
     * @return ID do pedido cadastrado
     */
  public int cadastrarPedido(Pedido p) {

    int idGerado = 0;

    String sql = "INSERT INTO pedidos "
            + "(idCliente, dataPedido, horaPedido, "
            + "idFuncionario, status, observacao, total) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(
                sql,
                PreparedStatement.RETURN_GENERATED_KEYS);

        prep.setInt(1, p.getIdCliente());

        prep.setString(2, p.getData());

        prep.setString(3, p.getHora());

        prep.setInt(4, p.getIdFuncionario());

        prep.setString(5, p.getStatus());

        prep.setString(6, p.getObservacao());

        prep.setDouble(7, p.getTotal());

        prep.executeUpdate();

        rs = prep.getGeneratedKeys();

        if (rs.next()) {

            idGerado = rs.getInt(1);
        }

        prep.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "PedidoDAO cadastrar: "
                + erro.getMessage());
    }

    return idGerado;
}


   /**
     * Retorna todos os pedidos cadastrados
     * no sistema.
     * 
     * @return lista contendo os pedidos
     */
   public ArrayList<Pedido> listaPedido() {


    String sql = "SELECT * FROM pedidos";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        while (rs.next()) {

            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));
            p.setIdCliente(rs.getInt("idCliente"));
            p.setIdFuncionario(rs.getInt("idFuncionario"));
            p.setData(rs.getString("dataPedido"));
            p.setHora(rs.getString("horaPedido"));
            p.setStatus(rs.getString("status"));
            p.setObservacao(rs.getString("observacao"));
            p.setTotal(rs.getDouble("total"));

            lista.add(p);
        }

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "PedidoDAO listar: " + erro.getMessage());
    }

    return lista;
}


    /**
     * Remove um pedido do banco de dados.
     * 
     * O método remove primeiro os pagamentos
     * e itens relacionados ao pedido
     * para evitar erros de chave estrangeira.
     * 
     * @param idPedido identificador do pedido
     */
    public void excluirPedido(int idPedido) {

    conn = new conectaDAO().connectDB();

    try {

        String sqlPagamento =
                "DELETE FROM pagamento WHERE idPedido = ?";

        prep = conn.prepareStatement(sqlPagamento);
        prep.setInt(1, idPedido);
        prep.executeUpdate();
        prep.close();

        String sqlItens =
                "DELETE FROM itensPedido WHERE idPedido = ?";

        prep = conn.prepareStatement(sqlItens);
        prep.setInt(1, idPedido);
        prep.executeUpdate();
        prep.close();

        String sqlPedido =
                "DELETE FROM pedidos WHERE id = ?";

        prep = conn.prepareStatement(sqlPedido);
        prep.setInt(1, idPedido);
        prep.executeUpdate();
        prep.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "PedidoDAO excluirPedido: "
                + erro.getMessage());
    }
}
    
    /**
     * Filtra pedidos utilizando o ID informado.
     * 
     * O filtro utiliza LIKE para permitir
     * buscas parciais.
     * 
     * @param id texto utilizado na pesquisa
     * @return lista contendo os pedidos encontrados
     */
    public ArrayList<Pedido> filtrar(String id) {

    String sql = "SELECT * FROM pedidos WHERE CAST(id AS CHAR) LIKE ?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        prep.setString(1, "%" + id + "%");

        rs = prep.executeQuery();

        while (rs.next()) {

            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));
            p.setIdCliente(rs.getInt("idCliente"));
            p.setIdFuncionario(rs.getInt("idFuncionario"));
            p.setData(rs.getString("dataPedido"));
            p.setHora(rs.getString("horaPedido"));
            p.setStatus(rs.getString("status"));
            p.setObservacao(rs.getString("observacao"));
            p.setTotal(rs.getDouble("total"));

            lista.add(p);
        }

    } catch (SQLException e) {
        System.out.println("PedidoDAO filtrar: " + e.getMessage());
    }

    return lista;
}
    
    /**
     * Retorna a quantidade de pedidos
     * cadastrados no dia atual.
     * 
     * @return total de pedidos do dia
     */
    public int contarPedidosDoDia() {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM pedidos WHERE dataPedido = CURDATE()";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt(1);
        }

    } catch (SQLException e) {
        System.out.println("Erro contarPedidosDoDia: " + e.getMessage());
    }

    return total;
}
    
    /**
     * Conta pedidos de acordo com o status informado.
     * 
     * @param status status utilizado na contagem
     * @return total de pedidos encontrados
     */
    public int contarPorStatus(String status) {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM pedidos WHERE status = ?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);
        prep.setString(1, status);

        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt(1);
        }

    } catch (SQLException e) {
        System.out.println("Erro contarPorStatus: " + e.getMessage());
    }

    return total;
}
    
    /**
     * Atualiza o status de um pedido.
     * 
     * @param id identificador do pedido
     * @param status novo status do pedido
     */
    public void atualizarStatus(int id, String status) {

    String sql = "UPDATE pedidos SET status = ? WHERE id = ?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);
        prep.setString(1, status);
        prep.setInt(2, id);

        prep.executeUpdate();

    } catch (SQLException e) {
        System.out.println("Erro atualizarStatus: " + e.getMessage());
    }
}
    
    /**
     * Retorna o próximo ID disponível
     * para cadastro de pedido.
     * 
     * @return próximo ID do pedido
     */
    public int buscarProximoIdPedido() {

    String sql = "SELECT MAX(id) + 1 AS proximoId FROM pedidos";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        rs = prep.executeQuery();

        if (rs.next()) {

            int id = rs.getInt("proximoId");

            // Se tabela estiver vazia
            if (id == 0) {

                return 1;
            }

            return id;
        }

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "PedidosDAO buscar ID: "
                + erro.getMessage());
    }

    return 1;
}
    
    /**
     * Busca todas as informações completas
     * de um pedido.
     * 
     * O método retorna:
     * cliente, itens, pagamento,
     * observações, valores e status.
     * 
     * @param idPedido identificador do pedido
     * @return objeto Pedido completo
     */
    public Pedido buscarPedidoCompleto(int idPedido) {

    Pedido p = null;

    String sql = "SELECT "
            + "p.id, "
            + "p.idCliente, "
            + "p.idFuncionario, "
            + "c.nome AS nomeCliente, "
            + "c.telefone, "
            + "c.endereco, "
            + "c.observacao AS obsCliente, "
            + "p.observacao AS obsPedido, "
            + "p.dataPedido, "
            + "p.horaPedido, "
            + "p.status, "
            + "p.total, "
            + "pg.metodo AS metodoPagamento, "
            + "ip.idCardapio, "
            + "ip.quantidade, "
            + "ip.subtotal, "
            + "m.nome AS item, "
            + "m.preco AS precoProduto "
            + "FROM pedidos p "
            + "JOIN cliente c ON p.idCliente = c.id "
            + "JOIN itensPedido ip ON p.id = ip.idPedido "
            + "JOIN cardapio m ON ip.idCardapio = m.id "
            + "LEFT JOIN pagamento pg ON p.id = pg.idPedido "
            + "WHERE p.id = ?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);
        prep.setInt(1, idPedido);

        rs = prep.executeQuery();

        while (rs.next()) {

            if (p == null) {

                p = new Pedido();

                p.setId(rs.getInt("id"));
                p.setIdCliente(rs.getInt("idCliente"));
                p.setIdFuncionario(rs.getInt("idFuncionario"));

                p.setNomeCliente(rs.getString("nomeCliente"));
                p.setTelefone(rs.getString("telefone"));
                p.setEndereco(rs.getString("endereco"));

                p.setObservacaoCliente(rs.getString("obsCliente"));
                p.setObservacao(rs.getString("obsPedido"));

                p.setData(rs.getString("dataPedido"));
                p.setHora(rs.getString("horaPedido"));

                p.setStatus(rs.getString("status"));
                p.setTotal(rs.getDouble("total"));

                p.setMetodoPagamento(rs.getString("metodoPagamento"));

                p.setItens(new ArrayList<>());
                p.setItensDetalhados(new ArrayList<>());
            }

            p.getItens().add(rs.getString("item"));

            ItensPedido item = new ItensPedido();

            item.setIdCardapio(rs.getInt("idCardapio"));
            item.setNomeProduto(rs.getString("item"));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setPrecoProduto(rs.getDouble("precoProduto"));
            item.setSubtotal(rs.getDouble("subtotal"));

            p.getItensDetalhados().add(item);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "PedidoDAO buscarPedidoCompleto: "
                + erro.getMessage());
    }

    return p;
}
    
    /**
     * Busca apenas os detalhes básicos
     * de um pedido.
     * 
     * Utilizado principalmente
     * na tela de detalhes do pedido.
     * 
     * @param idPedido identificador do pedido
     * @return objeto Pedido contendo detalhes
     */
    public Pedido buscarDetalhesPedido(int idPedido) {

    Pedido p = null;

    String sql = "SELECT "
            + "p.id, "
            + "p.horaPedido, "
            + "p.status, "
            + "p.observacao AS obsPedido, "
            + "m.nome AS item, "
            + "ip.quantidade "
            + "FROM pedidos p "
            + "JOIN itensPedido ip ON p.id = ip.idPedido "
            + "JOIN cardapio m ON ip.idCardapio = m.id "
            + "WHERE p.id = ?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);
        prep.setInt(1, idPedido);

        rs = prep.executeQuery();

        while (rs.next()) {

            if (p == null) {

                p = new Pedido();

                p.setId(rs.getInt("id"));
                p.setHora(rs.getString("horaPedido"));
                p.setStatus(rs.getString("status"));
                p.setObservacao(rs.getString("obsPedido"));

                p.setItensDetalhados(new ArrayList<>());
            }

            // itens do pedido (nome + quantidade)
            ItensPedido item = new ItensPedido();

            item.setNomeProduto(rs.getString("item"));
            item.setQuantidade(rs.getInt("quantidade"));

            p.getItensDetalhados().add(item);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "PedidoDAO buscarDetalhesPedido: " + erro.getMessage());
    }

    return p;
}
    
    /**
     * Retorna os pedidos exibidos
     * na tela do caixa.
     * 
     * Inclui cliente, valor,
     * método e status do pagamento.
     * 
     * @return lista de pedidos do caixa
     */
    public ArrayList<Pedido> listarPedidosCaixa() {


    String sql = "SELECT "
            + "p.id, "
            + "c.nome AS cliente, "
            + "p.total, "
            + "p.status, "
            + "pg.metodo, "
            + "pg.status AS pagamentoStatus "
            + "FROM pedidos p "
            + "JOIN cliente c ON p.idCliente = c.id "
            + "LEFT JOIN pagamento pg "
            + "ON p.id = pg.idPedido";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        rs = prep.executeQuery();

        while (rs.next()) {

            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));

            p.setNomeCliente(
                    rs.getString("cliente")
            );

            p.setTotal(
                    rs.getDouble("total")
            );

            p.setStatus(
                    rs.getString("status")
            );

            p.setMetodoPagamento(
                    rs.getString("metodo")
            );

            p.setStatusPagamento(
                    rs.getString("pagamentoStatus")
            );

            lista.add(p);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(
                null,
                "PedidoDAO listarPedidosCaixa: "
                + erro.getMessage()
        );
    }

    return lista;
}
    
    /**
     * Filtra pedidos da tela do caixa
     * utilizando o ID informado.
     * 
     * @param filtro texto utilizado na pesquisa
     * @return lista de pedidos encontrados
     */
    public ArrayList<Pedido> filtrarPedidosCaixa(String filtro) {


    String sql = "SELECT "
            + "p.id, "
            + "c.nome AS cliente, "
            + "p.total, "
            + "p.status, "
            + "pg.metodo, "
            + "pg.status AS pagamentoStatus "
            + "FROM pedidos p "
            + "JOIN cliente c ON p.idCliente = c.id "
            + "LEFT JOIN pagamento pg ON p.id = pg.idPedido "
            + "WHERE p.id LIKE ?";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, "%" + filtro + "%");

        rs = prep.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));
            p.setNomeCliente(rs.getString("cliente"));
            p.setTotal(rs.getDouble("total"));
            p.setStatus(rs.getString("status"));
            p.setMetodoPagamento(rs.getString("metodo"));
            p.setStatusPagamento(rs.getString("pagamentoStatus"));

            lista.add(p);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO filtrarPedidosCaixa: " + erro.getMessage());
    }

    return lista;
}
    
    /**
     * Retorna o valor total recebido
     * em pagamentos confirmados.
     * 
     * @return total recebido
     */
    public double totalRecebidoHoje() {

    double total = 0;

    String sql = "SELECT SUM(p.valor) AS total "
            + "FROM pagamento p "
            + "WHERE p.status = 'Pago'";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getDouble("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO totalRecebidoHoje: " + erro.getMessage());
    }

    return total;
}
    
    /**
     * Retorna a quantidade de pagamentos
     * com status "Pago".
     * 
     * @return total de pagamentos pagos
     */
    public int contarPagos() {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total "
            + "FROM pagamento "
            + "WHERE status = 'Pago'";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO contarPagos: " + erro.getMessage());
    }

    return total;
}
    
    /**
     * Retorna a quantidade de pagamentos
     * com status "Pendente".
     * 
     * @return total de pagamentos pendentes
     */
    public int contarPendentes() {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total "
            + "FROM pagamento "
            + "WHERE status = 'Pendente'";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO contarPendentes: " + erro.getMessage());
    }

    return total;
}
    
    /**
     * Retorna os pedidos exibidos
     * na tela do cozinheiro.
     * 
     * Exibe itens do pedido,
     * horário e status.
     * 
     * @return lista de pedidos da cozinha
     */
    public ArrayList<Pedido> listarPedidosCozinheiro() {


    String sql = "SELECT "
            + "p.id, "
            + "GROUP_CONCAT(c.nome SEPARATOR ', ') AS itens, "
            + "p.status, "
            + "p.horaPedido "
            + "FROM pedidos p "
            + "JOIN itensPedido ip ON p.id = ip.idPedido "
            + "JOIN cardapio c ON ip.idCardapio = c.id "
            + "GROUP BY p.id, p.status, p.horaPedido";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));
            p.setItensTexto(rs.getString("itens"));
            p.setStatus(rs.getString("status"));
            p.setHora(rs.getString("horaPedido"));

            lista.add(p);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO listarPedidosCozinheiro: " + erro.getMessage());
    }

    return lista;
}
    
    
    /**
     * Filtra pedidos da cozinha
     * utilizando o ID informado.
     * 
     * @param filtro texto utilizado na pesquisa
     * @return lista de pedidos encontrados
     */
    public ArrayList<Pedido> filtrarPedidosCozinheiro(String filtro) {


    String sql = "SELECT "
            + "p.id, "
            + "GROUP_CONCAT(c.nome SEPARATOR ', ') AS itens, "
            + "p.status, "
            + "p.horaPedido "
            + "FROM pedidos p "
            + "JOIN itensPedido ip ON p.id = ip.idPedido "
            + "JOIN cardapio c ON ip.idCardapio = c.id "
            + "WHERE p.id LIKE ? "
            + "GROUP BY p.id, p.status, p.horaPedido";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        prep.setString(1, "%" + filtro + "%");

        rs = prep.executeQuery();

        while (rs.next()) {

            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));
            p.setItensTexto(rs.getString("itens"));
            p.setStatus(rs.getString("status"));
            p.setHora(rs.getString("horaPedido"));

            lista.add(p);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(null,
                "PedidoDAO filtrarPedidosCozinheiro: "
                + erro.getMessage());
    }

    return lista;
}
    
    
    /**
     * Conta pedidos pelo status informado.
     * 
     * @param status status utilizado na contagem
     * @return total de pedidos encontrados
     */
    public int contarPedidosPorStatus(String status) {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total "
            + "FROM pedidos "
            + "WHERE status = ?";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, status);

        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO contarPedidosPorStatus: " + erro.getMessage());
    }

    return total;
}
    
    
    /**
     * Atualiza o status de um pedido.
     * 
     * Utilizado principalmente
     * pelas telas de cozinha e entrega.
     * 
     * @param idPedido identificador do pedido
     * @param status novo status do pedido
     */
    public void atualizarStatusPedido(int idPedido, String status) {

    String sql = "UPDATE pedidos SET status = ? WHERE id = ?";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);

        prep.setString(1, status);
        prep.setInt(2, idPedido);

        prep.executeUpdate();
        prep.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO atualizarStatusPedido: " + erro.getMessage());
    }
}
    
    
    /**
     * Retorna os pedidos exibidos
     * na tela do entregador.
     * 
     * @return lista de entregas
     */
    public ArrayList<Pedido> listarEntregas() {


    String sql = "SELECT "
            + "p.id, "
            + "c.nome AS cliente, "
            + "c.endereco, "
            + "p.status "
            + "FROM pedidos p "
            + "JOIN cliente c ON p.idCliente = c.id";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));
            p.setNomeCliente(rs.getString("cliente"));
            p.setEndereco(rs.getString("endereco"));
            p.setStatus(rs.getString("status"));

            lista.add(p);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO listarEntregas: " + erro.getMessage());
    }

    return lista;
}
    
    /**
     * Filtra entregas utilizando
     * o ID informado.
     * 
     * @param filtro texto utilizado na pesquisa
     * @return lista de entregas encontradas
     */
    public ArrayList<Pedido> filtrarEntregas(String filtro) {


    String sql = "SELECT "
            + "p.id, "
            + "c.nome AS cliente, "
            + "c.endereco, "
            + "p.status "
            + "FROM pedidos p "
            + "JOIN cliente c ON p.idCliente = c.id "
            + "WHERE p.id LIKE ?";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, "%" + filtro + "%");

        rs = prep.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));
            p.setNomeCliente(rs.getString("cliente"));
            p.setEndereco(rs.getString("endereco"));
            p.setStatus(rs.getString("status"));

            lista.add(p);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO filtrarEntregas: " + erro.getMessage());
    }

    return lista;
}
    
    /**
     * Conta entregas conforme o status informado.
     * 
     * @param status status utilizado na contagem
     * @return total de entregas encontradas
     */
    public int contarEntregasPorStatus(String status) {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total "
            + "FROM pedidos "
            + "WHERE status = ?";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, status);

        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO contarEntregasPorStatus: " + erro.getMessage());
    }

    return total;
}
    
    
    /**
     * Retorna a quantidade total
     * de entregas cadastradas.
     * 
     * @return total de entregas
     */
    public int contarEntregasTotais() {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total FROM pedidos";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO contarEntregasTotais: " + erro.getMessage());
    }

    return total;
}
    
    
    /**
     * Retorna o valor total de vendas
     * realizadas no dia informado.
     * 
     * @param dataHoje data utilizada na pesquisa
     * @return total vendido no dia
     */
    public double vendasDoDia(String dataHoje) {

    double total = 0;

    String sql = "SELECT SUM(pg.valor) AS total "
            + "FROM pagamento pg "
            + "JOIN pedidos p ON pg.idPedido = p.id "
            + "WHERE p.dataPedido = ? "
            + "AND pg.status = 'Pago'";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, dataHoje);
        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getDouble("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO vendasDoDia: " + erro.getMessage());
    }

    return total;
}
    
    
    /**
     * Retorna a quantidade de pedidos
     * realizados no dia informado.
     * 
     * @param dataHoje data utilizada na pesquisa
     * @return total de pedidos do dia
     */
    public int contarPedidosHoje(String dataHoje) {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total "
            + "FROM pedidos "
            + "WHERE dataPedido = ?";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, dataHoje);
        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO contarPedidosHoje: " + erro.getMessage());
    }

    return total;
}
    
    
    /**
     * Retorna os pedidos mais recentes
     * cadastrados no sistema.
     * 
     * @return lista de pedidos recentes
     */
    public ArrayList<Pedido> listarPedidosRecentes() {


    String sql = "SELECT p.id, c.nome AS cliente, "
            + "p.status, p.horaPedido "
            + "FROM pedidos p "
            + "JOIN cliente c ON p.idCliente = c.id "
            + "ORDER BY p.id DESC "
            + "LIMIT 5";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        rs = prep.executeQuery();

        while (rs.next()) {
            Pedido p = new Pedido();

            p.setId(rs.getInt("id"));
            p.setNomeCliente(rs.getString("cliente"));
            p.setStatus(rs.getString("status"));
            p.setHora(rs.getString("horaPedido"));

            lista.add(p);
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO listarPedidosRecentes: " + erro.getMessage());
    }

    return lista;
}
    
    
    /**
     * Retorna o valor total vendido
     * em um determinado período.
     * 
     * @param inicio data inicial
     * @param fim data final
     * @return total vendido no período
     */
    public double vendasPorPeriodo(String inicio, String fim) {

    double total = 0;

    String sql = "SELECT SUM(pg.valor) AS total "
            + "FROM pagamento pg "
            + "JOIN pedidos p ON pg.idPedido = p.id "
            + "WHERE pg.status = 'Pago' "
            + "AND p.dataPedido BETWEEN ? AND ?";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, inicio);
        prep.setString(2, fim);

        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getDouble("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO vendasPorPeriodo: " + erro.getMessage());
    }

    return total;
}
    
    /**
     * Retorna a quantidade de pedidos
     * concluídos em um período.
     * 
     * @param inicio data inicial
     * @param fim data final
     * @return total de pedidos concluídos
     */
    public int pedidosConcluidosPorPeriodo(String inicio, String fim) {

    int total = 0;

    String sql = "SELECT COUNT(*) AS total "
            + "FROM pedidos "
            + "WHERE status = 'Entregue' "
            + "AND dataPedido BETWEEN ? AND ?";

    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setString(1, inicio);
        prep.setString(2, fim);

        rs = prep.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

        prep.close();
        rs.close();

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null,
                "PedidoDAO pedidosConcluidosPorPeriodo: " + erro.getMessage());
    }

    return total;
}
    
    
    /**
     * Atualiza os dados principais
     * de um pedido já cadastrado.
     * 
     * @param p objeto contendo os novos dados
     * do pedido
     */
    public void atualizarPedido(Pedido p) {

    String sql = "UPDATE pedidos SET "
            + "idCliente=?, "
            + "status=?, "
            + "observacao=?, "
            + "total=? "
            + "WHERE id=?";

    conn = new conectaDAO().connectDB();

    try {

        prep = conn.prepareStatement(sql);

        prep.setInt(1, p.getIdCliente());
        prep.setString(2, p.getStatus());
        prep.setString(3, p.getObservacao());
        prep.setDouble(4, p.getTotal());
        prep.setInt(5, p.getId());

        prep.executeUpdate();

        prep.close();

    } catch (SQLException erro) {

        JOptionPane.showMessageDialog(
                null,
                "PedidoDAO atualizarPedido: "
                + erro.getMessage()
        );
    }
}
    
    
}
