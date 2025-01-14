package org.example.client.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MarketDataDTO(
        String symbol,
        Double price,
        Double volume,
        @JsonProperty("timestamp") String timestamp
) {
}
