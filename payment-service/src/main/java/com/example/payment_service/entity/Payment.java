package com.example.payment_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;
    private Long userId;
    private Double amount;
    private String method; // "CARD", "CASH", "PAYPAL", etc.
    private String status; // "PENDING", "COMPLETED", "FAILED"

    private LocalDateTime createdAt = LocalDateTime.now();

    public Payment() {}

    public Payment(Long ticketId, Long userId, Double amount,
                   String method, String status) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getTicketId() { return ticketId; }

    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Double getAmount() { return amount; }

    public void setAmount(Double amount) { this.amount = amount; }

    public String getMethod() { return method; }

    public void setMethod(String method) { this.method = method; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}