package com.metropolitan.it355.service;

import com.metropolitan.it355.entity.Colour;

import java.util.List;

public interface ColourService {
    List<Colour> findAll();
    List<Colour> findByColour(String colour);
    List<Colour> findByColourContaining(String colour);
    List<Colour> startsWithA();
}
