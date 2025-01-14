package org.example.client.mappers;

import org.example.client.contract.TradeDTO;
import org.example.core.model.Trade;

public class TradeMapper {

    public static Trade toEntity(TradeDTO dto) {
        Trade trade = new Trade();
        trade.setSymbol(dto.symbol());
        trade.setPrice(dto.price());
        trade.setQuantity(dto.quantity());
        trade.setTradeTime(dto.tradeTime());
        return trade;
    }

    public static TradeDTO toDTO(Trade entity) {
        return new TradeDTO(
                entity.getSymbol(),
                entity.getPrice(),
                entity.getQuantity(),
                entity.getTradeTime()
        );
    }
}
