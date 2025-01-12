package org.example.core.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.core.model.MarketData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BinanceService {

    /**
     * Извлечение списка MarketData из "сырых" данных.
     *
     * @param rawData Список списков объектов, содержащий данные о рынке.
     * @return Список объектов MarketData.
     */
    public List<MarketData> extractMarketData(List<List<Object>> rawData) {
        List<MarketData> marketDataList = new ArrayList<>();

        // Проверка на null или пустоту
        if (rawData == null || rawData.isEmpty()) {
            System.err.println("Входные данные пусты или недоступны.");
            return marketDataList;
        }

        // Обработка каждого списка объектов, представляющего одну запись
        for (List<Object> data : rawData) {
            try {
                if (data.size() >= 6) { // Убеждаемся, что есть необходимое количество полей
                    MarketData marketData = new MarketData();

                    // Присваиваем значения полям объекта MarketData
                    marketData.setTimestamp(convertToLong(data.get(0)));
                    marketData.setOpenPrice(convertToDouble(data.get(1)));
                    marketData.setHighPrice(convertToDouble(data.get(2)));
                    marketData.setLowPrice(convertToDouble(data.get(3)));
                    marketData.setClosePrice(convertToDouble(data.get(4)));
                    marketData.setVolume(convertToDouble(data.get(5)));

                    marketDataList.add(marketData);
                } else {
                    System.err.println("Недостаточно данных для обработки записи: " + data);
                }
            } catch (Exception e) {
                System.err.println("Ошибка в обработке записи [" + data + "]: " + e.getMessage());
            }
        }
        return marketDataList;
    }

    /**
     * Парсинг JSON строки и преобразование данных в список объектов MarketData.
     *
     * @param marketDataJson JSON строка с данными.
     * @return Список объектов MarketData.
     */
    public List<MarketData> parseMarketData(String marketDataJson) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Проверяем на null или пустую строку
        if (marketDataJson == null || marketDataJson.isBlank()) {
            System.err.println("JSON-строка пуста или null.");
            return Collections.emptyList();
        }

        try {
            // Преобразуем JSON в список списков объектов
            List<List<Object>> rawData = objectMapper.readValue(
                    marketDataJson,
                    new TypeReference<List<List<Object>>>() {}
            );

            // Извлекаем MarketData из сырых данных
            return extractMarketData(rawData);
        } catch (Exception e) {
            System.err.println("Ошибка парсинга JSON: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Преобразование объекта в Long.
     *
     * @param value Объект для преобразования.
     * @return Значение типа Long.
     */
    private Long convertToLong(Object value) {
        if (value instanceof Number) {
            return ((Number) value).longValue();
        } else if (value instanceof String) {
            try {
                return Long.parseLong((String) value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Невозможно преобразовать значение в Long: " + value, e);
            }
        } else {
            throw new IllegalArgumentException("Ожидался тип Number или String, но получен: " + value.getClass().getName());
        }
    }

    /**
     * Преобразование объекта в Double.
     *
     * @param value Объект для преобразования.
     * @return Значение типа Double.
     */
    private Double convertToDouble(Object value) {
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        } else if (value instanceof String) {
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Невозможно преобразовать значение в Double: " + value, e);
            }
        } else {
            throw new IllegalArgumentException("Ожидался тип Number или String, но получен: " + value.getClass().getName());
        }
    }
}