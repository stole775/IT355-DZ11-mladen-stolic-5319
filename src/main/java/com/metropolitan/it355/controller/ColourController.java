package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Colour;
import com.metropolitan.it355.service.ColourService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/colour")
public class ColourController {
    final ColourService colourService;

    @GetMapping
    public ResponseEntity getAll() {
        List<Colour> all  = colourService.findAll();
        return ResponseEntity.ok(all);
    }
    @GetMapping("/name/{colourName}")
    public ResponseEntity<List<Colour>> findByAttributeName(@PathVariable String colourName) {
        return ResponseEntity.ok(colourService.findByColour(colourName));
    }

    @GetMapping("/a")
    public ResponseEntity  getAllStartWithA() {
        List<Colour> all  = colourService.startsWithA();
        return ResponseEntity.ok(all);
    }

}
