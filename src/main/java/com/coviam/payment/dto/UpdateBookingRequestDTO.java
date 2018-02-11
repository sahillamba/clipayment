package com.coviam.payment.dto;

import com.coviam.payment.entity.Transaction;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateBookingRequestDTO implements Serializable {

    String superPnr;
    String paymentid;
    Transaction.Status status;

    private UpdateBookingRequestDTO(Builder builder) {
        setSuperPnr(builder.superPnr);
        setPaymentid(builder.paymentid);
        setStatus(builder.status);
    }


    public String getSuperPnr() {
        return superPnr;
    }

    public void setSuperPnr(String superPnr) {
        this.superPnr = superPnr;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public Transaction.Status getStatus() {
        return status;
    }

    public void setStatus(Transaction.Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateBookingRequestDTO that = (UpdateBookingRequestDTO) o;

        if (!superPnr.equals(that.superPnr)) return false;
        if (!paymentid.equals(that.paymentid)) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = superPnr.hashCode();
        result = 31 * result + paymentid.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UpdateBookingRequestDTO{" +
                "superPnr='" + superPnr + '\'' +
                ", paymentid='" + paymentid + '\'' +
                ", status=" + status +
                '}';
    }

    public static final class Builder {
        private String superPnr;
        private String paymentid;
        private Transaction.Status status;

        public Builder() {
        }

        public Builder superPnr(String val) {
            superPnr = val;
            return this;
        }

        public Builder paymentid(String val) {
            paymentid = val;
            return this;
        }

        public Builder status(Transaction.Status val) {
            status = val;
            return this;
        }

        public UpdateBookingRequestDTO build() {
            return new UpdateBookingRequestDTO(this);
        }
    }
}
