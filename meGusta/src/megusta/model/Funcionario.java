/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.model;

/**
 *
 * @author cleber
 */
public class Funcionario extends Entity{
    private int id;
    private String nome;
    private String rg;
    private String telefone;

    public Funcionario(int id, String nome, String rg, String telefone) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    

}
