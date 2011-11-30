/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author cleber
 */
public class ConexaoJavaSQL extends Conexao{
private static Connection connection;

    public ConexaoJavaSQL() {
        super();
        connection = null;
    }

    public static Connection getConnection() {
        if (connection == null){
            startConnection();
        }
        return connection;
    }

    private static void startConnection() {
        try {
            Class.forName(getDRIVER());
            connection = (Connection) DriverManager.getConnection(getURL(), getUSER(), getPASS());
        } catch (ClassNotFoundException e) {
            System.err.println("\n\nDriver desconhecido.");
            System.exit(-1);
        } catch (Exception e) {
            StackTraceElement[] stack = e.getStackTrace();
            if(stack.length > 0){
                System.err.println("Source\\File: " + stack[ 0].getFileName());
                System.err.println("Line: " + stack[ 0].getLineNumber());
                System.err.println("Message: " + e.getMessage());
                System.err.println("Exceprion: " + e);
            }
        }
    }

    public boolean executeCommand(String sqlClause){
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(sqlClause);
            statement.close();
            return true;
        } catch (Exception e) {
            StackTraceElement[] stack = e.getStackTrace();
            if(stack.length > 0){
                System.err.println("Line: " + stack[ 0].getLineNumber());
                System.err.println("Message: " + e.getMessage());
                System.err.println("Clause: " + sqlClause);
                System.err.println("Exceprion: " + e);
            }
            return false;
        }
    }

    public ResultSet executeQuery(String sqlClause){
        try {
            Statement statement = getConnection().createStatement();
            return statement.executeQuery(sqlClause);
        } catch (Exception e) {
            StackTraceElement[] stack = e.getStackTrace();
            if(stack.length > 0){
                System.err.println("Line: " + stack[ 0].getLineNumber());
                System.err.println("Message: " + e.getMessage());
                System.err.println("Clause: " + sqlClause);
                System.err.println("Exceprion: " + e);
            }
            return null;
        }
    }
}
