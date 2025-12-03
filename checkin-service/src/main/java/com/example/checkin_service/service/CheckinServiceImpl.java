package com.example.checkin_service.service;

import com.example.checkin_service.entity.Checkin;
import com.example.checkin_service.repository.CheckinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckinServiceImpl implements CheckinService {

    private final CheckinRepository checkinRepository;

    public CheckinServiceImpl(CheckinRepository checkinRepository) {
        this.checkinRepository = checkinRepository;
    }

    @Override
    public Checkin createCheckin(Checkin checkin) {
        return checkinRepository.save(checkin);
    }

    @Override
    public List<Checkin> getAllCheckins() {
        return checkinRepository.findAll();
    }

    @Override
    public Checkin getCheckinById(Long id) {
        return checkinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkin not found"));
    }

    @Override
    public List<Checkin> getCheckinsByTicketId(Long ticketId) {
        return checkinRepository.findByTicketId(ticketId);
    }

    @Override
    public Checkin updateCheckin(Long id, Checkin checkinDetails) {
        Checkin checkin = getCheckinById(id);
        checkin.setTicketId(checkinDetails.getTicketId());
        checkin.setUserId(checkinDetails.getUserId());
        checkin.setGate(checkinDetails.getGate());
        checkin.setStatus(checkinDetails.getStatus());
        checkin.setCheckinTime(checkinDetails.getCheckinTime());
        return checkinRepository.save(checkin);
    }

    @Override
    public void deleteCheckin(Long id) {
        checkinRepository.deleteById(id);
    }
}
