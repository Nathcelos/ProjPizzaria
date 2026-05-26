
package gui.Gerente;

import dao.CardapioDAO;
import gui.CRUD.CadastrarCardapio;
import gui.CRUD.EditarCardapio;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Cardapio;


public class PainelCardapio extends javax.swing.JPanel {

    
    public PainelCardapio() {
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
    
    //Mostrar total de itens do cardápio no label
    CardapioDAO dao = new CardapioDAO();
    int total = dao.contarCardapio();
    lblTotal.setText(String.valueOf(total));
    }

    public void atualizarTabela(String filtro) {

    DefaultTableModel modelo = (DefaultTableModel) tblCardapio.getModel();
    modelo.setRowCount(0);

    CardapioDAO dao = new CardapioDAO();
    ArrayList<Cardapio> lista;

    if (filtro == null || filtro.trim().isEmpty()) {
        lista = dao.listarCardapio(); 
    } else {
        lista = dao.filtrar(filtro); 
    }

    for (Cardapio c : lista) {
        modelo.addRow(new Object[]{
            c.getId(),
            c.getNome(),
            c.getDescricao(),
            c.getPreco(),
            c.getCategoria()
        });
    }
}

    public void atualizarTabela(ArrayList<Cardapio> lista) {

    DefaultTableModel model = (DefaultTableModel) tblCardapio.getModel();

    model.setRowCount(0);

    for (Cardapio c : lista) {

        model.addRow(new Object[]{
            c.getId(),
            c.getNome(),
            c.getDescricao(),
            c.getPreco(),
            c.getCategoria()
        });
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCardapio = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarProduto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btEditar = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(254, 250, 224));

        jLabel1.setFont(new java.awt.Font("Irish Grover", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(67, 40, 24));
        jLabel1.setText("Cardápio");

        lblHora.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(67, 40, 24));
        lblHora.setText("00:00");

        lblData.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(67, 40, 24));
        lblData.setText("00/00/0000");

        jPanel4.setBackground(new java.awt.Color(254, 250, 224));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        String[] colunas = {"Id", "Nome","Descrição", "Preço", "Categoria"};
        DefaultTableModel tabelaModelo = new DefaultTableModel (colunas, 0);

        CardapioDAO c = new CardapioDAO();
        ArrayList<Cardapio> lista = c.listarCardapio();

        for (int i = 0; i<lista.size(); i++){

            Cardapio consultaAtual = lista.get(i);

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Buscar produto:");

        txtBuscarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProdutoActionPerformed(evt);
            }
        });
        txtBuscarProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProdutoKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Categoria:");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Bebidas", "Pizzas Doces", "Pizzas Salgadas", "Porções", " " }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 236, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 141, 40), 3, true));

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(204, 102, 0));
        lblTotal.setText("00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Total produtos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addComponent(jLabel4))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(lblTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btEditar.setBackground(new java.awt.Color(153, 204, 255));
        btEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btEditar.setForeground(new java.awt.Color(0, 0, 102));
        btEditar.setText("Editar ");
        btEditar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 82, 154), 3, true));
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btAdicionar.setBackground(new java.awt.Color(52, 199, 89));
        btAdicionar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        btAdicionar.setText("Adicionar");
        btAdicionar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 145, 62), 3, true));
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btRemover.setBackground(new java.awt.Color(255, 153, 153));
        btRemover.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btRemover.setForeground(new java.awt.Color(123, 30, 58));
        btRemover.setText("Remover ");
        btRemover.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 30, 58), 3, true));
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(337, 337, 337))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(594, 594, 594)
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHora))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblHora)
                    .addComponent(lblData))
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
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

    private void txtBuscarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProdutoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
    if(tblCardapio.getSelectedRow() == -1){

    JOptionPane.showMessageDialog(null, "Selecione um item!");

} else {
       
    JFrame telaAtual = (JFrame) SwingUtilities.getWindowAncestor(this);
    EditarCardapio tela = new EditarCardapio(telaAtual);

    tela.setVisible(true);

    telaAtual.setVisible(false);
    
    }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
   JFrame telaAtual = (JFrame) SwingUtilities.getWindowAncestor(this);
    CadastrarCardapio tela = new CadastrarCardapio(telaAtual);

    tela.setVisible(true);

    telaAtual.setVisible(false);
    
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
    if (tblCardapio.getSelectedRow() == -1) {

    JOptionPane.showMessageDialog(null, "Selecione um item do cardápio!");

} else {

    int resposta = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza que deseja remover este item do cardápio?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
    );

    if (resposta == JOptionPane.YES_OPTION) {

        int linha = tblCardapio.getSelectedRow();

        int id = Integer.parseInt(
                tblCardapio.getValueAt(linha, 0).toString()
        );

        CardapioDAO dao = new CardapioDAO();

        dao.excluirCardapio(id);

        JOptionPane.showMessageDialog(null, "Item removido com sucesso!");

    }
    }
    }//GEN-LAST:event_btRemoverActionPerformed

    private void txtBuscarProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdutoKeyReleased
    atualizarTabela(txtBuscarProduto.getText());
    }//GEN-LAST:event_txtBuscarProdutoKeyReleased

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
    String categoriaSelecionada = cbCategoria.getSelectedItem().toString();

    CardapioDAO dao = new CardapioDAO();

    ArrayList<Cardapio> lista = dao.filtrarPorCategoria(categoriaSelecionada);

    atualizarTabela(lista);
    }//GEN-LAST:event_cbCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btRemover;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCardapio;
    private javax.swing.JTextField txtBuscarProduto;
    // End of variables declaration//GEN-END:variables
}
