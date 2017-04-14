package com.andre.waterdistributionsystem.controller;

import com.andre.waterdistributionsystem.dao.DataSource;
import com.andre.waterdistributionsystem.model.ServiceC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Andre Luis Sabino
 * @version 1.1
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
            System.err.println("Erro ao recuperar os dados".concat(ex.getMessage()));
        } catch (Exception ex) {
            System.err.println("Erro do sistema contate o suporte técnico!");
        }
        return null;
    }
}
