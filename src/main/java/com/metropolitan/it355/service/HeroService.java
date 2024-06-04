package com.metropolitan.it355.service;


import com.metropolitan.it355.entity.Superhero;

import java.util.List;

public interface HeroService {
    Superhero findHeroById(Long id);
    List<Superhero> findAllHero();


    List<Superhero> findBySuperheroName(String superheroName);
    List<Superhero> findBySuperheroNameContainsIgnoreCase(String superheroNameContains);
}


