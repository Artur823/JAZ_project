package org.example.core.config;

import com.binance.connector.client.impl.SpotClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinanceConfig {

    @Bean
    public SpotClientImpl spotClient() {
        // Укажите свои API Key и Secret
        String apiKey = "IIXqoIgEh6Tmy6gOSlMwey2jqeV7RdNhIbGoVAftgkg3wefa0cBKYGJ9zxYH3YN3";
        String secretKey = "inzftDVqXwqNwFxUk6FhwkLlEuUnwXy9xOU9OonOzHQUX52LC4GqT4alEocvSrMb";

        return new SpotClientImpl(apiKey, secretKey);
    }
}
