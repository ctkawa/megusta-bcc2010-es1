/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MesaUI.java
 *
 * Created on Dec 1, 2011, 6:12:29 AM
 */

package megusta.view;

import javax.swing.table.DefaultTableModel;
import megusta.controller.MesaControl;
import megusta.model.Mesa;

/**
 *
 * @author cleber
 */
public class MesaUI extends javax.swing.JPanel {

    private static final boolean MODO_EDICAO = true;

    /** Creates new form MesaUI */
    public MesaUI() {
        initComponents();
        carregarTabela();
        setControls(!MODO_EDICAO);
        
    }

    private void setControls(boolean isModoEdicao) {
        btnNovo.setEnabled(!isModoEdicao);
        btnAtualizar.setEnabled(!isModoEdicao);
        //btnExcluir.setEnabled(!isModoEdicao);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(isModoEdicao);
        btnCancelar.setEnabled(isModoEdicao);
        btnPesquisar.setEnabled(!isModoEdicao);
        tableMesa.setEnabled(!isModoEdicao);
        
        txtfCapacidade.setEditable(isModoEdicao);
    }

    private void carregarTabela() {
        String[][] clientes = new MesaControl().pesquisar("");
        String[] colunas = {"ID", "Capacidade"};
        tableMesa.setModel(
            new DefaultTableModel(clientes, colunas) {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex){
                    return false;
                }
            }
        );
        validate();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMesa = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        txtfLogging = new javax.swing.JTextField();
        txtfID = new javax.swing.JTextField();
        txtfCapacidade = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        tableMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMesaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMesa);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        txtfLogging.setEditable(false);
        txtfLogging.setText("Log");
        txtfLogging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfLoggingActionPerformed(evt);
            }
        });

        txtfCapacidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfCapacidadeActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jLabel2.setText("Capacidade:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfID, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(txtfCapacidade, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                    .addComponent(txtfLogging, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtfCapacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnNovo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAtualizar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnPesquisar))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(txtfLogging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtfLoggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfLoggingActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtfLoggingActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        setControls(MODO_EDICAO);
        txtfID.setText("");
        txtfCapacidade.setText("");
        txtfLogging.setText("...");
}//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        int id = Integer.parseInt(txtfID.getText());
        Mesa mesa = (Mesa) new MesaControl().pesquisar(id);
        if(mesa == null){
            txtfLogging.setText("Nenhuma mesa foi encontrada com a condicao.");
        }else{
            txtfID.setText(""+mesa.getId());
            txtfCapacidade.setText(""+mesa.getCapacidade());
            txtfLogging.setText("... retornado ...");
        }
}//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setControls(!MODO_EDICAO);
        txtfID.setText("");
        txtfCapacidade.setText("");
        txtfLogging.setText("...");
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Mesa mesa = new Mesa(
            //Integer.parseInt(txtfID.getText()),
            0,
            Integer.parseInt(txtfCapacidade.getText())
        );

        if (new MesaControl().salvar(mesa)){
            txtfLogging.setText("A Mesa foi cadastrada com sucesso.");
            setControls(!MODO_EDICAO);
            carregarTabela();
            txtfID.setText("");
            txtfCapacidade.setText("");
        }else{
            txtfLogging.setText("A mesa nao pode ser atualizada.");
        }
        carregarTabela();
}//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Mesa mesa = new Mesa(
                Integer.parseInt(txtfID.getText()),
                Integer.parseInt(txtfCapacidade.getText())
        );

        if (new MesaControl().excluir(mesa)){
            txtfLogging.setText("A mesa foi excluido com sucesso.");
            setControls(!MODO_EDICAO);
            carregarTabela();
            btnExcluir.setEnabled(false);
            txtfID.setText("");
            txtfCapacidade.setText("");
        }else{
            txtfLogging.setText("A mesa nao pode ser excluido.");
        }
        
}//GEN-LAST:event_btnExcluirActionPerformed

    private void txtfCapacidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfCapacidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfCapacidadeActionPerformed

    private void tableMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMesaMouseClicked
        if(btnNovo.isEnabled()){
            int linha = tableMesa.getSelectedRow();
            txtfID.setText((String) tableMesa.getValueAt(linha, 0));
            txtfCapacidade.setText((String) tableMesa.getValueAt(linha, 1));
            btnExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_tableMesaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableMesa;
    private javax.swing.JTextField txtfCapacidade;
    private javax.swing.JTextField txtfID;
    private javax.swing.JTextField txtfLogging;
    // End of variables declaration//GEN-END:variables

}
