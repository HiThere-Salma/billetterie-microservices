package com.example.ticket_service.service;

import com.example.ticket_service.entity.Ticket;
import java.util.List;

public interface TicketService {
    Ticket createTicket(Ticket ticket);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    Ticket updateTicket(Long id, Ticket ticketDetails);
    void deleteTicket(Long id);
}
