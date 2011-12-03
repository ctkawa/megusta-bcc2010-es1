/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import megusta.model.Reserva;

/**
 *
 * @author cleber
 */
public abstract class ReservaDAO extends ApplicationDAO{
    public abstract boolean salvar(Reserva reserva);
    public abstract boolean atualizar(Reserva reserva);
    public abstract boolean excluir(Reserva reserva);
    public abstract Reserva pesquisar(int id);
    public abstract String[][] pesquisar(String condicao);
}
