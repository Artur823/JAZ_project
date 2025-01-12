package org.example.web.WebController;

import org.example.core.model.MarketData;
import org.example.core.service.BinanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    private final BinanceService binanceService;
    private final RestTemplate restTemplate;

    // URL вашего API
    private final String API_URL = "http://localhost:8081/market-data";
    private static final Set<String> VALID_INTERVALS = Set.of("1m", "5m", "15m", "30m", "1h", "4h", "1d");

    // Конструктор
    public WebController(BinanceService binanceService, RestTemplate restTemplate) {
        this.binanceService = binanceService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/web/dashboard")
    public String getDashboard(Model model) {
        List<String> symbols = List.of("BTCUSDT", "ETHUSDT"); // Пример символов
        List<Map<String, Object>> marketData = new ArrayList<>(); // Список для данных криптовалют

        for (String symbol : symbols) {
            try {
                // Формируем URL API
                String url = String.format("%s?symbol=%s&interval=1h", API_URL, symbol);

                // Делаем запрос к API
                String marketDataJson = restTemplate.getForObject(url, String.class);

                // Парсим полученные данные c помощью BinanceService
                List<MarketData> dataList = binanceService.parseMarketData(marketDataJson);

                if (dataList != null && !dataList.isEmpty()) {
                    Map<String, Object> cryptoData = new HashMap<>();
                    cryptoData.put("symbol", symbol);
                    cryptoData.put("data", dataList);
                    marketData.add(cryptoData);
                } else {
                    LOGGER.warn("Нет данных для символа: {}", symbol);
                }
            } catch (Exception e) {
                LOGGER.error("Ошибка получения данных для символа {}: {}", symbol, e.getMessage());
                model.addAttribute("error", "Данные недоступны для: " + symbol);
            }
        }

        // Если данных нет, добавляем пустую коллекцию
        if (marketData.isEmpty()) {
            model.addAttribute("marketData", Collections.emptyList());
        } else {
            model.addAttribute("marketData", marketData);
        }

        return "webDashboard"; // Возвращаем шаблон Thymeleaf
    }

    /**
     * Проверяет правильность интервала (вспомогательный метод).
     */
    private boolean isValidInterval(String interval) {
        return interval != null && VALID_INTERVALS.contains(interval);
    }
}