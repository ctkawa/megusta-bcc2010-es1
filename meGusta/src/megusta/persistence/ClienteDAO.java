/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import megusta.model.Cliente;

/**
 *
 * @author cleber
 */
public abstract class ClienteDAO extends ApplicationDAO{
    public abstract boolean salvar(Cliente cliente);
    public abstract boolean atualizar(Cliente cliente);
    public abstract boolean excluir(Cliente cliente);
    public abstract Cliente pesquisarCpf(String cpf);
    public abstract String[][] pesquisar(String condicao);
}
