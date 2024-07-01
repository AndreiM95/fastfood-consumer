package com.example.fastfood_consumer;

import com.example.fastfood_consumer.kafka.KafkaConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({SpringExtension.class, StubRunnerExtension.class})
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "orderTopic" }, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.example:fastfood:+:stubs:8080"
)
public class KafkaConsumerTest {

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @Test
    public void testConsumeOrderCreatedEvent() {
        String message = "{\"event\":\"order_created\",\"details\":\"Created order: Burger\"}";
        kafkaConsumerService.consume(message);

        assertThat(message).contains("order_created");
    }
}