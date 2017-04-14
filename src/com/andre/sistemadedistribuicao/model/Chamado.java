package com.andre.sistemadedistribuicao.model;

import com.andre.sistemadedistribuicao.dao.ChamadoDAO;
import com.andre.sistemadedistribuicao.dao.DataSource;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * @author Andre Luis Sabino
 * @version 1.0
 * @since 12/04/2017
 */
public class Chamado {

    private int id;
    private String cliente;
    private String email;
    private String telefone;
    private String endereco;
    private String servico;
    private Date dataAbertura;
    private boolean encaminhado;
    private Date dataEncerramento;
    private boolean encerrado;
    private Time tempototal;

    public Chamado() {
    }

    public Chamado(int id, String cliente, String email, String telefone, String endereco, String servico, Date dataAbertura, boolean encaminhado, Date dataEncerramento, boolean encerrado, Time tempototal) {
        this.id = id;
        this.cliente = cliente;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.servico = servico;
        this.dataAbertura = dataAbertura;
        this.encaminhado = encaminhado;
        this.dataEncerramento = dataEncerramento;
        this.encerrado = encerrado;
        this.tempototal = tempototal;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getServico() {
        return servico;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public boolean isEncaminhado(int bit) {
        if (bit == 0) {
            this.encaminhado = false;
            return this.encaminhado;
        } else {
            this.encaminhado = true;
            return this.encaminhado;
        }
    }

    public Date getDataEncerramento() {
        return dataEncerramento;
    }

    public boolean isEncerrado(int bit) {
        if (bit == 0) {
            this.encerrado = false;
            return this.encerrado;
        } else {
            this.encerrado = true;
            return this.encerrado;
        }
    }

    public Time getTempototal() {
        return tempototal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setEncaminhado(boolean encaminhado) {
        this.encaminhado = encaminhado;
    }

    public void setDataEncerramento(Date dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado;
    }

    public void setTempototal(Time tempototal) {
        this.tempototal = tempototal;
    }

    @Override
    public String toString() {
        String statEncaminha;
        String statEncerrado;
        if (encaminhado == true) {
            statEncaminha = "Encaminhado";
        } else {
            statEncaminha = "Pendente";
        }

        if (encerrado == true) {
            statEncerrado = "Encerrado";

        } else {
            statEncerrado = "Aberto";
        }
        return "  " + "Numero:  " + id + ", Cliente:  " + cliente + ", E-mail:  " + email + ", Telefone:  " + telefone + ", Endereco:  " + endereco + ", Servico:  " + servico
                + ", dataAbertura:  " + dataAbertura + "," + statEncaminha + "," + statEncerrado + ", dataEncerramento:  " + dataEncerramento
                + ", tempototal:  " + tempototal + "\n";
    }

}
