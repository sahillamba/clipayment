package com.coviam.payment.entity;

import com.coviam.payment.entity.enums.ProviderStatus;
import com.coviam.payment.entity.jpa.support.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name=BusinessConfig.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class BusinessConfig extends Auditable<String> implements Serializable{

    public static final String TABLE_NAME="business_config";
    private static final String ID_COLUMN="ID";
    @Id
    @Column(name = BusinessConfig.ID_COLUMN)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "busniessId")
    private String busniessId;

    @Column(name = "maxAmount")
    private String maxAmount;

    @Column(name = "minAmount")
    private String minAmount;

    @Column(name = "busniessStatus")
    private Enum busniessStatus = ProviderStatus.active;

    @ManyToOne
    @JoinColumn(name = "providerConfig_id")
    @JsonBackReference
    private ProviderConfig providerConfig;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusniessId() {
        return busniessId;
    }

    public void setBusniessId(String busniessId) {
        this.busniessId = busniessId;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public Enum getBusniessStatus() {
        return busniessStatus;
    }

    public void setBusniessStatus(Enum busniessStatus) {
        this.busniessStatus = busniessStatus;
    }

    public ProviderConfig getProviderConfig() {
        return providerConfig;
    }

    public void setProviderConfig(ProviderConfig providerConfig) {
        this.providerConfig = providerConfig;
    }

    @Override
    public String toString() {
        return "BusinessConfig{" +
                "id='" + id + '\'' +
                ", busniessId='" + busniessId + '\'' +
                ", maxAmount='" + maxAmount + '\'' +
                ", minAmount='" + minAmount + '\'' +
                ", busniessStatus=" + busniessStatus +
                ", providerConfig=" + providerConfig +
                '}';
    }
}
