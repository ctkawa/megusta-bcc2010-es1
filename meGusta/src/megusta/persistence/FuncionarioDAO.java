/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import megusta.model.Funcionario;

/**
 *
 * @author cleber
 */
public abstract class FuncionarioDAO extends ApplicationDAO{
    public abstract boolean salvar(Funcionario funcionario);
    public abstract boolean atualizar(Funcionario funcionario);
    public abstract boolean excluir(Funcionario funcionario);
    public abstract Funcionario pesquisar(int id);
    public abstract String[][] pesquisar(String condicao);
}
