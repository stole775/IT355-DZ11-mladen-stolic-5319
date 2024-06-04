package com.metropolitan.it355.controller;

import com.metropolitan.it355.entity.MessageLog;
import com.metropolitan.it355.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message-logs")
public class MessageLogController {

    @Autowired
    private MessageLogRepository messageLogRepository;

    @GetMapping
    public List<MessageLog> getAllMessages() {
        return messageLogRepository.findAll();
    }
}
