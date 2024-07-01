package com.example.fastfood_consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.contract.verifier.messaging.internal.ContractVerifierMessaging;

@SpringBootTest
public class ContractVerifierTest {

    @Autowired
    ContractVerifierMessaging contractVerifierMessaging;

    @Test
    void validate_orderCreateContract() {
        // test logic
    }

    @Test
    void validate_deleteOrderContract() {
        // test logic
    }

    @Test
    void validate_updateOrderContract() {
        // test logic
    }
}