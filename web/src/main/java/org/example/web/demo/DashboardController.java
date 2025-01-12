package org.example.web.demo;

import org.example.core.model.MarketData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<MarketData> marketData = new ArrayList<>();

        // Добавим тестовые данные криптовалют
        MarketData btcData = new MarketData();
        btcData.setTimestamp(System.currentTimeMillis());
        btcData.setOpenPrice(42000.0);
        btcData.setHighPrice(42500.0);
        btcData.setLowPrice(41900.0);
        btcData.setClosePrice(42400.0);
        btcData.setVolume(1234.56);

        MarketData ethData = new MarketData();
        ethData.setTimestamp(System.currentTimeMillis() - 60000);
        ethData.setOpenPrice(3000.0);
        ethData.setHighPrice(3100.0);
        ethData.setLowPrice(2950.0);
        ethData.setClosePrice(3050.0);
        ethData.setVolume(4321.87);

        marketData.add(btcData);
        marketData.add(ethData);

        model.addAttribute("marketData", marketData); // Добавляем данные в модель

        return "dashboard"; // Возвращаем имя шаблона
    }
}