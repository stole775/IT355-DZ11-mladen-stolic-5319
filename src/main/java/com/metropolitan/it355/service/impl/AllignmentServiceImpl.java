package com.metropolitan.it355.service.impl;

import com.metropolitan.it355.entity.Alignment;
import com.metropolitan.it355.repository.AlignmentRepository;
import com.metropolitan.it355.service.AllignmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AllignmentServiceImpl implements AllignmentService {
    final AlignmentRepository alignmentRepository;

    @Override
    public List<Alignment> findAll() {

        return alignmentRepository.findAll();

    }



    @Override
    public List<Alignment> findByTitle(String title) {
        return alignmentRepository.findByTitleContaining(title);
    }

    @Override
    public Alignment findById(int id) {
//        Optional<Alignment> alignment = alignmentRepository.findById(id);
//        if (alignment.isPresent()) {
//            return alignment.get();
//        }
//        return null;
        return alignmentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No alignment found with id: " + id));
    }


}
