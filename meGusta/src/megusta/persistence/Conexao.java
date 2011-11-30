/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

/**
 *
 * @author cleber
 */
class Conexao {
private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/locadora";
    private static final String USER = "root";
    private static final String PASS = "root";

    public Conexao() {
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }
    
}
