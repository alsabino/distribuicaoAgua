/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andre.waterdistributionsystem.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Andre
 */
@Entity
@Table(name = "servicecall", catalog = "distribution", schema = "")
@NamedQueries({
    @NamedQuery(name = "ServiceCall.findAll", query = "SELECT s FROM ServiceCall s")
    , @NamedQuery(name = "ServiceCall.findByCallId", query = "SELECT s FROM ServiceCall s WHERE s.callId = :callId")
    , @NamedQuery(name = "ServiceCall.findByClientName", query = "SELECT s FROM ServiceCall s WHERE s.clientName = :clientName")
    , @NamedQuery(name = "ServiceCall.findByClientAddress", query = "SELECT s FROM ServiceCall s WHERE s.clientAddress = :clientAddress")
    , @NamedQuery(name = "ServiceCall.findByClientEmail", query = "SELECT s FROM ServiceCall s WHERE s.clientEmail = :clientEmail")
    , @NamedQuery(name = "ServiceCall.findByClientTelephone", query = "SELECT s FROM ServiceCall s WHERE s.clientTelephone = :clientTelephone")
    , @NamedQuery(name = "ServiceCall.findByServiceNeeded", query = "SELECT s FROM ServiceCall s WHERE s.serviceNeeded = :serviceNeeded")
    , @NamedQuery(name = "ServiceCall.findByOpenDate", query = "SELECT s FROM ServiceCall s WHERE s.openDate = :openDate")
    , @NamedQuery(name = "ServiceCall.findByStatus", query = "SELECT s FROM ServiceCall s WHERE s.status = :status")
    , @NamedQuery(name = "ServiceCall.findByFinishDate", query = "SELECT s FROM ServiceCall s WHERE s.finishDate = :finishDate")
    , @NamedQuery(name = "ServiceCall.findByTimeLapse", query = "SELECT s FROM ServiceCall s WHERE s.timeLapse = :timeLapse")})
public class ServiceCall implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CallId")
    private Integer callId;
    @Column(name = "ClientName")
    private String clientName;
    @Column(name = "ClientAddress")
    private String clientAddress;
    @Column(name = "ClientEmail")
    private String clientEmail;
    @Column(name = "ClientTelephone")
    private String clientTelephone;
    @Column(name = "ServiceNeeded")
    private String serviceNeeded;
    @Column(name = "OpenDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openDate;
    @Column(name = "Status")
    private String status;
    @Column(name = "FinishDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;
    @Column(name = "TimeLapse")
    private Long timeLapse;

    public ServiceCall() {
    }

    public ServiceCall(Integer callId) {
        this.callId = callId;
    }

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        Integer oldCallId = this.callId;
        this.callId = callId;
        changeSupport.firePropertyChange("callId", oldCallId, callId);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        String oldClientName = this.clientName;
        this.clientName = clientName;
        changeSupport.firePropertyChange("clientName", oldClientName, clientName);
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        String oldClientAddress = this.clientAddress;
        this.clientAddress = clientAddress;
        changeSupport.firePropertyChange("clientAddress", oldClientAddress, clientAddress);
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        String oldClientEmail = this.clientEmail;
        this.clientEmail = clientEmail;
        changeSupport.firePropertyChange("clientEmail", oldClientEmail, clientEmail);
    }

    public String getClientTelephone() {
        return clientTelephone;
    }

    public void setClientTelephone(String clientTelephone) {
        String oldClientTelephone = this.clientTelephone;
        this.clientTelephone = clientTelephone;
        changeSupport.firePropertyChange("clientTelephone", oldClientTelephone, clientTelephone);
    }

    public String getServiceNeeded() {
        return serviceNeeded;
    }

    public void setServiceNeeded(String serviceNeeded) {
        String oldServiceNeeded = this.serviceNeeded;
        this.serviceNeeded = serviceNeeded;
        changeSupport.firePropertyChange("serviceNeeded", oldServiceNeeded, serviceNeeded);
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        Date oldOpenDate = this.openDate;
        this.openDate = openDate;
        changeSupport.firePropertyChange("openDate", oldOpenDate, openDate);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        Date oldFinishDate = this.finishDate;
        this.finishDate = finishDate;
        changeSupport.firePropertyChange("finishDate", oldFinishDate, finishDate);
    }

    public Long getTimeLapse() {
        return timeLapse;
    }

    public void setTimeLapse(Long timeLapse) {
        Long oldTimeLapse = this.timeLapse;
        this.timeLapse = timeLapse;
        changeSupport.firePropertyChange("timeLapse", oldTimeLapse, timeLapse);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (callId != null ? callId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiceCall)) {
            return false;
        }
        ServiceCall other = (ServiceCall) object;
        if ((this.callId == null && other.callId != null) || (this.callId != null && !this.callId.equals(other.callId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andre.waterdistributionsystem.view.ServiceCall[ callId=" + callId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
