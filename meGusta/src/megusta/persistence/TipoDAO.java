/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import megusta.model.Tipo;

/**
 *
 * @author cleber
 */
public abstract class TipoDAO extends ApplicationDAO{
    public abstract boolean salvar(Tipo tipo);
    public abstract boolean atualizar(Tipo tipo);
    public abstract boolean excluir(Tipo tipo);
    public abstract Tipo pesquisar(int id);
    public abstract String[][] pesquisar(String condicao);
}
