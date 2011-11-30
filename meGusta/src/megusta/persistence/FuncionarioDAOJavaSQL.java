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
public class FuncionarioDAOJavaSQL extends FuncionarioDAO{

    public FuncionarioDAOJavaSQL() {
        conexao = new ConexaoJavaSQL();
    }

    @Override
    public boolean salvar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean atualizar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean excluir(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Funcionario pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[][] pesquisar(String condicao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
