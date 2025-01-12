package org.example.core.api;

import com.binance.connector.client.impl.SpotClientImpl;
import org.example.core.exceptions.BinanceApiException;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class BinanceApiService {

    private final SpotClientImpl spotClient;

    public BinanceApiService(SpotClientImpl spotClient) {
        this.spotClient = spotClient;
    }

    public String getMarketData(String symbol, String interval) {
        // Проверка входных данных
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol must not be null or empty");
        }
        if (interval == null || interval.isEmpty()) {
            throw new IllegalArgumentException("Interval must not be null or empty");
        }

        // Создаём параметры запроса
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", symbol);
        parameters.put("interval", interval);

        try {
            // Выполняем обращение к Binance API для получения данных
            return spotClient.createMarket().klines(parameters);
        } catch (Exception e) {
            throw new BinanceApiException("Error fetching market data: " + e.getMessage(), (IllegalArgumentException) e);
        }
    }
}