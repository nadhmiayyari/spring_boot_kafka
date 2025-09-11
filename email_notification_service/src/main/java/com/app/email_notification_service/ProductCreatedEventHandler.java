package com.app.email_notification_service;


import com.app.core_module.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "product-created-event")

public class ProductCreatedEventHandler {


    private final Logger LOGGER = LoggerFactory.getLogger(ProductCreatedEventHandler.class);

    @KafkaHandler
    public void handle(ProductCreatedEvent productCreatedEvent) {
        LOGGER.info("Received event : {} ",productCreatedEvent.getTitle());
    }
}
