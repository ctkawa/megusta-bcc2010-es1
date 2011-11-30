/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.controller;
import megusta.model.Entity;

/**
 *
 * @author cleber
 */
public abstract class ApplicationControl {
    public abstract boolean salvar(Entity entity);

    public abstract boolean excluir(Entity entity);

    public abstract Entity pesquisar(String key);
}
