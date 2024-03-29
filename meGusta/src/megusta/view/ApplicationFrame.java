/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ApplicationFrame.java
 *
 * Created on Nov 30, 2011, 8:17:14 PM
 */

package megusta.view;

/**
 *
 * @author cleber
 */
public class ApplicationFrame extends javax.swing.JFrame {

    /** Creates new form ApplicationFrame */
    public ApplicationFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBarraMenu = new javax.swing.JMenuBar();
        jMenuItemArquivo = new javax.swing.JMenu();
        jMenuItemFuncionario = new javax.swing.JMenuItem();
        jMenuItemMesa = new javax.swing.JMenuItem();
        jMenuItemReserva = new javax.swing.JMenuItem();
        jMenuItemCliente = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuItemArquivo.setText("Menu de Gerenciamento");

        jMenuItemFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFuncionario.setText("Gerenciamento de Funcionários");
        jMenuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFuncionarioActionPerformed(evt);
            }
        });
        jMenuItemArquivo.add(jMenuItemFuncionario);

        jMenuItemMesa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemMesa.setText("Gerenciamento de Mesas");
        jMenuItemMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMesaActionPerformed(evt);
            }
        });
        jMenuItemArquivo.add(jMenuItemMesa);

        jMenuItemReserva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemReserva.setText("Gerenciamento de Reservas");
        jMenuItemReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReservaActionPerformed(evt);
            }
        });
        jMenuItemArquivo.add(jMenuItemReserva);

        jMenuItemCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCliente.setText("Gerenciamento de Clientes");
        jMenuItemCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemClienteMouseClicked(evt);
            }
        });
        jMenuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClienteActionPerformed(evt);
            }
        });
        jMenuItemArquivo.add(jMenuItemCliente);

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuItemArquivo.add(jMenuItemSair);

        jBarraMenu.add(jMenuItemArquivo);

        setJMenuBar(jBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFuncionarioActionPerformed
        FuncionarioUI pnlFunc = new FuncionarioUI();
        setContentPane(pnlFunc);
        setSize(800, 600);
        validate();
    }//GEN-LAST:event_jMenuItemFuncionarioActionPerformed

private void jMenuItemMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMesaActionPerformed
        MesaUI pnlMesa = new MesaUI();
        setContentPane(pnlMesa);
        setSize(400, 550);
        validate();

}//GEN-LAST:event_jMenuItemMesaActionPerformed

private void jMenuItemReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReservaActionPerformed
        ReservaUI pnlReserva = new ReservaUI();
        setContentPane(pnlReserva);
        setSize(650, 600);
        validate();
}//GEN-LAST:event_jMenuItemReservaActionPerformed

private void jMenuItemClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemClienteMouseClicked

}//GEN-LAST:event_jMenuItemClienteMouseClicked

private void jMenuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClienteActionPerformed
    ClienteUI pnlCliente = new ClienteUI();
    setContentPane(pnlCliente);
    setSize(650, 600);
    validate();
}//GEN-LAST:event_jMenuItemClienteActionPerformed

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationFrame().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jBarraMenu;
    private javax.swing.JMenu jMenuItemArquivo;
    private javax.swing.JMenuItem jMenuItemCliente;
    private javax.swing.JMenuItem jMenuItemFuncionario;
    private javax.swing.JMenuItem jMenuItemMesa;
    private javax.swing.JMenuItem jMenuItemReserva;
    private javax.swing.JMenuItem jMenuItemSair;
    // End of variables declaration//GEN-END:variables

}
