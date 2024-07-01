package com.example.fastfood_consumer.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "orderTopic", groupId = "fastfood-consumer-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
