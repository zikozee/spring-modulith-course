package com.zee.springmodulithcourse.order;

import com.zee.springmodulithcourse.order.type.Status;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderIdentifier;
    private String customerName;
    private String customerEmail;
    private Timestamp orderDate = Timestamp.from(Instant.now());
    private Status status = Status.OPEN;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderIdentifier() {
        return orderIdentifier;
    }

    public void setOrderIdentifier(String orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderIdentifier='" + orderIdentifier + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }
}
