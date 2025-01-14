package org.example.api.services;

import org.example.client.contract.TradeDTO;
import org.example.client.mappers.TradeMapper;
import org.example.core.model.Trade;
import org.example.core.repository.ITradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeService {

    private final ITradeRepository ITradeRepository;

    public TradeService(ITradeRepository ITradeRepository) {
        this.ITradeRepository = ITradeRepository;
    }

    public void saveTrade(TradeDTO tradeDTO) {
        Trade trade = TradeMapper.toEntity(tradeDTO);
        ITradeRepository.save(trade);
    }

    public TradeDTO getTradeById(Long id) {
        return ITradeRepository.findById(id)
                .map(TradeMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Trade not found with id: " + id));
    }

    public List<TradeDTO> getAllTrades() {
        return ITradeRepository.findAll().stream()
                .map(TradeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
