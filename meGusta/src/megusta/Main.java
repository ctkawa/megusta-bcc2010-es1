/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta;

import megusta.view.Login;
/**
 *
 * @author cleber
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

}
