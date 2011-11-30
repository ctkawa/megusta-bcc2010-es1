/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.controller;

import megusta.model.Entity;
import megusta.model.Funcionario;
import megusta.persistence.FuncionarioDAOJavaSQL;

/**
 *
 * @author cleber
 */
public class FuncionarioControl extends ApplicationControl{

    @Override
    public boolean salvar(Entity entity) {
        Funcionario funcionario = (Funcionario) entity;
        return new FuncionarioDAOJavaSQL().salvar(funcionario);
    }

    @Override
    public boolean excluir(Entity entity) {
        Funcionario funcionario = (Funcionario) entity;
        return new FuncionarioDAOJavaSQL().excluir(funcionario);
    }

    @Override
    public boolean atualizar(Entity entity) {
        Funcionario funcionario = (Funcionario) entity;
        return new FuncionarioDAOJavaSQL().atualizar(funcionario);
    }

    @Override
    public Entity pesquisar(int id) {
        return new FuncionarioDAOJavaSQL().pesquisar(id);
    }

    @Override
    public String[][] pesquisar(String condicao) {
        return new FuncionarioDAOJavaSQL().pesquisar(condicao);
    }



}
