package org.example.core.repository;

import org.example.core.model.MarketData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarketDataRepository extends JpaRepository<MarketData, Long> {
    MarketData findBySymbol(String symbol); // Пример кастомного запроса
}
