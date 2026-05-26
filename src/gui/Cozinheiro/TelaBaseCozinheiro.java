
package gui.Cozinheiro;

import java.awt.Color;
import javax.swing.JButton;
import model.Usuario;


public class TelaBaseCozinheiro extends javax.swing.JFrame {

    
    public TelaBaseCozinheiro() {
        initComponents();
        
       
    }
    
    public TelaBaseCozinheiro(Usuario u) {
        initComponents();
        
         btTelaPrincipal.setBackground(new Color(254,250,224));
        btTelaPrincipal.setForeground(new Color(67,40,24));
        PainelConteudo.removeAll();
        PainelConteudo.add(new PainelPrincipal());
        PainelConteudo.repaint();
        PainelConteudo.revalidate();
        
        lblNome.setText(u.getNomeFuncionario());
    }

    public void resetarBotoes(){

    JButton[] botoes = {
        btTelaPrincipal,
        btPedidos,
        btEstoque
    };

    for(JButton botao : botoes){

        // Fundo
        botao.setBackground(new Color(67,40,24));

        // Texto
        botao.setForeground(new Color(254,250,224));

        // Borda
        botao.setBorder(
            javax.swing.BorderFactory.createLineBorder(
                new Color(254,250,224))
        );
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        btTelaPrincipal = new javax.swing.JButton();
        btPedidos = new javax.swing.JButton();
        btEstoque = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        PainelConteudo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(67, 40, 24));

        jPanel3.setBackground(new java.awt.Color(254, 250, 224));

        jLabel1.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(67, 40, 24));
        jLabel1.setText("Tela Cozinheiro");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNome.setBackground(new java.awt.Color(254, 250, 224));
        lblNome.setFont(new java.awt.Font("Irish Grover", 0, 12)); // NOI18N
        lblNome.setForeground(new java.awt.Color(254, 250, 224));
        lblNome.setText("Nome Cozinheiro");

        btTelaPrincipal.setBackground(new java.awt.Color(67, 40, 24));
        btTelaPrincipal.setFont(new java.awt.Font("Irish Grover", 0, 14)); // NOI18N
        btTelaPrincipal.setForeground(new java.awt.Color(254, 250, 224));
        btTelaPrincipal.setText("Tela Principal");
        btTelaPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 250, 224), 3, true));
        btTelaPrincipal.setOpaque(true);
        btTelaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTelaPrincipalActionPerformed(evt);
            }
        });

        btPedidos.setBackground(new java.awt.Color(67, 40, 24));
        btPedidos.setFont(new java.awt.Font("Irish Grover", 0, 14)); // NOI18N
        btPedidos.setForeground(new java.awt.Color(254, 250, 224));
        btPedidos.setText("Pedidos");
        btPedidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 250, 224), 3, true));
        btPedidos.setOpaque(true);
        btPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidosActionPerformed(evt);
            }
        });

        btEstoque.setBackground(new java.awt.Color(67, 40, 24));
        btEstoque.setFont(new java.awt.Font("Irish Grover", 0, 14)); // NOI18N
        btEstoque.setForeground(new java.awt.Color(254, 250, 224));
        btEstoque.setText("Estoque");
        btEstoque.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 250, 224), 3, true));
        btEstoque.setOpaque(true);
        btEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEstoqueActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Sair");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblNome))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btPedidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addGap(36, 36, 36)
                .addComponent(btTelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanel4.setBackground(new java.awt.Color(67, 40, 24));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        PainelConteudo.setBackground(new java.awt.Color(254, 250, 224));
        PainelConteudo.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PainelConteudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidosActionPerformed
    //Cor do botão
    resetarBotoes();

    btPedidos.setBackground(new Color(254,250,224));

    btPedidos.setForeground(new Color(67,40,24));
    
    //Remove o painel atual
    PainelConteudo.removeAll();

    //Coloca o novo painel
    PainelConteudo.add(new PainelPedidos());

    //Atualizam a tela
    PainelConteudo.repaint();

    PainelConteudo.revalidate();
    }//GEN-LAST:event_btPedidosActionPerformed

    private void btEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEstoqueActionPerformed
    //Cor do botão
    resetarBotoes();

    btEstoque.setBackground(new Color(254,250,224));

    btEstoque.setForeground(new Color(67,40,24));
    
    //Remove o painel atual
    PainelConteudo.removeAll();

    //Coloca o novo painel
    PainelConteudo.add(new PainelEstoque());

    //Atualizam a tela
    PainelConteudo.repaint();

    PainelConteudo.revalidate();
    }//GEN-LAST:event_btEstoqueActionPerformed

    private void btTelaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTelaPrincipalActionPerformed
    //Cor do botão
    resetarBotoes();

    btTelaPrincipal.setBackground(new Color(254,250,224));

    btTelaPrincipal.setForeground(new Color(67,40,24));
    
    //Remove o painel atual
    PainelConteudo.removeAll();

    //Coloca o novo painel
    PainelConteudo.add(new PainelPrincipal());

    //Atualizam a tela
    PainelConteudo.repaint();

    PainelConteudo.revalidate();
    }//GEN-LAST:event_btTelaPrincipalActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new TelaBaseCozinheiro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelConteudo;
    private javax.swing.JButton btEstoque;
    private javax.swing.JButton btPedidos;
    private javax.swing.JButton btTelaPrincipal;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblNome;
    // End of variables declaration//GEN-END:variables
}
