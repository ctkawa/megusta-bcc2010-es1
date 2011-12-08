/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package megusta.model;

import java.util.Date;

/**
 *
 * @author cleber
 */
public class Reserva extends Entity{
    private int id;
    private Date dataHora;
    private String cpf_cli;
    private int id_mesa;
    private boolean penalizado;
    private Date penalizado_ate;

    public Reserva(int id, Date dataHora, String cpf_cli, int id_mesa, boolean penalizado, Date penalizado_ate) {
        this.id = id;
        this.dataHora = dataHora;
        this.cpf_cli = cpf_cli;
        this.id_mesa = id_mesa;
        this.penalizado = penalizado;
        this.penalizado_ate = penalizado_ate;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cpf_cli) {
        this.cpf_cli = cpf_cli;
    }


    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public boolean isPenalizado() {
        return penalizado;
    }

    public void setPenalizado(boolean penalizado) {
        this.penalizado = penalizado;
    }

    public Date getPenalizado_ate() {
        return penalizado_ate;
    }

    public void setPenalizado_ate(Date penalizado_ate) {
        this.penalizado_ate = penalizado_ate;
    }


    

}
