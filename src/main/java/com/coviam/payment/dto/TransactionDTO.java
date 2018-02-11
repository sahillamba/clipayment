package com.coviam.payment.dto;

import com.coviam.payment.entity.Transaction;

import java.io.Serializable;

/**
 * Created by avinashkumar on 06/02/2018 AD.
 */
public class TransactionDTO implements Serializable {

    private String id;
    private String superPnr;
    private Double amount;
    private String providerId;
    private String paymentMethod;
    public static enum Status {PENDING, SUCCESSFUL, DEFERRED, CANCELLED};
    private Transaction.Status paymentStatus = Transaction.Status.PENDING;
    private String customerId;
    private CardDetailsDTO cardDetailsDTO;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSuperPnr() {
        return superPnr;
    }

    public void setSuperPnr(String superPnr) {
        this.superPnr = superPnr;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Transaction.Status getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Transaction.Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CardDetailsDTO getCardDetailsDTO() {
        return cardDetailsDTO;
    }

    public void setCardDetailsDTO(CardDetailsDTO cardDetailsDTO) {
        this.cardDetailsDTO = cardDetailsDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionDTO that = (TransactionDTO) o;

        if (!id.equals(that.id)) return false;
        if (!superPnr.equals(that.superPnr)) return false;
        if (!amount.equals(that.amount)) return false;
        if (!providerId.equals(that.providerId)) return false;
        if (!paymentMethod.equals(that.paymentMethod)) return false;
        if (paymentStatus != that.paymentStatus) return false;
        if (!customerId.equals(that.customerId)) return false;
        return cardDetailsDTO.equals(that.cardDetailsDTO);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + superPnr.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + providerId.hashCode();
        result = 31 * result + paymentMethod.hashCode();
        result = 31 * result + paymentStatus.hashCode();
        result = 31 * result + customerId.hashCode();
        result = 31 * result + cardDetailsDTO.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", superPnr='" + superPnr + '\'' +
                ", amount=" + amount +
                ", providerId='" + providerId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", customerId='" + customerId + '\'' +
                ", cardDetails=" + cardDetailsDTO +
                '}';
    }
}
