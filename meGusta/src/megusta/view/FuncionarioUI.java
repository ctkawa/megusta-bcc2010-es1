/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FuncionarioUI2.java
 *
 * Created on Nov 30, 2011, 9:41:13 PM
 */

package megusta.view;

import javax.swing.table.DefaultTableModel;
import megusta.controller.FuncionarioControl;
import megusta.controller.TipoControl;
import megusta.model.Funcionario;

/**
 *
 * @author cleber
 */
public class FuncionarioUI extends javax.swing.JPanel {

    private static final boolean MODO_EDICAO = true;

    /** CONSTRUTOR  Creates new form FuncionarioUI2 */
    public FuncionarioUI() {
        initComponents();
        setTipo();
        setControls(!MODO_EDICAO);
        carregarTabela();
    }

    // Ativar/Desativar botoes
    private void setControls(boolean isModoEdicao) {
        btnNovo.setEnabled(!isModoEdicao);
        btnAtualizar.setEnabled(!isModoEdicao);
        //btnExcluir.setEnabled(!isModoEdicao);
        btnExcluir.setEnabled(false);
        btnSalvar.setEnabled(isModoEdicao);
        btnCancelar.setEnabled(isModoEdicao);
        btnPesquisar.setEnabled(!isModoEdicao);
        tableFuncionario.setEnabled(!isModoEdicao);
        /*txtfID.setEditable(isModoEdicao);
        txtfRG.setEditable(isModoEdicao);
        txtfNome.setEditable(isModoEdicao);
        txtfTelefone.setEditable(isModoEdicao);
        cbbTipo.setEditable(isModoEdicao);*/
    }

    private void carregarTabela() {
        String[][] funcionarios = new FuncionarioControl().pesquisar("");
        //trocar numero por nome do cargo correspondente
        String[][] tipos = new TipoControl().pesquisar("");
        for(String[] row : funcionarios){
            row[3] = tipos[Integer.parseInt(row[3])-1][1];
        }

        String[] colunas = {"Nome", "CPF", "Telefone", "Tipo"};
        tableFuncionario.setModel(
            new DefaultTableModel(funcionarios, colunas) {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex){
                    return false;
                }
            }
        );
        validate();
    }

    // carregar conteudo do combobox
    private void setTipo(){
        String[][] tipos = new TipoControl().pesquisar("");
        for(String[] tipo:tipos){
            cbbTipo.insertItemAt(tipo[1], Integer.parseInt(tipo[0]));
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFuncionario = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtfTelefone = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtfCPF = new javax.swing.JTextField();
        txtfNome = new javax.swing.JTextField();
        txtfLogging = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        cbbTipo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        jLabel4.setText("Telefone:");

        tableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
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
        tableFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableFuncionario);

        jLabel3.setText("CPF:");

        jLabel2.setText("Nome:");

        txtfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfTelefoneActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfCPFActionPerformed(evt);
            }
        });

        txtfLogging.setEditable(false);
        txtfLogging.setText("Log");

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

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

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cbbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "escolha..." }));
        cbbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTipoActionPerformed(evt);
            }
        });

        jLabel6.setText("Tipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfLogging, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(txtfNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addComponent(txtfCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(512, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(518, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(jLabel2)
                    .addComponent(txtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(jLabel3)
                    .addComponent(txtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(jLabel4)
                    .addComponent(txtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(jLabel6)
                    .addComponent(cbbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtfLogging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(552, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfTelefoneActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtfTelefoneActionPerformed

    private void txtfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfCPFActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtfCPFActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        setControls(MODO_EDICAO);
        txtfNome.setText("");
        txtfCPF.setText("");
        txtfTelefone.setText("");
        txtfLogging.setText("...");
}//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        int cpf = Integer.parseInt(txtfCPF.getText());
        Funcionario funcionario = (Funcionario) new FuncionarioControl().pesquisar(cpf);
        if(funcionario == null){
            txtfLogging.setText("Nenhum funcionario foi encontrado com a condicao.");
        }else{
            txtfNome.setText(funcionario.getNome());
            txtfCPF.setText(funcionario.getCpf());
            txtfTelefone.setText(""+funcionario.getTelefone());
            txtfLogging.setText("... retornado ...");
        }
}//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setControls(!MODO_EDICAO);
        txtfNome.setText("");
        txtfCPF.setText("");
        txtfTelefone.setText("");
        txtfLogging.setText("...");
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Funcionario funcionario = new Funcionario(
                txtfNome.getText(),
                txtfCPF.getText(),
                txtfTelefone.getText(),
                cbbTipo.getSelectedIndex()
        );

        if (new FuncionarioControl().salvar(funcionario)){
            txtfLogging.setText("O funcionario foi cadastrado com sucesso.");
            setControls(!MODO_EDICAO);
            carregarTabela();
        }else{
            txtfLogging.setText("O funcionario nao pode ser atualizado.");
        }
}//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Funcionario funcionario = new Funcionario(
                txtfNome.getText(),
                txtfCPF.getText(),
                txtfTelefone.getText(),
                cbbTipo.getSelectedIndex()
        );

        if (new FuncionarioControl().excluir(funcionario)){
            txtfLogging.setText("o funcionario foi excluido com sucesso.");
            setControls(!MODO_EDICAO);
            carregarTabela();
            btnExcluir.setEnabled(false);
            txtfNome.setText("");
            txtfCPF.setText("");
            txtfTelefone.setText("");
            cbbTipo.setSelectedIndex(0);
        }else{
            txtfLogging.setText("A mesa nao pode ser excluido.");
        }
}//GEN-LAST:event_btnExcluirActionPerformed

    private void cbbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTipoActionPerformed

    private void tableFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFuncionarioMouseClicked
        if(btnNovo.isEnabled()){
            int linha = tableFuncionario.getSelectedRow();
            txtfNome.setText((String) tableFuncionario.getValueAt(linha, 0));
            txtfCPF.setText((String) tableFuncionario.getValueAt(linha, 1));
            txtfTelefone.setText((String) tableFuncionario.getValueAt(linha, 2));
            
            String[][] tipos = new TipoControl().pesquisar("");
            for(String[] row : tipos){//gambiarra total
                if(row[1].equals(tableFuncionario.getValueAt(linha, 3))){
                    cbbTipo.setSelectedIndex(Integer.parseInt(row[0]));
                }
            }
            btnExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_tableFuncionarioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbbTipo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tableFuncionario;
    private javax.swing.JTextField txtfCPF;
    private javax.swing.JTextField txtfLogging;
    private javax.swing.JTextField txtfNome;
    private javax.swing.JTextField txtfTelefone;
    // End of variables declaration//GEN-END:variables

}
