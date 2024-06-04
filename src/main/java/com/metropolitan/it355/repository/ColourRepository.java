package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColourRepository extends JpaRepository<Colour, Integer> {
    List<Colour> findByColour(String colour);
    List<Colour> findByColourContaining(String colour);

    List<Colour> findAllByColourStartsWith(String colour);

}
