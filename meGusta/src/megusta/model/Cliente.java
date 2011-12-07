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
    private String cpf;
    private String nome;
    private String telefone;

    public Cliente(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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
