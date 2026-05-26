

package gui.Gerente;

import dao.EstoqueDAO;
import gui.CRUD.AtualizarEstoque;
import gui.CRUD.CadastrarItem;
import gui.CRUD.EditarItem;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.Estoque;



public class PainelEstoque extends javax.swing.JPanel {

    
    public PainelEstoque() {
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
    
    carregarTabela();
atualizarLabels();
    }

    public void carregarTabela(){

    DefaultTableModel modelo = (DefaultTableModel) tblEstoque.getModel();
    modelo.setRowCount(0); // limpa a tabela

    EstoqueDAO dao = new EstoqueDAO();
    ArrayList<Estoque> lista = dao.listarEstoque();

    for (Estoque e : lista) {
        modelo.addRow(new Object[]{
            e.getId(),
            e.getNome(),
            e.getFornecedor(),
            e.getQuantidade(),
            e.getValidade(),
            e.getCategoria(),
            
        });
    }
}
    
    public void atualizarTabela(String filtro) {

    DefaultTableModel modelo = (DefaultTableModel) tblEstoque.getModel();
    modelo.setRowCount(0);

    EstoqueDAO dao = new EstoqueDAO();
    ArrayList<Estoque> lista;

    if (filtro == null || filtro.trim().isEmpty()) {
        lista = dao.listarEstoque(); 
    } else {
        lista = dao.filtrar(filtro); 
    }

    for (Estoque e : lista) {
        modelo.addRow(new Object[]{
            e.getId(),
            e.getNome(),
            e.getFornecedor(),
            e.getQuantidade(),
            e.getValidade(),
            e.getCategoria()
        });
    }
}
    
    public void atualizarLabels() {

    EstoqueDAO dao = new EstoqueDAO();

    lblTotal.setText(String.valueOf(dao.contarEstoque()));
    
    lblBaixo.setText(String.valueOf(dao.contarEstoqueBaixo()));

    lblVencendo.setText(String.valueOf(dao.contarItensVencendo()));
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
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarItem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstoque = new javax.swing.JTable();
        btRemover = new javax.swing.JButton();
        btAdicionar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btAtualizar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblBaixo = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblVencendo = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        jLabel14.setText("jLabel14");

        jPanel1.setBackground(new java.awt.Color(254, 250, 224));

        jLabel1.setFont(new java.awt.Font("Irish Grover", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(67, 40, 24));
        jLabel1.setText("Estoque");

        lblHora.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(67, 40, 24));
        lblHora.setText("00:00");

        lblData.setFont(new java.awt.Font("Irish Grover", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(67, 40, 24));
        lblData.setText("00/00/0000");

        jPanel4.setBackground(new java.awt.Color(254, 250, 224));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingredientes em estoque", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Buscar ingrediente:");

        txtBuscarItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarItemKeyReleased(evt);
            }
        });

        String[] colunas = {"Id", "Nome","Fornecedor", "Quantidade", "Validade","Categoria"};
        DefaultTableModel tabelaModelo = new DefaultTableModel (colunas, 0);

        EstoqueDAO d = new EstoqueDAO();
        ArrayList<Estoque> lista = d.listarEstoque();

        for (int i = 0; i<lista.size(); i++){

            Estoque consultaAtual = lista.get(i);

            String[] linha = {
                String.valueOf(consultaAtual.getId()),
                consultaAtual.getNome(),
                consultaAtual.getValidade(),
                String.valueOf(consultaAtual.getQuantidade()),
                consultaAtual.getCategoria(),
            };

            tabelaModelo.addRow(linha);
        }
        tblEstoque.setModel(tabelaModelo);
        jScrollPane1.setViewportView(tblEstoque);

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
                        .addComponent(txtBuscarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

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

        jPanel3.setBackground(new java.awt.Color(255, 236, 153));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 141, 40), 3, true));

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(204, 102, 0));
        lblTotal.setText("00");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Total ingredientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addComponent(jLabel4))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(lblTotal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btAtualizar.setBackground(new java.awt.Color(255, 236, 153));
        btAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btAtualizar.setForeground(new java.awt.Color(255, 141, 40));
        btAtualizar.setText("Atualizar");
        btAtualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 141, 40), 3, true));
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 153, 153));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(123, 30, 58), 3, true));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Estoque baixo");

        lblBaixo.setBackground(new java.awt.Color(102, 0, 0));
        lblBaixo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblBaixo.setText("00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lblBaixo))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBaixo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 82, 154), 3, true));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Itens vencendo");

        lblVencendo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblVencendo.setForeground(new java.awt.Color(0, 82, 154));
        lblVencendo.setText("00");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lblVencendo))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVencendo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblHora)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
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

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
   
    JFrame telaAtual = (JFrame) SwingUtilities.getWindowAncestor(this);
    CadastrarItem tela = new CadastrarItem(telaAtual);

    tela.setVisible(true);

    telaAtual.setVisible(false);
       
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
    int linha = tblEstoque.getSelectedRow();

if (linha == -1) {

    JOptionPane.showMessageDialog(null,
            "Selecione um item!");

    return;
}

int idItem = Integer.parseInt(
        tblEstoque.getValueAt(linha, 0).toString()
);

int confirmar = JOptionPane.showConfirmDialog(
        null,
        "Deseja remover este item do estoque?",
        "Confirmar remoção",
        JOptionPane.YES_NO_OPTION
);

if (confirmar == JOptionPane.YES_OPTION) {

    EstoqueDAO dao = new EstoqueDAO();

    dao.excluirEstoque(idItem);

    JOptionPane.showMessageDialog(null,
            "Item removido com sucesso!");

    atualizarTudo();
}
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
    if(tblEstoque.getSelectedRow() == -1){

    JOptionPane.showMessageDialog(null,
            "Selecione um item!");

} else {

    int linha =
            tblEstoque.getSelectedRow();

    int idItem = Integer.parseInt(
            tblEstoque
                    .getValueAt(linha, 0)
                    .toString()
    );

    PainelEstoque telaAtual = this;

    EditarItem tela = new EditarItem(telaAtual, idItem);

    tela.setVisible(true);

}
    }//GEN-LAST:event_btEditarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
    int linha = tblEstoque.getSelectedRow();

if (linha == -1) {

    JOptionPane.showMessageDialog(null, "Selecione um item!");

} else {

    int id = Integer.parseInt(tblEstoque.getValueAt(linha, 0).toString());
    String ingrediente = tblEstoque.getValueAt(linha, 1).toString();
    int quantidade = Integer.parseInt(tblEstoque.getValueAt(linha, 3).toString());
    String validade = tblEstoque.getValueAt(linha, 4).toString();
    String obs = "";

    AtualizarEstoque tela = new AtualizarEstoque(
        this,
        id,
        ingrediente,
        quantidade,
        validade
);

    tela.setVisible(true);
}
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void txtBuscarItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarItemKeyReleased
    atualizarTabela(txtBuscarItem.getText());
    }//GEN-LAST:event_txtBuscarItemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBaixo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVencendo;
    private javax.swing.JTable tblEstoque;
    private javax.swing.JTextField txtBuscarItem;
    // End of variables declaration//GEN-END:variables
}
