package com.metropolitan.it355.controller;

import com.metropolitan.it355.service.MessageSenderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class JmsController {

    private final MessageSenderService messageSenderService;

    @PostMapping("/jms/send")
    public String sendMessage(@RequestParam String destination, @RequestParam String message) {
        messageSenderService.sendMessage(destination, message);
        return "redirect:/jms/monitor";
    }

    @GetMapping("/jms/monitor")
    public String getMonitorPage() {
        return "jms-monitor";
    }
}
