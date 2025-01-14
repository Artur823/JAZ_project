package org.example.frontend.client;

import org.example.client.contract.TradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TradeClient {

    private final RestTemplate restTemplate;

    @Autowired
    public TradeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String API_BASE_URL = "http://localhost:8080/api/trades";

    public List<TradeDTO> getAllTrades() {
        TradeDTO[] response = restTemplate.getForObject(API_BASE_URL, TradeDTO[].class);
        return Arrays.asList(response);
    }

    public TradeDTO getTradeById(Long id) {
        return restTemplate.getForObject(API_BASE_URL + "/" + id, TradeDTO.class);
    }

    public void saveTrade(TradeDTO tradeDTO) {
        restTemplate.postForObject(API_BASE_URL, tradeDTO, TradeDTO.class);
    }
}
