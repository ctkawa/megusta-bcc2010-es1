/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.model;

/**
 *
 * @author cleber
 */
public class Cliente extends Entity{
    private int cpf;
    private String nome;
    private String telefone;

    public Cliente(int cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
