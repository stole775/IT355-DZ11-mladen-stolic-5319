package com.metropolitan.it355.service.impl;

import com.metropolitan.it355.entity.Attribute;
import com.metropolitan.it355.repository.AttributeRepository;
import com.metropolitan.it355.service.AttributeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class AttributeServiceImpl implements AttributeService {
 final AttributeRepository attributeRepository;//koristi se za injektovanje???

    @Override
    public List<Attribute> findAll() {
        return attributeRepository.findAll();
    }

    @Override
    public List<Attribute> findByAttributeName(String attributeName) {
        return attributeRepository.findByAttributeName(attributeName);
    }

    @Override
    public List<Attribute> findById(Integer id) {
        return attributeRepository.findAllById(Collections.singleton(id));
    }


}
