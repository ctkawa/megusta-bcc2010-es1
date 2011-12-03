/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.model;

/**
 *
 * @author cleber
 */
public class Tipo extends Entity{
    private int id;
    private String funcao;

    public Tipo(int id, String funcao) {
        this.id = id;
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
