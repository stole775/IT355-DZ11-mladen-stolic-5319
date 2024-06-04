package com.metropolitan.it355.service.impl;

import com.metropolitan.it355.entity.Superhero;
import com.metropolitan.it355.repository.HeroRepository;
import com.metropolitan.it355.service.HeroService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HeroServiceImpl implements HeroService {

    final HeroRepository heroRepository;

    @Override
    public Superhero findHeroById(Long id) {
        return heroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Hero not found"));
    }

    @Override
    public List<Superhero> findAllHero() {
        return heroRepository.findAll();
    }

    @Override
    public List<Superhero> findBySuperheroName(String superheroName) {
        return heroRepository.findBySuperheroName(superheroName);
    }

    @Override
    public List<Superhero> findBySuperheroNameContainsIgnoreCase(String superheroNameContains) {
        return heroRepository.findBySuperheroNameContainsIgnoreCase(superheroNameContains);
    }


}
