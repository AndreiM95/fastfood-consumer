package com.example.fastfood_consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContractVerifierConfig {

    @Bean
    public ContractVerifierMessaging<?> contractVerifierMessaging() {
        return new ContractVerifierMessaging<>();
    }
}
