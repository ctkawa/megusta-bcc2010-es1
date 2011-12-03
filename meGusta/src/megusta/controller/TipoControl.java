/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.controller;

import megusta.model.Entity;
import megusta.model.Tipo;
import megusta.persistence.TipoDAOJavaSQL;

/**
 *
 * @author cleber
 */
public class TipoControl extends ApplicationControl{

    @Override
    public boolean salvar(Entity entity) {
        Tipo ent = (Tipo) entity;
        return new TipoDAOJavaSQL().salvar(ent);
    }

    @Override
    public boolean atualizar(Entity entity) {
        Tipo ent = (Tipo) entity;
        return new TipoDAOJavaSQL().atualizar(ent);
    }

    @Override
    public boolean excluir(Entity entity) {
        Tipo ent = (Tipo) entity;
        return new TipoDAOJavaSQL().excluir(ent);
    }

    @Override
    public Entity pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[][] pesquisar(String condicao) {
        return new TipoDAOJavaSQL().pesquisar(condicao);
    }

}
