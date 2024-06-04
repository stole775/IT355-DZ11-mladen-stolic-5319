package com.metropolitan.it355.repository;

import com.metropolitan.it355.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
    List<Attribute> findAll();
    List<Attribute> findByAttributeName(String attributeName);

    @Override
    List<Attribute> findAllById(Iterable<Integer> integers);




}
