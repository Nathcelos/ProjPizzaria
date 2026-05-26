

package gui.Atendente;

import dao.PedidoDAO;
import gui.CRUD.EditarPedido;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.ArrayList;
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
    lblAndamento.setText(String.valueOf(dao.contarPorStatus("Em preparo")));
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
        btCancelar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblAndamento = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        btCancelar.setBackground(new java.awt.Color(255, 153, 153));
        btCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(123, 30, 58));
        btCancelar.setText("Cancelar Pedido");
        btCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 30, 58), 3, true));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btEditar.setBackground(new java.awt.Color(153, 204, 255));
        btEditar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btEditar.setForeground(new java.awt.Color(0, 0, 102));
        btEditar.setText("Editar Pedido");
        btEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 82, 154), 3, true));
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(243, 238, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(138, 99, 210), 3, true));

        lblAndamento.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAndamento.setForeground(new java.awt.Color(138, 99, 210));
        lblAndamento.setText("00");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Pedidos em andamento");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAndamento)
                    .addComponent(jLabel10))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addComponent(lblAndamento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblData)
                        .addGap(18, 18, 18)
                        .addComponent(lblHora)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblHora)
                    .addComponent(lblData))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEditar)
                    .addComponent(btCancelar))
                .addContainerGap(45, Short.MAX_VALUE))
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
    if (tblPedidos.getSelectedRow() == -1) {

    JOptionPane.showMessageDialog(null, "Selecione um pedido!");

} else {

    int resposta = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza que deseja cancelar o pedido?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
    );

    if (resposta == JOptionPane.YES_OPTION) {

        int linha = tblPedidos.getSelectedRow();

        int id = Integer.parseInt(
                tblPedidos.getValueAt(linha, 0).toString()
        );

        PedidoDAO dao = new PedidoDAO();

        dao.atualizarStatus(id, "Cancelado");

        JOptionPane.showMessageDialog(null, "Pedido cancelado!");
        
        listarPedidos();

    }else {

        JOptionPane.showMessageDialog(null, "Nenhuma alteração realizada.");
    }
}
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
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
    }//GEN-LAST:event_btEditarActionPerformed

    private void txtBuscarPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPedidoKeyReleased
    atualizarTabela(txtBuscarPedido.getText());
    }//GEN-LAST:event_txtBuscarPedidoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAndamento;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblPedidosHoje;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtBuscarPedido;
    // End of variables declaration//GEN-END:variables
}
