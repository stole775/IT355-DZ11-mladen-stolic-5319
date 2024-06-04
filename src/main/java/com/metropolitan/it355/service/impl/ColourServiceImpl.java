package com.metropolitan.it355.service.impl;

import com.metropolitan.it355.entity.Colour;
import com.metropolitan.it355.repository.ColourRepository;
import com.metropolitan.it355.service.ColourService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ColourServiceImpl implements ColourService {

    final ColourRepository colourRepository;

    @Override
    public List<Colour> findAll() {
        return colourRepository.findAll();
    }

    @Override
    public List<Colour> findByColour(String colour) {
        return colourRepository.findByColour(colour);
    }

    @Override
    public List<Colour> findByColourContaining(String colour) {
        return colourRepository.findByColourContaining(colour);
    }

    @Override
    public List<Colour> startsWithA() {
        return colourRepository.findAllByColourStartsWith("a");
    }
}
