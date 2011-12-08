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


import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import megusta.controller.MesaControl;
import megusta.controller.ReservaControl;
import megusta.model.Reserva;

/**
 *
 * @author cleber
 */
public class ReservaUI extends javax.swing.JPanel {

    private static final boolean MODO_EDICAO = true;
    private int[] id_mesa;

    /** CONSTRUTOR  Creates new form FuncionarioUI2 */
    public ReservaUI() {
        initComponents();
        id_mesa = new int[100];
        
        setMesa(null);
        setControls(MODO_EDICAO);
        carregarTabela();
    }

    // Ativar/Desativar botoes
    private void setControls(boolean isModoEdicao) {
        btnNovo.setEnabled(!isModoEdicao);
        btnAtualizar.setEnabled(!isModoEdicao);
        btnExcluir.setEnabled(!isModoEdicao);
        btnSalvar.setEnabled(isModoEdicao);
        btnCancelar.setEnabled(isModoEdicao);
        btnPesquisar.setEnabled(!isModoEdicao);
        tableDados.setEnabled(!isModoEdicao);

        txtfId.setEditable(!isModoEdicao);
        /*txtfCPFCliente.setEditable(isModoEdicao);
        jSpinnerDia.setEnabled(isModoEdicao);
        jSpinnerMes.setEnabled(isModoEdicao);
        jSpinnerAno.setEnabled(isModoEdicao);
        jSpinnerHora.setEnabled(isModoEdicao);
        jSpinnerMinuto.setEnabled(isModoEdicao);
        cbbMesa.setEnabled(isModoEdicao);*/
    }

    private void carregarTabela() {
        String[][] reservas = new ReservaControl().pesquisar("");
        String[] colunas = {"ID", "DATA", "CPF Cliente", "id_mesa", "penalizado", "penalizado_ate"};
        tableDados.setModel(
            new DefaultTableModel(reservas, colunas) {
                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex){
                    return false;
                }
            }
        );
        validate();
    }



    // carregar conteudo do combobox


    private void setMesa(Date datahora){
        while(cbbMesa.getItemCount()>1)
            cbbMesa.removeItemAt(1);
        String[][] mesas;
        if(datahora != null){
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTime(datahora);
            Calendar calfim = Calendar.getInstance();
            calfim.setTime(datahora);
            calfim.add(Calendar.HOUR, 2);
            System.out.println("LIST mesa que nao esta na reserva entre "+sdf.format(cal.getTime()).toString()+" e "+sdf.format(calfim.getTime()).toString());
            mesas = new MesaControl().pesquisar("mesa.id NOT IN (SELECT id_mesa FROM reserva "
                    + "WHERE data < '" +sdf.format(cal.getTime())+ "'"
                    + "OR   data > '" +sdf.format(calfim.getTime())+ "')");
            int i=1;
            for(String[] mesa:mesas){
                id_mesa[i] = Integer.parseInt(mesa[0]);
                cbbMesa.insertItemAt(mesa[1], i);
                i++;
                System.out.println("i:"+i);
            }
        } else {
            mesas = new MesaControl().pesquisar("");
            System.out.println("LIST ALL MESA");
            int i=1;
            for(String[] mesa:mesas){
                id_mesa[i] = Integer.parseInt(mesa[0]);
                cbbMesa.insertItemAt(mesa[1], i);
                i++;
                System.out.println("null i:"+i);
            }
        }
        
        

    }

    private void refinarCbbMesa(){
        Calendar cal = Calendar.getInstance();
        cal.set(
                Integer.parseInt(jSpinnerAno.getValue().toString()),
                Integer.parseInt(jSpinnerMes.getValue().toString()),
                Integer.parseInt(jSpinnerDia.getValue().toString()),
                Integer.parseInt(jSpinnerHora.getValue().toString()),
                Integer.parseInt(jSpinnerMinuto.getValue().toString()
            ));
        setMesa(cal.getTime());
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
        tableDados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtfCPFCliente = new javax.swing.JTextField();
        txtfId = new javax.swing.JTextField();
        txtfLogging = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        cbbMesa = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerMinuto = new javax.swing.JSpinner();
        jSpinnerDia = new javax.swing.JSpinner();
        jSpinnerMes = new javax.swing.JSpinner();
        jSpinnerAno = new javax.swing.JSpinner();
        jSpinnerHora = new javax.swing.JSpinner();

        jLabel5.setText("jLabel5");

        jLabel4.setText("Horário:");

        tableDados.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDados);

        jLabel3.setText("CPF cliente:");

        jLabel2.setText("Id:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtfCPFCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfCPFClienteActionPerformed(evt);
            }
        });

        txtfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfIdActionPerformed(evt);
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

        cbbMesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "escolha..." }));
        cbbMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMesaActionPerformed(evt);
            }
        });
        cbbMesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cbbMesaFocusGained(evt);
            }
        });

        jLabel6.setText("Qtd. pessoas:");

        jLabel1.setText("Data:");

        jSpinnerMinuto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 5));

        jSpinnerDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jSpinnerMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jSpinnerAno.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2011), Integer.valueOf(2011), null, Integer.valueOf(1)));

        jSpinnerHora.setModel(new javax.swing.SpinnerNumberModel(12, 0, 23, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)))
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jSpinnerDia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerMes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)
                                    .addGap(12, 12, 12)
                                    .addComponent(jSpinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jSpinnerMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtfId)
                                .addComponent(txtfCPFCliente))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtfLogging, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(514, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(520, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(jLabel2)
                    .addComponent(txtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(jLabel3)
                    .addComponent(txtfCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExcluir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jSpinnerDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jSpinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(jLabel6)
                    .addComponent(cbbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtfLogging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(560, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(352, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtfCPFClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfCPFClienteActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtfCPFClienteActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        setControls(MODO_EDICAO);
        txtfId.setText("");
        txtfCPFCliente.setText("");
        
        /* Rascunho, obter valor de agora */
        jSpinnerAno.setValue(2011);
        jSpinnerMes.setValue(12);
        jSpinnerDia.setValue(8);
        jSpinnerHora.setValue(12);
        jSpinnerMinuto.setValue(0);

        cbbMesa.setSelectedIndex(0);
        
        txtfLogging.setText("...");

        refinarCbbMesa();
}//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        int cpf = Integer.parseInt(txtfCPFCliente.getText());
        Reserva reserva = (Reserva) new ReservaControl().pesquisar(cpf);
        if(reserva == null){
            txtfLogging.setText("Nenhuma reserva foi encontrada com a condicao.");
        }else{
            txtfId.setText("" + reserva.getId());
            txtfCPFCliente.setText("" + reserva.getCpf_cli());

            jSpinnerAno.setValue(reserva.getDataHora().getYear());
            jSpinnerMes.setValue(reserva.getDataHora().getMonth());
            jSpinnerDia.setValue(reserva.getDataHora().getDate());
            jSpinnerHora.setValue(reserva.getDataHora().getHours());
            jSpinnerMinuto.setValue(reserva.getDataHora().getMinutes());

            cbbMesa.setSelectedIndex(reserva.getId_mesa());
            
            txtfLogging.setText("... retornado ...");
        }
}//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setControls(!MODO_EDICAO);
        txtfId.setText("");
        txtfCPFCliente.setText("");

        /*
        jSpinnerAno.setValue(2011);
        jSpinnerMes.setValue(12);
        jSpinnerDia.setValue(8);
        jSpinnerHora.setValue(12);
        jSpinnerMinuto.setValue(0);
        */

        cbbMesa.setSelectedIndex(0);

        txtfLogging.setText("...");
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(cbbMesa.getSelectedIndex()==0){
            txtfLogging.setText("Informe a mesa para a reserva.");
            return;
        }

        Reserva reserva = new Reserva(
                // (int id, Date dataHora, String cpf_cli, int id_mesa, boolean penalizado, Date penalizado_ate)
                //Integer.parseInt(txtfId.getText()),
                0,
                new Date(),
                txtfCPFCliente.getText(),
                cbbMesa.getSelectedIndex(),
                false,
                null//new Date() // penalizado ate
        );

        if (new ReservaControl().salvar(reserva)){
            txtfLogging.setText("A reserva foi cadastrada com sucesso.");
            setControls(!MODO_EDICAO);
            carregarTabela();
        }else{
            txtfLogging.setText("A reserva nao pode ser atualizada.");
        }
}//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Reserva reserva = new Reserva(
                // (int id, Date dataHora, String cpf_cli, int id_mesa, boolean penalizado, Date penalizado_ate)
                //Integer.parseInt(txtfId.getText()),
                Integer.parseInt(txtfId.getText()),
                new Date(),
                txtfCPFCliente.getText(),
                cbbMesa.getSelectedIndex(),
                false,
                null//new Date() // penalizado ate
        );

        if (new ReservaControl().excluir(reserva)){
            txtfLogging.setText("a reserva foi excluido com sucesso.");
            setControls(!MODO_EDICAO);
            carregarTabela();
            btnExcluir.setEnabled(false);

            txtfId.setText("");
            txtfCPFCliente.setText("");
            /* Rascunho, obter valor de agora */
            jSpinnerAno.setValue(2011);
            jSpinnerMes.setValue(12);
            jSpinnerDia.setValue(8);
            jSpinnerHora.setValue(12);
            jSpinnerMinuto.setValue(0);

            /*String data = (String) tableDados.getValueAt(linha, 1);
            Calendar cal = Calendar.getInstance();
            jSpinnerAno.setValue(Integer.parseInt(data.substring(0, 4)));
            jSpinnerMes.setValue(Integer.parseInt(data.substring(5, 7)));
            jSpinnerDia.setValue(Integer.parseInt(data.substring(8, 10)));
            jSpinnerHora.setValue(Integer.parseInt(data.substring(11, 13)));
            jSpinnerMinuto.setValue(Integer.parseInt(data.substring(14, 16)));*/

            cbbMesa.setSelectedIndex(0);

        }else{
            txtfLogging.setText("A mesa nao pode ser excluido.");
        }
}//GEN-LAST:event_btnExcluirActionPerformed

    private void cbbMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMesaActionPerformed

    private void tableDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDadosMouseClicked
        
        if(btnNovo.isEnabled()){
            int linha = tableDados.getSelectedRow();
            txtfId.setText((String) tableDados.getValueAt(linha, 0));
            txtfCPFCliente.setText((String) tableDados.getValueAt(linha, 2));


            // yyyy-mm-dd hh:mm:ss.s
            String data = (String) tableDados.getValueAt(linha, 1);
            Calendar cal = Calendar.getInstance();
            

            jSpinnerAno.setValue(Integer.parseInt(data.substring(0, 4)));
            jSpinnerMes.setValue(Integer.parseInt(data.substring(5, 7)));
            jSpinnerDia.setValue(Integer.parseInt(data.substring(8, 10)));
            jSpinnerHora.setValue(Integer.parseInt(data.substring(11, 13)));
            jSpinnerMinuto.setValue(Integer.parseInt(data.substring(14, 16)));

            cbbMesa.setSelectedIndex(Integer.parseInt((String) tableDados.getValueAt(linha, 3)));

            btnExcluir.setEnabled(true);
            btnAtualizar.setEnabled(true);
        } else {
            setControls(!MODO_EDICAO);
        }
    }//GEN-LAST:event_tableDadosMouseClicked

private void txtfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfIdActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtfIdActionPerformed

private void cbbMesaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbbMesaFocusGained
    refinarCbbMesa();
}//GEN-LAST:event_cbbMesaFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbbMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner jSpinnerAno;
    private javax.swing.JSpinner jSpinnerDia;
    private javax.swing.JSpinner jSpinnerHora;
    private javax.swing.JSpinner jSpinnerMes;
    private javax.swing.JSpinner jSpinnerMinuto;
    private javax.swing.JTable tableDados;
    private javax.swing.JTextField txtfCPFCliente;
    private javax.swing.JTextField txtfId;
    private javax.swing.JTextField txtfLogging;
    // End of variables declaration//GEN-END:variables

}
