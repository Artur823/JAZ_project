package org.example.client.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderBookDTO(
        String symbol,
        @JsonProperty("bid_price") Double bidPrice,
        @JsonProperty("bid_quantity") Double bidQuantity,
        @JsonProperty("ask_price") Double askPrice,
        @JsonProperty("ask_quantity") Double askQuantity,
        Long timestamp
) {
}
