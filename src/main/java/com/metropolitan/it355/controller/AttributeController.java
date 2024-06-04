package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.Attribute;
import com.metropolitan.it355.repository.MessageLogRepository;
import com.metropolitan.it355.service.AttributeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/attribute")
public class AttributeController {
    private final AttributeService attributeService;
    final MessageLogRepository messageLogRepository;
    private final JmsTemplate jmsTemplate;

    @GetMapping
    public ResponseEntity<List<Attribute>> getAll() {
        List<Attribute> all  = attributeService.findAll();
        jmsTemplate.convertAndSend("attributeQueue", "Fetched all attributes");

        return ResponseEntity.ok(all);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Attribute>> findByAttributeName(@PathVariable String name) {
        jmsTemplate.convertAndSend("attributeQueue", "Searching for attribute by name: " + name);
        return ResponseEntity.ok(attributeService.findByAttributeName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getById(@PathVariable int id) {
        Attribute attribute = (Attribute) attributeService.findById(id);
        jmsTemplate.convertAndSend("attributeQueue", "Fetched attribute by ID: " + id);
        return ResponseEntity.ok(attribute);
    }
}
