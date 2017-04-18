package com.andre.waterdistributionsystem.controller;

import com.andre.waterdistributionsystem.dao.DataSource;
import com.andre.waterdistributionsystem.model.ServiceCall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.andre.waterdistributionsystem.view.ServiceCallView;
import static com.andre.waterdistributionsystem.view.ServiceCallView.DATEFORMAT;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * @author Andre Luis Sabino
 * @version 1.3
 * @since 12/04/2017
 */
public class ServiceCallDAO {

    private DataSource datasource;

    public ServiceCallDAO(DataSource dataSource) {
        this.datasource = dataSource;
    }

    public ServiceCallDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertServiceCall(ServiceCall serviceCall) {
        try {
            String query = "INSERT into servicecall (ClientName, ClientAddress, ClientEmail, ClientTelephone, ServiceNeeded, OpenDate, Status ) values(?,?,?,?,?,SYSDATE(),'Aberto')";
            try (PreparedStatement ps = datasource.getConnection().prepareStatement(query)) {
                ps.setString(1, serviceCall.getClientName());
                ps.setString(2, serviceCall.getClientAddress());
                ps.setString(3, serviceCall.getClientEmail());
                ps.setString(4, serviceCall.getClientTelephone());
                ps.setString(5, serviceCall.getServiceNeeded());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Novo chamado adicionado com sucesso!");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados: ".concat(ex.getMessage()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro do sistema contate o suporte técnico! ".concat(ex.getMessage()));
        }

    }


    /* Metodo para atualizar o Status do chamado para encaminhado */
    public void updateStatus(int CallId) {
        ServiceCall serviceCall = new ServiceCall();
        serviceCall.setCallId(CallId);
        try {
            String updateQuery = "UPDATE servicecall SET Status = 'Encaminhado' WHERE CallId = ? ";
            PreparedStatement ps = datasource.getConnection().prepareStatement(updateQuery);
            ps.setInt(1, serviceCall.getCallId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar status do chamado: ".concat(ex.getMessage()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro do sistema contate o suporte técnico! ".concat(ex.getMessage()));
        }
    }

    /* Metodo para atualizar o Status do chamado para finalizado */
    public void finishService(ServiceCall serviceCall) {
        try {
            String updateQuery = "UPDATE servicecall SET Status = 'Finalizado', FinishDate = SYSDATE() WHERE CallId = ? ";
            try (PreparedStatement ps = datasource.getConnection().prepareStatement(updateQuery)) {
                ps.setInt(1, serviceCall.getCallId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar status do chamado: ".concat(ex.getMessage()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro do sistema contate o suporte técnico! ".concat(ex.getMessage()));
        }

    }

    /* Metodo para definir o e-mail para qual será direcionado a equipe de atendimento */
    public String teamMailSelector(int CallId) {
        ServiceCall serviceCall = new ServiceCall();
        serviceCall.setCallId(CallId);
        String teamMail = "";
        String result = "";

        try {
            String selectServiceQuery = "SELECT ServiceNeeded from servicecall WHERE CallId = ? ";
            PreparedStatement ps = datasource.getConnection().prepareStatement(selectServiceQuery);
            ps.setInt(1, serviceCall.getCallId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar status do chamado: ".concat(ex.getMessage()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro do sistema contate o suporte técnico! ".concat(ex.getMessage()));
        }
        switch (result) {
            case "Ligar Registro": {
                teamMail = "yondaimers@gmail.com";
                break;
            }
            case "Verificação Interna": {
                teamMail = "sabinoandreluis@gmail.com";
                break;
            }
            case "Verificação Externa": {
                teamMail = "sabinoandreluis@gmail.com";
                break;
            }
            case "Verificação Rede( Agua )": {
                teamMail = "sabinoandreluis@gmail.com";
                break;
            }
            case "Verificação Rede( Esgoto )": {
                teamMail = "sabinoandreluis@gmail.com";
                break;
            }
            case "Manutenção Rede( Esgoto )": {
                teamMail = "yondaimers@gmail.com";
                break;
            }
            case "Manutenção Rede( Agua )": {
                teamMail = "yondaimers@gmail.com";
                break;
            }
            default:
                break;
        }
        return teamMail;

    }

    /* Metodo para definir o Assunto do email a ser direcionado a equipe de atendimento */
    public String mailSubject(int CallId) {
        ServiceCall serviceCall = new ServiceCall();
        serviceCall.setCallId(CallId);
        String result = "";
        try {
            String selectServiceQuery = "SELECT ServiceNeeded from servicecall WHERE CallId = ? ";
            PreparedStatement ps = datasource.getConnection().prepareStatement(selectServiceQuery);
            ps.setInt(1, serviceCall.getCallId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar status do chamado: ".concat(ex.getMessage()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro do sistema contate o suporte técnico! ".concat(ex.getMessage()));
        }
        String emailSubject = "Requisição de serviço de atendimento para: ".concat(result);
        return emailSubject;

    }

    /*Implementação do metodo now() para atribuir valor ao campo jFormattedTextField onde deve retornar a data e hora local atual*/
    public String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DATEFORMAT);
        String s = (format.format(cal.getTime()));
        return s;
    }
    

}
