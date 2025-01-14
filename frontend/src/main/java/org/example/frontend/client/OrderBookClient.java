package org.example.frontend.client;

import org.example.client.contract.OrderBookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderBookClient {

    private final RestTemplate restTemplate;

    @Autowired
    public OrderBookClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String API_BASE_URL = "http://localhost:8080/api/order-books";

    public List<OrderBookDTO> getAllOrderBooks() {
        OrderBookDTO[] response = restTemplate.getForObject(API_BASE_URL, OrderBookDTO[].class);
        return Arrays.asList(response);
    }

    public OrderBookDTO getOrderBookById(Long id) {
        return restTemplate.getForObject(API_BASE_URL + "/" + id, OrderBookDTO.class);
    }

    public void saveOrderBook(OrderBookDTO orderBookDTO) {
        restTemplate.postForObject(API_BASE_URL, orderBookDTO, OrderBookDTO.class);
    }
}
