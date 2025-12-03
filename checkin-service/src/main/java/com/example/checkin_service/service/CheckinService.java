package com.example.checkin_service.service;

import com.example.checkin_service.entity.Checkin;

import java.util.List;

public interface CheckinService {
    Checkin createCheckin(Checkin checkin);
    List<Checkin> getAllCheckins();
    Checkin getCheckinById(Long id);
    List<Checkin> getCheckinsByTicketId(Long ticketId);
    Checkin updateCheckin(Long id, Checkin checkinDetails);
    void deleteCheckin(Long id);
}
