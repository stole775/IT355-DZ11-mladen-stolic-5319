package com.metropolitan.it355.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "mainQueue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
