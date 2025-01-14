package org.example.frontend.client;

import org.example.client.contract.KlineDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class KlineDataClient {

    private final RestTemplate restTemplate;

    @Autowired
    public KlineDataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String API_BASE_URL = "http://localhost:8080/api/kline-data";

    public List<KlineDataDTO> getAllKlineData() {
        KlineDataDTO[] response = restTemplate.getForObject(API_BASE_URL, KlineDataDTO[].class);
        assert response != null;
        return Arrays.asList(response);
    }

    public KlineDataDTO getKlineDataById(Long id) {
        return restTemplate.getForObject(API_BASE_URL + "/" + id, KlineDataDTO.class);
    }

    public void saveKlineData(KlineDataDTO klineDataDTO) {
        restTemplate.postForObject(API_BASE_URL, klineDataDTO, KlineDataDTO.class);
    }
}
