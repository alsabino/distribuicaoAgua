package com.andre.waterdistributionsystem.model;

import com.andre.waterdistributionsystem.controller.ServiceCallDAO;
import com.andre.waterdistributionsystem.dao.DataSource;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * @author Andre Luis Sabino
 * @version 1.1
 * @since 12/04/2017
 */
public class ServiceC {

    private int callId;
    private String clientName;
    private String clientAddress;
    private String clientEmail;
    private String clientTelephone;
    private String serviceNeeded;
    private Date openDate;
    private int status;
    private Date finishDate;
    private Time timeLapse;

    public ServiceC() {
    }

    public ServiceC(int callId, String clientName, String clientAddress, String clientEmail, String clientTelephone, String serviceNeeded, Date openDate, int status, Date finishDate, Time timeLapse) {
        this.callId = callId;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientEmail = clientEmail;
        this.clientTelephone = clientTelephone;
        this.serviceNeeded = serviceNeeded;
        this.openDate = openDate;
        this.status = status;
        this.finishDate = finishDate;
        this.timeLapse = timeLapse;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(String clientTelephone) {
        this.clientTelephone = clientTelephone;
    }

    public String getServiceNeeded() {
        return serviceNeeded;
    }

    public void setServiceNeeded(String serviceNeeded) {
        this.serviceNeeded = serviceNeeded;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Time getTimeLapse() {
        return timeLapse;
    }

    public void setTimeLapse(Time timeLapse) {
        this.timeLapse = timeLapse;
    }

    public String statusVerification() {
        String serviceStatus;
        int ref = getStatus();

        if (ref == 0) {
            serviceStatus = "Aberto";
        } else if (ref == 1) {
            serviceStatus = "Encaminhado";
        } else {
            serviceStatus = "Finalizado";
        }
        return serviceStatus;
    }

    @Override
    public String toString() {
        String serviceStatus = statusVerification();
        return "Chamados:  " + "#" + callId + ", Cliente:  " + clientName + ", Endereço:  =" + clientAddress +
                ", E-mail:  =" + clientEmail + ", Telefone:  =" + clientTelephone + ", Serviço:  =" + serviceNeeded +
                ", Data de abertura:  =" + openDate + ", Status:  " + status + ", Data de finalização:  =" + finishDate + ", Tempo decorrido:  " + timeLapse + '\n';
    }

    
}
