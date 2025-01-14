package org.example.api.controllers;

import org.example.client.contract.OrderBookDTO;
import org.example.api.services.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-book")
public class OrderBookController {

    private final OrderBookService orderBookService;

    @Autowired
    public OrderBookController(OrderBookService orderBookService) {
        this.orderBookService = orderBookService;
    }

    @PostMapping
    public void saveOrderBook(@RequestBody OrderBookDTO orderBookDTO) {
        orderBookService.saveOrderBook(orderBookDTO);
    }

    @GetMapping("/{id}")
    public OrderBookDTO getOrderBook(@PathVariable Long id) {
        return orderBookService.getOrderBookById(id);
    }

    @GetMapping
    public List<OrderBookDTO> getAllOrderBooks() {
        return orderBookService.getAllOrderBooks();
    }
}
