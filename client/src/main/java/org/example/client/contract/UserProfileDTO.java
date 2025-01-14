package org.example.client.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserProfileDTO(
        String username,                          // Имя пользователя
        String email,                             // Email пользователя
        @JsonProperty("preferred_currency") String preferredCurrency, // Предпочитаемая валюта
        Double balance,                           // Баланс
        @JsonProperty("last_login") Long lastLogin // Время последнего входа
) {
}
