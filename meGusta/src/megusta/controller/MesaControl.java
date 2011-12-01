/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.controller;

import megusta.model.Entity;
import megusta.model.Mesa;
import megusta.persistence.MesaDAOJavaSQL;

/**
 *
 * @author cleber
 */
public class MesaControl extends ApplicationControl{

    @Override
    public boolean salvar(Entity entity) {
        Mesa ent = (Mesa) entity;
        return new MesaDAOJavaSQL().salvar(ent);
    }

    @Override
    public boolean atualizar(Entity entity) {
        Mesa ent = (Mesa) entity;
        return new MesaDAOJavaSQL().atualizar(ent);
    }

    @Override
    public boolean excluir(Entity entity) {
        Mesa ent = (Mesa) entity;
        return new MesaDAOJavaSQL().excluir(ent);
    }

    @Override
    public Entity pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[][] pesquisar(String condicao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
