

package gui.Gerente;

import dao.PedidoDAO;
import gui.CRUD.EditarPedido;
import gui.CRUD.VerPedido;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Pedido;



public class PainelPedidos extends javax.swing.JPanel {

    
    public PainelPedidos() {
        initComponents();
        listarPedidos();
        
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
    
    //Mostrar pedidos nos label
    PedidoDAO dao = new PedidoDAO();
    int total = dao.contarPedidosDoDia();
    lblPedidosHoje.setText(String.valueOf(total));
    lblCancelados.setText(String.valueOf(dao.contarPorStatus("Finalizado")));
    lblCancelados.setText(String.valueOf(dao.contarPorStatus("Cancelado")));
    }

 public void listarPedidos(){

    DefaultTableModel modelo = (DefaultTableModel) tblPedidos.getModel();
    modelo.setRowCount(0);

    PedidoDAO dao = new PedidoDAO();
    ArrayList<Pedido> lista = dao.listaPedido();

    for (Pedido p : lista) {
        modelo.addRow(new Object[]{
            p.getId(),
            p.getIdCliente(),
            p.getIdFuncionario(),
            p.getData(),
            p.getHora(),
            p.getStatus(),
            
        });
    }
}
 
    public void atualizarTabela(String filtro) {

    DefaultTableModel modelo = (DefaultTableModel) tblPedidos.getModel();
    modelo.setRowCount(0);

    PedidoDAO dao = new PedidoDAO();
    ArrayList<Pedido> lista;

    if (filtro == null || filtro.trim().isEmpty()) {
        lista = dao.listaPedido(); 
    } else {
        lista = dao.filtrar(filtro); 
    }

    for (Pedido p : lista) {
        modelo.addRow(new Object[]{
            p.getId(),
            p.getIdCliente(),
            p.getIdFuncionario(),
            p.getData(),
            p.getHora(),
            p.getStatus()
        });
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPedidosHoje = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarPedido = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btRemoverPedido = new javax.swing.JButton();
        btEditarPedido = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        blFinalizados = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblCancelados = new javax.swing.JLabel();
        btVerPedido = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        jLabel14.setText("jLabel14");

        jPanel1.setBackground(new java.awt.Color(254, 250, 224));

        jLabel1.setFont(new java.awt.Font("Irish Grover", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(67, 40, 24));
        jLabel1.setText("Pedidos");

        lblHora.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(67, 40, 24));
        lblHora.setText("00:00");

        lblData.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(67, 40, 24));
        lblData.setText("00/00/0000");

        jPanel3.setBackground(new java.awt.Color(255, 236, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 141, 40), 3, true));

        lblPedidosHoje.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPedidosHoje.setForeground(new java.awt.Color(204, 102, 0));
        lblPedidosHoje.setText("00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pedidos hoje");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPedidosHoje)
                    .addComponent(jLabel4))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(lblPedidosHoje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 250, 224));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos recentes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Buscar pedido:");

        txtBuscarPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPedidoKeyReleased(evt);
            }
        });

        String[] colunas = {"Id", "id Cliente","Id Funcionário", "Data","Hora","Status"};
        DefaultTableModel tabelaModelo = new DefaultTableModel (colunas, 0);

        PedidoDAO p = new PedidoDAO();
        ArrayList<Pedido> lista = p.listaPedido();

        for (int i = 0; i<lista.size(); i++){

            Pedido consultaAtual = lista.get(i);

            String[] linha = {
                String.valueOf(consultaAtual.getId()),
                String.valueOf(consultaAtual.getIdFuncionario()),
                consultaAtual.getData(),
                consultaAtual.getHora(),
                consultaAtual.getStatus(),
            };

            tabelaModelo.addRow(linha);
        }
        tblPedidos.setModel(tabelaModelo);
        jScrollPane1.setViewportView(tblPedidos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );

        btRemoverPedido.setBackground(new java.awt.Color(255, 153, 153));
        btRemoverPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btRemoverPedido.setForeground(new java.awt.Color(123, 30, 58));
        btRemoverPedido.setText("Remover Pedido");
        btRemoverPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 30, 58), 3, true));
        btRemoverPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverPedidoActionPerformed(evt);
            }
        });

        btEditarPedido.setBackground(new java.awt.Color(153, 204, 255));
        btEditarPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btEditarPedido.setForeground(new java.awt.Color(0, 0, 102));
        btEditarPedido.setText("Editar Pedido");
        btEditarPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 82, 154), 3, true));
        btEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarPedidoActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 145, 62), 3, true));

        blFinalizados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        blFinalizados.setForeground(new java.awt.Color(34, 145, 62));
        blFinalizados.setText("00");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Pedidos finalizados");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blFinalizados)
                    .addComponent(jLabel10))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addComponent(blFinalizados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 30, 58), 3, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Pedidos cancelados");

        lblCancelados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCancelados.setForeground(new java.awt.Color(123, 30, 58));
        lblCancelados.setText("00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblCancelados))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCancelados)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btVerPedido.setBackground(new java.awt.Color(255, 236, 153));
        btVerPedido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btVerPedido.setForeground(new java.awt.Color(255, 141, 40));
        btVerPedido.setText("Ver Pedido");
        btVerPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 141, 40), 3, true));
        btVerPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblData)
                .addGap(18, 18, 18)
                .addComponent(lblHora)
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btVerPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btRemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblData)
                    .addComponent(lblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditarPedido)
                    .addComponent(btRemoverPedido)
                    .addComponent(btVerPedido))
                .addGap(36, 36, 36))
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

    private void btRemoverPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverPedidoActionPerformed
    if(tblPedidos.getSelectedRow() == -1){

    JOptionPane.showMessageDialog(null, "Selecione um pedido!");

} else {
        
        int resposta = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza que deseja excluir o cliente?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
    );

    if (resposta == JOptionPane.YES_OPTION) {

         int linha = tblPedidos.getSelectedRow();

        int id = Integer.parseInt(
                tblPedidos.getValueAt(linha, 0).toString()
        );

        PedidoDAO dao = new PedidoDAO();

        dao.excluirPedido(id);

        JOptionPane.showMessageDialog(null, "Cliente excluído!");
        
        listarPedidos();

    }
        
    }
    }//GEN-LAST:event_btRemoverPedidoActionPerformed

    private void btEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarPedidoActionPerformed
    int linha = tblPedidos.getSelectedRow();

if (linha == -1) {
    JOptionPane.showMessageDialog(null, "Selecione um pedido!");
    return;
}

int idPedido = Integer.parseInt(
        tblPedidos.getValueAt(linha, 0).toString()
);

EditarPedido tela = new EditarPedido(idPedido);

tela.setVisible(true);
    }//GEN-LAST:event_btEditarPedidoActionPerformed

    private void btVerPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerPedidoActionPerformed
    if (tblPedidos.getSelectedRow() == -1) {

    JOptionPane.showMessageDialog(null, "Selecione um pedido!");

} else {

    JFrame telaAtual = (JFrame) SwingUtilities.getWindowAncestor(this);

    int linhaSelecionada = tblPedidos.getSelectedRow();

    int id = Integer.parseInt(
        tblPedidos.getValueAt(linhaSelecionada, 0).toString()
    );

    VerPedido tela = new VerPedido(id, telaAtual);

    tela.setVisible(true);
    telaAtual.setVisible(false);
}
    }//GEN-LAST:event_btVerPedidoActionPerformed

    private void txtBuscarPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPedidoKeyReleased
    atualizarTabela(txtBuscarPedido.getText());
    }//GEN-LAST:event_txtBuscarPedidoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blFinalizados;
    private javax.swing.JButton btEditarPedido;
    private javax.swing.JButton btRemoverPedido;
    private javax.swing.JButton btVerPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCancelados;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblPedidosHoje;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtBuscarPedido;
    // End of variables declaration//GEN-END:variables
}
