package org.example.frontend.client;

import org.example.client.contract.MarketDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MarketDataClient {

    private final RestTemplate restTemplate;

    @Autowired
    public MarketDataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String API_BASE_URL = "http://localhost:8080/api/market-data";

    public List<MarketDataDTO> getAllMarketData() {
        MarketDataDTO[] response = restTemplate.getForObject(API_BASE_URL, MarketDataDTO[].class);
        return Arrays.asList(response);
    }

    public MarketDataDTO getMarketDataById(Long id) {
        return restTemplate.getForObject(API_BASE_URL + "/" + id, MarketDataDTO.class);
    }

    public void saveMarketData(MarketDataDTO marketData) {
        restTemplate.postForObject(API_BASE_URL, marketData, MarketDataDTO.class);
    }
}
