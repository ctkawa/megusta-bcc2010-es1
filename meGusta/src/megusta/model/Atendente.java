/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.model;

/**
 *
 * @author cleber
 */
public class Atendente extends Funcionario{

    public Atendente(String nome, String cpf, String telefone, int tipo) {
        super(nome, cpf, telefone, tipo);   // chamando construtor do soperclasse
    }

}
