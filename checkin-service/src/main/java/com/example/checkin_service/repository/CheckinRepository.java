package com.example.checkin_service.repository;

import com.example.checkin_service.entity.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {

    // Optionnel : récupérer tous les checkins pour un ticket
    List<Checkin> findByTicketId(Long ticketId);
}
