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
    private int id_cli;
    private int id_mesa;
    private boolean penalizado;
    private Date penalizado_ate;

    public Reserva(int id, Date dataHora, int id_cli, int id_mesa, boolean penalizado, Date penalizado_ate) {
        this.id = id;
        this.dataHora = dataHora;
        this.id_cli = id_cli;
        this.id_mesa = id_mesa;
        this.penalizado = penalizado;
        this.penalizado_ate = penalizado_ate;
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

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
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
