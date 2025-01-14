package org.example.core.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinanceApiService {
    private final RestTemplate restTemplate;

    public BinanceApiService() {
        this.restTemplate = new RestTemplate();
    }

    public String getMarketData(String symbol) {
        String url = "https://api.binance.com/api/v3/ticker/price?symbol=" + symbol;
        return restTemplate.getForObject(url, String.class);
    }
}