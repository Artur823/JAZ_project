package org.example.core.repository;

import org.example.core.model.KlineData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKlineDataRepository extends JpaRepository<KlineData, Long> {
    KlineData findBySymbolAndOpenTime(String symbol, Long openTime);
}

