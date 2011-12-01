/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import megusta.model.Funcionario;

/**
 *
 * @author cleber
 */
public class FuncionarioDAOJavaSQL extends FuncionarioDAO{

    public FuncionarioDAOJavaSQL() {
        conexao = new ConexaoJavaSQL();
    }

    @Override
    public ConexaoJavaSQL getConexao() {
        return (ConexaoJavaSQL) conexao;
    }
    
    @Override
    public boolean salvar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (id, nome, rg, telefone) VALUES("
                +funcionario.getId()+", '"
                +funcionario.getNome()+"', '"
                +funcionario.getRg()+"', '"
                +funcionario.getTelefone()+"');";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario (id, nome, rg, telefone) VALUES("
                +funcionario.getId()+", '"
                +funcionario.getNome()+"', '"
                +funcionario.getRg()+"', '"
                +funcionario.getTelefone()+"');";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean excluir(Funcionario funcionario) {
        String sql = "DELETE funcionario WHERE (id="
                +funcionario.getId()+");";
        return getConexao().executeCommand(sql);
    }

    @Override
    public Funcionario pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[][] pesquisar(String condicao) {
        String sql = "SELECT * FROM funcionario" +
                (condicao.equals("") ? ";" : " WHERE " + condicao + ";");

        ResultSet resultSet = getConexao().executeQuery(sql);
        List<String[]> funcionarios = new ArrayList<String[]>();
        int numLinhas = 0;

        try {
            if(resultSet != null){
                while(resultSet.next()){
                    String[] funcionario = new String[4];

                    funcionario[0] = resultSet.getString("id");
                    funcionario[1] = resultSet.getString("nome");
                    funcionario[2] = resultSet.getString("rg");
                    funcionario[3] = resultSet.getString("telefone");

                    funcionarios.add(funcionario);
                    numLinhas++;
                }
            }
        } catch (SQLException e) {
            StackTraceElement[] stack = e.getStackTrace();
            if(stack.length > 0){
                System.err.println("Message: " + e.getMessage());
                System.err.println("Command: " + sql);
                System.err.println("Exceprion: " + e);
            }
        }

        return funcionarios.toArray(new String[numLinhas][4]);
    }

}
