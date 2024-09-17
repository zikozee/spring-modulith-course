package com.zee.springmodulithcourse.payment;

import com.zee.springmodulithcourse.payment.type.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private long amount;
    private Timestamp paymentDate = Timestamp.from(Instant.now());
    private PaymentStatus status = PaymentStatus.INCOMPLETE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", status=" + status +
                '}';
    }
}
