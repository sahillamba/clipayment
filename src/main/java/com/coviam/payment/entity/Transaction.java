package com.coviam.payment.entity;

import com.coviam.payment.entity.jpa.support.Auditable;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name=Transaction.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class Transaction  extends Auditable<String> implements Serializable{
    public static final String TABLE_NAME="transaction";
    private static final String ID_COLUMN="ID";

    @Id
    @Column(name = Transaction.ID_COLUMN)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "superPnr")
    private String superPnr;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "providerId")
    private String providerId;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    public static enum Status {PENDING, SUCCESSFUL, DEFERRED, CANCELLED};

    @Column(name = "paymentStatus")
    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    @Column(name="customerId")
    private String customerId;

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

    public Status getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", superPnr='" + superPnr + '\'' +
                ", amount=" + amount +
                ", providerId='" + providerId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
