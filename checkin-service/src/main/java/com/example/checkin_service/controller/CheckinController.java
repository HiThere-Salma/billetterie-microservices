package com.example.checkin_service.controller;

import com.example.checkin_service.entity.Checkin;
import com.example.checkin_service.service.CheckinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkins")
public class CheckinController {

    private final CheckinService checkinService;

    public CheckinController(CheckinService checkinService) {
        this.checkinService = checkinService;
    }

    @PostMapping
    public ResponseEntity<Checkin> createCheckin(@RequestBody Checkin checkin) {
        Checkin created = checkinService.createCheckin(checkin);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Checkin> getAllCheckins() {
        return checkinService.getAllCheckins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checkin> getCheckin(@PathVariable Long id) {
        return ResponseEntity.ok(checkinService.getCheckinById(id));
    }

    @GetMapping("/ticket/{ticketId}")
    public List<Checkin> getCheckinsByTicket(@PathVariable Long ticketId) {
        return checkinService.getCheckinsByTicketId(ticketId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checkin> updateCheckin(@PathVariable Long id,
                                                 @RequestBody Checkin checkinDetails) {
        return ResponseEntity.ok(checkinService.updateCheckin(id, checkinDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheckin(@PathVariable Long id) {
        checkinService.deleteCheckin(id);
        return ResponseEntity.noContent().build();
    }
}