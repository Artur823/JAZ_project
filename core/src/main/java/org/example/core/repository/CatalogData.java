package org.example.core.repository;

public class CatalogData implements ICatalogData {
    private final IKlineDataRepository klineDataRepository;
    private final IMarketDataRepository marketDataRepository;
    private final IOrderBookRepository orderBookRepository;
    private final ITradeRepository tradeRepository;
    private final IUserProfileRepository userProfileRepository;

    public CatalogData(IKlineDataRepository klineDataRepository, IMarketDataRepository marketDataRepository, IOrderBookRepository orderBookRepository, ITradeRepository tradeRepository, IUserProfileRepository userProfileRepository) {
        this.klineDataRepository = klineDataRepository;
        this.marketDataRepository = marketDataRepository;
        this.orderBookRepository = orderBookRepository;
        this.tradeRepository = tradeRepository;
        this.userProfileRepository = userProfileRepository;
    }

    public IKlineDataRepository getKlineDataRepository() {
        return klineDataRepository;
    }

    public IMarketDataRepository getMarketDataRepository() {
        return marketDataRepository;
    }

    public IOrderBookRepository getOrderBookRepository() {
        return orderBookRepository;
    }

    public ITradeRepository getTradeRepository() {
        return tradeRepository;
    }

    public IUserProfileRepository getUserProfileRepository() {
        return userProfileRepository;
    }
}
