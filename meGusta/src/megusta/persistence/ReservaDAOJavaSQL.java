/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.persistence;

import megusta.model.Reserva;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author cleber
 */
public class ReservaDAOJavaSQL extends ReservaDAO{

    @Override
    public ConexaoJavaSQL getConexao() {
        return (ConexaoJavaSQL) conexao;
    }

    @Override
    public boolean salvar(Reserva reserva) {
        String sql = "INSERT INTO reserva (id, data, id_cli, id_mesa) VALUES("
                +reserva.getId()+"', '"
                +reserva.getDataHora()+"', '"
                +reserva.getId_cli()+"', '"
                +reserva.getId_mesa()+"');";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean atualizar(Reserva reserva) {
        String sql = "UPDATE reserva (id, data, id_cli, id_mesa) VALUES("
                +reserva.getId()+"', '"
                +reserva.getDataHora()+"', '"
                +reserva.getId_cli()+"', '"
                +reserva.getId_mesa()+"');";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean excluir(Reserva reserva) {
        String sql = "DELETE reserva WHERE (id="
                +reserva.getId()+");";
        return getConexao().executeCommand(sql);
    }

    @Override
    public Reserva pesquisar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String[][] pesquisar(String condicao) {
        String sql = "SELECT * FROM reserva" +
                (condicao.equals("") ? ";" : " WHERE " + condicao + ";");

        ConexaoJavaSQL conn = getConexao();
        ResultSet resultSet = conn.executeQuery(sql);
        List<String[]> reservas = new ArrayList<String[]>();
        int numLinhas = 0;

        try {
            if(resultSet != null){
                while(resultSet.next()){
                    String[] reserva = new String[4];

                    reserva[0] = resultSet.getString("id");
                    reserva[1] = resultSet.getString("data");
                    reserva[2] = resultSet.getString("id_cli");
                    reserva[3] = resultSet.getString("id_mesa");

                    reservas.add(reserva);
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

        return reservas.toArray(new String[numLinhas][4]);
    }


}
