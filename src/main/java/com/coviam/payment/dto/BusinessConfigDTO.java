package com.coviam.payment.dto;

import com.coviam.payment.dto.enumsDTO.ProviderStatusDTO;

import java.io.Serializable;

/**
 * Created by avinashkumar on 06/02/2018 AD.
 */
public class BusinessConfigDTO implements Serializable {

    private String id;
    private String busniessId;
    private String maxAmount;
    private String minAmount;
    private Enum busniessStatus = ProviderStatusDTO.active;
    private ProviderConfigDTO providerConfigDTO;

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

    public ProviderConfigDTO getProviderConfigDTO() {
        return providerConfigDTO;
    }

    public void setProviderConfigDTO(ProviderConfigDTO providerConfigDTO) {
        this.providerConfigDTO = providerConfigDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessConfigDTO that = (BusinessConfigDTO) o;

        if (!id.equals(that.id)) return false;
        if (!busniessId.equals(that.busniessId)) return false;
        if (!maxAmount.equals(that.maxAmount)) return false;
        if (!minAmount.equals(that.minAmount)) return false;
        if (!busniessStatus.equals(that.busniessStatus)) return false;
        return providerConfigDTO.equals(that.providerConfigDTO);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + busniessId.hashCode();
        result = 31 * result + maxAmount.hashCode();
        result = 31 * result + minAmount.hashCode();
        result = 31 * result + busniessStatus.hashCode();
        result = 31 * result + providerConfigDTO.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BusinessConfigDTO{" +
                "id='" + id + '\'' +
                ", busniessId='" + busniessId + '\'' +
                ", maxAmount='" + maxAmount + '\'' +
                ", minAmount='" + minAmount + '\'' +
                ", busniessStatus=" + busniessStatus +
                ", providerConfigDTO=" + providerConfigDTO +
                '}';
    }
}
