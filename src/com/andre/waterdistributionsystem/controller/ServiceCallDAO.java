package com.andre.waterdistributionsystem.controller;

import com.andre.waterdistributionsystem.dao.DataSource;
import com.andre.waterdistributionsystem.model.ServiceC;
import com.andre.waterdistributionsystem.model.ServiceCall;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.andre.waterdistributionsystem.view.ServiceCallView;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 * @author Andre Luis Sabino
 * @version 1.2
 * @since 12/04/2017
 */

public class ServiceCallDAO {

    private DataSource datasource;
    

    public ServiceCallDAO(DataSource dataSource) {
        this.datasource = dataSource;
    }

    public ArrayList<ServiceC> printServiceCall() {
        try {
            String SQL = "SELECT * FROM servicecall ";
            PreparedStatement ps = datasource.getConnection().prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ArrayList<ServiceC> serviceCallList = new ArrayList<ServiceC>();

            while (rs.next()) {
                ServiceC callData = new ServiceC();
                callData.setCallId(rs.getInt("CallId"));
                callData.setClientName(rs.getString("ClientName"));
                callData.setClientAddress(rs.getString("ClientAddress"));
                callData.setClientEmail(rs.getString("ClientEmail"));
                callData.setClientTelephone(rs.getString("ClientTelephone"));
                callData.setServiceNeeded(rs.getString("ServiceNeeded"));
                callData.setOpenDate(rs.getDate("OpenDate"));
                callData.setStatus(rs.getInt("Status"));
                callData.setFinishDate(rs.getDate("FinishDate"));
                callData.setTimeLapse(rs.getTime("TimeLapse"));

            }
            ps.close();
            return serviceCallList;

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao recuperar os dados".concat(ex.getMessage()));
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,"Erro do sistema contate o suporte técnico!");
        }
        return null;
    }

    public void insertServiceCall(ServiceCall serviceCall)  {
        try {
          
            java.sql.Date SqlDate = new java.sql.Date (serviceCall.getOpenDate().getTime());   
            String query = "INSERT into servicecall (ClientName, ClientAddress, ClientEmail, ClientTelephone, ServiceNeeded, OpenDate, Status ) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = datasource.getConnection().prepareStatement(query);
            ps.setString(1,serviceCall.getClientName());
            ps.setString(2,serviceCall.getClientAddress());
            ps.setString(3,serviceCall.getClientEmail());
            ps.setString(4,serviceCall.getClientTelephone());
            ps.setString(5,serviceCall.getServiceNeeded());
            ps.setDate(6, SqlDate);
            ps.setString(7,serviceCall.getStatus());
        
            System.out.println(query);
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Novo chamado adicionado com sucesso!");        
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir os dados: ".concat(ex.getMessage()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro do sistema contate o suporte técnico! ".concat(ex.getMessage()));
        } 

    }
}
