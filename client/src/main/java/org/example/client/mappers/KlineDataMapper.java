package org.example.client.mappers;

import org.example.client.contract.KlineDataDTO;
import org.example.core.model.KlineData;
import org.springframework.stereotype.Component;

@Component
public class KlineDataMapper {

    // Преобразование DTO в Entity
    public static KlineData toEntity(KlineDataDTO dto) {
        KlineData klineData = new KlineData();
        klineData.setSymbol(dto.symbol());
        klineData.setOpenPrice(dto.openPrice());
        klineData.setHighPrice(dto.highPrice());
        klineData.setLowPrice(dto.lowPrice());
        klineData.setClosePrice(dto.closePrice());
        klineData.setVolume(dto.volume());
        klineData.setOpenTime(dto.openTime());
        klineData.setCloseTime(dto.closeTime());
        return klineData;
    }

    // Преобразование Entity в DTO
    public static KlineDataDTO toDTO(KlineData entity) {
        return new KlineDataDTO(
                entity.getSymbol(),
                entity.getOpenPrice(),
                entity.getHighPrice(),
                entity.getLowPrice(),
                entity.getClosePrice(),
                entity.getVolume(),
                entity.getOpenTime(),
                entity.getCloseTime()
        );
    }
}
