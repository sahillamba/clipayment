package com.coviam.payment.entity;

import com.coviam.payment.entity.jpa.support.Auditable;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name=CardDetails.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
public class CardDetails extends Auditable<String> implements Serializable{

    public static final String TABLE_NAME="card_details";
    private static final String ID_COLUMN="ID";

    @Id
    @Column(name = CardDetails.ID_COLUMN)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "nameOnCard")
    private String nameOnCard;

    @Column(name = "expDate")
    private String expDate;

    @Column(name = "userId")
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "CardDetails{" +
                "id='" + id + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", expDate='" + expDate + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
