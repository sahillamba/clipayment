package com.coviam.payment.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumar on 06/02/2018 AD.
 */
public class ProviderConfigDTO implements Serializable {

    private String id;
    private String providerName;
    private String providerUrl;
    private String providerCallbackUrl;
    private String providerCredentialKey1;
    private String providerCredentialKey2;
    public static enum Status {active, inactive, deferred, cancelled};
    private ProviderConfigDTO.Status providerStatus = ProviderConfigDTO.Status.active;
    private List<BusinessConfigDTO> businessConfigDetailsDTO = new ArrayList<>();

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

    public void setProviderStatus(ProviderConfigDTO.Status providerStatus) {
        this.providerStatus = providerStatus;
    }

    public List<BusinessConfigDTO> getBusinessConfigDetailsDTO() {
        return businessConfigDetailsDTO;
    }

    public void setBusinessConfigDetailsDTO(List<BusinessConfigDTO> businessConfigDetailsDTO) {
        this.businessConfigDetailsDTO = businessConfigDetailsDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProviderConfigDTO that = (ProviderConfigDTO) o;

        if (!id.equals(that.id)) return false;
        if (!providerName.equals(that.providerName)) return false;
        if (!providerUrl.equals(that.providerUrl)) return false;
        if (!providerCallbackUrl.equals(that.providerCallbackUrl)) return false;
        if (!providerCredentialKey1.equals(that.providerCredentialKey1)) return false;
        if (!providerCredentialKey2.equals(that.providerCredentialKey2)) return false;
        if (providerStatus != that.providerStatus) return false;
        return businessConfigDetailsDTO.equals(that.businessConfigDetailsDTO);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + providerName.hashCode();
        result = 31 * result + providerUrl.hashCode();
        result = 31 * result + providerCallbackUrl.hashCode();
        result = 31 * result + providerCredentialKey1.hashCode();
        result = 31 * result + providerCredentialKey2.hashCode();
        result = 31 * result + providerStatus.hashCode();
        result = 31 * result + businessConfigDetailsDTO.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProviderConfigDTO{" +
                "id='" + id + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerUrl='" + providerUrl + '\'' +
                ", providerCallbackUrl='" + providerCallbackUrl + '\'' +
                ", providerCredentialKey1='" + providerCredentialKey1 + '\'' +
                ", providerCredentialKey2='" + providerCredentialKey2 + '\'' +
                ", providerStatus=" + providerStatus +
                ", businessConfigDetailsDTO=" + businessConfigDetailsDTO +
                '}';
    }
}
