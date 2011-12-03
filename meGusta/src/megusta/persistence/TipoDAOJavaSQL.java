/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import megusta.model.Tipo;

/**
 *
 * @author cleber
 */
public class TipoDAOJavaSQL extends TipoDAO{

    public TipoDAOJavaSQL() {
        conexao = new ConexaoJavaSQL();
    }

    @Override
    public ConexaoJavaSQL getConexao() {
        return (ConexaoJavaSQL) conexao;
    }

    @Override
    public boolean salvar(Tipo tipo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean atualizar(Tipo tipo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean excluir(Tipo tipo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tipo pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[][] pesquisar(String condicao) {
        String sql = "SELECT * FROM tipo_funcionario" +
                (condicao.equals("") ? ";" : " WHERE " + condicao + ";");
        ConexaoJavaSQL conn = getConexao();
        ResultSet resultSet = conn.executeQuery(sql);
        List<String[]> tipos = new ArrayList<String[]>();
        int numLinhas = 0;

        try {
            if(resultSet != null){
                while(resultSet.next()){
                    String[] tipo = new String[2];

                    tipo[0] = resultSet.getString("id");
                    tipo[1] = resultSet.getString("funcao");


                    tipos.add(tipo);
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

        return tipos.toArray(new String[numLinhas][2]);
    }


}
