package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Superhero, Long> {

    List<Superhero> findAll();


    List<Superhero> findBySuperheroName(String superheroName);
    List<Superhero> findBySuperheroNameContainsIgnoreCase(String superheroNameContains);
}
