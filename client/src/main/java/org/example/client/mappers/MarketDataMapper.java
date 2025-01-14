package org.example.client.mappers;

import org.example.core.model.MarketData;
import org.example.client.contract.MarketDataDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MarketDataMapper {

    // Преобразование сущности MarketData в DTO
    public static MarketDataDTO toDTO(MarketData marketData) {
        return new MarketDataDTO(
                marketData.getSymbol(),
                marketData.getPrice(),
                marketData.getVolume(),
                marketData.getTimestamp()
        );
    }

    // Преобразование DTO в сущность MarketData
    public static MarketData toEntity(MarketDataDTO marketDataDTO) {
        MarketData marketData = new MarketData();
        marketData.setSymbol(marketDataDTO.symbol());
        marketData.setPrice(marketDataDTO.price());
        marketData.setVolume(marketDataDTO.volume());
        marketData.setTimestamp(marketDataDTO.timestamp());
        return marketData;
    }

    // Преобразование списка сущностей MarketData в список DTO
    public static List<MarketDataDTO> toDTOList(List<MarketData> marketDataList) {
        return marketDataList.stream()
                .map(MarketDataMapper::toDTO)
                .collect(Collectors.toList());
    }
}
