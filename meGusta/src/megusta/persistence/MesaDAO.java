/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import megusta.model.Mesa;

/**
 *
 * @author cleber
 */
public abstract class MesaDAO {
    public abstract boolean salvar(Mesa mesa);
    public abstract boolean atualizar(Mesa mesa);
    public abstract boolean excluir(Mesa mesa);
    public abstract Mesa pesquisar(int id);
    public abstract String[][] pesquisar(String condicao);
}
