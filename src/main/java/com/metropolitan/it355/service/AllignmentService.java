package com.metropolitan.it355.service;

import com.metropolitan.it355.entity.Alignment;

import java.util.List;

public interface AllignmentService {
    List<Alignment> findAll();

    List<Alignment> findByTitle(String title);

    Alignment findById(int id);
}
