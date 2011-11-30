/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

/**
 *
 * @author cleber
 */
public abstract class ApplicationDAO {
    protected Conexao conexao;

    public Conexao getConexao() {
        return conexao;
    }
}
