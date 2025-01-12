package org.example.api.ApiController;

import org.example.core.service.BinanceService;
import org.example.core.model.MarketData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.*;

@Controller
public class ApiController {

    private final BinanceService binanceService;
    private final RestTemplate restTemplate;

    // Карта соответствий символов и названий (можно загрузить из файла, БД или API)
    private static final Map<String, String> CRYPTO_NAMES = Map.of(
            "BTCUSDT", "Bitcoin",
            "ETHUSDT", "Ethereum",
            "BNBUSDT", "Binance Coin",
            "DOGEUSDT", "Dogecoin"
    );

    public ApiController(BinanceService binanceService, RestTemplate restTemplate) {
        this.binanceService = binanceService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/dashboard")
    public String getDashboard(@RequestParam(defaultValue = "BTCUSDT") String symbol,
                               @RequestParam(defaultValue = "1m") String interval,
                               Model model) {
        try {
            // Загружаем данные из REST API
            String apiUrl = String.format("http://localhost:8081/market-data?symbol=%s&interval=%s", symbol, interval);
            ResponseEntity<List<List<Object>>> response = restTemplate.exchange(
                    apiUrl,
                    org.springframework.http.HttpMethod.GET,
                    null,
                    new org.springframework.core.ParameterizedTypeReference<List<List<Object>>>() {}
            );

            // Обработанные данные, готовые для отображения
            List<MarketData> marketData = binanceService.extractMarketData(response.getBody());

            // Получаем читаемое название криптовалюты
            String cryptoName = CRYPTO_NAMES.getOrDefault(symbol, "Unknown");

            model.addAttribute("cryptoName", cryptoName); // Название валюты
            model.addAttribute("symbol", symbol); // Тикер
            model.addAttribute("marketData", marketData); // Рыночные данные
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка при получении данных: " + e.getMessage());
        }

        // Отображаем страницу
        return "dashboard";
    }
}