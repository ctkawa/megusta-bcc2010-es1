/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.controller;

import megusta.model.Entity;
import megusta.model.Reserva;
import megusta.persistence.ReservaDAOJavaSQL;

/**
 *
 * @author cleber
 */
public class ReservaControl extends ApplicationControl{

    @Override
    public boolean salvar(Entity entity) {
        Reserva ent = (Reserva) entity;
        return new ReservaDAOJavaSQL().salvar(ent);
    }

    @Override
    public boolean atualizar(Entity entity) {
        Reserva ent = (Reserva) entity;
        return new ReservaDAOJavaSQL().atualizar(ent);
    }

    @Override
    public boolean excluir(Entity entity) {
        Reserva ent = (Reserva) entity;
        return new ReservaDAOJavaSQL().excluir(ent);
    }

    @Override
    public Entity pesquisar(int id) {
        return new ReservaDAOJavaSQL().pesquisar(id);
    }

    @Override
    public String[][] pesquisar(String condicao) {
        return new ReservaDAOJavaSQL().pesquisar(condicao);
    }

}
