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

    public ReservaDAOJavaSQL() {
        conexao = new ConexaoJavaSQL();
    }

    @Override
    public ConexaoJavaSQL getConexao() {
        return (ConexaoJavaSQL) conexao;
    }

    @Override
    public boolean salvar(Reserva reserva) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "INSERT INTO reserva (data, cpf_cli, id_mesa, penalizado, penalizado_ate) VALUES('"
                /*+reserva.getId()+"', '"*/
                +sdf.format(reserva.getDataHora())+"', '"
                +reserva.getCpf_cli()+"', '"
                +reserva.getId_mesa()+"', ";
        sql += (reserva.isPenalizado()?"true":"false")+", ";
        sql += (reserva.getPenalizado_ate()==null?"null":"'"+sdf.format(reserva.getPenalizado_ate())+"'")+");";
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean atualizar(Reserva reserva) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "UPDATE reserva SET "
                + " data='"+sdf.format(reserva.getDataHora())+"', "
                + " cpf_cli='"+reserva.getCpf_cli()+"', "
                + " id_mesa='"+reserva.getId_mesa()+"'"
                + " WHERE id='"+reserva.getId()+"';";
        System.out.println("Mandando comando SQL: "+sql);
        return getConexao().executeCommand(sql);
    }

    @Override
    public boolean excluir(Reserva reserva) {
        String sql = "DELETE FROM reserva WHERE (id="
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
        System.out.println("Mandando comando SQL: "+sql);

        ConexaoJavaSQL conn = getConexao();
        ResultSet resultSet = conn.executeQuery(sql);
        List<String[]> reservas = new ArrayList<String[]>();
        int numLinhas = 0;

        try {
            if(resultSet != null){
                while(resultSet.next()){
                    String[] reserva = new String[6];

                    reserva[0] = resultSet.getString("id");
                    reserva[1] = resultSet.getString("data");
                    reserva[2] = resultSet.getString("cpf_cli");
                    reserva[3] = resultSet.getString("id_mesa");
                    reserva[4] = resultSet.getString("penalizado");
                    reserva[5] = resultSet.getString("penalizado_ate");

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

        return reservas.toArray(new String[numLinhas][6]);
    }


}
