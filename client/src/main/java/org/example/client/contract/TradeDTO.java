package org.example.client.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TradeDTO(
        String symbol,               // Торговый символ (например, BTCUSDT)
        Double price,                // Цена
        Double quantity,             // Количество
        @JsonProperty("trade_time") Long tradeTime  // Время сделки
) {
}
