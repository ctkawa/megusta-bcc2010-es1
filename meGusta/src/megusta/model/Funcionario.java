/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.model;

import java.util.Date;

/**
 *
 * @author cleber
 */
public class Funcionario extends Entity{
    private int id;
    private String nome;
    private String rg;
    private int telefone;

    public Funcionario(int id, String nome, String rg, int telefone) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
