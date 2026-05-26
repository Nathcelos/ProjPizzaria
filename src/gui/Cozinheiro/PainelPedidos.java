

package gui.Cozinheiro;

import dao.PedidoDAO;
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
    
    atualizarTudo();
    }

    public void atualizarTabela(String filtro) {

    String[] colunas = {
        "Id",
        "Itens",
        "Status",
        "Horário"
    };

    DefaultTableModel tabelaModelo =
            new DefaultTableModel(colunas, 0);

    PedidoDAO dao = new PedidoDAO();

    ArrayList<Pedido> lista;

    if (filtro == null || filtro.trim().isEmpty()) {
        lista = dao.listarPedidosCozinheiro();
    } else {
        lista = dao.filtrarPedidosCozinheiro(filtro);
    }

    for (Pedido p : lista) {
        tabelaModelo.addRow(new Object[]{
            p.getId(),
            p.getItensTexto(),
            p.getStatus(),
            p.getHora()
        });
    }

    tblPedidos.setModel(tabelaModelo);
}
    
    public void atualizarLabels() {

    PedidoDAO dao = new PedidoDAO();

    lblPendentes.setText(
            String.valueOf(
                    dao.contarPedidosPorStatus("Na Fila")
            )
    );

    lblEmPreparo.setText(
            String.valueOf(
                    dao.contarPedidosPorStatus("Em preparo")
            )
    );

    lblFinalizados.setText(
            String.valueOf(
                    dao.contarPedidosPorStatus("Para Entrega")
            )
    );
}
    
    public void atualizarTudo() {

    atualizarTabela("");

    atualizarLabels();
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
        jPanel2 = new javax.swing.JPanel();
        lblFinalizados = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPendentes = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btIniciar = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        btAbrir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblEmPreparo = new javax.swing.JLabel();
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

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 145, 62), 3, true));

        lblFinalizados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblFinalizados.setForeground(new java.awt.Color(0, 102, 0));
        lblFinalizados.setText("00");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Pedidos finalizados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFinalizados)
                    .addComponent(jLabel5))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFinalizados)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 236, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 141, 40), 3, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Pedidos pendentes");

        lblPendentes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPendentes.setForeground(new java.awt.Color(204, 102, 0));
        lblPendentes.setText("00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblPendentes))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPendentes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(254, 250, 224));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedidos recentes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Buscar pedido:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        String[] colunas = {
            "Id",
            "Itens",
            "Status",
            "Horário"
        };

        DefaultTableModel tabelaModelo =
        new DefaultTableModel(colunas, 0);

        PedidoDAO dao = new PedidoDAO();

        ArrayList<Pedido> lista =
        dao.listarPedidosCozinheiro();

        for (Pedido p : lista) {

            Object[] linha = {
                p.getId(),
                p.getItensTexto(),
                p.getStatus(),
                p.getHora()
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
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        btIniciar.setBackground(new java.awt.Color(255, 236, 153));
        btIniciar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btIniciar.setForeground(new java.awt.Color(204, 102, 0));
        btIniciar.setText("Iniciar Preparo");
        btIniciar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 141, 40), 3, true));
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        btFinalizar.setBackground(new java.awt.Color(52, 199, 89));
        btFinalizar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btFinalizar.setText("Finalizar Pedido");
        btFinalizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 145, 62), 3, true));
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        btAbrir.setBackground(new java.awt.Color(153, 204, 255));
        btAbrir.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btAbrir.setForeground(new java.awt.Color(0, 0, 102));
        btAbrir.setText("Abrir Pedido");
        btAbrir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 82, 154), 3, true));
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(243, 238, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(138, 99, 210), 3, true));

        lblEmPreparo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEmPreparo.setForeground(new java.awt.Color(138, 99, 210));
        lblEmPreparo.setText("00");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Em preparo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmPreparo)
                    .addComponent(jLabel10))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmPreparo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(btAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46)
                            .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblData)
                .addGap(18, 18, 18)
                .addComponent(lblHora)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblHora)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
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

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
    int linha = tblPedidos.getSelectedRow();

if (linha == -1) {
    JOptionPane.showMessageDialog(null, "Selecione um pedido!");
    return;
}

int idPedido = Integer.parseInt(
        tblPedidos.getValueAt(linha, 0).toString()
);

PedidoDAO dao = new PedidoDAO();

dao.atualizarStatusPedido(idPedido, "Para Entrega");

JOptionPane.showMessageDialog(null,
        "Pedido finalizado!");

atualizarTudo();
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
    int linha = tblPedidos.getSelectedRow();

if (linha == -1) {
    JOptionPane.showMessageDialog(null, "Selecione um pedido!");
    return;
}

int idPedido = Integer.parseInt(
        tblPedidos.getValueAt(linha, 0).toString()
);

PedidoDAO dao = new PedidoDAO();

dao.atualizarStatusPedido(idPedido, "Em preparo");

JOptionPane.showMessageDialog(null,
        "Pedido iniciado!");

atualizarTudo();
    }//GEN-LAST:event_btIniciarActionPerformed

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
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
    }//GEN-LAST:event_btAbrirActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
    atualizarTabela(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btIniciar;
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
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblEmPreparo;
    private javax.swing.JLabel lblFinalizados;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblPendentes;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
