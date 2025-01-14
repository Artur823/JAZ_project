package org.example.api.controllers;

import org.example.client.contract.KlineDataDTO;
import org.example.api.services.KlineDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kline-data")
public class KlineDataController {

    private final KlineDataService klineDataService;

    @Autowired
    public KlineDataController(KlineDataService klineDataService) {
        this.klineDataService = klineDataService;
    }

    @PostMapping
    public void saveKlineData(@RequestBody KlineDataDTO klineDataDTO) {
        klineDataService.saveKlineData(klineDataDTO);
    }

    @GetMapping("/{id}")
    public KlineDataDTO getKlineData(@PathVariable Long id) {
        return klineDataService.getKlineDataById(id);
    }

    @GetMapping
    public List<KlineDataDTO> getAllKlineData() {
        return klineDataService.getAllKlineData();
    }
}
