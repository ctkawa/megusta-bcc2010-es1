/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import megusta.model.Entity;
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
        String sql = "INSERT INTO funcionario (nome, cpf, telefone, tipo) VALUES('"
                +funcionario.getNome()+"', '"
                +funcionario.getCpf()+"', '"
                +funcionario.getTelefone()+"', '"
                +funcionario.getTipo()+"');";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET "
                + " nome='"+funcionario.getNome()+"', "
                + " telefone='"+funcionario.getTelefone()+"', "
                + " tipo='"+funcionario.getTipo()+"'"
                + " WHERE cpf='"+funcionario.getCpf()+"';";
        System.out.println("Mandando comando SQL: "+sql);
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean excluir(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE (cpf='"
                +funcionario.getCpf()+"');";
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

        ConexaoJavaSQL conn = getConexao();
        ResultSet resultSet = conn.executeQuery(sql);
        List<String[]> funcionarios = new ArrayList<String[]>();
        int numLinhas = 0;

        try {
            if(resultSet != null){
                while(resultSet.next()){
                    String[] funcionario = new String[4];

                    funcionario[0] = resultSet.getString("nome");
                    funcionario[1] = resultSet.getString("cpf");
                    funcionario[2] = resultSet.getString("telefone");
                    funcionario[3] = resultSet.getString("tipo");

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

    public Entity pesquisarCPF(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE cpf = '" + cpf + "';";

        ConexaoJavaSQL conn = getConexao();
        ResultSet resultSet = conn.executeQuery(sql);
        List<String[]> funcionarios = new ArrayList<String[]>();

        try {
            if(resultSet != null && resultSet.next()){
                    Funcionario funcionario = new Funcionario(
                            resultSet.getString("nome"),
                            resultSet.getString("cpf"),
                            resultSet.getString("telefone"),
                            Integer.parseInt(resultSet.getString("tipo"))
                            );
                    return funcionario;
            }
        } catch (SQLException e) {
            StackTraceElement[] stack = e.getStackTrace();
            if(stack.length > 0){
                System.err.println("Message: " + e.getMessage());
                System.err.println("Command: " + sql);
                System.err.println("Exceprion: " + e);
            }
        }

        return null;
    }

}
