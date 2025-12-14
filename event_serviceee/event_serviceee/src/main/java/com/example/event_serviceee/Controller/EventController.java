package com.example.event_serviceee.Controller;

import com.example.event_serviceee.entity.Event;
import com.example.event_serviceee.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventRepository eventRepository;

    // ✅ injection propre (constructor injection)
    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping
    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody Event event) {
        Event saved = eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved); // ✅ renvoie JSON
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!eventRepository.existsById(id)) return ResponseEntity.notFound().build();
        eventRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
