package org.example.core.config;

import org.example.core.service.BinanceApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfig {
    @Bean
    public BinanceApiService binanceApiService() {
        return new BinanceApiService();
    }
}