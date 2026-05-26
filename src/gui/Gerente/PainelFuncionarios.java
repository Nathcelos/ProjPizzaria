
package gui.Gerente;

import dao.FuncionarioDAO;
import dao.UsuarioDAO;
import gui.CRUD.CadastrarFuncionario;
import gui.CRUD.EditarFuncionario;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;


public class PainelFuncionarios extends javax.swing.JPanel {

   
    public PainelFuncionarios() {
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
    
    carregarTabelaFuncionarios();
    atualizarLabels();
    }

    public void carregarTabelaFuncionarios() {

    String[] colunas = {
        "Id",
        "Id Usuário",
        "Nome",
        "Telefone",
        "Cargo",
        "Data Contratação"
    };

    DefaultTableModel tabelaModelo =
            new DefaultTableModel(colunas, 0);

    FuncionarioDAO fdao =
            new FuncionarioDAO();

    ArrayList<Funcionario> lista =
            fdao.listarFuncionarios();

    for (int i = 0; i < lista.size(); i++) {

        Funcionario consultaAtual =
                lista.get(i);

        String[] linha = {

            String.valueOf(
                    consultaAtual.getId()
            ),

            String.valueOf(
                    consultaAtual.getIdUsuario()
            ),

            consultaAtual.getNome(),

            consultaAtual.getTelefone(),

            consultaAtual.getCargo(),

            consultaAtual.getDataContratacao()
        };

        tabelaModelo.addRow(linha);
    }

    tblFuncionarios.setModel(tabelaModelo);
}
    
    public void atualizarTabela(String filtro) {

    DefaultTableModel modelo =
            (DefaultTableModel) tblFuncionarios.getModel();

    modelo.setRowCount(0);

    FuncionarioDAO dao = new FuncionarioDAO();

    ArrayList<Funcionario> lista;

    if (filtro == null || filtro.trim().isEmpty()) {

        lista = dao.listarFuncionarios();

    } else {

        lista = dao.filtrarFuncionarios(filtro);
    }

    for (Funcionario f : lista) {

        modelo.addRow(new Object[]{

            f.getId(),

            f.getIdUsuario(),

            f.getNome(),

            f.getTelefone(),

            f.getCargo(),

            f.getDataContratacao()
        });
    }
}
    
    public void atualizarLabels() {

    FuncionarioDAO dao = new FuncionarioDAO();

    lblTotalFuncionarios.setText(String.valueOf(dao.contarFuncionarios()));

    lblEntregadores.setText(String.valueOf(dao.contarFuncionariosPorCargo("Entregador")));

    lblAtendentes.setText(String.valueOf(dao.contarFuncionariosPorCargo("Atendente")));

    lblCozinheiros.setText(String.valueOf(dao.contarFuncionariosPorCargo("Cozinheiro")));
}
    
    public void recarregarTabela() {

    atualizarTabela("");
    atualizarLabels();
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblAtendentes = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        txtBuscarFuncionario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblCozinheiros = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalFuncionarios = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblEntregadores = new javax.swing.JLabel();
        btEditar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();

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

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(123, 30, 58));
        jButton1.setText("Remover ");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 30, 58), 3, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(254, 250, 224));

        jLabel1.setFont(new java.awt.Font("Irish Grover", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(67, 40, 24));
        jLabel1.setText("Funcionários");

        lblHora.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(67, 40, 24));
        lblHora.setText("00:00");

        lblData.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(67, 40, 24));
        lblData.setText("00/00/0000");

        jPanel3.setBackground(new java.awt.Color(255, 236, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 141, 40), 3, true));

        lblAtendentes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAtendentes.setForeground(new java.awt.Color(204, 102, 0));
        lblAtendentes.setText("00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Atendentes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAtendentes)
                    .addComponent(jLabel4))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAtendentes)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 250, 224));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        String[] colunas = {"Id", "Id Usuário", "Nome", "Telefone", "Cargo", "Data Contratação"};

        DefaultTableModel tabelaModelo =
        new DefaultTableModel(colunas, 0);

        FuncionarioDAO fdao = new FuncionarioDAO();

        ArrayList<Funcionario> lista =
        fdao.listarFuncionarios();

        for (int i = 0; i < lista.size(); i++) {

            Funcionario consultaAtual = lista.get(i);

            String[] linha = {

                String.valueOf(consultaAtual.getId()),

                String.valueOf(consultaAtual.getIdUsuario()),
                consultaAtual.getNome(),
                consultaAtual.getTelefone(),
                consultaAtual.getCargo(),
                consultaAtual.getDataContratacao()};

            tabelaModelo.addRow(linha);
        }
        tblFuncionarios.setModel(tabelaModelo);
        jScrollPane1.setViewportView(tblFuncionarios);

        txtBuscarFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarFuncionarioKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Buscar funcionário:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 82, 154), 3, true));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Cozinheiros");

        lblCozinheiros.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCozinheiros.setForeground(new java.awt.Color(0, 82, 154));
        lblCozinheiros.setText("00");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblCozinheiros))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCozinheiros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(153, 255, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(34, 145, 62), 3));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Funcionários ativos");

        lblTotalFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTotalFuncionarios.setForeground(new java.awt.Color(0, 102, 0));
        lblTotalFuncionarios.setText("00");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblTotalFuncionarios))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalFuncionarios)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 30, 58), 3, true));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Entregadores");

        lblEntregadores.setBackground(new java.awt.Color(102, 0, 0));
        lblEntregadores.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEntregadores.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lblEntregadores))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEntregadores)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btEditar.setBackground(new java.awt.Color(153, 204, 255));
        btEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btEditar.setForeground(new java.awt.Color(0, 0, 102));
        btEditar.setText("Editar Funcionário");
        btEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 82, 154), 3, true));
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btRemover.setBackground(new java.awt.Color(255, 153, 153));
        btRemover.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btRemover.setForeground(new java.awt.Color(123, 30, 58));
        btRemover.setText("Remover Funcionário");
        btRemover.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 30, 58), 3, true));
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        btAdicionar.setBackground(new java.awt.Color(52, 199, 89));
        btAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        btAdicionar.setText("Adicionar Funcionário");
        btAdicionar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 145, 62), 3, true));
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblData)
                                .addGap(18, 18, 18)
                                .addComponent(lblHora))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblData)
                    .addComponent(lblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
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

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
   if(tblFuncionarios.getSelectedRow() == -1){

    JOptionPane.showMessageDialog(null,
            "Selecione um funcionário!");

} else {

    int linha =
            tblFuncionarios.getSelectedRow();

    int idFuncionario = Integer.parseInt(
            tblFuncionarios
                    .getValueAt(linha, 0)
                    .toString()
    );

    int idUsuario = Integer.parseInt(
            tblFuncionarios
                    .getValueAt(linha, 1)
                    .toString()
    );

    PainelFuncionarios telaAtual = this;

    EditarFuncionario tela =
            new EditarFuncionario(
                    telaAtual,
                    idFuncionario,
                    idUsuario
            );

    tela.setVisible(true);
}
   
    }//GEN-LAST:event_btEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
    int linha = tblFuncionarios.getSelectedRow();

if (linha == -1) {

    JOptionPane.showMessageDialog(null,
            "Selecione um funcionário!");

    return;
}

int idFuncionario = Integer.parseInt(
        tblFuncionarios
                .getValueAt(linha, 0)
                .toString()
);

int idUsuario = Integer.parseInt(
        tblFuncionarios
                .getValueAt(linha, 1)
                .toString()
);

// confirmação
int confirmar = JOptionPane.showConfirmDialog(
        null,
        "Deseja remover este funcionário?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION
);

if (confirmar == JOptionPane.YES_OPTION) {

    FuncionarioDAO fdao =
            new FuncionarioDAO();

    UsuarioDAO udao =
            new UsuarioDAO();

    // remove funcionário
    fdao.excluirFuncionario(idFuncionario);

    // remove usuário
    udao.excluirUsuario(idUsuario);

    JOptionPane.showMessageDialog(null,
            "Funcionário removido!");

    recarregarTabela();
}

    }//GEN-LAST:event_btRemoverActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
    if(tblFuncionarios.getSelectedRow() == -1){

    JOptionPane.showMessageDialog(null, "Selecione um funcionário!");

} else {
        
    JFrame telaAtual = (JFrame) SwingUtilities.getWindowAncestor(this);
    CadastrarFuncionario tela = new CadastrarFuncionario(telaAtual);

    tela.setVisible(true);

    telaAtual.setVisible(false);
    
    }

    }//GEN-LAST:event_btAdicionarActionPerformed

    private void txtBuscarFuncionarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarFuncionarioKeyReleased
    atualizarTabela(txtBuscarFuncionario.getText());
    }//GEN-LAST:event_txtBuscarFuncionarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAtendentes;
    private javax.swing.JLabel lblCozinheiros;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEntregadores;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTotalFuncionarios;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtBuscarFuncionario;
    // End of variables declaration//GEN-END:variables
}
