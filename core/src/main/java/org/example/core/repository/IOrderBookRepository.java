package org.example.core.repository;

import org.example.core.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderBookRepository extends JpaRepository<OrderBook, Long> {
    OrderBook findBySymbolAndTimestamp(String symbol, Long timestamp);
}
