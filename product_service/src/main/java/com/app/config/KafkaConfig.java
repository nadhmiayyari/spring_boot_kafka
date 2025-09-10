package com.app.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

@Configuration
public class KafkaConfig {


    @Bean
    NewTopic topic1(){
        return TopicBuilder
                .name("product-created-event")
                .partitions(3)
                .replicas(1)
                .configs(Map.of("min.insync.replicas","1"))
                .build();
    }
}
