package com.metropolitan.it355.controller;



import com.metropolitan.it355.entity.Alignment;
import com.metropolitan.it355.repository.MessageLogRepository;
import com.metropolitan.it355.service.AllignmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/allignmet")
public class AllignmentController {

    final AllignmentService allignmentService;

    @GetMapping
    public ResponseEntity getAllAlignments() {
        List<Alignment> allAlignments = allignmentService.findAll();
        
        return ResponseEntity.ok(allAlignments);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Alignment>> getAllByTitle(@PathVariable String title) {
        return ResponseEntity.ok(allignmentService.findByTitle(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alignment> getById(@PathVariable int id) {
        return ResponseEntity.ok(allignmentService.findById(id));
    }
}
