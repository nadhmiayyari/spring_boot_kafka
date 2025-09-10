package com.app.service;

import com.app.dto.ProductCreatedEvent;
import com.app.rest.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
public class ProductServiceImpl implements IProductService{

    KafkaTemplate<String,ProductCreatedEvent> kafkaTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    public ProductServiceImpl(KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(ProductDto productDto) throws ExecutionException, InterruptedException {
        String id = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        productCreatedEvent.setId(id);
        productCreatedEvent.setPrice(productDto.getPrice());
        productCreatedEvent.setQuantity(10);
        productCreatedEvent.setTitle("iphone_15");



        //String topic, K key, @Nullable V data
       CompletableFuture< SendResult<String,ProductCreatedEvent>> futureResult =
               kafkaTemplate.send("product-created-event",id,productCreatedEvent);

        futureResult.whenComplete((result,exception)->{
            if(exception!=null){
                LOGGER.error(exception.getMessage());
            }else{
                LOGGER.info("Product created successfully");
            }
        });
        LOGGER.info("Returning Product Id");

        return id;
    }


}
