package org.example.core.repository;

public interface ICatalogData {

    IKlineDataRepository getKlineDataRepository();

    IMarketDataRepository getMarketDataRepository();

    IOrderBookRepository getOrderBookRepository();

    ITradeRepository getTradeRepository();

    IUserProfileRepository getUserProfileRepository();
}
