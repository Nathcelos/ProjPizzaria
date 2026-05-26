
package gui.Atendente;

import dao.PagamentoDAO;
import model.Pagamento;
import dao.CardapioDAO;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.ItensPedidoDAO;
import model.Pedido;
import gui.CRUD.TelaCadastrarObservacao;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Cardapio;
import model.Cliente;
import model.ItensPedido;
import model.Usuario;


public class PainelNovoPedido extends javax.swing.JPanel {

    
    private Usuario usuarioLogado;
    
    public PainelNovoPedido() {
        initComponents();
        
    }
    
    public PainelNovoPedido(Usuario u) {
    initComponents();

    
    //Data atual
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
        lblData.setText(formatar.format(data));
        
        //Hora atual
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            Date hora = new Date();
            SimpleDateFormat formatar1 = new SimpleDateFormat("HH:mm");
            lblHora.setText(formatar1.format(hora));
        });
    timer.start();
    
    this.usuarioLogado = u;

    txtAtendente.setText(u.getNomeFuncionario());

    iniciarTabelaPedido();
    carregarIdPedido();
    carregarDataHora();
}
    
    public void calcularTotal() {

    double total = 0;

    DefaultTableModel modelo =
            (DefaultTableModel) tblPedido.getModel();

    for (int i = 0; i < modelo.getRowCount(); i++) {

        total += Double.parseDouble(
                modelo.getValueAt(i, 4).toString());
    }

    lblTotal.setText("R$ " + total);
}
    
    
    public void atualizarTabelaCardapio(String filtro) {

    DefaultTableModel modelo = (DefaultTableModel) tblCardapio.getModel();
    modelo.setRowCount(0);

    CardapioDAO dao = new CardapioDAO();
    ArrayList<Cardapio> listaCardapio;

    if (filtro == null || filtro.trim().isEmpty()) {
        listaCardapio = dao.listarCardapio(); 
    } else {
        listaCardapio = dao.filtrar(filtro); 
    }

    for (Cardapio c : listaCardapio) {
        modelo.addRow(new Object[]{
            c.getId(),
            c.getNome(),
            c.getDescricao(),
            c.getPreco(),
            c.getCategoria()
        });
    }
}

    public void atualizarTabelaCardapio(ArrayList<Cardapio> listaCardapio) {

    DefaultTableModel model = (DefaultTableModel) tblCardapio.getModel();

    model.setRowCount(0);

    for (Cardapio c : listaCardapio) {

        model.addRow(new Object[]{
            c.getId(),
            c.getNome(),
            c.getDescricao(),
            c.getPreco(),
            c.getCategoria()
        });
    }
}
    
    public void atualizarTabelaPedidos(ArrayList<ItensPedido> lista) {

    DefaultTableModel model =
            (DefaultTableModel) tblPedido.getModel();

    model.setRowCount(0);

    for (ItensPedido p : lista) {

        model.addRow(new Object[]{

            p.getIdCardapio(),

            p.getNomeProduto(),

            p.getQuantidade(),

            p.getPrecoProduto(),

            p.getSubtotal()
        });
    }
}
    
    public void iniciarTabelaPedido() {

    String[] colunasPedido = {
        "Id",
        "Produto",
        "Valor uni.",
        "Quantidade",
        "Subtotal"
    };

    DefaultTableModel modelo =
            new DefaultTableModel(colunasPedido, 0);

    tblPedido.setModel(modelo);
}
    
    public void carregarDataHora() {

    LocalDateTime agora = LocalDateTime.now();

    DateTimeFormatter formatador =
            DateTimeFormatter.ofPattern(
                    "dd/MM/yyyy HH:mm");

    txtDataHora.setText(
            agora.format(formatador));
}
    
    public void carregarIdPedido() {

    PedidoDAO dao = new PedidoDAO();

    int id = dao.buscarProximoIdPedido();

    txtIdPedido.setText(String.valueOf(id));
}
    
    private String observacaoPedido = "";
    
    public void setObservacaoPedido(String observacao) {

    this.observacaoPedido = observacao;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btCadastrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtBuscarProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCardapio = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtAdicionarPedido = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIdPedido = new javax.swing.JTextField();
        txtDataHora = new javax.swing.JTextField();
        txtAtendente = new javax.swing.JTextField();
        cbPagamento = new javax.swing.JComboBox<>();
        cbStatus = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btRemover = new javax.swing.JButton();
        btLimparPedido = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btAdicionarObservacao = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");

        jPanel1.setBackground(new java.awt.Color(254, 250, 224));

        jLabel1.setFont(new java.awt.Font("Irish Grover", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(67, 40, 24));
        jLabel1.setText("Novo Pedido");

        lblHora.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(67, 40, 24));
        lblHora.setText("00:00");

        lblData.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(67, 40, 24));
        lblData.setText("00/00/0000");

        jPanel9.setBackground(new java.awt.Color(254, 250, 224));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(67, 40, 24));

        jLabel4.setBackground(new java.awt.Color(254, 250, 224));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 250, 224));
        jLabel4.setText("Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Nome:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Telefone:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Id:");

        btBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastrar.setText("Novo Cliente");
        btCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Endereço:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndereco)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btCadastrar))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(254, 250, 224));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Buscar produto:");

        txtBuscarProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProdutoKeyReleased(evt);
            }
        });

        String[] colunasCardapio = {
            "Id",
            "Nome",
            "Descrição",
            "Preço",
            "Categoria"
        };

        DefaultTableModel tabelaModelo =
        new DefaultTableModel(colunasCardapio, 0);

        CardapioDAO c = new CardapioDAO();
        ArrayList<Cardapio> listaCardapio = c.listarCardapio();

        for (int i = 0; i<listaCardapio.size(); i++){

            Cardapio consultaAtual = listaCardapio.get(i);

            String[] linha = {
                String.valueOf(consultaAtual.getId()),
                consultaAtual.getNome(),
                consultaAtual.getDescricao(),
                String.valueOf(consultaAtual.getPreco()),
                consultaAtual.getCategoria()
            };

            tabelaModelo.addRow(linha);
        }
        tblCardapio.setModel(tabelaModelo);
        jScrollPane1.setViewportView(tblCardapio);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Quantidade:");

        txtAdicionarPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAdicionarPedido.setText("Adicionar ao pedido");
        txtAdicionarPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtAdicionarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdicionarPedidoActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(67, 40, 24));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 250, 224));
        jLabel15.setText("Cardápio");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAdicionarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdicionarPedido))
                .addGap(16, 16, 16))
        );

        jPanel4.setBackground(new java.awt.Color(254, 250, 224));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Nº do pedido:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Data:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Atendente:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Forma de pagamento:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Status:");

        txtIdPedido.setEditable(false);

        txtDataHora.setEditable(false);
        txtDataHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataHoraActionPerformed(evt);
            }
        });

        txtAtendente.setEditable(false);

        cbPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Pix", "Débito", "Crédito" }));

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Na Fila", " " }));

        jPanel6.setBackground(new java.awt.Color(67, 40, 24));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 250, 224));
        jLabel10.setText("Informações do pedido");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAtendente, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txtDataHora)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(254, 250, 224));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        String[] colunasPedido = {
            "Id",
            "Produto",
            "Quantidade",
            "Valor uni.",
            "Subtotal"
        };

        DefaultTableModel tabelaModeloP =
        new DefaultTableModel(colunasPedido, 0);

        ItensPedidoDAO p = new ItensPedidoDAO();

        ArrayList<ItensPedido> lista =
        p.listarItensPedido();

        for (int i = 0; i < lista.size(); i++) {

            ItensPedido consultaAtual = lista.get(i);

            String[] linha = {

                String.valueOf(consultaAtual.getIdCardapio()),

                consultaAtual.getNomeProduto(),

                String.valueOf(consultaAtual.getQuantidade()),

                String.valueOf(consultaAtual.getPrecoProduto()),

                String.valueOf(consultaAtual.getSubtotal())
            };

            tabelaModeloP.addRow(linha);
        }
        tblPedido.setModel(tabelaModeloP);
        jScrollPane2.setViewportView(tblPedido);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Total pedido:");

        jLabel20.setText("______________________________________________");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTotal.setText("R$ 0000,00");

        btRemover.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRemover.setText("Remover Item");
        btRemover.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btLimparPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btLimparPedido.setText("Limpar Pedido");
        btLimparPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btLimparPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparPedidoActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(67, 40, 24));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(254, 250, 224));
        jLabel18.setText("Itens do pedido");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLimparPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 195, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal)
                        .addGap(19, 19, 19))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(lblTotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover)
                    .addComponent(btLimparPedido))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btAdicionarObservacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAdicionarObservacao.setText("Adicionar Observação");
        btAdicionarObservacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarObservacaoActionPerformed(evt);
            }
        });

        btFinalizar.setBackground(new java.awt.Color(52, 199, 89));
        btFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btFinalizar.setText("Finalizar Pedido");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCancelar.setText("Cancelar Pedido");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAdicionarObservacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(btFinalizar)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblData)
                                .addGap(18, 18, 18)
                                .addComponent(lblHora))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(0, 38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblHora)
                    .addComponent(lblData))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAdicionarObservacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    // CONFIRMAÇÃO 
    int confirmar = JOptionPane.showConfirmDialog(
            null,
            "Deseja cancelar o pedido?",
            "Cancelar Pedido",
            JOptionPane.YES_NO_OPTION
    );

    if (confirmar != JOptionPane.YES_OPTION) {

        return;
    }

    // LIMPAR TABELA 
    DefaultTableModel modelo =
            (DefaultTableModel) tblPedido.getModel();

    modelo.setRowCount(0);

    // LIMPAR CAMPOS CLIENTE 
    txtIdCliente.setText("");

    txtNomeCliente.setText("");

    txtTelefone.setText("");

    txtEndereco.setText("");

    // LIMPAR QUANTIDADE
    txtQuantidade.setText("");

    // ZERAR TOTAL 
    lblTotal.setText("Total: R$ 0,00");

    // VOLTAR COMBOBOX 
    cbPagamento.setSelectedIndex(0);

    cbStatus.setSelectedIndex(0);

    // GERAR NOVO ID E DATA
    carregarIdPedido();

    carregarDataHora();

    JOptionPane.showMessageDialog(null,
            "Pedido cancelado!");
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
    // VALIDAR NOME
    if (txtNomeCliente.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(null,
                "Digite o nome do cliente!");

        txtNomeCliente.requestFocus();

        return;
    }

    // VALIDAR TELEFONE
    if (txtTelefone.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(null,
                "Digite o telefone!");

        txtTelefone.requestFocus();

        return;
    }

    // VALIDAR ENDEREÇO
    if (txtEndereco.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(null,
                "Digite o endereço!");

        txtEndereco.requestFocus();

        return;
    }

    Cliente c = new Cliente();

    c.setNome(txtNomeCliente.getText());

    c.setTelefone(txtTelefone.getText());

    c.setEndereco(txtEndereco.getText());

    ClienteDAO dao = new ClienteDAO();

    dao.cadastrarCliente(c);

    // LIMPAR CAMPOS ✨
    txtNomeCliente.setText("");

    txtTelefone.setText("");

    txtEndereco.setText("");

    txtIdCliente.setText("");

    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
    txtIdCliente.setText("");
    txtNomeCliente.setText("");
    txtTelefone.setText("");
    txtEndereco.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
     // VALIDAR CLIENTE 
if (txtIdCliente.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(null,
            "Busque um cliente!");

    return;
}

// VALIDAR ITENS 
if (tblPedido.getRowCount() == 0) {

    JOptionPane.showMessageDialog(null,
            "Adicione itens ao pedido!");

    return;
}

// CRIAR PEDIDO 
Pedido pedido = new Pedido();

pedido.setIdCliente(
        Integer.parseInt(txtIdCliente.getText()));

// PEGAR DATA E HORA 🚨
String dataHora =
        txtDataHora.getText();

String[] partes =
        dataHora.split(" ");

String data = partes[0];

String hora = partes[1];

// SALVAR SEPARADO 
pedido.setData(data);

pedido.setHora(hora);

// ID FUNCIONÁRIO
pedido.setIdFuncionario(usuarioLogado.getIdFuncionario());

// OBSERVAÇÃO
pedido.setObservacao(observacaoPedido);

// TOTAL 🍕
double total = 0;

for (int i = 0; i < tblPedido.getRowCount(); i++) {

    total += Double.parseDouble(
            tblPedido.getValueAt(i, 4).toString());
}

pedido.setTotal(total);

// SALVAR PEDIDO
PedidoDAO pedidoDAO = new PedidoDAO();

int idPedidoGerado = pedidoDAO.cadastrarPedido(pedido);

// SALVAR ITENS 🍕
ItensPedidoDAO itensDAO =
        new ItensPedidoDAO();

for (int i = 0; i < tblPedido.getRowCount(); i++) {

    ItensPedido item = new ItensPedido();

    item.setIdPedido(idPedidoGerado);

    item.setIdCardapio(
            Integer.parseInt(
                    tblPedido.getValueAt(i, 0).toString()));

    item.setQuantidade(
            Integer.parseInt(
                    tblPedido.getValueAt(i, 3).toString()));

    item.setSubtotal(
            Double.parseDouble(
                    tblPedido.getValueAt(i, 4).toString()));

    itensDAO.cadastrarItemPedido(item);
}

// PAGAMENTO 💳
Pagamento pagamento = new Pagamento();

pagamento.setIdPedido(idPedidoGerado);

pagamento.setMetodo(
        cbPagamento.getSelectedItem().toString()
);

// SE FOR DINHEIRO = PENDENTE
if (cbPagamento.getSelectedItem().toString()
        .equals("Dinheiro")) {

    pagamento.setStatus("Pendente");

} else {

    pagamento.setStatus("Pago");
}

// SALVAR PAGAMENTO
PagamentoDAO pagamentoDAO =
        new PagamentoDAO();

pagamentoDAO.cadastrarPagamento(pagamento);

JOptionPane.showMessageDialog(null,
        "Pedido salvo com sucesso!");
   
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btAdicionarObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarObservacaoActionPerformed
    TelaCadastrarObservacao tela = new TelaCadastrarObservacao(this);

    tela.setVisible(true);
    
    }//GEN-LAST:event_btAdicionarObservacaoActionPerformed

    private void txtDataHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataHoraActionPerformed

    }//GEN-LAST:event_txtDataHoraActionPerformed

    private void txtAdicionarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdicionarPedidoActionPerformed
   int linha = tblCardapio.getSelectedRow();

if (linha == -1) {

    JOptionPane.showMessageDialog(null,
            "Selecione um item!");

    return;
}

// VALIDAR CAMPO VAZIO
if (txtQuantidade.getText().trim().isEmpty()) {

    JOptionPane.showMessageDialog(null,
            "Digite a quantidade!");

    txtQuantidade.requestFocus();

    return;
}

int quantidade;

try {

    quantidade =
            Integer.parseInt(txtQuantidade.getText());

} catch (NumberFormatException e) {

    JOptionPane.showMessageDialog(null,
            "Digite apenas números!");

    txtQuantidade.requestFocus();

    return;
}

// VALIDAR ZERO OU NEGATIVO
if (quantidade <= 0) {

    JOptionPane.showMessageDialog(null,
            "A quantidade deve ser maior que zero!");

    txtQuantidade.requestFocus();

    return;
}

// ID do produto
int idCardapio = Integer.parseInt(
        tblCardapio.getValueAt(linha, 0).toString());

// Nome do produto
String produto =
        tblCardapio.getValueAt(linha, 1).toString();

// Valor do produto
double valor = Double.parseDouble(
        tblCardapio.getValueAt(linha, 3).toString());

// Subtotal
double subtotal = valor * quantidade;

DefaultTableModel modelo =
        (DefaultTableModel) tblPedido.getModel();

modelo.addRow(new Object[]{

    idCardapio,
    produto,
    valor,
    quantidade,
    subtotal
});

calcularTotal();

txtQuantidade.setText("");
    }//GEN-LAST:event_txtAdicionarPedidoActionPerformed

    private void txtBuscarProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdutoKeyReleased
    atualizarTabelaCardapio(txtBuscarProduto.getText());
    }//GEN-LAST:event_txtBuscarProdutoKeyReleased

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
    int linha =
            tblPedido.getSelectedRow();

    if (linha == -1) {

        JOptionPane.showMessageDialog(null,
                "Selecione um item para remover!");

        return;
    }

    DefaultTableModel modelo =
            (DefaultTableModel) tblPedido.getModel();

    modelo.removeRow(linha);

    calcularTotal();

    }//GEN-LAST:event_btRemoverActionPerformed

    private void btLimparPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparPedidoActionPerformed
    int confirmar = JOptionPane.showConfirmDialog(
            null,
            "Deseja limpar todo o pedido?"
    );

    if (confirmar == 0) {

        DefaultTableModel modelo =
                (DefaultTableModel) tblPedido.getModel();

        modelo.setRowCount(0);

        calcularTotal();
    }
    }//GEN-LAST:event_btLimparPedidoActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
    // VALIDAR CAMPO VAZIO
    if (txtIdCliente.getText().trim().isEmpty()) {

        JOptionPane.showMessageDialog(null,
                "Digite o ID do cliente!");

        txtIdCliente.requestFocus();

        return;
    }

    int idCliente;

    try {

        idCliente =
                Integer.parseInt(txtIdCliente.getText());

    } catch (NumberFormatException e) {

        JOptionPane.showMessageDialog(null,
                "Digite apenas números!");

        txtIdCliente.requestFocus();

        return;
    }

    ClienteDAO dao = new ClienteDAO();

    Cliente c = dao.buscarClientePorId(idCliente);

    if (c != null) {

        txtNomeCliente.setText(c.getNome());

        txtTelefone.setText(c.getTelefone());

        txtEndereco.setText(c.getEndereco());

    } else {

        JOptionPane.showMessageDialog(null,
                "Cliente não encontrado!");

        txtNomeCliente.setText("");

        txtTelefone.setText("");

        txtEndereco.setText("");
    }
    }//GEN-LAST:event_btBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarObservacao;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btLimparPedido;
    private javax.swing.JButton btRemover;
    private javax.swing.JComboBox<String> cbPagamento;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCardapio;
    private javax.swing.JTable tblPedido;
    private javax.swing.JButton txtAdicionarPedido;
    private javax.swing.JTextField txtAtendente;
    private javax.swing.JTextField txtBuscarProduto;
    private javax.swing.JTextField txtDataHora;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdPedido;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
