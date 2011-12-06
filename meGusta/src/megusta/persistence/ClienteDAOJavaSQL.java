/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import megusta.model.Cliente;

/**
 *
 * @author cleber
 */
public class ClienteDAOJavaSQL extends ClienteDAO{

    public ClienteDAOJavaSQL() {
        conexao = new ConexaoJavaSQL();
    }

    @Override
    public ConexaoJavaSQL getConexao() {
        return (ConexaoJavaSQL) conexao;
    }
    
    @Override
    public boolean salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, telefone) VALUES('"
                +cliente.getNome()+"', '"
                +cliente.getTelefone()+"');";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean atualizar(Cliente cliente) {
        String sql = "UPDATE cliente (cpf, nome, telefone) VALUES("
                +cliente.getCpf()+", '"
                +cliente.getNome()+"', '"
                +cliente.getTelefone()+"');";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean excluir(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE (cpf="
                +cliente.getCpf()+");";
        return getConexao().executeCommand(sql);
    }

    @Override
    public Cliente pesquisar(int cpf) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[][] pesquisar(String condicao) {
        String sql = "SELECT * FROM cliente" +
                (condicao.equals("") ? ";" : " WHERE " + condicao + ";");

        ConexaoJavaSQL conn = getConexao();
        ResultSet resultSet = conn.executeQuery(sql);
        List<String[]> clientes = new ArrayList<String[]>();
        int numLinhas = 0;

        try {
            if(resultSet != null){
                while(resultSet.next()){
                    String[] cliente = new String[3];

                    cliente[0] = resultSet.getString("cpf");
                    cliente[1] = resultSet.getString("nome");
                    cliente[2] = resultSet.getString("telefone");

                    clientes.add(cliente);
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

        return clientes.toArray(new String[numLinhas][5]);
    }

}
