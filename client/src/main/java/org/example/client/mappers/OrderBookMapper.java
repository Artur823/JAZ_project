package org.example.client.mappers;

import org.example.client.contract.OrderBookDTO;
import org.example.core.model.OrderBook;

public class OrderBookMapper {

    // Преобразование OrderBookDTO в сущность OrderBook
    public static OrderBook toEntity(OrderBookDTO dto) {
        OrderBook orderBook = new OrderBook();
        orderBook.setSymbol(dto.symbol());
        orderBook.setBidPrice(dto.bidPrice());
        orderBook.setBidQuantity(dto.bidQuantity());
        orderBook.setAskPrice(dto.askPrice());
        orderBook.setAskQuantity(dto.askQuantity());
        orderBook.setTimestamp(dto.timestamp());
        return orderBook;
    }

    // Преобразование сущности OrderBook в OrderBookDTO
    public static OrderBookDTO toDTO(OrderBook entity) {
        return new OrderBookDTO(
                entity.getSymbol(),
                entity.getBidPrice(),
                entity.getBidQuantity(),
                entity.getAskPrice(),
                entity.getAskQuantity(),
                entity.getTimestamp()
        );
    }
}
