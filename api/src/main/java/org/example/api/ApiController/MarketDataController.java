package org.example.api.ApiController;

import com.binance.connector.client.impl.SpotClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class MarketDataController {

    private final SpotClientImpl spotClient;

    @Autowired
    public MarketDataController(SpotClientImpl spotClient) {
        this.spotClient = spotClient;
    }

    @GetMapping("/market-data")
    public String fetchMarketDataFromBinance(
            @RequestParam String symbol,
            @RequestParam String interval) {

        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        parameters.put("symbol", symbol);
        parameters.put("interval", interval);

        // Подключаемся к Binance API и возвращаем данные
        return spotClient.createMarket().klines(parameters);
    }
}