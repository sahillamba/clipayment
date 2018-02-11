package com.coviam.payment.entity;

import com.coviam.payment.entity.jpa.support.Auditable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name=ProviderConfig.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class ProviderConfig  extends Auditable<String> implements Serializable{

    public static final String TABLE_NAME="provider_config";
    private static final String ID_COLUMN="ID";

    @Id
    @Column(name = ProviderConfig.ID_COLUMN)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "providerName")
    @NotNull
    private String providerName;

    @Column(name = "providerUrl")
    @NotNull
    private String providerUrl;

    @Column(name = "providerCallbackUrl")
    @NotNull
    private String providerCallbackUrl;

    @Column(name = "providerCredentialKey1")
    @NotNull
    private String providerCredentialKey1;

    @Column(name = "providerCredentialKey2")
    @NotNull
    private String providerCredentialKey2;


    public static enum Status {active, inactive, deferred, cancelled};

    @Column(name = "providerStatus")
    @Enumerated(EnumType.STRING)
    private Status providerStatus = Status.active;

    @OneToMany(
            mappedBy = "providerConfig",
            cascade = CascadeType.ALL,
            fetch=FetchType.EAGER
    )
    @JsonManagedReference
    private List<BusinessConfig> businessConfigDetails = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerUrl) {
        this.providerUrl = providerUrl;
    }

    public String getProviderCallbackUrl() {
        return providerCallbackUrl;
    }

    public void setProviderCallbackUrl(String providerCallbackUrl) {
        this.providerCallbackUrl = providerCallbackUrl;
    }

    public String getProviderCredentialKey1() {
        return providerCredentialKey1;
    }

    public void setProviderCredentialKey1(String providerCredentialKey1) {
        this.providerCredentialKey1 = providerCredentialKey1;
    }

    public String getProviderCredentialKey2() {
        return providerCredentialKey2;
    }

    public void setProviderCredentialKey2(String providerCredentialKey2) {
        this.providerCredentialKey2 = providerCredentialKey2;
    }

    public Enum getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(Status providerStatus) {
        this.providerStatus = providerStatus;
    }

    public List<BusinessConfig> getBusinessConfigDetails() {
        return businessConfigDetails;
    }

    public void setBusinessConfigDetails(List<BusinessConfig> businessConfigDetails) {
        this.businessConfigDetails = businessConfigDetails;
    }

    @Override
    public String toString() {
        return "ProviderConfig{" +
                "id='" + id + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerUrl='" + providerUrl + '\'' +
                ", providerCallbackUrl='" + providerCallbackUrl + '\'' +
                ", providerCredentialKey1='" + providerCredentialKey1 + '\'' +
                ", providerCredentialKey2='" + providerCredentialKey2 + '\'' +
                ", providerStatus=" + providerStatus +
                ", businessConfigDetails=" + businessConfigDetails +
                '}';
    }
}
