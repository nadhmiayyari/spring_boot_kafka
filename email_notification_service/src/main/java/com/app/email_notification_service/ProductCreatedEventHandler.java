package com.app.email_notification_service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedEventHandler {

    @KafkaListener(topics = "product-created-event")
    public void handle(ProductCreatedEvent productCreatedEvent) {
        System.out.println("Received event");
    }
}
