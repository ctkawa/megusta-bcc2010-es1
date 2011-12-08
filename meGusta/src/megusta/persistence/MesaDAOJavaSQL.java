/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import megusta.model.Mesa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cleber
 */
public class MesaDAOJavaSQL extends MesaDAO{

    public MesaDAOJavaSQL() {
        conexao = new ConexaoJavaSQL();
    }

    @Override
    public ConexaoJavaSQL getConexao() {
        return (ConexaoJavaSQL) conexao;
    }

    @Override
    public boolean salvar(Mesa mesa) {
        String sql = "INSERT INTO mesa (capacidade) VALUES('"
                
                +mesa.getCapacidade()+"');";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean atualizar(Mesa mesa) {
        String sql = "UPDATE mesa SET "
                + " capacidade='"+mesa.getCapacidade()+"' "
                + " WHERE id='"+mesa.getId()+"';";
        System.out.println("Mandando comando SQL: "+sql);
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean excluir(Mesa mesa) {
        String sql = "DELETE FROM mesa WHERE (id="
                +mesa.getId()+");";
        return getConexao().executeCommand(sql);
    }

    @Override
    public Mesa pesquisar(int id) {
        String sql = "SELECT * FROM mesa WHERE id = '" + id + "';";
        ConexaoJavaSQL conn = getConexao();
        ResultSet resultSet = conn.executeQuery(sql);

        try {
            if(resultSet != null && resultSet.next()){
                    Mesa mesa = new Mesa(
                            Integer.parseInt(resultSet.getString("id")),
                            Integer.parseInt(resultSet.getString("capacidade"))
                            );
                    return mesa;
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

    @Override
    public String[][] pesquisar(String condicao) {
        String sql = "SELECT * FROM mesa" +
                (condicao.equals("") ? ";" : " WHERE " + condicao + ";");

        ConexaoJavaSQL conn = getConexao();
        ResultSet resultSet = conn.executeQuery(sql);
        List<String[]> mesas = new ArrayList<String[]>();
        int numLinhas = 0;

        try {
            if(resultSet != null){
                while(resultSet.next()){
                    String[] mesa = new String[2];

                    mesa[0] = resultSet.getString("id");
                    mesa[1] = resultSet.getString("capacidade");

                    mesas.add(mesa);
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

        return mesas.toArray(new String[numLinhas][2]);
    }


}
