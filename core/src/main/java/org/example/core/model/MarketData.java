package org.example.core.model;

public class MarketData {
    private long timestamp;
    private Double openPrice;
    private Double highPrice;
    private Double lowPrice;
    private Double closePrice;
    private Double volume;

    // Пустой конструктор
    public MarketData() {}

    // Полный конструктор
    public MarketData(long timestamp, Double openPrice, Double highPrice, Double lowPrice,
                      Double closePrice, Double volume) {
        this.timestamp = timestamp;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
        this.volume = volume;
    }

    // Геттеры
    public long getTimestamp() {
        return timestamp;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public Double getVolume() {
        return volume;
    }

    // Сеттеры
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    // Переопределяем toString для удобного вывода
    @Override
    public String toString() {
        return "MarketData{" +
                "timestamp=" + timestamp +
                ", openPrice=" + openPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", closePrice=" + closePrice +
                ", volume=" + volume +
                '}';
    }
}