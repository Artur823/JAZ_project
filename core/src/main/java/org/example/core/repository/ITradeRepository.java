package org.example.core.repository;

import org.example.core.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITradeRepository extends JpaRepository<Trade, Long> {
    Trade findBySymbolAndTradeTime(String symbol, Long tradeTime);
}
