package com.metropolitan.it355.service;

import com.metropolitan.it355.entity.Attribute;

import java.util.List;

public interface AttributeService {

    List<Attribute> findAll();
    List<Attribute> findByAttributeName(String attributeName);
    List<Attribute> findById(Integer id);


}
