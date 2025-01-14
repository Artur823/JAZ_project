package org.example.api.controllers;

import org.example.client.contract.TradeDTO;
import org.example.api.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public void saveTrade(@RequestBody TradeDTO tradeDTO) {
        tradeService.saveTrade(tradeDTO);
    }

    @GetMapping("/{id}")
    public TradeDTO getTrade(@PathVariable Long id) {
        return tradeService.getTradeById(id);
    }

    @GetMapping
    public List<TradeDTO> getAllTrades() {
        return tradeService.getAllTrades();
    }
}
