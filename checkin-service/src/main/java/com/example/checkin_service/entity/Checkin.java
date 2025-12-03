package com.example.checkin_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Checkin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ticketId;
    private Long userId;
    private String gate;        // ex: "G1", "Entrée principale"
    private String status;      // ex: "CHECKED_IN", "DENIED"

    private LocalDateTime checkinTime = LocalDateTime.now();

    public Checkin() {}

    public Checkin(Long ticketId, Long userId, String gate, String status) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.gate = gate;
        this.status = status;
        this.checkinTime = LocalDateTime.now();
    }

    // Getters & setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getGate() { return gate; }
    public void setGate(String gate) { this.gate = gate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCheckinTime() { return checkinTime; }
    public void setCheckinTime(LocalDateTime checkinTime) { this.checkinTime = checkinTime; }
}