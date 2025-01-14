package org.example.api.services;

import org.example.client.contract.MarketDataDTO;
import org.example.client.mappers.MarketDataMapper;
import org.example.core.model.MarketData;
import org.example.core.repository.IMarketDataRepository;
import org.example.core.service.BinanceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

@Service
public class MarketDataService {

    private final BinanceApiService binanceApiService;
    private final IMarketDataRepository IMarketDataRepository;
    private final ObjectMapper objectMapper;

    @Autowired  // Spring автоматически внедрит зависимость
    public MarketDataService(BinanceApiService binanceApiService, IMarketDataRepository IMarketDataRepository, ObjectMapper objectMapper) {
        this.binanceApiService = binanceApiService;
        this.IMarketDataRepository = IMarketDataRepository;
        this.objectMapper = objectMapper;
    }

    // Метод для получения всех данных о рынке и их преобразования в DTO
    public List<MarketDataDTO> getAllMarketData() {
        List<MarketData> marketDataList = IMarketDataRepository.findAll();
        return MarketDataMapper.toDTOList(marketDataList);
    }

    // Метод для получения данных о рынке по ID и преобразования в DTO
    public MarketDataDTO getMarketData(Long id) {
        MarketData marketData = IMarketDataRepository.findById(id).orElseThrow(() -> new RuntimeException("Market data not found"));
        return MarketDataMapper.toDTO(marketData);
    }

    // Сохранение данных о рынке и возврат DTO
    public MarketDataDTO saveMarketData(MarketDataDTO marketDataDTO) {
        MarketData marketData = MarketDataMapper.toEntity(marketDataDTO);
        marketData = IMarketDataRepository.save(marketData);
        return MarketDataMapper.toDTO(marketData);
    }

    // Метод для получения данных с Binance и сохранения в БД
    public void fetchAndSaveMarketData(String symbol) {
        String json = binanceApiService.getMarketData(symbol);
        try {
            Map<String, Object> data = objectMapper.readValue(json, Map.class);

            MarketData marketData = new MarketData();
            marketData.setSymbol((String) data.get("symbol"));
            marketData.setPrice(Double.valueOf((String) data.get("price")));
            IMarketDataRepository.save(marketData);
        } catch (Exception e) {
            throw new RuntimeException("Error processing market data", e);
        }
    }
}
