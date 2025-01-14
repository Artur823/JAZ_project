package org.example.scheduler.scheduler;

import org.example.api.services.MarketDataService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MarketDataScheduler {

    private final MarketDataService marketDataService;

    // Внедрение зависимости
    public MarketDataScheduler(MarketDataService marketDataService) {
        this.marketDataService = marketDataService;
    }

    // Запуск задачи каждую минуту
    @Scheduled(fixedRate = 60000) // Каждую минуту
    public void updateMarketData() {
        marketDataService.fetchAndSaveMarketData("BTCUSDT");
    }
}
