package com.metropolitan.it355.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AttributeMessageListener {

    @JmsListener(destination = "attributeQueue")
    public void onMessage(String message) {

        System.out.println("Received message: " + message);
    }
}
