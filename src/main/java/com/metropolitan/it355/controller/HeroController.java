package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Superhero;
import com.metropolitan.it355.service.HeroService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/heroes")
public class HeroController {

final HeroService heroService;

    @GetMapping("/{id}")
    public ResponseEntity<Superhero> getHeroById(@PathVariable Long id) {
        try {
            Superhero hero = heroService.findHeroById(id);
            return ResponseEntity.ok(hero);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Superhero>> getAllHeroes() {
        List<Superhero> allSuperhero = heroService.findAllHero();
        return ResponseEntity.ok(allSuperhero);
    }
    @GetMapping("/ime/{name}")
    public ResponseEntity<List<Superhero>> getHeroByName(@PathVariable String name) {
        List<Superhero> allSuperhero = heroService.findBySuperheroName(name);
        return ResponseEntity.ok(allSuperhero);
    }
    @GetMapping("/slovo/{slovo}")
    public ResponseEntity<List<Superhero>> getHeroBySlovo(@PathVariable String slovo) {
        List<Superhero> allSuperhero = heroService.findBySuperheroNameContainsIgnoreCase(slovo);
        return ResponseEntity.ok(allSuperhero);
    }
}
