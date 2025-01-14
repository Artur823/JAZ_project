package org.example.client.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KlineDataDTO(
        String symbol,
        @JsonProperty("open_price") Double openPrice,
        @JsonProperty("high_price") Double highPrice,
        @JsonProperty("low_price") Double lowPrice,
        @JsonProperty("close_price") Double closePrice,
        Double volume,
        @JsonProperty("open_time") Long openTime,
        @JsonProperty("close_time") Long closeTime
) {
}
