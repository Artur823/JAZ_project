package org.example.frontend.frontendControllersWeb;

import org.example.client.contract.MarketDataDTO;
import org.example.frontend.client.MarketDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market-data")
public class MarketDataWebController {

    private final MarketDataClient marketDataClient;

    @Autowired
    public MarketDataWebController(MarketDataClient marketDataClient) {
        this.marketDataClient = marketDataClient;
    }

    // Отображение списка всех данных MarketData
    @GetMapping
    public String listMarketData(Model model) {
        model.addAttribute("marketDataList", marketDataClient.getAllMarketData());
        return "market-data/list"; // Шаблон для отображения списка данных
    }

    // Отображение деталей конкретного MarketData по ID
    @GetMapping("/{id}")
    public String viewMarketDataDetails(@PathVariable Long id, Model model) {
        MarketDataDTO marketData = marketDataClient.getMarketDataById(id);
        if (marketData == null) {
            model.addAttribute("error", "Market Data not found");
            return "error"; // Переход на страницу ошибки, если данные не найдены
        }
        model.addAttribute("marketData", marketData);
        return "market-data/details"; // Шаблон для отображения подробностей данных
    }

    // Отображение формы для создания нового MarketData
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("marketData", new MarketDataDTO("", 0.0, 0.0, "")); // Создаем пустой объект DTO
        return "market-data/form";
    }

    // Обработка данных формы для создания нового MarketData
    @PostMapping
    public String saveMarketData(@ModelAttribute MarketDataDTO marketDataDTO) {
        try {
            marketDataClient.saveMarketData(marketDataDTO); // Сохранение данных через клиент
            return "redirect:/market-data"; // Перенаправление на список после сохранения
        } catch (Exception e) {
            e.printStackTrace(); // Логируем ошибку (можно заменить на логгер)
            return "error"; // Шаблон ошибки
        }
    }
}
