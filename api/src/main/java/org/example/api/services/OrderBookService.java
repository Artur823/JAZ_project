package org.example.api.services;

import org.example.client.contract.OrderBookDTO;
import org.example.client.mappers.OrderBookMapper;
import org.example.core.model.OrderBook;
import org.example.core.repository.IOrderBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderBookService {
    private final IOrderBookRepository IOrderBookRepository;

    public OrderBookService(IOrderBookRepository IOrderBookRepository) {
        this.IOrderBookRepository = IOrderBookRepository;
    }
    public void saveOrderBook(OrderBookDTO OrderBookDTO) {
    OrderBook orderBook = OrderBookMapper.toEntity(OrderBookDTO);
    IOrderBookRepository.save(orderBook);
    }

    public OrderBookDTO getOrderBookById(Long id) {
        return IOrderBookRepository.findById(id)
                .map(OrderBookMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("KlineData not found with id: " + id));
    }

    public List<OrderBookDTO> getAllOrderBooks() {
        return IOrderBookRepository.findAll().stream()
                .map(OrderBookMapper::toDTO)
                .collect(Collectors.toList());
    }
}
