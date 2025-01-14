package org.example.api.controllers;

import org.example.client.contract.MarketDataDTO;
import org.example.api.services.MarketDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market-data")
public class MarketDataController {

    private final MarketDataService marketDataService;

    @Autowired
    public MarketDataController(MarketDataService marketDataService) {
        this.marketDataService = marketDataService;
    }

    // Получить все данные о рынке
    @GetMapping
    public ResponseEntity<List<MarketDataDTO>> getAllMarketData() {
        List<MarketDataDTO> marketDataDTOs = marketDataService.getAllMarketData();
        return ResponseEntity.ok(marketDataDTOs);
    }

    // Получить данные о рынке по ID
    @GetMapping("/{id}")
    public ResponseEntity<MarketDataDTO> getMarketDataById(@PathVariable Long id) {
        try {
            MarketDataDTO marketDataDTO = marketDataService.getMarketData(id);
            return ResponseEntity.ok(marketDataDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Сохранить новые данные о рынке
    @PostMapping
    public ResponseEntity<MarketDataDTO> saveMarketData(@RequestBody MarketDataDTO marketDataDTO) {
        try {
            MarketDataDTO savedMarketData = marketDataService.saveMarketData(marketDataDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMarketData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // Получить и сохранить данные о рынке по символу
    @GetMapping("/fetch")
    public ResponseEntity<String> fetchMarketData(@RequestParam String symbol) {
        try {
            marketDataService.fetchAndSaveMarketData(symbol);
            return ResponseEntity.ok("Market data fetched and saved successfully for symbol: " + symbol);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching market data: " + e.getMessage());
        }
    }
}
