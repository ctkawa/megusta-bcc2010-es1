/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.controller;

import megusta.model.Entity;
import megusta.model.Cliente;
import megusta.persistence.ClienteDAOJavaSQL;

/**
 *
 * @author cleber
 */
public class ClienteControl extends ApplicationControl{

    @Override
    public boolean salvar(Entity entity) {
        Cliente cliente = (Cliente) entity;
        return new ClienteDAOJavaSQL().salvar(cliente);
    }

    @Override
    public boolean excluir(Entity entity) {
        Cliente cliente = (Cliente) entity;
        return new ClienteDAOJavaSQL().excluir(cliente);
    }

    @Override
    public boolean atualizar(Entity entity) {
        Cliente cliente = (Cliente) entity;
        return new ClienteDAOJavaSQL().atualizar(cliente);
    }

    @Override
    public Entity pesquisar(int id) {
        return new ClienteDAOJavaSQL().pesquisar(id);
    }

    @Override
    public String[][] pesquisar(String condicao) {
        return new ClienteDAOJavaSQL().pesquisar(condicao);
    }



}
